package com.mariofernandes.javapoc.session.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.FlushMode;
import org.springframework.session.SaveMode;
import org.springframework.session.data.redis.RedisSessionExpirationStore;
import org.springframework.session.data.redis.SortedSetRedisSessionExpirationStore;
import org.springframework.session.data.redis.config.ConfigureReactiveRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisIndexedHttpSession;
import tools.jackson.databind.DefaultTyping;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import tools.jackson.databind.jsontype.PolymorphicTypeValidator;


@Configuration
// @EnableRedisHttpSession -> Better for simple cases, like shopping cart.
// @EnableRedisIndexedHttpSession -> Better for complex cases, like user authentication and authorization,
//                                   where we may need to query sessions based on attributes.
@EnableRedisIndexedHttpSession(
        redisNamespace = "${spring.session.redis.namespace}",
        maxInactiveIntervalInSeconds = 10,
        flushMode = FlushMode.IMMEDIATE, // cons: performance impact. pros: consistency
        saveMode = SaveMode.ON_GET_ATTRIBUTE // cons: lost session if attribute is not accessed. pros: performance
)
// Better specify properties in annotation's attribute. Like redisNamespace, flushMode, saveMode, etc.
public class RedisHttpSessionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RedisHttpSessionConfig.class);

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private int redisPort;

    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        LOG.info("Configuring Custom springSessionDefaultRedisSerializer()");
        // Configure ObjectMapper with PolymorphicTypeValidator to allow specific packages for deserialization.
        // This is important for security to prevent deserialization vulnerabilities and issues.
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("com.mariofernandes.javapoc.session.dto.") // Allow my custom DTOs
                .allowIfSubType("java.util.") // Allow Java Collections like Map, List, etc.
                .allowIfSubType("java.math.") // Allow Java Math classes like BigDecimal, BigInteger
                .allowIfSubType("java.lang.") // Allow Java Core classes like String, Integer, etc. (because @EnableRedisIndexedHttpSession may store such types)
                .build();

        ObjectMapper mapper = JsonMapper.builder()
                .activateDefaultTyping(ptv, DefaultTyping.NON_FINAL)
                .findAndAddModules()
                .build();

        return new GenericJacksonJsonRedisSerializer(mapper);
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        LOG.info("Configuring LettuceConnectionFactory()");

        // I can customize the Redis connection here if needed
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisHost);
        redisConfig.setPort(redisPort);
        // If Redis requires authentication, set the password here
        // redisConfig.setPassword(RedisPassword.of("yourRedisPassword"));

        return new LettuceConnectionFactory(redisConfig);
    }

    @Bean
    public RedisSessionExpirationStore redisSessionExpirationStore(RedisConnectionFactory connectionFactory) {
        LOG.info("Configuring custom RedisSessionExpirationStore()");
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // Set key serializer
        template.setKeySerializer(StringRedisSerializer.UTF_8);
        template.setHashKeySerializer(StringRedisSerializer.UTF_8);

        // Set connection factory
        template.setConnectionFactory(connectionFactory);

        template.afterPropertiesSet();

        return new SortedSetRedisSessionExpirationStore(template, "session:cart");
    }

    @Bean
    public ConfigureReactiveRedisAction configureReactiveRedisAction() {
        LOG.info("Configuring custom ConfigureReactiveRedisAction()");
        // Disable Auto-configuration of Redis Keyspace Notifications
        return ConfigureReactiveRedisAction.NO_OP;
    }
}


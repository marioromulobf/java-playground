package com.mariofernandes.javapoc.session.config;

import com.mariofernandes.javapoc.session.dto.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.FlushMode;
import org.springframework.session.SaveMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.util.Map;

@Configuration
@EnableRedisHttpSession(
        redisNamespace = "${spring.session.redis.namespace}",
        maxInactiveIntervalInSeconds = 60,
        flushMode = FlushMode.ON_SAVE,
        saveMode = SaveMode.ALWAYS
)
public class RedisHttpSessionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RedisHttpSessionConfig.class);

    @Bean
    public RedisSerializer<CartItem> springSessionDefaultRedisSerializer(ObjectMapper mapper) {
        LOG.info("Configuring springSessionDefaultRedisSerializer()");
        return new JacksonJsonRedisSerializer<>(mapper, CartItem.class);
    }

//    @Bean
//    public RedisTemplate<String, Map<String, CartItem>> userRedisTemplate(RedisConnectionFactory connectionFactory) {
//        LOG.info("Begin userRedisTemplate()");
//        RedisTemplate<String, Map<String, CartItem>> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        //Key serializer
//        template.setKeySerializer(new StringRedisSerializer());
//
//        //Value serializer for CartItem objects
//        ObjectMapper mapper = new ObjectMapper();
//        JacksonJsonRedisSerializer<CartItem> serializer = new JacksonJsonRedisSerializer<>(mapper, CartItem.class);
//
//        template.setValueSerializer(serializer);
//        template.afterPropertiesSet();
//
//        return template;
//    }

}


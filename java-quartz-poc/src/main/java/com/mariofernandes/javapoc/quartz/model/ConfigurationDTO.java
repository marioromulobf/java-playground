package com.mariofernandes.javapoc.quartz.model;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

public class ConfigurationDTO implements Serializable {
    private String name;
    private Integer value;

    public ConfigurationDTO() {
    }

    public ConfigurationDTO(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConfigurationDTO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

}

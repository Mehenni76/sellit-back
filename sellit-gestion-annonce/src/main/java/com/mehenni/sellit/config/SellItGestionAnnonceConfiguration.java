package com.mehenni.sellit.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
@org.springframework.context.annotation.Configuration
public class SellItGestionAnnonceConfiguration {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
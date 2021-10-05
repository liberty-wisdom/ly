package com.zh.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:version.properties")
public class Version {
    @Value("${ly.name}")
    private  String v;

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}

package com.example.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yun_kai
 */
@Data
@ConfigurationProperties(prefix = "openai")
public class OpenAi {
    private String model;
    private String prompt;
    private Integer temperature;
    private Integer max_tokens;
    private Boolean stream;
}

package com.example.moizaspringserver.domain.feed.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties(prefix = "feed.viewcount")
public class ViewCountProperties {
    private final Integer cacheMaximum;
}

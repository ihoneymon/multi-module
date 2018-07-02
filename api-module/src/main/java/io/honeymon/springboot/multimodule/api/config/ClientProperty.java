package io.honeymon.springboot.multimodule.api.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jiheon.kim on 2018. 7. 2.
 */
@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("client")
public class ClientProperty {
    private String id;
    private String key;
}

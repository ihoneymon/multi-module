package io.honeymon.springboot.multimodule.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author jiheon.kim on 2018. 7. 2.
 */
@Configuration
@EnableConfigurationProperties({ClientProperty.class})
public class RestTemplateConfig {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    ClientProperty clientProperty;

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.interceptors(new CustomClientHttpRequestInterceptor(clientProperty.getKey(), clientProperty.getId()))
                .build();
    }

    public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
        public static final String HEADER_CLIENT = "Client";
        private final String apiKey;
        private String clientId;


        public CustomClientHttpRequestInterceptor(String apiKey) {
            Assert.hasText(apiKey, "Required apiKey.");

            this.apiKey = String.format("Bearer %s", apiKey);
        }

        /**
         * HttpHeader [{@link HttpHeaders#AUTHORIZATION}, "Client"] 추가
         *
         * @param apiKey
         * @param clientId
         */
        public CustomClientHttpRequestInterceptor(String apiKey, String clientId) {
            this(apiKey);
            this.clientId = clientId;
        }


        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            HttpHeaders headers = request.getHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.set(HttpHeaders.AUTHORIZATION, apiKey);

            if (StringUtils.hasText(clientId)) {
                headers.set(HEADER_CLIENT, clientId);
            }
            return execution.execute(request, body);
        }
    }
}

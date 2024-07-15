package kz.itstep.client2.config;

import kz.itstep.client2.rest.RestProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public RestProductClient restProductClient() {
        return new RestProductClient(
                RestClient.builder()
                        .baseUrl("http://localhost:8080")
                        .build()
        );
    }
}

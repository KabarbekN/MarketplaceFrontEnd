package kz.itstep.client2.config;

import kz.itstep.client2.rest.RestProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public RestProductClient restProductClient(
            @Value("${basicURL}") String basicUrl,
            @Value("${spring.security.user.name}") String username,
            @Value("${spring.security.user.password}") String password
    ) {
        return new RestProductClient(
                RestClient.builder()
                        .baseUrl(basicUrl)
                        .requestInterceptor(
                                new BasicAuthenticationInterceptor(
                                        username,
                                        password
                                )
                        )
                        .build()

        );
    }
}

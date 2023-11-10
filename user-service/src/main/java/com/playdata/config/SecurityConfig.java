package com.playdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
        return http
/**                .authorizeRequests() //인증, 인가 설정을 시작한다! 는 뜻
//                .requestMatchers("/login", "/signup", "/user").permitAll() // 해당 주소는 인증, 인가 허용
//                .anyRequest().authenticated() // 나머지에 대해서는 인증을 요구하겠어요.
//                .and()
//                .csrf()
//                .disable()
//                .build();
 */
                .authorizeHttpRequests(a -> a
                        .requestMatchers("/login", "/signup", "/user").permitAll()
                        .anyRequest().authenticated())
                        .csrf(csrfgconfig -> csrfgconfig
                                .disable())
                        .build();
    }
}

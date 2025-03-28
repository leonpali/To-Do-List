package projects.java.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                c -> c.requestMatchers("/overview", "/error", "/css/**", "/img/**", "/add-task.html","/favicon.ico").permitAll()
                        .anyRequest().authenticated()
        ).csrf(AbstractHttpConfigurer::disable)
                .headers(
                        h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
                );
        return chainBuilder.build();
    }
}

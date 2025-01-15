package jonas.exambyte.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .csrf(configurer -> configurer.disable()) 
            // TODO: csrf aktivieren und Token für die jeweiligen Seiten erstellen
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/login", "/edit", "/static/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(login -> login.permitAll())
            .logout(logout -> logout.permitAll());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
            .password("{noop}" + 4) // {noop} für plaintext Passwort
            .roles("USER")
            .build();

        System.out.println("Generated Password: " + 4);

        return new InMemoryUserDetailsManager(user);
    }
}

package hh.bookstore_new.bookstore_new.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/delete/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                        
                .formLogin(formlogin -> formlogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/booklist", true)
                        .permitAll()
                        )
                        .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("user1234")
        .roles("USER")
        .build();

        
        UserDetails admin = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("admin1234")
        .roles("ADMIN")
        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}

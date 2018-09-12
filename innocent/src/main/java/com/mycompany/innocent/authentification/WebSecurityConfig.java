package com.mycompany.innocent.authentification;

import com.mycompany.innocent.authentification.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().and()
        .authorizeRequests().antMatchers("/","/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic().authenticationEntryPoint(authEntryPoint);

        // .and()
		// .formLogin()
		// 	.loginPage("/login") 
        //     .defaultSuccessUrl("/home",true)
        // .and()
        // .logout()
        // .logoutSuccessUrl("/")
        // .deleteCookies("JSESSIONID")
        // .logoutSuccessHandler(logoutSuccessHandler());
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("pw").roles("USER").build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public CustomLogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }
}
package org.javaboy.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/22 16:28
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("javaboy").password("$2a$10$UbhHZNsJQQ5yU8wpzXTPWuFNlNeysFXXnrxmhDB8sm7ymHQGuzge6").roles("admin")
                .and()
                .withUser("江南一点雨").password("$2a$10$UbhHZNsJQQ5yU8wpzXTPWuFNlNeysFXXnrxmhDB8sm7ymHQGuzge6").roles("user");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/oauth/**").authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .and()
                .csrf().disable();
    }
}

# SpringSecurityBasic


## Basic Authentication, role based and url based

    package com.arun.springsecuritybasic.config;
    
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    import org.springframework.security.crypto.password.NoOpPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    
    @Configuration
    public class BasicSecurity extends WebSecurityConfigurerAdapter {
    
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("adminUser")
                    .password("adminPassword")
                    .roles("ADMIN")
                    .and()
                    .withUser("User")
                    .password("password")
                    .roles("BASIC");
        }
    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/admin/**")
                    .hasAnyRole("ADMIN")
                    .anyRequest()
                    .fullyAuthenticated()
                    .and()
                    .httpBasic();
    
            http.authorizeRequests()
                    .antMatchers("/user/**")
                    .hasAnyRole("BASIC")
                    .anyRequest()
                    .fullyAuthenticated()
                    .and()
                    .httpBasic();
        }
    
        @Bean
        public PasswordEncoder encoder() {
            return NoOpPasswordEncoder.getInstance();
        }
    }

package com.btcc.institucional.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(
                            "/",
                            "/empresa",
                            "/premios",
                            "/intranet",
                            "/noticias/**",
                            "/contato",
                            "/popup",
                            "/panel",
                            "/login/**",
                            "/docs/**",
                            "/js/**",
                            "/css/**",
                            "/fonts/**",
                            "/image/**",
                            "/lib/**",
                            "/files/**",
                            "/admin/usuarios/**",
                            "/admin/noticias/**",
                            "/admin/imagens/**",
                            "/admin/css/**",
                        	"/admin/image/**",
                        	"/admin/js/**",
                        	"/admin/js/**",
                            "/webjars/**")
                    	.permitAll()
                    .antMatchers("/admin/**").hasAuthority("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/panel")
                    .usernameParameter("email").passwordParameter("password")
                    .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("admin").password("password").roles("ADMIN");
    } 
    
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
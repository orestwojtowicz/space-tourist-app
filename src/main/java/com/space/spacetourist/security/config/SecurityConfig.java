package com.space.spacetourist.security.config;


import com.space.spacetourist.security.filters.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService myUserDetailsService;
    private JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(UserDetailsService myUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.myUserDetailsService = myUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);




    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/**/api/**").permitAll()
                .antMatchers(HttpMethod.GET,"/**/flight/tourist/{id}").permitAll()
                .antMatchers("/**/authenticate").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/hello/**").permitAll()
                .antMatchers("/api/add/tourist").permitAll()
                .antMatchers("/api/get/tourist/{id}").permitAll()
                .antMatchers("/**/create/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // applay filter chain


        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().sameOrigin(); // REMOVE LATER




    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

























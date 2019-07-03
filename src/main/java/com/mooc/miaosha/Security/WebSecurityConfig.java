package com.mooc.miaosha.Security;


import com.mooc.miaosha.Service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author fukang.yang 791934683@qq.com  fukang.yang@transwarp.io
 * @date 2019/6/27 9:45
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/com/mooc/miaosha").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login/to_login")
                .defaultSuccessUrl("/login/do_login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
        ;
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        return new MyUserDetailsService();
//    }
}

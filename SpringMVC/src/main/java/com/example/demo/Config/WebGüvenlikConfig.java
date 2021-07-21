package com.example.demo.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Maneger.KullaniciDetaylarService;

@Configuration
@EnableWebSecurity
public class WebGüvenlikConfig extends WebSecurityConfigurerAdapter{
    
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new KullaniciDetaylarService();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider autProvider=new DaoAuthenticationProvider();
		autProvider.setUserDetailsService(userDetailsService());
		autProvider.setPasswordEncoder(passwordEncoder());
		
		return autProvider;
	}
	



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/edit/**","/delete/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and() 
		.exceptionHandling().accessDeniedPage("/403");
	
	}
	

}

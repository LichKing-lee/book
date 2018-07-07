package com.yong.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.yong.book.login.LoginUserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity webSecurity) {
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/**").authenticated();
		httpSecurity.formLogin().loginProcessingUrl("/login");
		httpSecurity.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	}

	@Configuration
	public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		private LoginUserDetailsService loginUserDetailsService;

		public AuthenticationConfiguration(LoginUserDetailsService loginUserDetailsService) {
			this.loginUserDetailsService = loginUserDetailsService;
		}

		@Bean
		PasswordEncoder passwordEncoder() {
			return new PasswordEncoderImpl();
		}

		@Override
		public void init(AuthenticationManagerBuilder builder) throws Exception {
			builder.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder());
		}
	}

	public static class PasswordEncoderImpl implements PasswordEncoder {
		@Override
		public String encode(CharSequence rawPassword) {
			return "CRYPTO::" + rawPassword;
		}

		@Override
		public boolean matches(CharSequence rawPassword, String encodedPassword) {
			return encodedPassword.equals(encode(rawPassword));
		}
	}
}

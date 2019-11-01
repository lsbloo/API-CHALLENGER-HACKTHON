package com.softapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuração de autenticação e urls abertas;
 * 
 * @author osvaldoairon
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailService userDetailService;
	

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.POST, "/login").permitAll().
				antMatchers(HttpMethod.POST,"/creat/shop").permitAll()
				.antMatchers(HttpMethod.POST,"/creat/consumer").permitAll()
				.antMatchers(HttpMethod.POST,"soft/api/products").permitAll()
				.antMatchers(HttpMethod.POST,"/soft/api/keeper").authenticated()
				.and()
		        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
		        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
		        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
	}
	
	
	/**
	 * cria a autenticação entre meu usuarioservice;.
	 * o match entre o body post que vem da url /login tem seus parametros
	 * filtrados pelo JWTAuthentication e JWTAuthorization que retorna a bearer com o token do usuario logado
	 * 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder aDuth) throws Exception {
		aDuth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService);
		return authProvider;
	}
	
}

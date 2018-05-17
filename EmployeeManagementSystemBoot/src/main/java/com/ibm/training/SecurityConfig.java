/*package com.ibm.training;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication().dataSource(dataSource)
	    	.usersByUsernameQuery(
				"select uname,pwd from user where uname=?")
			.authoritiesByUsernameQuery(
				"select uname, role from user where uname=?");
	}
		
	

		// Authorization : Role -> Access
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic().and().authorizeRequests().antMatchers("/admin/**")
					.hasRole("admin").antMatchers("/**").hasRole("ADMIN").and()
					.csrf().disable().headers().frameOptions().disable();
		}

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .httpBasic()
    .and()
      .authorizeRequests()
        .antMatchers("/index.html", "/", "/home", "/login").permitAll()
        .anyRequest().authenticated();
  }
}

}
*/
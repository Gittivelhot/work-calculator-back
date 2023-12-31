package gittiVelhot.workCalculator;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import gittiVelhot.workCalculator.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private UserDetailService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http, UserDetailService userDetail) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers(antMatcher("/css/**")).permitAll() 
				.requestMatchers(antMatcher("/signup")).permitAll()
				.requestMatchers(antMatcher("/saveuser")).permitAll()
				.requestMatchers(antMatcher("/v3/api-docs/**")).permitAll() 
				.anyRequest().authenticated())
			.rememberMe((rememberMe) -> rememberMe
				.userDetailsService(userDetail)
				.tokenValiditySeconds(86400)
				.key("your-remember-me-key")
			)
			.httpBasic(Customizer.withDefaults())
			.csrf(csrf -> csrf.disable());

		return http.build();
	}
}

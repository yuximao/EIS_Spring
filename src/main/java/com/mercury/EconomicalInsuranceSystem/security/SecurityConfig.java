package com.mercury.EconomicalInsuranceSystem.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.EconomicalInsuranceSystem.security.handles.AuthenticationEntryPointImpl;
import com.mercury.EconomicalInsuranceSystem.security.handles.AuthenticationFailureHandlerImpl;
import com.mercury.EconomicalInsuranceSystem.security.handles.AuthenticationSuccessHandlerImpl;
import com.mercury.EconomicalInsuranceSystem.security.handles.LogoutSuccessHandlerImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)


@EnableWebSecurity		//也是一个bean
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private AuthenticationEntryPointImpl authenticationEntryPointImpl;
    
//    @Autowired
//    private AccessDeniedHandlerImpl accessDeniedHandlerImpl;
    
    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
    
    @Autowired
    private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
    
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
	
	
	@Autowired
	private UserDetialsServiceimpl userDetailsServiceimpl;
	
	public void configure(HttpSecurity http) throws Exception {
		http
			.cors().and()	//加入cors阻挡sop
//			.csrf()
//			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//			.and()
			.csrf().disable()	//关闭csrf保护iu
			.authorizeRequests()//许可请求
			//security的部份
//				.antMatchers(HttpMethod.GET,"/products","/index.html","/checkinfo").permitAll()	//做一些限定，比如密码要求 什么时候使用什么时候无效；可以是限定GET POST,或者指定界面
//				.antMatchers(HttpMethod.DELETE,"/orders/*")
//				.hasAuthority("ADMIN")	//只让admin可以删除;hasRole只能填一个，hasanyrole可以填多个；也可以在annotation里面写
//				.anyRequest().authenticated()
				.anyRequest().permitAll()
				.and()
				
				.exceptionHandling()
	                //.accessDeniedHandler(accessDeniedHandlerImpl)	//确保了页面有奇怪操作后不会跳出来
	                //.authenticationEntryPoint(authenticationEntryPointImpl)	//再把login页面做好前先//掉这块，不方便调试；用来解决匿名用户访问无权限资源时的异常
	                .and()
				
			.formLogin()		// if not login yet, redirect to /login page
			//自定义登陆界面,写自己的url
			//.loginPage(loginPage)
			//.isCustomLoginPage() 告诉系统我用的是自己的page
			//自定义username和psw的key名字
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(authenticationSuccessHandlerImpl)	//成功失败的反应
			.failureHandler(authenticationFailureHandlerImpl)
			.and()
			
			.logout()
	            .permitAll()    
	            .logoutUrl("/logout")
	            .logoutSuccessHandler(logoutSuccessHandlerImpl)
	            .and()
			
			.httpBasic()
			.and().rememberMe()
			;
	}
	
	//加密密码
	@Bean       // put the return object into spring container, as a bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
	}
	@Autowired      // @Autowired on function will autowired the parameters
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceimpl).passwordEncoder(passwordEncoder());
        //只要有了userDetailsService，就相当于告诉spring不要再使用默认的username了，不会再生成密码了
    }
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
	}
}

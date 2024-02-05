package community.portal.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http.csrf().disable()
            .authorizeHttpRequests()
            .antMatchers(HttpMethod.GET, "/").permitAll()
            .antMatchers(HttpMethod.GET, "/register").permitAll()
            .antMatchers(HttpMethod.POST, "/register").permitAll()
            .antMatchers(HttpMethod.GET, "/register/admin").permitAll()
            .antMatchers(HttpMethod.POST, "/register/admin").permitAll()
            .antMatchers(HttpMethod.GET, "/confirmation").permitAll()
            .antMatchers(HttpMethod.GET, "/verify").permitAll()
            .antMatchers(HttpMethod.GET, "/forget").permitAll()
            .antMatchers(HttpMethod.GET, "/sitemap").permitAll()
            .antMatchers(HttpMethod.POST, "/forget").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers(HttpMethod.GET, "/login").permitAll()
            .antMatchers(HttpMethod.POST, "/update-profile").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.GET, "/home").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.GET, "/search").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.GET, "/user").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.GET, "/profile").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.POST, "/post").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.POST, "/comment").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.GET, "/comment/**").hasAnyAuthority("user", "admin")
            .antMatchers(HttpMethod.GET, "/admin/modify/**").hasAnyAuthority("admin")
            .antMatchers(HttpMethod.GET, "/admin/modify").hasAnyAuthority("admin")
            .antMatchers(HttpMethod.POST, "/modify").hasAnyAuthority("admin")
            .antMatchers(HttpMethod.GET, "/css/**").permitAll()
            .antMatchers(HttpMethod.GET, "/js/**").permitAll()
            .antMatchers(HttpMethod.GET, "/images/**").permitAll()
            .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/home", true)
            .permitAll()
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .deleteCookies()
        .and()
            .exceptionHandling()
            .accessDeniedPage("/403");

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
        
}

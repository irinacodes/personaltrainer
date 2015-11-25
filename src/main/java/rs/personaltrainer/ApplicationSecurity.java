package rs.personaltrainer;


import com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBindingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;


@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RESTAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
                .password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //any request starting with “/rest/” in the URL will only be accessible to authenticated users
        http.authorizeRequests().antMatchers("/rest/**").authenticated();

        //disable cross site request forgery
        http.csrf().disable();

        //what happens when an unauthenticated client tries to access a restricted resource
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        //user is required to submit login credentials as a form
        http.formLogin().successHandler(authenticationSuccessHandler);

        //specify a custom authentication failure handler.
        http.formLogin().failureHandler(authenticationFailureHandler);

        http.logout().logoutSuccessUrl("/");

        // CSRF tokens handling
        http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
    }
}

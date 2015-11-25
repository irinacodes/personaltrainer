package rs.personaltrainer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import rs.personaltrainer.restsecurity.ApplicationSecurity;

@SpringBootApplication
public class Application {

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new ApplicationSecurity();
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // CORS
//    @Bean
//    FilterRegistrationBean corsFilter(@Value("${tagit.origin:http://localhost:8181}") final String origin) {
//        return new FilterRegistrationBean(new Filter() {
//            public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//
//                HttpServletRequest request = (HttpServletRequest) req;
//                HttpServletResponse response = (HttpServletResponse) res;
//                String method = request.getMethod();
//                // this origin value could just as easily have come from a database
//                response.setHeader("Access-Control-Allow-Origin", origin);
//                response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
//                response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
//                response.setHeader("Access-Control-Allow-Credentials", "true");
//                response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
//                if ("OPTIONS".equals(method)) {
//                    response.setStatus(HttpStatus.OK.value());
//                } else {
//                    chain.doFilter(req, res);
//                }
//            }
//
//            public void init(FilterConfig filterConfig) {}
//
//            public void destroy() {}
//        });
//    }


}

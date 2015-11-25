package rs.personaltrainer.restsecurity;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class RESTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        //make sure to clean up any authentication attributes left in the HttpServletRequest instance
        //by default the method will trigger a 200 status instead of a 301 normally sent by a Spring Security form login
        clearAuthenticationAttributes(request);
    }
}

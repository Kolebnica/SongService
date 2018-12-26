package beans.external;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class UserServiceBean {

    @Inject
    @DiscoverService(value = "userservice", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> userServiceWebTarget;

    @Counted(name = "callUserService", monotonic = true)
    public boolean validUserId(int userId) throws Exception{
        if(userServiceWebTarget.isPresent()) {
            WebTarget t = userServiceWebTarget.get();

             Response response = t.path("api/users/"+userId).request().head();

            return response.getStatus() == 200;
        }
        else{
            throw new Exception("User service not found");
        }
    }
}

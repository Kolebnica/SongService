package beans.external;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfileServiceBean {

    //TODO: external services

    /*
    @Inject
    @DiscoverService(value = "profileservice", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> profileServiceWebTarget;

    @Counted(name = "callProfileService", monotonic = true)
    public User getUserProfile() {
        if(profileServiceWebTarget.isPresent()) {
            WebTarget t = profileServiceWebTarget.get();

            User u = t.path("api/userprofile/1").request().get(User.class);

            return u;
        }

        // no service found
        return null;
    }
    */
}

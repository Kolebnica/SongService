package beans.external;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class LibraryServiceBean {

    @Inject
    @DiscoverService(value = "libraryservice", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> libraryServiceWebTarget;

    @Counted(name = "callLibraryService", monotonic = true)
    public boolean validAlbumId(int albumId) throws Exception{
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            //Response response = t.path("api/userprofile/"+userId).request().head();
            // TODO validate ids.
            //return response.getStatus() == 200;

            return true;
        }
        else{
            //throw new Exception("Library service not found");
            // TODO: odkomentiraj
            return true;
        }
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public boolean validArtistId(int artistId) throws Exception{
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            //Response response = t.path("api/userprofile/"+userId).request().head();
            // TODO validate ids.
            //return response.getStatus() == 200;

            return true;
        }
        else{
            //throw new Exception("Library service not found");
            // TODO: odkomentiraj
            return true;
        }
    }
}

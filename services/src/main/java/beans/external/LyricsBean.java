package beans.external;

import org.eclipse.microprofile.metrics.annotation.Counted;
import pojo.LyricsRequest;
import pojo.LyricsResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.xml.ws.Response;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class LyricsBean {

    @Counted(name = "callLirycsExternal", monotonic = true)
    public String getLyrics(String searchParam) throws Exception{
        Map<String, String> searchQuery = new HashMap<String, String>();
        searchQuery.put("search", searchParam);
        LyricsRequest lyricsRequest = new LyricsRequest();
        lyricsRequest.setId("9m9c8U4f");
        lyricsRequest.setKey("free");
        lyricsRequest.setData(searchQuery);


        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client
                .target("https://macgyverapi-music-graph-v1.p.rapidapi.com/");

        javax.ws.rs.core.Response response = webTarget
                .request()
                .header("X-RapidAPI-Key", "0b5c058cc3msh05b0a94245a9ef3p12ef18jsn680627a3ba53")
                .header("Content-Type", "application/json")
                .post(Entity.json(lyricsRequest));
        if(response.getStatus() == 200)
            return response.readEntity(String.class);
        else
            return null;
    }
}

package api.resources;


import beans.crud.StreamBean;
import beans.external.LyricsBean;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.logs.cdi.Log;
import entities.Stream;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
@Path("lyrics")
@ApplicationScoped
@Tags(value = @Tag(name = "stream"))
@Log
public class LyricsResource {

    @Inject
    private LyricsBean lyricsBean;

    @Operation(
            summary = "Get data",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Data."),
            }
    )
    @GET
    public Response getLyrics(@QueryParam("q") String query){
        try{
            return Response.ok(lyricsBean.getLyrics(query)).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}

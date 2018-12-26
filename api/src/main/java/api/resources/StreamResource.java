package api.resources;


import beans.crud.SongBean;
import beans.crud.StreamBean;
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

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM})
@Produces(MediaType.APPLICATION_JSON)
@Path("stream")
@ApplicationScoped
@Tags(value = @Tag(name = "stream"))
@Log
public class StreamResource {

    @Inject
    StreamBean streamBean;

    @Operation(
            summary = "Upload song",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Upload successful. Return is song id."),
            }
    )
    @POST
        public Response uploadStream(@RequestBody byte[] stream) {
        Stream s = streamBean.putStream(stream);
        return Response.ok(s.getId()).build();
    }

    @Operation(
            summary = "Get song",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Stream."),
            }
    )
    @GET
    @Path("{id}")
    public Response getStream(@PathParam("id") int streamId){
        Stream s = streamBean.getStreamById(streamId);
        return Response.ok(s.getData(),MediaType.APPLICATION_OCTET_STREAM).build();
    }
}

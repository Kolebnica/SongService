package api.resources;


import beans.crud.SongBean;
import beans.crud.StreamBean;
import com.kumuluz.ee.logs.cdi.Log;
import entities.Song;
import entities.Stream;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import pojo.UploadForm;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("upload")
@ApplicationScoped
@Tags(value = @Tag(name = "authentication"))
@Log
public class UploadResource {

    @Inject
    SongBean songBean;

    @Inject
    StreamBean streamBean;

    @Operation(
            summary = "Uploads songs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Upload successful. Return is song metadata."),
            }
    )
    @POST
    public Response uploadSong(@RequestBody UploadForm uploadForm) {
        Stream s = streamBean.putStream(uploadForm.getStream());
        Song song = uploadForm.getSong();
        song.setStream_id(s.getId());
        return Response.ok(songBean.putSong(song)).build();
    }
}

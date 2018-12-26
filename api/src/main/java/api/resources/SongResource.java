package api.resources;


import beans.crud.SongBean;
import com.kumuluz.ee.logs.cdi.Log;
import entities.Song;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import pojo.SongDataContract;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("song")
@ApplicationScoped
@Tags(value = @Tag(name = "authentication"))
@Log
public class SongResource {

    @Inject
    SongBean songBean;

    @Operation(
            summary = "Post song data",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Song metadata."),
            }
    )
    @POST
    public Response uploadSong(@RequestBody Song song) {
        return Response.ok(songBean.putSong(song)).build();
    }

    @Operation(
            summary = "Get song data",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Song metadata."),
            }
    )
    @GET
    @Path("{id}")
    public Response getSong(@PathParam("id") int songId){
        return Response.ok(songBean.getSong(songId)).build();
    }

    @Operation(
            summary = "Get list of all songs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All song metadata."),
            }
    )
    @GET
    @Path("/list")
    public Response getListOfSongs(){
        List<Song> songs = songBean.getAllSongs();

        List<SongDataContract> resultSongs = new ArrayList<SongDataContract>();

        for (Song song: songs) {
            SongDataContract sdc = new SongDataContract();

            sdc.setTitle(song.getTitle());
            sdc.setAlbum("Unknown");
            sdc.setArtist("Unknown");
            sdc.setStreamId(song.getStream_id());

            resultSongs.add(sdc);
        }

        return Response.ok(resultSongs).build();
    }


}

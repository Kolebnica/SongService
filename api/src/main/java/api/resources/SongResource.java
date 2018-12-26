package api.resources;


import beans.crud.SongBean;
import beans.external.LibraryServiceBean;
import beans.external.UserServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import entities.Song;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@Tags(value = @Tag(name = "song"))
@Log
public class SongResource {

    @Inject
    SongBean songBean;

    @Inject
    UserServiceBean userServiceBean;

    @Inject
    LibraryServiceBean libraryServiceBean;

    @Operation(
            summary = "Post song data",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Song metadata."),
            }
    )
    @POST
    public Response uploadSong(@RequestBody Song song) {
        try{
            if (song.getUser_id() == null)
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Missing user id.").build();

            if (!userServiceBean.validUserId(song.getUser_id()))
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Invalid user id.").build();

            if(song.getAlbum_id() != null){
                if(!libraryServiceBean.validAlbumId(song.getAlbum_id()))
                    return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Invalid album id.").build();
            }

            if(song.getArtist_id() != null){
                if(!libraryServiceBean.validArtistId(song.getArtist_id()))
                    return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Invalid artist id.").build();
            }

            return Response.ok(songBean.putSong(song)).build();
        }catch (Exception e){
            //log exception
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Something went wrong." + e).build();
        }
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

    @Operation(
            summary = "Get songs by artist",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Songs for given artist"),
            },
            parameters = {
                    @Parameter(name = "artistId", in = ParameterIn.PATH),
            }
    )
    @GET
    @Path("artist/{artistId}")
    public Response getSongsByArtist(@PathParam("artistId") int artistId) {
        return Response.ok(songBean.getSongsByArtist(artistId)).build();
    }

    @Operation(
            summary = "Get songs by album",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Songs in given album"),
            },
            parameters = {
                    @Parameter(name = "albumId", in = ParameterIn.PATH),
            }
    )
    @GET
    @Path("album/{albumId}")
    public Response getSongsByAlbum(@PathParam("albumId") int albumId) {
        return Response.ok(songBean.getSongsByAlbum(albumId)).build();
    }

    @Operation(
            summary = "Get songs by user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Songs by given user"),
            },
            parameters = {
                    @Parameter(name = "userId", in = ParameterIn.PATH),
            }
    )
    @GET
    @Path("user/{userId}")
    public Response getSongsByUser(@PathParam("userId") int userId) {
        return Response.ok(songBean.getSongsByUser(userId)).build();
    }

}

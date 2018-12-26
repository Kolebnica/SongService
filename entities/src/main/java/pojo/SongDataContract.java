package pojo;

public class SongDataContract {

    private String title;
    private String album;
    private String artist;
    private int streamId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getStreamId() {
        return streamId;
    }

    public void setStreamId(int streamId) {
        this.streamId = streamId;
    }
}
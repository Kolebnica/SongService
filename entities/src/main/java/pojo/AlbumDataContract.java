package pojo;

public class AlbumDataContract {

    private int id;
    private int userId;
    private String title;
    private ArtistDataContract artist;
    private int releaseYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArtistDataContract getArtist() {
        return artist;
    }

    public void setArtist(ArtistDataContract artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

}

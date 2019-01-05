package pojo;

import java.util.List;

public class ArtistDataContract {

    private int id;
    private int userId;
    private String creativeName;
    private String fullName;
    private List<AlbumDataContract> albums;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserIdd() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreativeName() {
        return creativeName;
    }

    public void setCreativeName(String creativeName) {
        this.creativeName = creativeName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<AlbumDataContract> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumDataContract> albums) {
        this.albums = albums;
    }

}

package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import java.io.Serializable;

@Entity(name = "songs")
@NamedQueries(value = {
    @NamedQuery(name = "Song.getById", query = "SELECT s FROM songs s WHERE s.id = :id"),
    @NamedQuery(name = "Song.getSongs", query = "SELECT s FROM songs s"),
    @NamedQuery(name = "Song.getSongsByArtist", query = "SELECT s FROM songs s WHERE s.artist_id = :id"),
    @NamedQuery(name = "Song.getSongsByUser", query = "SELECT s FROM songs s WHERE s.user_id = :id"),
    @NamedQuery(name = "Song.getSongsByAlbum", query = "SELECT s FROM songs s WHERE s.album_id = :id")
})
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlID
    @XmlElement
    private int id;

    @Column(unique = true)
    private Integer stream_id;

    private Integer artist_id;

    private Integer album_id;

    private String title;

    private Integer user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStream_id() {
        return stream_id;
    }

    public void setStream_id(Integer stream_id) {
        this.stream_id = stream_id;
    }

    public Integer getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Integer artist_id) {
        this.artist_id = artist_id;
    }

    public Integer getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}

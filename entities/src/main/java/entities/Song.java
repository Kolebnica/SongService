package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import java.io.Serializable;

@Entity(name = "songs")
@NamedQueries(value = {
    @NamedQuery(name = "Song.getById", query = "SELECT s FROM songs s WHERE s.id = :id")
})
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlID
    @XmlElement
    private int id;

    @Column(unique = true)
    private int stream_id;

    private int artist_id;

    private int album_id;

    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStream_id() {
        return stream_id;
    }

    public void setStream_id(int stream_id) {
        this.stream_id = stream_id;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

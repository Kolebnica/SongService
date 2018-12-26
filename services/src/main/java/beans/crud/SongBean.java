package beans.crud;

import entities.Song;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SongBean {

    @PersistenceContext(unitName = "sr-jpa")
    private EntityManager em;

    @Inject
    @Metric(name="songDbCall")
    private Counter counter;

    /**
     * Get song by id
     */
    @Transactional
    public Song getSong(int id) {
        return em.find(Song.class, id);
    }

    /**
     * Get all songs
     */
    @Transactional
    public List<Song> getAllSongs() {
        TypedQuery<Song> q = em.createNamedQuery("Song.getSongs", Song.class);
        return q.getResultList();
    }

    /**
     * Put new song
     */
    @Transactional
    public Song putSong(Song song){
        em.persist(song);
        em.flush();
        return song;
    }

    @Counted(name = "SongBeanCall", monotonic = true)
    public List<Song> getSongsByArtist(int artistId) {
        TypedQuery<Song> q = em.createNamedQuery("Song.getSongsByArtist", Song.class).setParameter("id", artistId);
        return q.getResultList();
    }

    @Counted(name = "SongBeanCall", monotonic = true)
    public List<Song> getSongsByAlbum(int albumId) {
        TypedQuery<Song> q = em.createNamedQuery("Song.getSongsByAlbum", Song.class).setParameter("id", albumId);
        return q.getResultList();
    }

    @Counted(name = "SongBeanCall", monotonic = true)
    public List<Song> getSongsByUser(int userId) {
        TypedQuery<Song> q = em.createNamedQuery("Song.getSongsByUser", Song.class).setParameter("id", userId);
        return q.getResultList();
    }
}

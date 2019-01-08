package beans.crud;

import entities.Song;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SongBean {

    @PersistenceContext(unitName = "sr-jpa")
    private EntityManager em;

    /**
     * Get song by id
     */
    @Transactional
    @Counted(name = "SongBeanCall", monotonic = true)
    public Song getSong(int id) {
        return em.find(Song.class, id);
    }

    /**
     * Get all songs
     */
    @Transactional
    @Counted(name = "SongBeanCall", monotonic = true)
    public List<Song> getAllSongs() {
        TypedQuery<Song> q = em.createNamedQuery("Song.getSongs", Song.class);
        return q.getResultList();
    }

    /**
     * Put new song
     */
    @Transactional
    @Counted(name = "SongBeanCall", monotonic = true)
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

    @Transactional
    @Counted(name = "SongBeanCall", monotonic = true)
    public Song updateSong(int id, Song s) {
        Song existing = em.find(Song.class, id);
        if (existing == null) {
            return null;
        }

        s.setId(existing.getId());
        s = em.merge(s);
        em.flush();
        return s;
    }
}

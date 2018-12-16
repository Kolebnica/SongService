package beans.crud;

import entities.Song;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

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
     * Put new song
     */
    @Transactional
    public Song putSong(Song song){
        em.persist(song);
        em.flush();
        return song;
    }
}

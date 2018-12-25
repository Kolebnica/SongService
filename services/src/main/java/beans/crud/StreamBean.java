package beans.crud;

import entities.Song;
import entities.Stream;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class StreamBean {

    @PersistenceContext(unitName = "sr-jpa")
    private EntityManager em;

    /**
     * Put new stream
     */
    @Transactional
    public Stream putStream(byte[] dataStream){
        Stream s = new Stream();
        s.setData(dataStream);

        em.persist(s);
        em.flush();
        return s;
    }
}

package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import java.io.Serializable;

@Entity(name = "streams")
@NamedQueries(value = {
    @NamedQuery(name = "Stream.getById", query = "SELECT s FROM streams s WHERE s.id = :id")
})
public class Stream implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlID
    @XmlElement
    private int id;

    private byte[] data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

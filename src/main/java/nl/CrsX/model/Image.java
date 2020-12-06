package nl.CrsX.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "Image")
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    @Lob
    private byte[] pic;

    public Image(String name, String type, byte[] pic){
        this.name = name;
        this.type = type;
        this.pic = pic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}

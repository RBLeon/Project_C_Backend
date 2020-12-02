package nl.CrsX.dao;

import nl.CrsX.model.Image;

import java.util.List;

public interface ImageDao {

    Image save(Image image);

    Image get(long id);

    List<Image> list();

    void update(long id, Image image);

    void delete(long id);

}

package nl.CrsX.service;

import nl.CrsX.model.Image;

import java.util.List;

public interface ImageService {

    Image save(Image car);

    Image get(long id);

    List<Image> list();

    void update(long id, Image car);

    void delete(long id);
}

package nl.CrsX.service;

import nl.CrsX.dao.ImageDao;
import nl.CrsX.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ImageServiceImp implements ImageService{
    @Autowired
    private ImageDao imageDao;

    @Override
    @Transactional
    public Image save(Image image) {
        return imageDao.save(image);
    }

    @Override
    @Transactional
    public Image get(long id) {
        return imageDao.get(id);
    }

    @Override
    @Transactional
    public List<Image> list() {
        return imageDao.list();
    }

    @Override
    @Transactional
    public void update(long id, Image image) {
        imageDao.update(id, image);
    }

    @Override
    @Transactional
    public void delete(long id) {
        imageDao.delete(id);
    }
}

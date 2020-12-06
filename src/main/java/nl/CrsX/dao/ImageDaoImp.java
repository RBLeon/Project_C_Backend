package nl.CrsX.dao;

import nl.CrsX.model.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDaoImp implements ImageDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Image save(Image image) {
        sessionFactory.getCurrentSession().save(image);
        return image;
    }

    @Override
    public Image get(long id) {
        return sessionFactory.getCurrentSession().get(Image.class, id);
    }

    @Override
    public List<Image> list() {
        List<Image> list = sessionFactory.getCurrentSession().createQuery("from Image").list();
        return list;
    }

    @Override
    public void update(long id, Image image) {
        Session session = sessionFactory.getCurrentSession();
        Image Image2 = session.byId(Image.class).load(id);
        Image2.setName(image.getName());;
        Image2.setType(image.getType());
        Image2.setPic(image.getPic());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Image image = sessionFactory.getCurrentSession().byId(Image.class).load(id);
        sessionFactory.getCurrentSession().delete(image);
    }
}

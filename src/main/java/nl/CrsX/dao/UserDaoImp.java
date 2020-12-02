package nl.CrsX.dao;


import nl.CrsX.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

    @Override
    public User get(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User GetUserByUsername(String username) {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
        User retrievedUser = new User();
        for (User user: list) {
            if(username.equals(user.getUserName())){
                retrievedUser = user;
            }
        }
        return retrievedUser;
    }

    @Override
    public List<User> list() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
        return list;
    }

    @Override
    public void update(long id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User user2 = session.byId(User.class).load(id);
        user2.setAddress(user.getAddress());
        user2.setEmail(user.getEmail());
        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        user2.setPassword(user.getPassword());
        user2.setUserName(user.getUserName());
        session.flush();
    }

    @Override
    public void delete(long id) {
        User user = sessionFactory.getCurrentSession().byId(User.class).load(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}

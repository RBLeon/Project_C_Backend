package nl.CrsX.service;

import nl.CrsX.dao.UserDao;
import nl.CrsX.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public long save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public User get(long id) {
        return userDao.get(id);
    }

    @Override
    @Transactional
    public User GetUserByUsername(String username) {
        return userDao.GetUserByUsername(username);
    }

    @Override
    @Transactional
    public List<User> list() {
        return userDao.list();
    }

    @Override
    @Transactional
    public void update(long id, User user) { userDao.update(id, user); }

    @Override
    @Transactional
    public void delete(long id) { userDao.delete(id); }
}

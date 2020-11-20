package nl.CrsX.dao;

import nl.CrsX.model.User;

import java.util.List;

public interface UserDao {
        long save(User car);

        User get(long id);

        User GetUserByUsername(String username);

        List<User> list();

        void update(long id, User user);

        void delete(long id);

}

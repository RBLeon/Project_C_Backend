package nl.CrsX.service;

import nl.CrsX.model.User;

import java.util.List;

public interface UserService {
    long save(User user);

    User get(long id);

    User GetUserByUsername(String username);

    List<User> list();

    void update(long id, User user);

    void delete(long id);
}

package beganov.dao;

import beganov.entity.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> getUsers();

    User getUserById(long id);

    void deleteUser(long id);

    void updateUser(User user, long id);
}

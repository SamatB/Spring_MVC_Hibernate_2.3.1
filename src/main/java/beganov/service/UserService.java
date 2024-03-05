package beganov.service;

import beganov.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getUsers();

    User getUserById(long id);

    void deleteUser(long id);

    void updateUser(User user, long id);

}

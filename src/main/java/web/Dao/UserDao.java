package web.Dao;

import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import java.util.List;

public interface UserDao {
    List<User> allUser();

    void saveUser(User user);

    void delete(int id);

    void edit(User user);

    User getById(int id);

    List<User> getAllUsers();

    void update(int id, User user);

}


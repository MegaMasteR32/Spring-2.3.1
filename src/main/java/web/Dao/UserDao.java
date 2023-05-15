package web.Dao;

import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void delete(int id);

    User getById(int id);

    List<User> getAllUsers();


}


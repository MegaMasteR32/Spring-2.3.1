package web.Service;

import web.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUsers(User user);

    User getById(int id);

    void update(int id, User user);

    void delete(int id);
}

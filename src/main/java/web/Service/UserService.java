package web.Service;

import web.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUsers(User user);

    User getById(int id);

    void delete(int id);
}

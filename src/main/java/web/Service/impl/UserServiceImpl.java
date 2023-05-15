package web.Service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.Model.User;
import web.Service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUsers(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
package web.Dao;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@AllArgsConstructor
class UserDaoImpl implements UserDao{
    private final SessionFactory sessionFactory;

    @Override
    public List<User> allUser() {
        sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    @Transactional
    public void saveUser(User user) { sessionFactory.getCurrentSession().saveOrUpdate(user);

    }

    @Override
    @Transactional
    public void delete(int id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("delete from User where id =:userID");
        query.setParameter("userID", id);
        query.executeUpdate();

    }
    @Override
    @Transactional
    public void update(int id, User updateUser){
        User userToBeUpdate = getById(id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setSurname((updateUser.getSurname()));
        userToBeUpdate.setAge(updateUser.getAge());
        userToBeUpdate.setEmail(updateUser.getEmail());
        saveUser(userToBeUpdate);

    }

    @Override
    @Transactional
    public void edit(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
//        return List.of(new User( "frfr", "regr", 5,"f@grfg"),new User("frfr2", "regr2", 5,"f@grfg2"));
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
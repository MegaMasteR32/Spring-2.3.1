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
class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;


    @Override
    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
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
    public User getById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
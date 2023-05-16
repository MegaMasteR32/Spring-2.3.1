package web.Dao;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@AllArgsConstructor
class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        TypedQuery<User> query = entityManager.getCurrentSession().createQuery("delete from User where id =:userID");
        query.setParameter("userID", id);
        query.executeUpdate();

    }

    @Override
    @Transactional
    public User getById(int id) {
        return entityManager.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
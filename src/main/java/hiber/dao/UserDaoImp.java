package hiber.dao;

import hiber.model.User;
import hiber.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUser(String model, int series) {
        Session session = sessionFactory.openSession();
        String queryUserByCarId = "from User u where u.car.model = :model and u.car.series = :series";
        TypedQuery<User> query2 = session.createQuery(queryUserByCarId);
        query2.setParameter("model", model);
        query2.setParameter("series", series);
        User user = query2.getSingleResult();
        session.close();
        return user;

    }
}

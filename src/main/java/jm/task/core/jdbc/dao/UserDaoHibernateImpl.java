package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {



    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String create = "CREATE TABLE `pavel`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastName` VARCHAR(45) NULL,\n" +
                    "  `age` INT NULL,\n" +
                    "  PRIMARY KEY (`idUser`),\n" +
                    "  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) VISIBLE)";

        Query query = session.createSQLQuery(create);

        transaction.commit();
        session.close();

    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS users";

        Query query = session.createSQLQuery(sql);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(User user) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
            session.close();
        }

    }

    @Override
    public void removeUserById(User user) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(user);

            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "SELECT * FROM users";

        session.getSession();
        Query query = session.createNativeQuery(sql);
        List<User> userList = query.list();

        transaction.commit();
        session.close();

        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String delete = "DELETE FROM users";
        session.createSQLQuery(delete);

        transaction.commit();
        session.close();
    }
}

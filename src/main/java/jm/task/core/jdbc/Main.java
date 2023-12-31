package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getSessionFactory();
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();

        userDao.saveUser("name1", "lastName1", (byte) 22);
        userDao.saveUser("name2", "lastName2", (byte) 1);
        userDao.saveUser("name3", "lastName3", (byte) 34);
        userDao.saveUser("name4", "lastName4", (byte) 55);

        userDao.removeUserById(3L);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}

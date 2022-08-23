package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

            userService.createUsersTable();


        List<User> users = new ArrayList<>();
        users.add(new User("Keig", "Hearts", (byte) 4));
        users.add(new User("Evklid", "Hearts", (byte) 5));
        users.add(new User("Martell", "Hearts", (byte) 6));
        users.add(new User("Avrora", "Hearts", (byte) 8));

        for (User us : users) {
            userService.saveUser(us.getName(), us.getLastName(), (byte) us.getAge());
        }

        List<User> usersTable = userService.getAllUsers();
        for (User us : usersTable) {
            System.out.println(us);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    public  void add(Car car);
    List<User> listUsers();

    User getUser(String model, int series);
}

package web.repository;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    public void delete(Long id);


    public void update(User updatedUser);


    User getUserById(Long id);

    List<User> getAllUsers();

    User getUserByUsername(String username);


}

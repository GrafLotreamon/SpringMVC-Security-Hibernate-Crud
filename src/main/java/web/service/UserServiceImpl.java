package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserDao;

import javax.inject.Named;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;

    }

    public void addUser(User user) {

        String p = user.getPassword();
        user.setPassword(passwordEncoder.encode(p));
        userDao.addUser(user);


    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }


    public void update(User updatedUser) {
        String p = updatedUser.getPassword();
        updatedUser.setPassword(passwordEncoder.encode(p));
        userDao.update(updatedUser);
    }


    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByUsername(username);


    }


}

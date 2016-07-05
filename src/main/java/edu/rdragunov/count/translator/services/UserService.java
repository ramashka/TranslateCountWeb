package edu.rdragunov.count.translator.services;

import edu.rdragunov.count.translator.entities.User;
import edu.rdragunov.count.translator.repositories.UserRepository;
import edu.rdragunov.count.translator.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by roman.dragunov on 13-04-02016.
 */

@Component
@Transactional
public class UserService implements IUserService{
  @Autowired
  private UserRepository userRepository;


  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Long id) {
    return userRepository.findById(id);
  }

  public List<User> save(Collection<User> users){
    return userRepository.save(users);
  }

  public void delete(User user){
      userRepository.delete(user);
  }

  public User login(String login, String password) {
    password= password==null ? "" : password;
    User u=userRepository.findByNickName(login);
    if (u==null){
      return null;
    }
    String userPass=u.getPassword();
    userPass= userPass==null ? "" :userPass;
    if (password.equals(userPass)){
      return u;
    }
    return null;
  }

  public User save(User user){
    System.out.println("Start to save user: " + user);
    user=userRepository.save(user);
    System.out.println("User has been save successfully: " + user);
    return user;
  }
}

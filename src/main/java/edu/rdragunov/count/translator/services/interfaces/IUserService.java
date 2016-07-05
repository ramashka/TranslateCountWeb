package edu.rdragunov.count.translator.services.interfaces;


import edu.rdragunov.count.translator.entities.User;

import java.util.Collection;

/**
 * Created by roman.dragunov on 13-04-02016.
 */
public interface IUserService {
  Collection<User> findAll();
  User findById(Long id);
  User save(User user);
  User login(String login, String password);

}

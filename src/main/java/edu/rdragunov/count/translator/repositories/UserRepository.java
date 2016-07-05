package edu.rdragunov.count.translator.repositories;

import edu.rdragunov.count.translator.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by roman.dragunov on 13-04-02016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findById(Long Id);
  User findByNickName(String login);

}

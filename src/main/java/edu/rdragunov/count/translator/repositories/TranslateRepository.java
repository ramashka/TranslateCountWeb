package edu.rdragunov.count.translator.repositories;

import edu.rdragunov.count.translator.entities.Translate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by roman.dragunov on 13-04-02016.
 */
@Repository
public interface TranslateRepository extends JpaRepository<Translate, Long> {
  Translate findById(Long Id);
  List<Translate> findByUserIdAndDateBetween(Long userId, Date startDate, Date endDate);
  List<Translate> findByDateBetween(Date startDate, Date endDate);

}

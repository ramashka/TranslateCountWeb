package edu.rdragunov.count.translator.services.interfaces;

import edu.rdragunov.count.translator.entities.Translate;

import java.util.Collection;
import java.util.Date;

/**
 * Created by roman.dragunov on 20-05-02016.
 */
public interface ITranslateService {
  Collection<Translate> findAll();
  Collection<Translate> findTranslatesBetweenDate(Date startDate, Date endDate);
  Collection<Translate> findTranslatesByThisWeek();
  Collection<Translate> findTranslatesByLastWeek();
  Collection<Translate> findTranslatesByThisMonth();
  Collection<Translate> findTranslatesByLastMonth();
  Collection<Translate> save(Iterable<Translate> translates);
  Translate save(Translate translate);
}

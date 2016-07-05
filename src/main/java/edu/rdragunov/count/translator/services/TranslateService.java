package edu.rdragunov.count.translator.services;

import edu.rdragunov.count.translator.entities.Translate;
import edu.rdragunov.count.translator.repositories.TranslateRepository;
import edu.rdragunov.count.translator.services.interfaces.ITranslateService;
import edu.rdragunov.count.translator.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

/**
 * Created by roman.dragunov on 13-04-02016.
 */

@Component
@Transactional
public class TranslateService implements ITranslateService{
  @Autowired
  private TranslateRepository translateRepository;

    @Override
    public Collection<Translate> findAll() {
      return translateRepository.findAll();
    }

    @Override
    public Collection<Translate> findTranslatesBetweenDate(Date startDate, Date endDate) {
      return translateRepository.findByDateBetween(startDate,endDate);
    }

    @Override
    public Collection<Translate> findTranslatesByThisWeek() {
      DateHelper.DateBetween thisWeek=DateHelper.getThisWeek();
      return translateRepository.findByDateBetween(thisWeek.getStartDate(),thisWeek.getEndDate());
    }

    @Override
    public Collection<Translate> findTranslatesByLastWeek() {
      DateHelper.DateBetween lastWeek=DateHelper.getPrevWeek();
      return translateRepository.findByDateBetween(lastWeek.getStartDate(),lastWeek.getEndDate());
    }

    @Override
    public Collection<Translate> findTranslatesByThisMonth() {
      DateHelper.DateBetween thisMonth=DateHelper.getThisMonth();
      return translateRepository.findByDateBetween(thisMonth.getStartDate(),thisMonth.getEndDate());
    }

    @Override
    public Collection<Translate> findTranslatesByLastMonth() {
      DateHelper.DateBetween lastMonth=DateHelper.getPrevMonth();
      return translateRepository.findByDateBetween(lastMonth.getStartDate(),lastMonth.getEndDate());
    }

    @Override
    public Collection<Translate> save(Iterable<Translate> translates) {
      return translateRepository.save(translates);
    }

    @Override
    public Translate save(Translate translate) {
      return translateRepository.save(translate);
    }
}

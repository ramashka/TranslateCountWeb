package edu.rdragunov.count.translator.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by roman.dragunov on 20-05-02016.
 */
public class DateHelper {

  public static DateBetween getThisMonth(){
    Calendar c=getZeroHourMinuteSecondMillisInCalendar();
    c.set(Calendar.DAY_OF_MONTH,1);
    Date start=c.getTime();
    c.add(Calendar.MONTH,1);
    c.add(Calendar.DAY_OF_MONTH,-1);
    Date end=c.getTime();
    return new DateBetween(start,end);
  }

  public static DateBetween getPrevMonth(){
    Calendar c=getZeroHourMinuteSecondMillisInCalendar();
    c.set(Calendar.DAY_OF_MONTH,1);
    c.add(Calendar.DAY_OF_MONTH,-1);
    Date end=c.getTime();
    c.set(Calendar.DAY_OF_MONTH,1);
    Date start=c.getTime();
    return new DateBetween(start,end);
  }

  public static DateBetween getPrevWeek(){
    Calendar c=getZeroHourMinuteSecondMillisInCalendar();
    int i=c.get(Calendar.DAY_OF_WEEK)-c.getFirstDayOfWeek();
    c.add(Calendar.DATE, -i -7);
    Date start=c.getTime();
    c.add(Calendar.DATE,6);
    Date end=c.getTime();
    return new DateBetween(start, end);
  }

  public static DateBetween getThisWeek(){
    Calendar c=getZeroHourMinuteSecondMillisInCalendar();
    int i=c.get(Calendar.DAY_OF_WEEK)-c.getFirstDayOfWeek();
    c.add(Calendar.DATE, -i);
    Date start=c.getTime();
    c.add(Calendar.DATE,6);
    Date end=c.getTime();
    return new DateBetween(start, end);
  }

  private static Calendar getZeroHourMinuteSecondMillisInCalendar(){
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY,0);
    calendar.set(Calendar.MINUTE,0);
    calendar.set(Calendar.SECOND,0);
    calendar.set(Calendar.MILLISECOND,0);
    return calendar;
  }

  public static class DateBetween{
    private Date startDate;
    private Date endDate;

    public DateBetween(Date startDate, Date endDate){
      this.startDate=startDate;
      this.endDate=endDate;
    }

    public Date getStartDate() {
      return startDate;
    }

    public Date getEndDate() {
      return endDate;
    }
  }
}

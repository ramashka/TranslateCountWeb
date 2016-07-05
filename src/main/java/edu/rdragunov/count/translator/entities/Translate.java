package edu.rdragunov.count.translator.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rdragunov on 11.04.2016.
 */
@Entity
@Table(name = "translate")
public class Translate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "SYMBOLS_COUNT")
    private long symbolsCount;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;
    private Long userId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getSymbolsCount() {
        return symbolsCount;
    }

    public void setSymbolsCount(long symbolsCount) {
        this.symbolsCount = symbolsCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Translate{" +
            "id=" + id +
            ", date=" + date +
            ", symbolsCount=" + symbolsCount +
            ", user=" + user +
            ", userId=" + userId +
            '}';
    }
}

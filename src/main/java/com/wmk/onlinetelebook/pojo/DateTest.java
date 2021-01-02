package com.wmk.onlinetelebook.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTest {
    private int id;
    private LocalDate date;
    private LocalDateTime timeStamp;
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "DateTest{" +
                "id=" + id +
                ", date=" + date +
                ", timeStamp=" + timeStamp +
                ", dateTime=" + dateTime +
                '}';
    }

    public DateTest(LocalDate date, LocalDateTime timeStamp, LocalDateTime dateTime) {
        this.date = date;
        this.timeStamp = timeStamp;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

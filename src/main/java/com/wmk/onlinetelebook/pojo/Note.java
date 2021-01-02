package com.wmk.onlinetelebook.pojo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
    private Date date;
    private String dateStr;
    private String weather;
    private String content;
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString() {
        return "Note{" +
                "date=" + date +
                ", dateStr='" + dateStr + '\'' +
                ", weather='" + weather + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    static int i = 1;
    public Note(Date date, String weather, String content) {
        this.date = date;
        this.dateStr = formatter.format(date);
        this.weather = weather;
        this.content = content;
        this.index = i++;
    }
}

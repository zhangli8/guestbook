package com.zhangli;


import java.sql.Timestamp;

public class Guestbook {

  private long id;
  private String name;
  private String title;
  private String subTitle;
  private java.sql.Timestamp date;
  private String content;

  public Guestbook() {
  }

  public Guestbook(String name, String title, String subTitle, Timestamp date, String content) {
    this.name = name;
    this.title = title;
    this.subTitle = subTitle;
    this.date = date;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}

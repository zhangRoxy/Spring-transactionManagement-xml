package com.zrs.bean;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_account")
public class Account {

  private long id;
  private String username;
  private double money;

  public Account() {
  }

  public Account(String username, double money) {
    this.username = username;
    this.money = money;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", money=" + money +
            '}';
  }
}

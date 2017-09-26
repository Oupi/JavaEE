/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Opiframe
 */
@Component
public class UserRepository {

  private List<User> userList = new ArrayList<>();

  public boolean addUser(User user) {
    boolean isFound = false;

    for (User u : userList) {
      if (u.getUserName().equals(user.getUserName())) {
        isFound = true;
      }
    }
    if (!isFound) {
      userList.add(user);
      return true;
    }
    return false;
  }

  public boolean checkUser(User user) {
    boolean isFound = false;

    for (User u : userList) {
      if (u.getUserName().equals(user.getUserName())) {
        if (u.getPassword().equals(user.getPassword())) {
          isFound = true;
        }
      }
    }
    return isFound;
  }
}

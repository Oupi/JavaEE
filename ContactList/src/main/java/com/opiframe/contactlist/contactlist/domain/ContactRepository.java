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
public class ContactRepository {

  private List<Contact> contactList = new ArrayList<>();

  public List<Contact> findByLastName(String lastName) {
    List<Contact> tempList = new ArrayList<>();

    for (Contact c : this.contactList) {
      if (c.getLastName().contentEquals(lastName)) {
        tempList.add(c);
      }
    }
    return tempList;
  }
  
  public boolean addContact(Contact contact){
    if(!contactList.contains(contact)){
      contactList.add(contact);
      return true;
    }
    return false;
  }
  
  public boolean deleteAll(){
    contactList.clear();
    return true;
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.service;

import com.opiframe.contactlist.contactlist.domain.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.opiframe.contactlist.contactlist.domain.Contact;
import com.opiframe.contactlist.contactlist.domain.User;
import com.opiframe.contactlist.contactlist.domain.UserRepository;

/**
 *
 * @author Opiframe
 */
@Service
public class ContactService {

  @Autowired
  private ContactRepository repo;

  @Autowired
  private UserRepository userRepo;

  public List<Contact> findByLastName(String lastName) {
    return repo.findByLastName(lastName);
  }

  public boolean addContact(Contact contact) {
    return repo.addContact(contact);
  }

  public boolean deleteAll() {
    return repo.deleteAll();
  }

  public boolean addUser(User user) {
    return userRepo.addUser(user);
  }

  public boolean checkUser(User user) {
    return userRepo.checkUser(user);
  }
}

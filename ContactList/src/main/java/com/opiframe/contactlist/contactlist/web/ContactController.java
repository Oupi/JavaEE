/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.web;

import com.opiframe.contactlist.contactlist.domain.Contact;
import com.opiframe.contactlist.contactlist.domain.User;
import com.opiframe.contactlist.contactlist.service.ContactService;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Opiframe
 */
@RestController
public class ContactController {
  @Autowired
  private ContactService service;
  
  @RequestMapping(value="api/contact/{lastName}",method=RequestMethod.GET)
  public @ResponseBody List<Contact> findByLastName(@PathVariable("lastName") String lastName){
    return service.findByLastName(lastName);
  }
  
  @RequestMapping(value="api/contact", method=RequestMethod.POST)
  public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
    Random random = new Random();
    Long id = random.nextLong();
    contact.setId(id);
    if(service.addContact(contact)){
      return new ResponseEntity<Contact>(contact,HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.CONFLICT);
  }
  
  @RequestMapping(value="api/contact", method=RequestMethod.DELETE)
  public @ResponseBody String deleteAll(){
    service.deleteAll();
    return "{'Status':'Success'}";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public ResponseEntity<String> login(@RequestBody User user){
    if(service.checkUser(user)){
      return new ResponseEntity<String>("{\"authtoken\":\"123\"}", HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
  }
  
  @RequestMapping(value="/register", method=RequestMethod.POST)
  public ResponseEntity<User> register(@RequestBody User user){
    if(service.addUser(user)){
      return new ResponseEntity<User>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.CONFLICT);
    }
  }
}

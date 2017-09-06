/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.coursemanager;

import com.opiframe.java.coursemanager.models.Address;
import com.opiframe.java.coursemanager.models.Course;
import com.opiframe.java.coursemanager.models.Room;
import com.opiframe.java.coursemanager.models.Student;
import com.opiframe.java.coursemanager.models.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Opiframe
 */
@Named(value = "controller")
@RequestScoped
public class Controller {

  public static final int STUDENT_CHOICE = 1,
          TEACHER_CHOICE = 2,
          ROOM_CHOICE = 3,
          COURSE_CHOICE = 4;
  private int choice;
  private String firstName, lastName, courseName, teacherTitle,
          city, streetAddress, roomName;
  private int roomNumber;
  
  private List<?> list; 
  /**
   * Creates a new instance of Controller
   */
  public Controller() {
  }
  
  public List<Room> getRooms(){
    return new ArrayList<Room>();
  }  
  
  public String addRoom(){
    Room tempRoom = new Room();
    tempRoom.setNumber(roomNumber);
    tempRoom.setName(roomName);
    
    return "index";
  }
  
  public String addTeacher(){
    Teacher tempTchr = new Teacher();
    tempTchr.setTitle(teacherTitle);
    tempTchr.setFirstName(firstName);
    tempTchr.setLastName(lastName);
    
    Address tempAddr = new Address();
    tempAddr.setStreetAddress(streetAddress);
    tempAddr.setCity(city);
    
    tempTchr.setAddress(tempAddr);
    
    return "index";
  }
  

  public void remove(Object o){
    if(o instanceof com.opiframe.java.coursemanager.models.Student){
      
    }
    if(o instanceof com.opiframe.java.coursemanager.models.Teacher){
      
    }
    if(o instanceof com.opiframe.java.coursemanager.models.Room){
      
    }
    if(o instanceof com.opiframe.java.coursemanager.models.Course){
      
    }
  }
  
  /**
   * @return the list
   */
  public List<?> getList() {
    switch(choice){
      case STUDENT_CHOICE:
        return (List<Student>)list;
      case TEACHER_CHOICE:
        return (List<Teacher>)list;
      case ROOM_CHOICE:
        return (List<Room>)list;
      case COURSE_CHOICE:
        return (List<Course>)list;
      default:
        return null;
    }
  }

  /**
   * @param list the list to set
   */
  public void setList(List<?> list) {
    this.list = list;
  }

  /**
   * @return the choice
   */
  public int getChoice() {
    return choice;
  }

  /**
   * @param choice the choice to set
   */
  public void setChoice(int choice) {
    this.choice = choice;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the courseName
   */
  public String getCourseName() {
    return courseName;
  }

  /**
   * @param courseName the courseName to set
   */
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  /**
   * @return the teacherTitle
   */
  public String getTeacherTitle() {
    return teacherTitle;
  }

  /**
   * @param teacherTitle the teacherTitle to set
   */
  public void setTeacherTitle(String teacherTitle) {
    this.teacherTitle = teacherTitle;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the streetAddress
   */
  public String getStreetAddress() {
    return streetAddress;
  }

  /**
   * @param streetAddress the streetAddress to set
   */
  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  /**
   * @return the roomName
   */
  public String getRoomName() {
    return roomName;
  }

  /**
   * @param roomName the roomName to set
   */
  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  /**
   * @return the roomNumber
   */
  public int getRoomNumber() {
    return roomNumber;
  }

  /**
   * @param roomNumber the roomNumber to set
   */
  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }
}

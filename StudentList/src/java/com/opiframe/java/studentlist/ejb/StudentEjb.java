/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.studentlist.ejb;

import com.opiframe.java.studentlist.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Opiframe
 */
@Stateless
public class StudentEjb {
  
  private List<Student> studentList = new ArrayList<>();
  
  public List<Student> findAll(){
    return studentList;
  }
  
  public void addStudent(Student student){
    for(Student std:this.studentList){
      if(std.getStudentId() == student.getStudentId()){
        return;
      }      
    }
    this.studentList.add(student);
  }
  
  public void removeStudent(Student student){
    if(this.studentList.contains(student)){
      this.studentList.remove(student);
    }
  }  
}

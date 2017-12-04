/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Oula
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "carShop")
public class Car {

    @Id
    private String id;
    
    @Indexed
    private String type;
    
    private int price;
    private int year;
}

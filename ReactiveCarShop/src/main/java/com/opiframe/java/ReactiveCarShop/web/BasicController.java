/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Oula
 */
@Controller
public class BasicController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
    
}

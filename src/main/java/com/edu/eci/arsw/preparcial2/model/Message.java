/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eci.arsw.preparcial2.model;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Sebastián Reyes
 */
public class Message {
    
    @Id
    public String id;
    
    public String message;
    public String date;
    
    public Message() {}
    
    public Message(String message, String date) {
        this.message = message;
        this.date = date;
    }
    
    @Override
    public String toString() {
        return String.format("Message[id=%s, message='%s', date='%s']", id, message, date);
    }
    
}

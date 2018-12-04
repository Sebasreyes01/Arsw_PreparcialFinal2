/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eci.arsw.preparcial2.controllers;

import com.edu.eci.arsw.preparcial2.model.Message;
import com.edu.eci.arsw.preparcial2.model.MessageRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sebastián Reyes
 */
//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/messages")
public class Preparcial2API {

    @Autowired
    private MessageRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> handlerGetResourceMessage() {
        try {
            List<Message> messages = repository.findAll();
            Collections.reverse(messages);
            List<Message> ans;
            if(messages.size() > 10) {
                ans = messages.subList(0,10);
            } else {
                ans = messages;
            }
            return new ResponseEntity<>(ans, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Preparcial2API.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> handlerPostResourceMessage(@RequestBody Message m) {
        try {
            repository.save(new Message(m.message, m.date));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(Preparcial2API.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.eci.arsw.preparcial2.model;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 2117816
 */
public interface MessageRepository extends MongoRepository<Message, String> {
    
    public List<Message> findByDate(Date date);
    
}

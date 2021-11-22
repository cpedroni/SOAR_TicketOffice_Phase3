/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.lab.unil.eventwebsite.Exceptions;

/**
 *
 * @author valer
 */
public class AlreadyExistException extends Exception {
     private String message;

    /**
     *
     * @param message
     */
    public AlreadyExistException(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }
}

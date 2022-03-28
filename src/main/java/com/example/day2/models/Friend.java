package com.example.day2.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Friend {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String adress;

    @Override
    public String toString(){
        return String.format("Id: %d, FirstName: '%s', LastName: '%s', PhoneNumber: '%s', Adress: '%s'"
                , id,firstName,lastName,phoneNumber,adress);
    }
}
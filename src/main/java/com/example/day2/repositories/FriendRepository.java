package com.example.day2.repositories;

import com.example.day2.models.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findByFirstName(String firstName);
    List<Friend> findByFirstNameAndLastName(String firstName, String lastName);
    List<Friend> findByPhoneNumber(String phoneNumber);
    List<Friend> findByAdress(String adress);

    void deleteByFirstName(String firstName);

}

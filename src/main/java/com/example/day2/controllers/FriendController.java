package com.example.day2.controllers;

import com.example.day2.models.Friend;
import com.example.day2.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @RequestMapping("/add")
    public String addNewFriend(@RequestParam String firstName, @RequestParam String lastName
            , @RequestParam String phoneNumber, @RequestParam String adress){
        Friend friend = new Friend();
        friend.setFirstName(firstName);
        friend.setLastName(lastName);
        friend.setPhoneNumber(phoneNumber);
        friend.setAdress(adress);
        friendRepository.save(friend);
        return "Saved";
    }

    @RequestMapping("/findAll")
    public Iterable<Friend> getAllFriends(){
        return friendRepository.findAll();
    }

    @RequestMapping("/findByFirstName")
    public Iterable<Friend> getAllFriendsByFirstName(@RequestParam String firstName){
        return friendRepository.findByFirstName(firstName);
    }

    @RequestMapping("/findByPhoneNumber")
    public Iterable<Friend> getAllFriendsByPhoneNumber(@RequestParam String phoneNumber){
        return friendRepository.findByPhoneNumber(phoneNumber);
    }

    @RequestMapping("/removeByFirstNameAndLastName")
    public String removeFriendByFirstNameAndLastName(@RequestParam String firstName,@RequestParam String lastName){
        List<Friend> friends=  friendRepository.findByFirstNameAndLastName(firstName, lastName);
        friendRepository.delete(friends.get(0));
        return "Deleted";
    }
    @RequestMapping("/removeByFirstName")
    public String deleteFriendByFirstName(@RequestParam String firstName){
        friendRepository.deleteByFirstName(firstName);
        return "Deleted";
    }

    @RequestMapping("/updatePhoneNumber")
    public String updateFriendsPhoneNumber(@RequestParam long id, @RequestParam String phoneNumber){
        Friend friend = friendRepository.findById(id).get();
        friend.setPhoneNumber(phoneNumber);
        friendRepository.save(friend);
        return "Updated";
    }
}

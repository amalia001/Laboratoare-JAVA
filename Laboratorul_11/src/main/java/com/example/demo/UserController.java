package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    private final List<User> users = new ArrayList<>();
   // private Map<Integer, List<String>> friendList = new HashMap<>();
   private Map<String, List<String>> friendList = new HashMap<>();

    public UserController() {
        users.add(new User(1, "Amalia"));
        users.add(new User(2, "Laura"));
        users.add(new User(3, "Ana"));
        users.add(new User(4, "Alex"));
        users.add(new User(5, "Corina"));
        users.add(new User(6, "Ion"));
    }

    @GetMapping("/users")

    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/count")
    public int getTotal() {
        return users.size();
    }

    @GetMapping("/{id}")
        public User getUser ( @PathVariable("id") int id){
            return users.stream()
                    .filter(p -> p.getId() == id).findFirst().orElse(null);
        }

    @PostMapping("name")
    public int createUser(@RequestParam String name) {
        int id = 1 + users.size();
        users.add(new User(id, name));
        return id;
    }


    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>  createUser(@RequestBody User user)
    {
        users.add(user);
        return new ResponseEntity<>(
                "User created successfully", HttpStatus.CREATED);
    }


    public User findById(int id){
        for (User u: users)
            if(u.getId() == id)
                return u;
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable int id, @RequestParam String name) {
        User user = findById(id);
        if (user == null) {
            return new ResponseEntity<>(
                    "User not found", HttpStatus.NOT_FOUND); //or GONE
        }
        return new ResponseEntity<>(
                "User updated successsfully", HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        User user = findById(id);
        if (user == null) {
            return new ResponseEntity<>(
                    "User not found", HttpStatus.GONE);
        }
        users.remove(user);
        return new ResponseEntity<>("User removed", HttpStatus.OK);
    }

    @PostMapping("{name}")
    public Map<String, List<String>> addFriend(@PathVariable String name, @RequestParam String friendsName) {
        List<String> friends=new ArrayList<>();
        String[] arrayOfFriends  = friendsName.split(",");
        List<String> fr = new ArrayList<>();
        for(String friend:arrayOfFriends)
            fr.add(friend);
        friendList.put(name, fr);
        return friendList;
    }
}


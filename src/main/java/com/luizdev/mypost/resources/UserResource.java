package com.luizdev.mypost.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luizdev.mypost.domain.DTO.UserDTO;
import com.luizdev.mypost.domain.entities.User;
import com.luizdev.mypost.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> allUsers(){
        List<User> users = service.allUsers();
        List<UserDTO> dtos = users.stream()
        .map(u -> new UserDTO(u))
        .collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id){
        User user = service.findUserById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(UserDTO dto){
        User user = service.convertDTO(dto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public ResponseEntity<UserDTO> deleteUserById(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO dto, @PathVariable String id){
        User user = service.convertDTO(dto);
        user.setId(id);
        user = service.update(user);
        return ResponseEntity.noContent().build();
    }

}

package com.luizdev.mypost.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizdev.mypost.domain.DTO.UserDTO;
import com.luizdev.mypost.domain.entities.User;
import com.luizdev.mypost.exceptions.UserNotFoundException;
import com.luizdev.mypost.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> allUsers(){
        return repository.findAll();
    }

    public User findUserById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> 
        new UserNotFoundException("ERRO: Usuário não encontrado ou não existe"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id){
        findUserById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        Optional<User> newUser = repository.findById(user.getId());
        updateUser(newUser.get(),user);
        return repository.save(newUser.get());
    }

    private void updateUser(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User convertDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}

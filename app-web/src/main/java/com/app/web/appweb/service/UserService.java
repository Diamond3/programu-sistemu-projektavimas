package com.app.web.appweb.service;

import com.app.web.appweb.model.User;
import com.app.web.appweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> findAll() { return (List<User>) repo.findAll(); }
    public User findById(long id) throws NoSuchElementException { return repo.findById(id).orElseThrow();}
    public void update(User user) { repo.save(user); }
    public User add(User user) { return repo.save(user); }
    public void deleteById(long id) { repo.deleteById(id); }
}

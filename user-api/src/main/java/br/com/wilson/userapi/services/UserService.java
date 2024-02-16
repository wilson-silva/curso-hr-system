package br.com.wilson.userapi.services;

import br.com.wilson.userapi.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
}

package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.service.UserService;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

        private final UserRepository UserRepository;

        public UserServiceImpl(UserRepository UserRepository){
            this.UserRepository = UserRepository;
        }

        @Override
        public User finById (Long id) {
            return UserRepository.findById(id).orElseThrow(NoSuchElementException::new);
        }
        @Override
        public User create(User userToCreate){
            if (userRepository.existsByAccountNumber(userToCreate.getAccount().getAccount())){
                throw new IllegalAccessException("This Account number alredy exists");
            }    
            return userRepository.save(userToCreate);
    }
}

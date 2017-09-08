package com.dropbsoftware.userservice.service;

import com.dropbsoftware.userservice.dao.UserRepository;
import com.dropbsoftware.userservice.model.User;
import com.dropbsoftware.userservice.rest.model.UserDto;
import com.dropbsoftware.userservice.rest.model.UserLimited;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(UserDto newUserDto) {
        LOGGER.info("Saving user with nick {} and login {}", newUserDto.getNick(), newUserDto.getLogin());
        User user = new User();
        BeanUtils.copyProperties(newUserDto, user);
        User savedUser = userRepository.save(user);
        LOGGER.info("Successfully saved user with nick {} and login {}", savedUser.getNick(), savedUser.getLogin());

        UserDto savedUserDto = new UserDto();
        BeanUtils.copyProperties(savedUser, savedUserDto);

        return savedUserDto;
    }

    public UserDto update(Long id, UserLimited userLimited) {
        LOGGER.info("Searching user with id {}", id);
        User user = userRepository.findOne(id);
        LOGGER.info("Found user with id {}", userLimited);

        LOGGER.info("Updating user with id {}", id);
        user.setNick(userLimited.getNick());
        user = userRepository.save(user);
        LOGGER.info("Successfully updated user with id {}", id);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }

    public UserDto findById(Long userId) {
        LOGGER.info("Searching user with id {}", userId);
        User user = userRepository.findOne(userId);
        LOGGER.info("Successfully found user with id {}", user.getId());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }

    public UserDto findByLogin(String login) {
        LOGGER.info("Searching user with login {}", login);
        User user = userRepository.findByLogin(login);
        LOGGER.info("Successfully found user with login {}", login);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }

    public UserDto findByNick(String nick) {
        LOGGER.info("Searching user with nick {}", nick);
        User user = userRepository.findByNick(nick);
        LOGGER.info("Successfully found user with nick {}", nick);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }

    public boolean exists(UserDto user) {
        LOGGER.info("Checking if user with login {} and nick {} exists", user.getLogin(), user.getNick());
        boolean exists = userRepository.exists(user.getLogin(), user.getNick());
        if (exists) {
            LOGGER.info("User with login {} and nick {} exists", user.getLogin(), user.getNick());
        } else {
            LOGGER.info("User with login {} and nick {} doesn't exist", user.getLogin(), user.getNick());
        }

        return exists;
    }
}

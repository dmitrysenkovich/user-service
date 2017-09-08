package com.dropbsoftware.userservice.rest.controller;

import com.dropbsoftware.userservice.rest.model.UserDto;
import com.dropbsoftware.userservice.rest.model.UserLimited;
import com.dropbsoftware.userservice.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "UserService")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ApiOperation("Find user by id")
    public UserDto findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    @ApiOperation("Find user by login or nick")
    public UserDto findUserByLoginOrNick(@RequestParam(required = false) String login,
                                         @RequestParam(required = false) String nick) {
        return login != null ? userService.findByLogin(login) : userService.findByNick(nick);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create new user")
    public UserDto createUser(@Valid @RequestBody UserDto newUser) {
        UserDto savedUser = userService.save(newUser);

        return savedUser;
    }

    @PutMapping("/{id}")
    @ApiOperation("Update user")
    public UserDto updateUser(@PathVariable Long id,
                              @Valid @RequestBody UserLimited userLimited) {
        return userService.update(id, userLimited);
    }
}

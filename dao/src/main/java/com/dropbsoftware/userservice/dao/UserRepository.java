package com.dropbsoftware.userservice.dao;

import com.dropbsoftware.userservice.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    User findByNick(String nick);

    @Query("select count(user) > 0 from User user where user.login = :login and user.nick = :nick")
    boolean exists(String login, String nick);
}

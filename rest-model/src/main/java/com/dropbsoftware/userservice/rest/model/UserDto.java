package com.dropbsoftware.userservice.rest.model;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiParam;

public class UserDto {
    private Long id;

    @ApiParam(value = "User login")
    @Size(min = 4, max = 8)
    private String login;

    @ApiParam(value = "User nick")
    @Size(min = 4, max = 8)
    private String nick;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (login != null ? !login.equals(userDto.login) : userDto.login != null) return false;
        return nick != null ? nick.equals(userDto.nick) : userDto.nick == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}

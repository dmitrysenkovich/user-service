package com.dropbsoftware.userservice.rest.model;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiParam;

public class UserLimited {

    @ApiParam(value = "User nick")
    @Size(min = 4, max = 8)
    private String nick;

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

        UserLimited that = (UserLimited) o;

        return nick != null ? nick.equals(that.nick) : that.nick == null;
    }

    @Override
    public int hashCode() {
        return nick != null ? nick.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserLimited{" +
                "nick='" + nick + '\'' +
                '}';
    }
}

package net.andreasfalk.oauth.client;

import java.io.Serializable;

/**
 * Created by AFA on 19.05.2016.
 */
public class User implements Serializable {

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("username", username)
                .toString();
    }
}

package com.gn.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserWithProfile {
    private User user;
    private UserProfile userProfile;

    @Override
    public String toString() {
        return "UserWithProfile{" +
                "user=" + user +
                ", userProfile=" + userProfile +
                '}';
    }
}
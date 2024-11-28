package com.gn.model.vo;

public class UserWithProfile {
    private User user;
    private UserProfile userProfile;

    public UserWithProfile(User user, UserProfile userProfile) {
        this.user = user;
        this.userProfile = userProfile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserWithProfile{" +
                "user=" + user +
                ", userProfile=" + userProfile +
                '}';
    }
}
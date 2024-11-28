package com.gn.model.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserProfile {
    private int profileId;
    private int userId;
    private LocalDate birth;
    private int height;
    private String gender;
    private String phoneNumber;
    private String address;
    private String profilePicture;
    private String interests;
    private String mbti;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public UserProfile() {}
    
//	public UserProfile(LocalDate birth, int height, String gender, String phoneNumber,
//			String address, String profilePicture, String interests, String mbti, String bio, LocalDateTime createdAt,
//			LocalDateTime updatedAt) {
//		this.birth = birth;
//		this.height = height;
//		this.gender = gender;
//		this.phoneNumber = phoneNumber;
//		this.address = address;
//		this.profilePicture = profilePicture;
//		this.interests = interests;
//		this.mbti = mbti;
//		this.bio = bio;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//	}
    
	public UserProfile(Integer profileId, Integer userId, LocalDate birth, int height, String gender, String phoneNumber,
			String address, String profilePicture, String interests, String mbti, String bio, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.profileId = profileId;
		this.userId = userId;
		this.birth = birth;
		this.height = height;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.profilePicture = profilePicture;
		this.interests = interests;
		this.mbti = mbti;
		this.bio = bio;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    @Override
    public String toString() {
        return "UserProfile{" +
                "profileId=" + profileId +
                ", userId=" + userId +
                ", birth=" + birth +
                ", height=" + height +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", interests='" + interests + '\'' +
                ", mbti='" + mbti + '\'' +
                ", bio='" + bio + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

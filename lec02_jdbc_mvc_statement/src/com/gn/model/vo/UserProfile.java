package com.gn.model.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
}

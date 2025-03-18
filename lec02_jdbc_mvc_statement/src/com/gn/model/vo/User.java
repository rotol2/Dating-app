package com.gn.model.vo;

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
public class User {
    private int userId;
    private String email;
    private String password;
    private String username;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

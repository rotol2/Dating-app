package com.gn.model.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Rating {	
	private int ratingId;
	private int senderId;
	private int receiverId;
	private int rating;
	private LocalDateTime sendAt;
}

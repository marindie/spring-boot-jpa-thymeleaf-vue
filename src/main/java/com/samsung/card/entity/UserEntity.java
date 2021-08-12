package com.samsung.card.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="TBL_USERS")
public class UserEntity {
	
	@Id
	private String userId;

	@Column(nullable = true, unique = false, length = 100)
	private String userName;

	@Column(nullable = true, unique = false, length = 5)
	private String userRank;

	@Column(nullable = true, unique = false, length = 5)
	private String phoneNo;	
}

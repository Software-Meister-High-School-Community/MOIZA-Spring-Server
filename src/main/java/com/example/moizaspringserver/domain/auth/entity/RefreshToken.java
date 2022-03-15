package com.example.moizaspringserver.domain.auth.entity;

import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class RefreshToken {

	@Id
	private String accountId;

	@Indexed
	private String token;

	@TimeToLive
	private Long timeToLive;

	@Builder
	public RefreshToken(String accountId, String token, Long timeToLive) {
		this.accountId = accountId;
		this.token = token;
		this.timeToLive = timeToLive;
	}

	public void updateToken(String token) {
		this.token = token;
	}

}
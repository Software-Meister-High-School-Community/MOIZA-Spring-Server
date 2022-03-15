package com.example.moizaspringserver.domain.auth.entity;

import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class EmailCode {

	@Id
	private String accountId;

	private RefreshToken refreshToken;

	@TimeToLive
	private Long timeToLive;

	@Builder
	public EmailCode(String accountId,
		RefreshToken refreshToken, Long timeToLive) {
		this.accountId = accountId;
		this.refreshToken = refreshToken;
		this.timeToLive = timeToLive;
	}
}

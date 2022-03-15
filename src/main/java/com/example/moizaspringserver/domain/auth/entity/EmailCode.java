package com.example.moizaspringserver.domain.auth.entity;

import com.example.moizaspringserver.domain.auth.type.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class EmailCode {

	@Id
	private String email;

	private String authCode;

	private Type type;

	@TimeToLive
	private Long timeToLive;

	@Builder
	public EmailCode(String email, String authCode,
		Type type, Long timeToLive) {
		this.email = email;
		this.authCode = authCode;
		this.type = type;
		this.timeToLive = timeToLive;
	}
}

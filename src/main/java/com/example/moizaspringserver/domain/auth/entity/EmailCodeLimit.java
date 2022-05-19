package com.example.moizaspringserver.domain.auth.entity;

import com.example.moizaspringserver.domain.auth.type.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class EmailCodeLimit {

	@Id
	private String email;

	private Type type;

	private long timeToLive;

	private int count;

	@Builder
	public EmailCodeLimit(String email, Type type) {
		this.email = email;
		this.type = type;
		this.timeToLive = 3600 * 24L;
		this.count = 1;
	}

	public EmailCodeLimit addCount() {
		this.count++;
		return this;
	}
}

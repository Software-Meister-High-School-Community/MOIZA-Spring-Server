package com.example.moizaspringserver.domain.viewcount.entity;

import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class FeedViewCount {

	@Id
	private Integer feedId;

	private Integer viewCount;
}

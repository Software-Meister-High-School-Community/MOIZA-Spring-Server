package com.example.moizaspringserver.domain.feed.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class FeedLikeId implements Serializable {

	private Integer user;

	private Integer feed;

	@Builder
	public FeedLikeId(Integer user, Integer feed) {
		this.user = user;
		this.feed = feed;
	}
}

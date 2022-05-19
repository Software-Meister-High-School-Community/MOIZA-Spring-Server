package com.example.moizaspringserver.domain.like.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class FeedLikeId implements Serializable {

	private Integer user;

	private Integer feed;

	@Builder
	public FeedLikeId(Integer user, Integer feed) {
		this.user = user;
		this.feed = feed;
	}
}

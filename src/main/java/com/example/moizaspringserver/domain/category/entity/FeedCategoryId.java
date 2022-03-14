package com.example.moizaspringserver.domain.category.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class FeedCategoryId implements Serializable {

	private Integer feed;

	private Integer category;

	@Builder
	public FeedCategoryId(Integer feed, Integer category) {
		this.feed = feed;
		this.category = category;
	}
}

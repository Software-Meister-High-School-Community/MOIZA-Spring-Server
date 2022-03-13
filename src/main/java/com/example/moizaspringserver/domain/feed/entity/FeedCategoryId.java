package com.example.moizaspringserver.domain.feed.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class FeedCategoryId implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "feed_id", nullable = false)
	private Feed feed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Builder
	public FeedCategoryId(Feed feed, Category category) {
		this.feed = feed;
		this.category = category;
	}
}

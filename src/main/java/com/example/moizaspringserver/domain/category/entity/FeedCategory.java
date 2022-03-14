package com.example.moizaspringserver.domain.category.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed_category")
public class FeedCategory {

	@EmbeddedId
	private FeedCategoryId id;

	@MapsId("feed")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "feed_id", nullable = false)
	private Feed feed;

	@MapsId("category")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Builder
	public FeedCategory(FeedCategoryId id, Feed feed,
		Category category) {
		this.id = id;
		this.feed = feed;
		this.category = category;
	}
}

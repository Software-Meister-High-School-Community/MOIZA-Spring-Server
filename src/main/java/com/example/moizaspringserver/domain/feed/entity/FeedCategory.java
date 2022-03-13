package com.example.moizaspringserver.domain.feed.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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

	@Builder
	public FeedCategory(FeedCategoryId id) {
		this.id = id;
	}
}

package com.example.moizaspringserver.domain.feed.entity;

import com.example.moizaspringserver.global.entity.BaseTimeEntity;
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
@Table(name = "tbl_feed_like")
public class FeedLike extends BaseTimeEntity {

	@EmbeddedId
	private FeedLikeId id;

	@Builder
	public FeedLike(FeedLikeId id) {
		this.id = id;
	}
}

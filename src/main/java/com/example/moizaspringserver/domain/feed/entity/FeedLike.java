package com.example.moizaspringserver.domain.feed.entity;

import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.global.entity.BaseTimeEntity;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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

	@MapsId("user")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@MapsId("feed")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "feed_id", nullable = false)
	private Feed feed;

	@Builder
	public FeedLike(FeedLikeId id, User user,
		Feed feed) {
		this.id = id;
		this.user = user;
		this.feed = feed;
	}
}

package com.example.moizaspringserver.domain.feed.presenstation.dto.response;

import com.example.moizaspringserver.domain.feed.type.FeedType;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PopularFeedListResponse {

	private final List<PopularFeed> feedList;

	@Getter
	@Builder
	public static class PopularFeed {
		private final Integer id;

		private final String title;

		private final FeedType type;

		private final LocalDateTime createdAt;

		private final String authorName;

		private final boolean isLike;

		private final Integer likeCount;

		private final String content;

		private final String category;
	}
}

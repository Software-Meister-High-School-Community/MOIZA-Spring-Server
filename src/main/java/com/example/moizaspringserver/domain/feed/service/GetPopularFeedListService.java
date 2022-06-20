package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.category.entity.FeedCategoryId;
import com.example.moizaspringserver.domain.category.repository.FeedCategoryRepository;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.presenstation.dto.response.PopularFeedListResponse;
import com.example.moizaspringserver.domain.feed.presenstation.dto.response.PopularFeedListResponse.PopularFeed;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import com.example.moizaspringserver.domain.like.entity.FeedLikeId;
import com.example.moizaspringserver.domain.like.repository.FeedLikeRepository;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetPopularFeedListService {

	private final PublicFeedRepository publicFeedRepository;
	private final FeedLikeRepository feedLikeRepository;
	private final FeedCategoryRepository feedCategoryRepository;
	private final UserFacade userFacade;

	public PopularFeedListResponse execute() {

		List<PublicFeed> publicFeedList = publicFeedRepository
			.findTop8ByCreatedAtBetweenOrderByLikeCountDesc(
				LocalDateTime.now().minusDays(1), LocalDateTime.now()
			);

		List<PopularFeed> popularFeedList = publicFeedList
			.stream()
			.map(this::buildPopularFeed)
			.collect(Collectors.toList());

		return new PopularFeedListResponse(popularFeedList);
	}

	public PopularFeed buildPopularFeed(PublicFeed publicFeed) {

		boolean isLike = feedLikeRepository.findById(FeedLikeId.builder()
			.user(userFacade.queryCurrentUser().getId())
			.feed(publicFeed.getFeedId())
			.build()).isPresent();

		String category = feedCategoryRepository.findById_Feed(publicFeed.getFeedId())
			.get(0).getCategory().getCategoryName();

		return PopularFeed.builder()
			.id(publicFeed.getFeedId())
			.title(publicFeed.getTitle())
			.type(publicFeed.getFeed().getFeedType())
			.createdAt(publicFeed.getCreatedAt())
			.authorName(publicFeed.getFeed().getUser().getName())
			.isLike(isLike)
			.likeCount(publicFeed.getLikeCount())
			.content(publicFeed.getContent())
			.category(category)
			.build();
	}
}

package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import com.example.moizaspringserver.domain.like.entity.FeedLike;
import com.example.moizaspringserver.domain.like.entity.FeedLikeId;
import com.example.moizaspringserver.domain.like.repository.FeedLikeRepository;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddLikeService {

	private final PublicFeedRepository publicFeedRepository;
	private final UserFacade userFacade;
	private final FeedLikeRepository feedLikeRepository;

	@Transactional
	public void execute(Integer feedId) {

		PublicFeed feed = publicFeedRepository.findById(feedId)
			.orElseThrow(() -> FeedNotFoundException.EXCEPTION);

		feed.like();

		FeedLike feedLike = FeedLike.builder()
			.id(FeedLikeId.builder()
				.user(
					userFacade.queryCurrentUser()
						.getId()
				)
				.feed(feed.getFeedId())
				.build())
			.build();

		feedLikeRepository.save(feedLike);
	}
}

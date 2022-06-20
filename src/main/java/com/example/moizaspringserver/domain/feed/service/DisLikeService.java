package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import com.example.moizaspringserver.domain.like.entity.FeedLikeId;
import com.example.moizaspringserver.domain.like.repository.FeedLikeRepository;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DisLikeService {

	private final PublicFeedRepository publicFeedRepository;
	private final FeedLikeRepository feedLikeRepository;
	private final UserFacade userFacade;

	@Transactional
	public void execute(Integer feedId) {

		publicFeedRepository.findById(feedId)
			.orElseThrow(() -> FeedNotFoundException.EXCEPTION)
			.dislike();

		Integer userId = userFacade.queryCurrentUser().getId();

		FeedLikeId feedLikeId = FeedLikeId.builder()
			.feed(feedId)
			.user(userId)
			.build();

		feedLikeRepository.deleteById(feedLikeId);
	}
}

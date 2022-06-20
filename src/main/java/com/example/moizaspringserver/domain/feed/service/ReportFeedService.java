package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.exception.FeedReportAlreadyExistsException;
import com.example.moizaspringserver.domain.feed.facade.FeedFacade;
import com.example.moizaspringserver.domain.report.entity.FeedReport;
import com.example.moizaspringserver.domain.report.entity.FeedReportId;
import com.example.moizaspringserver.domain.report.entity.Report;
import com.example.moizaspringserver.domain.report.repository.FeedReportRepository;
import com.example.moizaspringserver.domain.report.repository.ReportRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReportFeedService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final ReportRepository reportRepository;
    private final FeedReportRepository feedReportRepository;

    @Transactional
    public void execute(Integer feedId) {
        Feed feed = feedFacade.getFeedById(feedId);
        User user = userFacade.queryCurrentUser();

        if (feedReportRepository.findByFeedAndReportUser(feed, user).isPresent()) {
            throw FeedReportAlreadyExistsException.EXCEPTION;
        }

        Report report = Report.builder()
                .user(user)
                .build();

        FeedReportId feedReportId = FeedReportId.builder()
                .feed(feed.getId())
                .report(report.getId())
                .build();

        FeedReport feedReport = FeedReport.builder()
                .id(feedReportId)
                .build();

        reportRepository.save(report);
        feedReportRepository.save(feedReport);
    }
}

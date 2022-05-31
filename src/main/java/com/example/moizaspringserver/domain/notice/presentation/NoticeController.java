package com.example.moizaspringserver.domain.notice.presentation;

import com.example.moizaspringserver.domain.notice.presentation.dto.Response.NoticeDetailResponse.NoticeDetail;
import com.example.moizaspringserver.domain.notice.service.QueryNoticeDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/notices")
@RestController
public class NoticeController {

    private final QueryNoticeDetailService queryNoticeDetailService;

    @GetMapping("/{notice-id}")
    public NoticeDetail queryNoticeDetail(@PathVariable("notice-id") Integer id) {
        return queryNoticeDetailService.execute(id);
    }

}

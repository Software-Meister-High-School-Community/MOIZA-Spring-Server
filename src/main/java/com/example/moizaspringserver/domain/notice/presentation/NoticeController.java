package com.example.moizaspringserver.domain.notice.presentation;

import com.example.moizaspringserver.domain.notice.service.DeleteNoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    private final DeleteNoticeService deleteNoticeService;
    private final QueryNoticeDetailService queryNoticeDetailService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{notice-id}")
    public void deleteNotice(@PathVariable("notice-id") Integer id) {
        deleteNoticeService.execute(id);
    }

    @GetMapping("/{notice-id}")
    public NoticeDetail queryNoticeDetail(@PathVariable("notice-id") Integer id) {
        return queryNoticeDetailService.execute(id);
    }

}

package com.example.moizaspringserver.domain.notice.presentation;

import com.example.moizaspringserver.domain.notice.service.DeleteNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/notices")
@RestController
public class NoticeController {

    private final DeleteNoticeService deleteNoticeService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{notice-id}")
    public void deleteNotice(@PathVariable("notice-id") Integer id) {
        deleteNoticeService.execute(id);
    }
}

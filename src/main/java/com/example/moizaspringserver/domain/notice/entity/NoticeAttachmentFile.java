package com.example.moizaspringserver.domain.notice.entity;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_notice_attachment_file")
public class NoticeAttachmentFile extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 255)
    private String attachmentFileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    @Builder
    public NoticeAttachmentFile(String attachmentFileUrl, Notice notice) {
        this.attachmentFileUrl = attachmentFileUrl;
        this.notice = notice;
    }

}

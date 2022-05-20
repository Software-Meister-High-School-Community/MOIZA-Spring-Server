package com.example.moizaspringserver.domain.comment.entity;

import com.example.moizaspringserver.global.entity.BaseIdEntity;
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
@Table(name = "tbl_comment_attachment_file")
public class CommentAttachmentFile extends BaseIdEntity {

    @NotNull
    @Length(max = 255)
    private String attachmentFileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commnet_id", nullable = false)
    private Comment comment;

    @Builder
    public CommentAttachmentFile(String attachmentFileUrl, Comment comment) {
        this.attachmentFileUrl = attachmentFileUrl;
        this.comment = comment;
    }
}

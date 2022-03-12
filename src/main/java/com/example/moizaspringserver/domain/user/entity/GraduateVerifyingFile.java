package com.example.moizaspringserver.domain.user.entity;

import com.example.moizaspringserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_graduate_verifying_file")
public class GraduateVerifyingFile extends BaseTimeEntity {

    @EmbeddedId
    private GraduateVerifyingFileId id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Length(max = 255)
    private String verifyingFileUrl;

    @Builder
    public GraduateVerifyingFile(GraduateVerifyingFileId id, User user, String verifyingFileUrl) {
        this.id = id;
        this.user = user;
        this.verifyingFileUrl = verifyingFileUrl;
    }
}

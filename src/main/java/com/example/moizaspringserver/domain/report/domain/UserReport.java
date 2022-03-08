package com.example.moizaspringserver.domain.report.domain;

import com.example.moizaspringserver.domain.report.domain.embedded.UserReportId;
import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user_report")
public class UserReport extends BaseTimeIdEntity {

    @EmbeddedId
    private UserReportId id;

}

package com.example.moizaspringserver.domain.user.entity;

import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_search_history")
public class SearchHistory extends BaseTimeIdEntity {

	@NotNull
	@Length(max = 500)
	private String keyword;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Builder
	public SearchHistory(String keyword, User user) {
		this.keyword = keyword;
		this.user = user;
	}
}

package com.example.moizaspringserver.domain.feed.entity;

import com.example.moizaspringserver.global.entity.BaseIdEntity;
import javax.persistence.Entity;
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
@Table(name = "tbl_category")
public class Category extends BaseIdEntity {

	@NotNull
	@Length(max = 10)
	private String categoryName;

	@Builder
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}
}

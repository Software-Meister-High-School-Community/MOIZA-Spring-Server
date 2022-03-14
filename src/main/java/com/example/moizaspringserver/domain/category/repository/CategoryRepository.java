package com.example.moizaspringserver.domain.category.repository;

import com.example.moizaspringserver.domain.category.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}

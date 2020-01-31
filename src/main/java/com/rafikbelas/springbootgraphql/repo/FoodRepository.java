package com.rafikbelas.springbootgraphql.repo;

import com.rafikbelas.springbootgraphql.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}

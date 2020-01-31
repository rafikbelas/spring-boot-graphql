package com.rafikbelas.springbootgraphql.service;

import com.rafikbelas.springbootgraphql.model.Food;
import com.rafikbelas.springbootgraphql.repo.FoodRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class FoodService {

    private final FoodRepository repo;

    public FoodService(FoodRepository foodRepository) {
        this.repo = foodRepository;
    }

    @GraphQLQuery(name = "foods")
    public List<Food> getFoods() {
        return repo.findAll();
    }

    @GraphQLQuery(name = "food")
    public Optional<Food> getFoodById(@GraphQLArgument(name = "id") Long id) {
        return repo.findById(id);
    }

    @GraphQLMutation(name = "saveFood")
    public Food saveFood(@GraphQLArgument(name = "food") Food food) {
        return repo.save(food);
    }

    @GraphQLMutation(name = "deleteFood")
    public void deleteFood(@GraphQLArgument(name = "id") Long id) {
        repo.deleteById(id);
    }

    @GraphQLQuery(name = "isGood")
    public boolean isGood(@GraphQLContext Food food) {
        return !Arrays.asList("Avocado", "Spam").contains(food.getName());
    }
}

package com.rafikbelas.springbootgraphql.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Food {

    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "A food's id")
    private Long id;

    @GraphQLQuery(name = "name", description = "A food's name")
    private String name;

    @Override
    public String toString() {
        return new StringBuilder("Food{")
                .append("id=").append(this.id).append(", ")
                .append("name='").append(this.name).append("'")
                .append("}").toString();
    }
}

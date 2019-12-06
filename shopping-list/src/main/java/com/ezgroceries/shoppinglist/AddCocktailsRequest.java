package com.ezgroceries.shoppinglist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cocktailIdList",
})
public class AddCocktailsRequest {

    private List<String> cocktailIdList = new ArrayList<>();

    public List<String> getCocktailIdList() {
        return cocktailIdList;
    }

    public void setCocktailIdList(List<String> cocktailIdList) {
        this.cocktailIdList = cocktailIdList;
    }

}

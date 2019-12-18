package com.ezgroceries.shoppinglist;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cocktail")
public class CocktailEntity {

    private UUID id;
    private UUID idDrink;
    private String name;
    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(UUID id_drink) {
        this.idDrink = id_drink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }
}
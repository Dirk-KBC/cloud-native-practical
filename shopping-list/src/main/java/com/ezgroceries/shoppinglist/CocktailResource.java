package com.ezgroceries.shoppinglist;

import java.util.List;
import java.util.UUID;

public class CocktailResource {

    private UUID uuid;
    private String cocktailName;
    private String glassName;
    private String description;
    private String pictureLocation;
    private List<String> ingredients;

    public CocktailResource(UUID uuid, String cocktailName, String glassName, String description, String pictureLocation, List<String> ingredients) {
        this.uuid = uuid;
        this.cocktailName = cocktailName;
        this.glassName = glassName;
        this.description = description;
        this.pictureLocation = pictureLocation;
        this.ingredients = ingredients;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public String getGlassName() {
        return glassName;
    }

    public void setGlassName(String glassName) {
        this.glassName = glassName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureLocation() {
        return pictureLocation;
    }

    public void setPictureLocation(String pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}

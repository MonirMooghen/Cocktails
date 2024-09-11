package kea.iabr.cocktails.model;

import java.util.ArrayList;
import java.util.List;

public class Cocktail {
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();

public Cocktail(String name, List<Ingredient> ingredients) {
    this.name = name;
    this.ingredients = ingredients;
}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Ingredient> getIngredients(){
    return ingredients;
    }




}

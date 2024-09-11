package kea.iabr.cocktails.model;

public class Ingredient {
    private String ingredientName;
    private boolean isAllergen;

    public Ingredient(String ingredientName, boolean isAllergen) {
        this.ingredientName = ingredientName;
        this.isAllergen = isAllergen;
    }

    public String getIngredientName(){
        return ingredientName;
    }

    public boolean isAllergen(){
        return isAllergen;
    }
}

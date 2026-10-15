package com.mariofernandes.javapoc.ejb.chapter2.item2;

public class NutritionFactsJavaBeans {
    // (mL) required
    private int serviceSize = -1;
    // (per container) required
    private int servings = -1;
    // (per serving) required
    private int calories = 0;
    // (g/serving) optional
    private int fat = 0;
    // (mg/serving) optional
    private int sodium = 0;
    // (g/serving) optional
    private int carbohydrate = 0;

    public NutritionFactsJavaBeans() {
        // Default constructor
    }

    public void setServiceSize(int serviceSize) {
        this.serviceSize = serviceSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}

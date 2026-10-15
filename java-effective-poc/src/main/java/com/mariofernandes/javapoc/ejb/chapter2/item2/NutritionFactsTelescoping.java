package com.mariofernandes.javapoc.ejb.chapter2.item2;

// Telescoping constructor pattern - does not scale well!
public class NutritionFactsTelescoping {
    // (mL) required
    private final int serviceSize;
    // (per container) required
    private final int servings;
    // (per serving) required
    private final int calories;
    // (g/serving) optional
    private final int fat;
    // (mg/serving) optional
    private final int sodium;
    // (g/serving) optional
    private final int carbohydrate;

    public NutritionFactsTelescoping(int serviceSize, int servings) {
        this(serviceSize, servings, 0);
    }

    public NutritionFactsTelescoping(int serviceSize, int servings, int calories) {
        this(serviceSize, servings, calories, 0);
    }

    public NutritionFactsTelescoping(int serviceSize, int servings, int calories, int fat) {
        this(serviceSize, servings, calories, fat, 0);
    }

    public NutritionFactsTelescoping(int serviceSize, int servings, int calories, int fat, int sodium) {
        this(serviceSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsTelescoping(int serviceSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.serviceSize = serviceSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}

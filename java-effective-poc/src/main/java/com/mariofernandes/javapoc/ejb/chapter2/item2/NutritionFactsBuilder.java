package com.mariofernandes.javapoc.ejb.chapter2.item2;

public class NutritionFactsBuilder {
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

    public static class Builder {
        // Required parameters
        private final int serviceSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int serviceSize, int servings) {
            this.serviceSize = serviceSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFactsBuilder build() {
            return new NutritionFactsBuilder(this);
        }
    }

    private NutritionFactsBuilder(Builder builder) {
        serviceSize = builder.serviceSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}

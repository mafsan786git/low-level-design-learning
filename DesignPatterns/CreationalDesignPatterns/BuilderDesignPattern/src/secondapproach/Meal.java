package secondapproach;

import java.util.ArrayList;
import java.util.List;

class Meal {
    private String mainCourse;
    private String side;
    private String drink;
    private String dessert;
    private boolean spicy;
    private String cookingInstructions;
    private List<String> allergies;
    private double price;

    // Private constructor to enforce builder usage
    private Meal() {}

    @Override
    public String toString() {
        return String.format("Meal: %s with %s, %s to drink. %s for dessert. %s",
                mainCourse, side, drink, dessert,
                spicy ? "Spicy" : "Non-spicy");
    }

    // Builder class
    public static class Builder {
        private final Meal meal;

        public Builder() {
            meal = new Meal();
        }

        public Builder mainCourse(String mainCourse) {
            validateNotNull(mainCourse, "Main course");
            meal.mainCourse = mainCourse;
            return this;
        }

        public Builder side(String side) {
            meal.side = side;
            return this;
        }

        public Builder drink(String drink) {
            meal.drink = drink;
            return this;
        }

        public Builder spicy(boolean spicy) {
            meal.spicy = spicy;
            return this;
        }

        public Builder addAllergy(String allergy) {
            if (meal.allergies == null) {
                meal.allergies = new ArrayList<>();
            }
            meal.allergies.add(allergy);
            return this;
        }

        public Builder cookingInstructions(String instructions) {
            meal.cookingInstructions = instructions;
            return this;
        }

        private void validateNotNull(Object obj, String field) {
            if (obj == null) {
                throw new IllegalArgumentException(field + " cannot be null");
            }
        }

        public Meal build() {
            // Validation logic
            validateNotNull(meal.mainCourse, "Main course");

            // Calculate price based on selections
            calculatePrice();

            return meal;
        }

        private void calculatePrice() {
            double basePrice = 10.0;
            if (meal.side != null) basePrice += 3.0;
            if (meal.drink != null) basePrice += 2.0;
            if (meal.dessert != null) basePrice += 4.0;
            meal.price = basePrice;
        }
    }
}

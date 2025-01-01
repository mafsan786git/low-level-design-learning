package secondapproach;

// Usage in a restaurant ordering system
class Restaurant {
    public static void main(String[] args) {
        // Regular customer order
        Meal regularMeal = new Meal.Builder()
                .mainCourse("Burger")
                .side("Fries")
                .drink("Coke")
                .build();

        // Health conscious customer
        Meal healthyMeal = new Meal.Builder()
                .mainCourse("Grilled Chicken")
                .side("Salad")
                .addAllergy("Nuts")
                .addAllergy("Dairy")
                .cookingInstructions("No oil")
                .build();

        // Spicy preference
        Meal spicyMeal = new Meal.Builder()
                .mainCourse("Chicken Wings")
                .spicy(true)
                .drink("Beer")
                .cookingInstructions("Extra hot sauce")
                .build();

        System.out.println(regularMeal);
        System.out.println(healthyMeal);
        System.out.println(spicyMeal);
    }
}

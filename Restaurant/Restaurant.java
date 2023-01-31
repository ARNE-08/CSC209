public class Restaurant {
    public static void main(String[] args) {
        Food Padthai = new Food(1, "Padthai", 49, 200, (short) 4);
        System.out.println(Padthai.toString());

        Padthai.setCategory("noodle");
        Padthai.addIngredients("shrimp");
        Padthai.addIngredients("noodle");
        Padthai.addIngredients("bean sprout");
        Padthai.addIngredients("egg");

        System.out.println(Padthai.ingredients.elementAt(0) + " " + Padthai.ingredients.elementAt(2));

        Food Tomyum = new Food(2, "Tomyum", 249.50, 500, (short) 5);
        Tomyum.setCategory("seafood");
        Tomyum.addIngredients("shrimp");
        Tomyum.addIngredients("lime");
        Tomyum.addIngredients("Chili pepper");

        Food Coke = new Food(3, "Coca Cola", 20, 150, (short) 3);
        Food Pepsi = new Food(4, "Pepsi", 20, 150, (short) 3);
        Food Fanta = new Food(5, "Fanta", 20, 150, (short) 2);

        Menu menu = new Menu();
        menu.addNewFood(Padthai);
        menu.addNewFood(Tomyum);
        menu.addNewFood(Coke);
        menu.addNewFood(Pepsi);
        menu.addNewFood(Fanta);
        menu.showAllFood();

        // menu.removeFood(4); // remove Pepsi
        // menu.showAllFood();
    }
}

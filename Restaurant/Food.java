import java.util.Vector;

public class Food {
    int ID, calories;
    String name, category;
    double price;
    short star;
    Vector ingredients;

    public Food(int i, String n, double p, int c, short s) {
        ID = i;
        name = n;
        price = p;
        calories = c;
        star = s;
        ingredients = new Vector<>(10);
    }

    public void setCategory(String cat) {
        String validCategory[] = { "noodle", "appetizer", "beef", "pork", "vegetarian",
                "chicken", "seafood", "dessert", "drink" };
        for (String i : validCategory) {
            if (cat.equalsIgnoreCase(i)) {
                category = cat;
                return;
            }
        }
        System.out.println("Not valid category");
    }

    public int addIngredients(String i) {
        ingredients.add(i);
        return ingredients.size();
    }

    public String toString() {
        return name + " " + price + " baht with " + star + " star.";
    }
}

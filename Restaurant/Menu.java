import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Menu {
    Food[] foods;
    int amountOfFood;
    String filename;

    public Menu() {
        foods = new Food[30];
        amountOfFood = 0;
        filename = "menu.dat";
    }

    public int addNewFood(Food i) {
        foods[amountOfFood] = i;
        amountOfFood++;
        writeOneFoodToFile(i);
        return amountOfFood;
    }

    public boolean removeFood(int foodID) {
        for (int i = 0; i < amountOfFood; i++) {
            if (foods[i].ID == foodID) {
                for (int j = i; j < amountOfFood - 1; j++) {
                    foods[j] = foods[j + 1];
                }
                amountOfFood--;
                return true;
            }
        }
        return false;
    }

    public void showAllFood() {
        for (int i = 0; i < amountOfFood; i++) {
            System.out.print(foods[i].ID + ") " + foods[i].name + " ");
        }
        System.out.println("");
    }

    // We need to know the byte because we are using random access file
    // This is the byte of one food
    // int ID, calories; (int size = 4 byte)
    // String name, category; (assume String size = 20 byte)
    // double price; (double size = 8 byte)
    // short star; (short size = 2 byte)
    // Vector ingredients; (fix the size so we it's inconvenience when we use it)
    // (20 * 10(fixed) = 200 byte)
    // Therefore one record = 4 + 4 + 20 + 20 + 8 + 2 + 200 = 258 byte for 1 food

    // writing food to the menu
    public boolean writeOneFoodToFile(Food f) {
        try {
            RandomAccessFile fpointer = new RandomAccessFile(filename, "rw"); // mode = read and then write
            fpointer.writeInt(f.ID);
            byte[] name = new byte[20];
            name = f.name.concat("                                          ").getBytes(); // any amount of space
            fpointer.write(name, 0, 20);
        } catch (FileNotFoundException e) {
            // use try-catch to catch the error when our file doesn't exist (in this
            // case menu.dat is not exist)
            e.printStackTrace();
        } catch (IOException e) {
            // catch the error that pop up when use fpointer.write
            e.printStackTrace();
        }
        return false;
    }
}

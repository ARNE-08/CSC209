import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;

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

    public boolean searchByName(String foodName) {
        try {
            RandomAccessFile fptr = new RandomAccessFile(filename, "r");
            byte[] temp = new byte[20];

            // learn how to seek and print out

            // currently pointer is pointing to 0
            // fptr.seek(4); // skip the ID (int = 4 byte)
            // fptr.read(temp, 0, 20);
            // System.out.println(new String(temp));

            // // seek next food
            // fptr.seek(fptr.getFilePointer() + 258 - 20); // move from current location
            // fptr.read(temp, 0, 20);
            // System.out.println(new String(temp) + " ");

            // another way to seek will also get the same result as above
            // For example, above is tomyum (with getpointer) this is also tomyum
            // will move from our first pointer (that we seek 4)
            // fptr.seek(258 + 4); // <-- no getFilepointer
            // fptr.read(temp, 0, 20);
            // System.out.println(new String(temp) + " ");

            // fptr.seek(258 * 2 + 4);
            // fptr.read(temp, 0, 20);
            // System.out.println(new String(temp) + " ");

            // actual code
            int record = 0;
            while (fptr.getFilePointer() < fptr.length() - 258) {
                fptr.seek(258 * record + 4);
                fptr.read(temp, 0, 20);
                String foodNameFromFile = new String(temp).trim();
                if (foodNameFromFile.equalsIgnoreCase(foodName)) {
                    // show price
                    fptr.seek(258 * record + 4 + 20 + 20);
                    double price = fptr.readDouble();
                    System.out.println("Price of " + foodName + ": " + price);
                    return true;
                }
                record++;
            }
            fptr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public void showNamePrice(short showFromStar) {
        RandomAccessFile fptr;
        try {
            fptr = new RandomAccessFile(filename, "r");
            byte[] temp = new byte[20];
            for (int rec = 0; fptr.getFilePointer() < fptr.length() - 258; rec++) { // -258 to make sure that we dont go
                                                                                    // beyond it
                fptr.seek(258 * rec + 4 + 20 + 20 + 8 + 4);
                short star = fptr.readShort();
                if (star >= showFromStar) {
                    fptr.seek(258 * rec + 4);
                    fptr.read(temp, 0, 20);
                    String name = new String(temp).trim();
                    fptr.seek(258 * rec + 4 + 20 + 20);
                    double price = fptr.readDouble();
                    System.out.println("Food name: " + name + ", Price: " + price);
                }
            }
            fptr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void readAllRecord() {
        try {
            RandomAccessFile fptr = new RandomAccessFile(filename, "r");
            while (fptr.getFilePointer() < fptr.length()) {
                byte[] temp = new byte[20];
                int id = fptr.readInt();
                System.out.print(id + " ");
                // read the food name
                fptr.read(temp, 0, 20); // read 20 byte from current pointer
                System.out.print(new String(temp).trim() + " ");
                fptr.read(temp, 0, 20);
                // read the food category
                System.out.print(new String(temp).trim() + " ");
                double price = fptr.readDouble();
                int cal = fptr.readInt();
                // int star = fptr.readInt();
                // will caused error because we use the wrong data type
                short s = fptr.readShort();
                System.out.println(price + " " + cal + " " + s + " ");
                String ingredient = "";
                for (int j = 0; j < 10; j++) { // we alreayd fixed the size to 10
                    fptr.read(temp, 0, 20);
                    ingredient += new String(temp).trim() + ", ";
                    // trim the remain 20 space out
                }
                System.out.print("Ingredients: " + ingredient);
                System.out.print("\n");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
            fpointer.seek(fpointer.length());
            byte[] temp = new byte[20];
            // temp = "65130500217 Paramita".getBytes();
            // fpointer.write(temp, 0, 20);
            fpointer.writeInt(f.ID); // it will not show in the file because text editor cannot read binary but we
                                     // still can read it
            temp = f.name.concat("                                         ").getBytes(); // any amount of space
            fpointer.write(temp, 0, 20);
            if (f.category != null) {
                temp = f.category.concat("                                 ").getBytes();
            } else {
                temp = "".concat("                                  ").getBytes();
            }
            fpointer.write(temp, 0, 20);
            fpointer.writeDouble(f.price);
            fpointer.writeInt(f.calories);
            fpointer.writeShort(f.star);

            int i = 0, j;
            for (j = 0; j < f.ingredients.size(); j++) {
                String t = ((String) f.ingredients.elementAt(j));
                temp = t.concat("                                      ").getBytes();
                fpointer.write(temp, 0, 20);
            }
            for (i += j; i < 10; i++) {
                temp = "                                 ".getBytes();
                fpointer.write(temp, 0, 20);
            } // to make sure about the fix size
            fpointer.close();

            // fpointer.writeInt(f.ID);
            // byte[] name = new byte[20];
            // name = f.name.concat(" ").getBytes(); // any amount of space
            // fpointer.write(name, 0, 20);
            // this code (with no seek) make the menu.dat appear only fanta because we
            // always write at "0"
            // so the food always replce itself
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

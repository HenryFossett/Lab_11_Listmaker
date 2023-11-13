import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        boolean done = false;
        String input = "";
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        String regEx = "^[AaDdPpQq]$";
        do{
            input = SafeInput.getRegExString(in, "A - Add an Item to the List\nD - Delete an Item from the List\nP - Print (Display) the List\nQ - Quit the Program\n", regEx);
            if (input.equalsIgnoreCase("A")){
                add(myArrList);
            }else if (input.equalsIgnoreCase("D")){
                delete(myArrList);
            }else if(input.equalsIgnoreCase("P")){
                print(myArrList);
            }else if(input.equalsIgnoreCase("Q")) {
                done = quit();
            }

        }while(!done);
    }
    public static void add(ArrayList<String> arrList){
        String input = "";
        int m = 0;
        Scanner in = new Scanner(System.in);
        input = SafeInput.getNonZeroLenString(in, "What would you like to add to the list");
        m = SafeInput.getInt(in, "What location would you like this list item placed");
        arrList.add(m-1, input);
    }
    public static boolean quit(){
        boolean done = false;
        Scanner in = new Scanner(System.in);
        done = SafeInput.getYNConfirm(in, "Do you want to quit the application? [Y/N]");
        if (done == true){
            done = SafeInput.getYNConfirm(in, "Are you sure? [Y/N]");
        }
        return done;
    }
    public static void print(ArrayList<String> arrList){
        for (int i = 0; i < arrList.size(); i++){
            System.out.println(i+1 + ". " +arrList.get(i));
        }
    }
    public static void delete(ArrayList<String> arrList){
        int m = 0;
        Scanner in = new Scanner(System.in);
        m = SafeInput.getInt(in, "What number would you like to delete");
        arrList.remove(m);
        System.out.println("The item at index " + m + " was deleted.");
    }
}

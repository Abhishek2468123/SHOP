
import java.util.Scanner;
public class Main{
    public static void display(){
        System.out.println("Please select from menu :- ");
        System.out.println("1.Show data in table.\n2.Insert into table.\n3.Update from table\n4.Delete from table.\n5.Exit");
    }

    public static void main(String[] args) {
        display();
        String query;
        Scanner sc = new Scanner(System.in);
        int i;
        while(true) {

             i = sc.nextInt();
             sc.nextLine();
            switch (i) {
                case 1 -> {
                    Show.show("SELECT * FROM Products where id = 114");
                    display();
                }
                case 2 -> {
                    System.out.println("Please Enter Insert query....");
                    query = sc.nextLine();
                    Insert.insert(query);
                    display();
                }
                case 3 -> {
                    System.out.println("Please Enter Update query....");
                    query = sc.nextLine();
                    Update.update(query);
                    display();
                }
                case 4 -> {
                    System.out.println("Please Enter Delete query....");
                    query = sc.nextLine();
                    Delete.delete(query);
                    display();
                }
                case 5 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Please enter correct input......");
                    display();
                }
            }
        }
    }
}
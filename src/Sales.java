
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Sales {
    public static boolean checkID(int id){

        if(Count.count("SELECT id FROM Products where id = "+id+" ") == 0){
            return false;
        }else{
            return true;
        }
    }

    public static void display(){
        System.out.println("Please select from menu :- ");
        System.out.println("(1). Buy\n(2). Sell\n(3). Exit");
    }

    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = con.createStatement();
        while(true) {
            Show.show("SELECT * FROM Products\n");
            display();
            int choice = sc.nextInt(),id;
            switch (choice) {
                case 1 -> {
                    System.out.println("Please Select id from table:- ");
                    id = sc.nextInt();
                    if(checkID(id)){
                        System.out.println("Product found.....");
                        System.out.println("Please Enter quantity....");
                        int quantity = sc.nextInt();
                        ResultSet rs = stmt.executeQuery("SELECT quantity FROM Products where id="+id+" ");
                        rs.next();
                        int ans = rs.getInt(1);
                        quantity += ans;
                        Update.update("UPDATE Products set quantity = "+quantity+" where id = "+id+" ");
                        System.out.println("Product added succesfully.....");
                    }else{
                        System.out.println("No such product found....\nPlease try again....");
                    }
                }
                case 2 ->{
                    System.out.println("Please Select id from table:- ");
                    id = sc.nextInt();
                    if(checkID(id)){
                        System.out.println("Product found.....");
                        System.out.println("Please Enter quantity....");
                        int quantity = sc.nextInt();
                        ResultSet rs = stmt.executeQuery("SELECT quantity FROM Products where id="+id+" ");
                        rs.next();
                        int ans = rs.getInt(1);
                        if(quantity > ans ){
                            System.out.println("Not available in entered quantity....");
                        }else{
                            quantity = ans - quantity;
                        Update.update("UPDATE Products set quantity = "+quantity+" where id = "+id+" ");
                        System.out.println("Product sold succesfully.....");
                        }
                    }
                }
                case 3 ->{
                    con.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Please select correct choice....");
                }
            }
        }
    }
}

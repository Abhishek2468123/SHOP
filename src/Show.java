
import java.sql.*;
public class Show {
    public static int show(String query){
        int i = 0;
        try{
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("*******************************************************************");
            System.out.printf("%-6s%-12s%-10s%-8s\n","id","name","quantity","price");
            while(rs.next()){
                i++;
                System.out.printf("%-6s%-12s%-10s%-8s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            System.out.println("*******************************************************************");
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }
}

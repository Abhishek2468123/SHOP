import java.sql.*;
public class Update {
    public static int update(String query){
        int count = 0;
        try{
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            count = stmt.executeUpdate(query);
            System.out.println(count+" "+"Udated successfully...");
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
}

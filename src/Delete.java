import java.sql.*;

public class Delete{
    public static int delete(String query){
        int count = 0;
        try{
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            count = stmt.executeUpdate(query);
            System.out.println(count+" "+"Deleted successfully...");
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
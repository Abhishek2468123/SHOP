import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Count {
        public static int count(String query){
            int i = 0;
            try{
                Connection con = DatabaseConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    i++;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return i;
        }
    }


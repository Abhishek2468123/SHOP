import java.sql.*;
public class Insert{
    public static int insert(String query) {
        int i = 0;
        try {
            Connection con = DatabaseConnection.getConnection();

            //create Statement interface object
            Statement stmt = con.createStatement();//throws SQLException

            /* Excecute Query :-
                1.boolean execute("query"); Insert/Update/Delete
                2.int executeUpdate("query"); Insert/Update/Delete
                3.ResultSet executeQuery("query") Select
             */
            //Insertion query
            i = stmt.executeUpdate(query);//throws SQLException
            System.out.println(i+" Records Inerted succesfully....");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}

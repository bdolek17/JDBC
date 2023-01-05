import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. Step: Registration to the driver
        Class.forName("org.postgresql.Driver");
        //2. Step: Create connection with database
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/batch108", "postgres", "1021");
        //3. Step: Create statement
        Statement st = con.createStatement();

        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees
        String sql1 = "UPDATE companies SET number_of_employees = 16000 WHERE number_of_employees < ((SELECT AVG(number_of_employees) FROM companies))";

        int numOfRecordsUpdated = st.executeUpdate(sql1);
        System.out.println("numOfRecordsUpdated = " + numOfRecordsUpdated);

        String sql2 = "SELECT * FROM companies";
        ResultSet resultSet1 = st.executeQuery(sql2);

        while (resultSet1.next()) {

            System.out.println(resultSet1.getInt(1) + " " + resultSet1.getString(2) + " " + resultSet1.getInt(3));

        }

        con.close();
        st.close();







    }
}

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _09_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);
        int minionsId = Integer.parseInt(scanner.nextLine());

        PreparedStatement updateMinions = connection.prepareStatement("" +
                "CALL usp_get_older(?);");
        updateMinions.setInt(1, minionsId);
        updateMinions.executeUpdate();

        PreparedStatement selectMinions = connection.prepareStatement("" +
                "SELECT name, age FROM minions WHERE id = ?");
        selectMinions.setInt(1, minionsId);

        ResultSet updatedMinionsSet = selectMinions.executeQuery();
        updatedMinionsSet.next();
        String minionName = updatedMinionsSet.getString("name");
        int minionAge = updatedMinionsSet.getInt("age");
        System.out.printf("%s %d\n",minionName,minionAge);

        connection.close();
    }
}

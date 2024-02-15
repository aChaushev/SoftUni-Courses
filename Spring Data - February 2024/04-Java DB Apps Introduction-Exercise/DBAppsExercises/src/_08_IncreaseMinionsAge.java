import java.sql.*;
import java.util.*;

public class _08_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);

        String minionsIds = Arrays.toString(scanner.nextLine().split(" "))
                .replaceAll("\\[", "(")
                .replaceAll("]", ")");

        //update minions
        PreparedStatement updateMinions = connection.prepareStatement("" +
                "UPDATE minions SET name = LOWER(name), age = age + 1 WHERE id IN " + minionsIds);
        updateMinions.executeUpdate();

        //print all minions
        PreparedStatement selectMinions = connection.prepareStatement("" +
                "SELECT name, age FROM minions");

        ResultSet updatedMinionsSet = selectMinions.executeQuery();

        while (updatedMinionsSet.next()) {
            String minionName = updatedMinionsSet.getString("name");
            int minionAge = updatedMinionsSet.getInt("age");
            System.out.printf("%s %d\n",minionName,minionAge);
        }

        connection.close();
    }
}

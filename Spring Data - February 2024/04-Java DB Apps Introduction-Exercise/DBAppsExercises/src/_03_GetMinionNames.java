import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _03_GetMinionNames {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);
        int villainIdInput = Integer.parseInt(scanner.nextLine());

        //REQUEST VILLAINS
        PreparedStatement villainStatement = connection.prepareStatement
                ("select name" +
                        " from villains" +
                        " where id = ?");

        villainStatement.setInt(1, villainIdInput);

        ResultSet villainSet = villainStatement.executeQuery();


        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.\n", villainIdInput);
            return;
        }

        String villainName = villainSet.getString("name");
        System.out.printf("Villain: %s\n", villainName);

        //REQUEST MINIONS
        PreparedStatement minionsStatement = connection.prepareStatement
                ("select" +
                        " distinct name," +
                        " age" +
                        " from minions" +
                        " join minions_villains mv on minions.id = mv.minion_id" +
                        " where mv.villain_id = ?");

        minionsStatement.setInt(1, villainIdInput);

        ResultSet minionsSet = minionsStatement.executeQuery();

        for (int i = 1; minionsSet.next(); i++) {
            String currentMinionName = minionsSet.getString("name");
            int currentMinionAge = minionsSet.getInt("age");
            System.out.printf("%d. %s %d\n", i, currentMinionName, currentMinionAge);
        }

        connection.close();
    }
}

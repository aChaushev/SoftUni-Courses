import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _05_ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        //INPUT
        //Bulgaria
        //Italy
        Scanner scanner = new Scanner(System.in);
        String countryInput = scanner.nextLine();

        //Set towns toUpperCase()
        PreparedStatement updateTownNames = connection.prepareStatement("" +
                " UPDATE towns SET name = UPPER(name) WHERE country = ?");
        updateTownNames.setString(1, countryInput);
        int updatedTownsCount = updateTownNames.executeUpdate();

        //Print Result
        if (updatedTownsCount == 0) {
            System.out.println("No town names were affected.");
            return;
        }

            //Get changed towns
            PreparedStatement changedTowns = connection.prepareStatement("" +
                    " SELECT name FROM towns" +
                    " WHERE country = ?;");
            changedTowns.setString(1, countryInput);

            ResultSet townsSet = changedTowns.executeQuery();

            List<String> towns = new ArrayList<>();
            while (townsSet.next()) {
                String currentTown = townsSet.getString("name");
                towns.add(currentTown);
            }

            System.out.println(updatedTownsCount + " town names were affected.");
            System.out.println(towns);

        connection.close();
    }
}



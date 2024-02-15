import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class _07_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement selectMinionNames = connection.prepareStatement("" +
                "SELECT name FROM minions;");
        ResultSet minionsSet = selectMinionNames.executeQuery();

        List<String> minionsList = new ArrayList<>();
        while (minionsSet.next()) {
            String currentMinion = minionsSet.getString("name");
            minionsList.add(currentMinion);
        }

        // print output
        while (!minionsList.isEmpty()) {
            System.out.println(minionsList.remove(0));
            if (minionsList.isEmpty()) {
                break;
            }
            System.out.println(minionsList.remove(minionsList.size() - 1));
        }

//        int start = 0;
//        int end = minionsList.size() - 1;
//
//        while (start <= end) {
//            System.out.println(minionsList.get(start));
//            if (start != end) {
//                System.out.println(minionsList.get(end));
//            }
//            start++;
//            end--;
//        }

        connection.close();
    }
}

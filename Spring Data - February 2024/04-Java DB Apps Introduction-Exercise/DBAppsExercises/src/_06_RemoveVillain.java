import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _06_RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        //INPUT
        //1 , 3 , 101
        Scanner scanner = new Scanner(System.in);
        int villainIdInput = Integer.parseInt(scanner.nextLine());

        PreparedStatement selectVillain = connection.prepareStatement("" +
                "SELECT name FROM villains WHERE id = ?");
        selectVillain.setInt(1, villainIdInput);
        ResultSet villainSet =  selectVillain.executeQuery();

        if(!villainSet.next()) {
            System.out.println("No such villain was found");
            return;
        }

        String villainName = villainSet.getString("name");

        //get minions count
        PreparedStatement selectMinions = connection.prepareStatement("" +
                " SELECT COUNT(minion_id) AS m_count" +
                " FROM minions_villains" +
                " WHERE villain_id = ?");
        selectMinions.setInt(1, villainIdInput);
        ResultSet minionsCountSet = selectMinions.executeQuery();
        minionsCountSet.next();
        int releasedMinionsCnt = minionsCountSet.getInt("m_count");

        connection.setAutoCommit(false); // default -> true
        //SQL statements are grouped into transactions that are terminated by a call
        // to either the method commit or the method rollback.

        try {
        //delete first mapping table, then villains
            PreparedStatement deleteMinionsVillains = connection.prepareStatement("" +
                    "DELETE FROM minions_villains WHERE villain_id = ?");
            deleteMinionsVillains.setInt(1, villainIdInput);
            deleteMinionsVillains.executeUpdate();

            PreparedStatement deleteVillains = connection.prepareStatement("" +
                    "DELETE FROM villains WHERE id = ?");
            deleteVillains.setInt(1, villainIdInput);
            deleteVillains.executeUpdate();

            connection.commit();
            // perform all operations

            System.out.printf("%s was deleted\n%d minions released\n",
                    villainName, releasedMinionsCnt);

        } catch (SQLException e) {
            connection.rollback();
            // if exception in try block then rollback -> don't execute try block content
            e.printStackTrace();
        }

        connection.close();
    }
}

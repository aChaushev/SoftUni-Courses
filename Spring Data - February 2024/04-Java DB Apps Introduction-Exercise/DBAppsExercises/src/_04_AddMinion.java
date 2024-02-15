import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _04_AddMinion {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        // INPUT
        //Minion: Robert 14 Berlin
        //Villain: Gru
        Scanner scanner = new Scanner(System.in);

        String[] minionInfo = scanner.nextLine().split(" ");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];

        String villainName = scanner.nextLine().split(" ")[1];

        int townId = getOrInsertTown(connection, minionTown);
        int villainId = getOrInsertVillain(connection, villainName);


        PreparedStatement insertMinion = connection.prepareStatement("" +
                "INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?)");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        int updateRowCount = insertMinion.executeUpdate();
        // updateRowCount -> за проверка дали редът се е insert-нал


        //get minion id
        PreparedStatement selectMinion = connection.prepareStatement("" +
                "SELECT id FROM minions WHERE name = ? AND age = ? AND town_id = ?");
        selectMinion.setString(1, minionName);
        selectMinion.setInt(2, minionAge);
        selectMinion.setInt(3, townId);

        ResultSet minionSet = selectMinion.executeQuery();
        minionSet.next();
        int minionId = minionSet.getInt("id");


        PreparedStatement insertMinionVillainId = connection.prepareStatement("" +
                "INSERT INTO minions_villains(minion_id, villain_id) VALUES (?, ?)");
        insertMinionVillainId.setInt(1,minionId);
        insertMinionVillainId.setInt(2,villainId);
        insertMinionVillainId.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.\n",
                minionName, villainName);

        connection.close();
    }

    private static int getOrInsertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement selectVillain = connection.prepareStatement("" +
                "SELECT id FROM villains WHERE name = ?");
        selectVillain.setString(1, villainName);

        ResultSet villainNameSet = selectVillain.executeQuery();

        int villainId;
        if (!villainNameSet.next()) {
            PreparedStatement insertVillain = connection.prepareStatement("" +
                    "INSERT INTO villains(name, evilness_factor) VALUES (?, ?)");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");
            insertVillain.executeUpdate();

            System.out.printf("Villain %s was added to the database.\n", villainName);

            //get new villain id
            ResultSet newVillainNameSet = selectVillain.executeQuery();
            newVillainNameSet.next();
            villainId = newVillainNameSet.getInt("id");

        } else {
            villainId = villainNameSet.getInt("id");
        }
        return villainId;
    }

    private static int getOrInsertTown(Connection connection, String minionTown) throws SQLException {
        PreparedStatement selectTown = connection.prepareStatement("" +
                "SELECT id FROM towns WHERE name = ?");

        selectTown.setString(1, minionTown);

        ResultSet townSet = selectTown.executeQuery();

        int townId;
        if (!townSet.next()) {  // if there is no such town
            PreparedStatement insertTown = connection.prepareStatement("" +
                    "INSERT INTO towns(name) VALUES (?);");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();

            System.out.printf("Town %s was added to the database.\n", minionTown);

            //get new town id
            ResultSet newTownSet = selectTown.executeQuery();
            newTownSet.next();
            townId = newTownSet.getInt("id");

        } else {
            townId = townSet.getInt("id");
        }

        return townId;
    }
}

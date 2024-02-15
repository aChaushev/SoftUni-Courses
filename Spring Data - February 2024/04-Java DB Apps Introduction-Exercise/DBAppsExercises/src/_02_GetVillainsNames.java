import java.sql.*;
import java.util.Properties;


public class _02_GetVillainsNames {

    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement
                ("select " +
                        " v.name, " +
                        " count(distinct  mv.minion_id) as minions_cnt" +
                        " from villains v" +
                        " join minions_villains mv on v.id = mv.villain_id" +
                        " group by v.name" +
                        " having minions_cnt > ?" +
                        " order by minions_cnt desc;");

        statement.setInt(1, 15);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String dbVilleinName = resultSet.getString("v.name");
            int dbMinionsCnt = resultSet.getInt("minions_cnt");

            System.out.printf("%s %s", dbVilleinName, dbMinionsCnt);
        }

        connection.close();
    }
}

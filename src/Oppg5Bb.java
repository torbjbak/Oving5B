import java.sql.*;

public class Oppg5Bb {

    void printTable(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int i;
        for(i = 1; i <= md.getColumnCount(); i++) {
            System.out.printf("%16s", md.getColumnName(i));
        }
        System.out.println();
        while(rs.next()) {
            for(i = 1; i <= md.getColumnCount(); i++) {
                System.out.printf("%16s", rs.getString(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.printf("%20s", "text");
    }
}

import java.sql.*;


public class Oppg5Ba {



    public static void main(String[] args) {
        String isbn = "'0-596-00123-1'";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://mysql-ait.stud.idi.ntnu.no/torbjbak",
                    "torbjbak","Le8OcFET");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select forfatter, tittel from boktittel where isbn = " + isbn);
            printTable(rs);
            System.out.println();

            rs = stmt.executeQuery("select count(*) antall from eksemplar where isbn = " + isbn);
            printTable(rs);

            con.close();

        }catch(Exception ex) {
            // If connection fail
            System.out.println("Error: " + ex);
        }
    }

    static void printTable(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int i;
        for(i = 1; i <= md.getColumnCount(); i++) {
            System.out.printf("|%20S|", md.getColumnName(i));
        }
        System.out.println();
        while(rs.next()) {
            for(i = 1; i <= md.getColumnCount(); i++) {
                System.out.printf("|%20s|", rs.getString(i));
            }
            System.out.println();
        }
    }
}
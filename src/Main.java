import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://mysql-ait.stud.idi.ntnu.no/torbjbak",
                    "torbjbak","Le8OcFET");

            Statement stmt = con.createStatement();

            System.out.println("Forfatter           Tittel");
            ResultSet rs = stmt.executeQuery("select forfatter, tittel from boktittel where isbn = '0-596-00123-1'");
            while(rs.next()) {
                System.out.println(rs.getString("forfatter") + "   " + rs.getString("tittel"));
            }

            rs = stmt.executeQuery("select count(*) antall from eksemplar where isbn = '0-596-00123-1'");
            while(rs.next()) {
                System.out.println("\nAntall: "+ rs.getInt("antall"));
            }

            con.close();

        }catch(Exception ex) {
            // If connection fail
            System.out.println("Error: " + ex);
        }
    }
}
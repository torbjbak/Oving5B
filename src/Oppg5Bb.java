import java.sql.*;
import java.util.Scanner;

public class Oppg5Bb {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int success = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql-ait.stud.idi.ntnu.no/torbjbak",
                    "torbjbak", "Le8OcFET");

            System.out.print("Registrer lånetaker!\nEksemplarnr: ");
            int eksNr = sc.nextInt(); sc.nextLine();

            System.out.print("ISBN-nr: ");
            String isbn = sc.nextLine();

            System.out.print("Lånetaker: ");
            String navn = sc.nextLine();

            String query = "UPDATE eksemplar SET laant_av = '"+ navn +"' WHERE isbn = '"+ isbn
                    +"' AND eks_nr = "+ eksNr +" AND laant_av IS NULL;";

            PreparedStatement ps = con.prepareStatement(query);
            success = ps.executeUpdate();

            con.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        if(success > 0) {
            System.out.println("\nEn lånetaker ble registrert!");
        } else {
            System.out.println("\nNoe gikk galt!");
        }
    }
}

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;


public class HotelReservationSystem {
    public static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    public static final String username = "root";
    public static final String password = "Blessings@101";

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            while (true){
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("6. Exit");
                System.out.println("Choose an option");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        reserveRoom(con,scanner);
                        break;
                    case 2:
                        viewReservations(con);
                        break;
                    case 3:
                        getRoomNumber(con,scanner);
                        break;
                    case 4:
                        updateReservation(con,scanner);
                        break;
                    case 5:
                        deleteReservation(con,scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.Try again.");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    private static void reserveRoom(Connection con,Scanner scanner){
        try {
            System.out.println("Enter guest name: ");
            String guestName = scanner.next();
            scanner.nextLine();
            System.out.println("Enter room number: ");
            int roomNumber = scanner.nextInt();
            System.out.println("Enter contact number");
            String contactNumber = scanner.next();

            String sql = "INSERT INTO reservations(guest_name,room_number, contact_number)" +
                    "VALUES('" + guestName + "', " + roomNumber + ", '" + contactNumber + "')";

            try(Statement st = con.createStatement()){
                int affectedrows = st.executeUpdate(sql);
                if(affectedrows>0)
                    System.out.println("Reservation successful");
                else
                    System.out.println("Reservation failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void viewReservations(Connection connection) throws SQLException{
        String sql = "SELECT * FROM reservations";
        try(Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            System.out.println("Current Reservations:");
            System.out.println(" +----------------+--------------+-------------+----------------+-----------------------+");
            System.out.println("(| Reservation ID | Guest        | Room Number | Contact Number | Reservation Date      |");
            System.out.println(" +----------------+--------------+-------------+----------------+-----------------------+");
            while(rs.next()){
                int reservationID = rs.getInt("reservation_id");
                String guestName = rs.getString("guest_name");
                int roomNumber = rs.getInt("room_number");
                String contactNumber = rs.getString("contact_number");
                String reservationDate = rs.getTimestamp("reservation_date").toString();

                // Format and display the reservation in table like format
                System.out.printf("| %-15d | %-12s | %-11d | %-14s | %-19s |\n",
                        reservationID,guestName,roomNumber,contactNumber,reservationDate);
            }
            System.out.println(" +----------------+-------------+--------------+---------------+------------------------+");
        }
    }
    private static void getRoomNumber(Connection con, Scanner sc){
        System.out.println("Enter reservation ID: ");
        int reservationId = sc.nextInt();
        System.out.println("Enter guest name: ");
        String guestName = sc.next();
        String sql = "SELECT room_number FROM reservations " +
                "WHERE reservation_id = " + reservationId +
                "AND guest_name = '" + guestName + "'";
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            if(rs.next()){
                int roomNumber = rs.getInt("room_number");
                System.out.println("Room number for Reservation ID " + reservationId +
                        " and Guest " + guestName  + " is " + roomNumber);
            }else{
                System.out.println("Reservation not found for the given ID and guest name.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void updateReservation(Connection con, Scanner sc){
        try {
            System.out.println("Enter reservation ID to update: ");
            int reservationId = sc.nextInt();
            sc.nextLine();

            if(!reservationExists(con,reservationId)){
                System.out.println("Reservation not found for the given ID.");
                return;
            }

            System.out.println("Enter new guest name: ");
            String newGuestName = sc.nextLine();
            System.out.println("Enter new room number: ");
            int newRoomNumber = sc.nextInt();
            System.out.println("Enter new contact number: ");
            String newContactNumber = sc.next();

            String sql = "UPDATE reservations SET guest_name = '" + newGuestName + "', " +
                    "room_number = " + newRoomNumber + ", " + "contact_number = '" +
                    newContactNumber + "' " + "WHERE reservation_id = " + reservationId;

            try(Statement st = con.createStatement()){
                int affectedRows = st.executeUpdate(sql);

                if(affectedRows > 0){
                    System.out.println("Reservation updated successfully!");
                }else{
                    System.out.println("Reservation update failed.");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void deleteReservation(Connection con,Scanner sc){
        try {
            System.out.println("Enter reservation ID to delete: ");
            int reservationId = sc.nextInt();

            if(!reservationExists(con,reservationId)){
                System.out.println("Reservation not found for the given ID.");
                return;
            }

            String sql = "DELETE FROM reservations WHERE reservation_id = " + reservationId;

            try (Statement st = con.createStatement()){
                int affectedRows = st.executeUpdate(sql);

                if(affectedRows > 0){
                    System.out.println("Reservation deleted successfully!");
                }else{
                    System.out.println("Reservation deletion failed");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static boolean reservationExists(Connection con, int reservationId){
        try{
            String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = " + reservationId;
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql)){

                return rs.next(); // if there's a result, the reservation exists
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false; // Handle database errors as needed
        }
    }
    public static void exit() throws InterruptedException{
        System.out.print("Exiting system");
        int i = 5;
        while (i!=0){
            System.out.print(".");
            Thread.sleep(150);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Using Hotel Reservation System");
    }
}

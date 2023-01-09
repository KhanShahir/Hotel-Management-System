import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Room{

    public enum RoomType {SINGLE, DOUBLE, STUDIO, SUITE};

    private RoomType roomType;
    private double pricePerNight;
    private double roomSize;
    private int roomNumber;
    private int floorNumber;
    private String description;
    private boolean isVacant;
    private List<Reservation> reservations;

    public Room(RoomType roomType, double pricePerNight, double roomSize, int roomNumber, int floorNumber, String description) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.roomSize = roomSize;
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.description = description;
        this.isVacant = true;
        this.reservations = new ArrayList<>();
    }

    public boolean getVacancyStatus() {
        return isVacant;
    }

    // Getter method for the room number
    public int getRoomNumber() {
        return roomNumber;
    }

    // Getter method for the price per night
    public double getPricePerNight() {
        return pricePerNight;
    }

    // Setter method for the price per night
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Getter method for the list of reservations
    public List<Reservation> getReservations() {
        return reservations;
    }

    public int reserve(Date startDate, Date endDate, Person guest) {
        // Check if the room is available for the given start and end dates
        if (isVacant || checkAvailability(startDate, endDate)) {
            // Create a new reservation for the room
            Reservation reservation = new Reservation(startDate, endDate, pricePerNight, guest);
            // Add the reservation to the list of reservations for the room
            reservations.add(reservation);
            // Set the vacancy status of the room to false
            isVacant = false;
            // Return the reservation number of the new reservation
            return reservation.getReservationNumber();
        }
        // If the room is not available, return zero
        return 0;
    }

    private boolean checkAvailability(Date startDate, Date endDate) {
        // Check if any of the existing reservations for the room conflict with the given start and end dates
        for (Reservation reservation : reservations) {
            if (!reservation.isAvailable(startDate, endDate)) {
                return false;
            }
        }
        return true;
    }

    public void cancel(int reservationNumber) {
        // Find the reservation with the given reservation number
        for (Reservation reservation : reservations) {
            if (reservation.getReservationNumber() == reservationNumber) {
                // Remove the reservation from the list of reservations for the room
                reservations.remove(reservation);
                break;
            }
        }
    }

    public void checkin() {
        isVacant = true;
    }

    // Method that sets the vacancy status of the room to false
    public void checkout() {
        isVacant = false;
    }

    public String status() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation list of room number ").append(roomNumber).append(": ");
        if (isVacant) {
            sb.append("Vacant.");
        } else {
            sb.append("Occupied.");
        }
        sb.append("\n");
        for (Reservation reservation : reservations) {
            sb.append(reservation).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {

    return roomType + ", price=$" + pricePerNight + ", Size=" + roomSize +
    ", Number=" + roomNumber + ", Floor=" + floorNumber +
    "\nDescription:  " + description;
    
    }

}

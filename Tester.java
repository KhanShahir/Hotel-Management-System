import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    
    public static void main(String[] args) {
        
        // Create a 3.5 stars hotel, named "Baba-Mama", built in 2018, with two floors
        // The owners' "firstname last name"'s of the hotel are "Ali Baba" and "Alice Mama".

        ArrayList<Person> owners = new ArrayList<>();
        owners.add(new Person("Ali", "Baba"));
        owners.add(new Person("Alice", "Mama"));
        Hotel hotel = new Hotel("Baba-Mama", owners, Year.of(2018), 2, 3.5);

        
        
        // Adding some rooms to this new hotel
        // SINGLE, price=$35.50, size=200, floor=1, number=101, description="Single Room without view");
        // Double, price=$50.50, size=350, floor=1, number=102, description="Double Room without view");
        // Double, price=$55.00, size=400, floor=2, number=201, description="Double Room with view");
        // Suite, price=80.00, size=500, floor=2, number=202, description="Suite Room with view and balcony");

        hotel.addRoom(new Room(Room.RoomType.SINGLE, 35.50, 200, 101, 1, "Single Room without view"));
        hotel.addRoom(new Room(Room.RoomType.DOUBLE, 50.50, 350, 102, 1, "Double Room without view"));
        hotel.addRoom(new Room(Room.RoomType.DOUBLE, 55.00, 400, 201, 2, "Double Room with view"));
        hotel.addRoom(new Room(Room.RoomType.SUITE, 80.00, 500, 202, 2, "Suite Room with view and balcony"));
        
        
        // Show the hotel information, including its rooms
        
        
        // Reserve the room number 102 for "Joe Uncle", checkin March 6, 2021, checkout March 8, 2021
        // Print out the reservation result
        
        int reservationNumber = hotel.reserve(102, Date.valueOf("2021-03-06"), Date.valueOf("2021-03-08"), new Person("Joe", "Uncle"));
        System.out.println("Room 102 " + (reservationNumber > 0 ? "Reservation successful. Reservation number: " + reservationNumber : "Reservation was not successful. Check the room availability."));
        
        
        
        // Change the price of the room 102 to $52.00

        Room room = hotel.getRoom(102);
        room.setPricePerNight(52.00);
        
        // Reserve the room number 102 for "Mike Brother", checkin April 2, 2021, checkout April 4, 2021
        // Print out the reservation result

        reservationNumber = hotel.reserve(102, Date.valueOf("2021-04-02"), Date.valueOf("2021-04-04"), new Person("Mike", "Brother"));
        if (reservationNumber != 0) {
            System.out.println("Room 102 Reservation successful. Reservation number: " + reservationNumber);
        } else {
            System.out.println("Sorry, Reservation was not successful. Check the room availability.");
        }
        
        
        
        
        // Reserve the room number 101 for "Maria Aunt", checkin May 27, 2021, checkout May 28, 2021
        // Print out the reservation result
        
        reservationNumber = hotel.reserve(101, Date.valueOf("2021-05-27"), Date.valueOf("2021-05-28"), new Person("Maria", "Aunt"));
        System.out.println("Room 101 " + (reservationNumber > 0 ? "Reservation successful. Reservation number: " + reservationNumber : "Reservation was not successful. Check the room availability."));
        
        
        
        
        // Reserve the room number 101 for "laura Sister", checkin May 25, 2021, checkout May 28, 2021
        // Print out the reservation result
        
        reservationNumber = hotel.reserve(101, Date.valueOf("2021-05-25"), Date.valueOf("2021-05-28"), new Person("Laura", "Sister"));
        System.out.println("Room 101 " + (reservationNumber > 0 ? "Reservation successful. Reservation number: " + reservationNumber : "Sorry, Reservation was not successful. Check the room availability."));
        
        
        // Check in the room 102

        room = hotel.getRoom(102);
        room.checkin();
        
        // Cancel reservation number 10003 and show the cancellation result

        boolean cancellationResult = hotel.cancel(10003);
        System.out.println("Reservation 10003 is " + (cancellationResult ? "canceled." : "not found."));
        
        
        
        // Show all the statuses of all the rooms

        System.out.println("---------------");
        System.out.println("Rooms' Statuses");
        System.out.println("---------------");
        for (Room r : hotel.getRooms()) {
            System.out.println(r.status());
        }


    }
}

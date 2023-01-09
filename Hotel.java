import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;

public class Hotel extends Building{

    private String name;
    private double rate;
    private ArrayList<Person> owners;
    private ArrayList<Room> rooms;

    public Hotel(){

        super();

    }

    public Hotel(String name, ArrayList<Person> owners, Year yearBuilt, int numberOfFloors, double rate) {
        super(yearBuilt, numberOfFloors);
        this.name = name;
        this.owners = owners;
        this.rate = rate;
        this.rooms = new ArrayList<>();
    }
    
    public String getName(){

        return name;

    }

    public ArrayList<Person> getOwners(){

        return owners;

    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(int roomNumber){

        for(Room room: rooms){
            if (room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        
        return null;

    }

    public void addOwner(Person owner){

        owners.add(owner);
    }

    public void addRoom(Room room){

        rooms.add(room);
    }

    public int reserve(int roomNumber, Date startDate, Date endDate, Person guest) {
        // Find the room with the given room number
        Room room = getRoom(roomNumber);
        // If the room was found, reserve it and return the reservation number
        if (room != null) {
            return room.reserve(startDate, endDate, guest);
        }
        // If the room was not found, return zero
        return 0;
    }

    public boolean cancel(int reservationNumber) {
        // Find the room with the given reservation number
        for (Room room : rooms) {
            if (room.getReservations().stream().anyMatch(reservation -> reservation.getReservationNumber() == reservationNumber)) {
                // Cancel the reservation
                room.cancel(reservationNumber);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", ").append(rate).append(" stars.\n");
        sb.append("Hotel Owners: ");
        for (Person owner : owners) {
            sb.append(owner.getFirstName()).append(" ").append(owner.getLastName()).append("  ");
        }
        sb.append("\nRooms:\n");
        for (Room room : rooms) {
            sb.append(room).append("\n");
        }
        return sb.toString();
    }

}

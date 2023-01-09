import java.sql.Date;

public class Reservation{

    private Date startDate;
    private Date endDate;
    private double pricePerNight;
    private Person guest;
    private static int lastReservationNumber = 100000;
    private int reservationNumber;

    public Reservation(Date startDate, Date endDate, double pricePerNight, Person guest){

        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerNight = pricePerNight;
        this.guest = guest;
        this.reservationNumber = ++lastReservationNumber;
    
    }

    public Date getStartDate(){

        return startDate;

    }

    public Date getEndDate(){

        return endDate;

    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public boolean isAvailable(Date startDate, Date endDate){

        if (startDate.after(this.startDate) && endDate.after(this.endDate)) {
            return true;
        }
        // Check if the given start and end dates are before the start and end dates of this reservation
        if (startDate.before(this.startDate) && endDate.before(this.endDate)) {
            return true;
        }
        // If the start and end dates are not before or after the start and end dates of this reservation, then the room is not available
        return false;

    }

    @Override
    public String toString(){

        return "Reservation Number: " + reservationNumber + "\n" +
               "From: " + startDate + " To: " + endDate + "\n" +
               "Guest: " + guest + "\n" +
               "$" + pricePerNight + " per night";

    }

}

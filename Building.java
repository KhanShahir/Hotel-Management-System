import java.time.Year;

public class Building {

    private Year yearBuilt;
    private int numFloors;
   
    public Building(){
        
        this.yearBuilt = Year.now();
        this.numFloors = 1;
        
    }

    public Building(Year yearBuilt, int numFloors){

        this.yearBuilt = yearBuilt;
        this.numFloors = numFloors;


    }

    // Getter method for the year of built
    public Year getYearBuilt() {
        return yearBuilt;
    }

    // Setter method for the year of built
    public void setYearBuilt(Year yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    // Getter method for the number of floors
    public int getNumFloors() {
        return numFloors;
    }

    // Setter method for the number of floors
    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

}
    

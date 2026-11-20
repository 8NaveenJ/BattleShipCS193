import java.util.Arrays;

public class Ship {
    private boolean sunk = false;
    
    //list containing the coordinates of each segment of the ship | example: [A1, A2, A3]
    private String[] coords;
    
    //list containing the status of each segment of the ship, where 1 = undamaged and 0 = damaged
    private int[] coordsValues;
    
    public Ship(String name, String[] coords) {
        this.coords = coords;
        this.coordsValues = new int[coords.length];
        Arrays.fill(coordsValues, 1);
    }
}

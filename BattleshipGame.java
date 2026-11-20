import java.util.Arrays;
import java.util.Scanner;

public class BattleshipGame {
    
    private static String[] shipNames = {"Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier"};
    private static int[] shipLengths = {2, 3, 3, 4, 5};
    
    //list of ship objects for each player, each containing positions and sunk status
    private Ship[] playerOneShipObjects = new Ship[5];
    private Ship[] playerTwoShipObjects = new Ship[5];
    
    //matrixes displaying ship locations for each player
    private String[][] playerOneShips;
    private String[][] playerTwoShips;
  
    //matrixes displaying hits and misses on other player
    private String[][] playerOneHitField; //shows hits on player 2
    private String[][] playerTwoHitField; //shows hits on player 1
    
    private int rows = 10;
    private int columns = 10;
    
    public BattleshipGame() {
        
        //populate empty ship matrixes
        
        playerOneShips = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(playerOneShips[i], "~");
        }
        playerTwoShips = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(playerTwoShips[i], "~");
        }
        
        // populate empty hit fields
        
        playerOneHitField = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(playerOneHitField[i], "~");
        }
        playerTwoHitField = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(playerTwoHitField[i], "~");
        }
        
    }
    
    public void begin() {
        
        selectShipPlacements(1, playerOneShips);
        selectShipPlacements(2, playerTwoShips);
        
    }
    
    //temporary for testing
    public String[][] getPlayerOneShips() {
        return playerOneShips;
    }
    
    public void displayMatrix(String[][] matrix) {
        System.out.print("  ");
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        
        for (int i = 0; i < rows; i++) {
            
            System.out.print((char)(i + 65) + " ");
            
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("---------------------");
        System.out.println("");
    }
    
    //prompts player to input coordinates for each ship placement
    private void selectShipPlacements(int player, String[][] playerShipMatrix) {
        
        Scanner s = new Scanner(System.in);
        displayMatrix(playerShipMatrix);
        
        for (int i = 0; i < 5; i++) {
            IO.println("Player " + player);
            IO.println("Select " + shipNames[i] + " start position (format: a1, b2, etc.)");
            String coord = s.nextLine();
            int[] converted = convertCoords(coord);
            IO.println(Arrays.toString(converted));
            playerShipMatrix[converted[0]][converted[1]] = "X";
            displayMatrix(playerShipMatrix);
        }
        
        
    }
    //takes input coord (format: a1, b2, etc.) 
    //returns matrix index equivalent in the form {row, column} or {-1,-1} if the input is invalid
    private int[] convertCoords(String coord) {
        
        //check for invalid input length
        if ((coord.length() < 2) || (coord.length() > 3)) {
            return new int[]{-1, -1};
        }
        
        String letter = coord.substring(0,1).toLowerCase();
        
        //check if row is invalid or out of bounds
        if ((letter.charAt(0) < 97) || (letter.charAt(0) >= (97 + rows))) {
            return new int[]{-1, -1};
        }
        
        int number = -1;
        try {
            
            number = Integer.parseInt(coord.substring(1));
        
        //catches invalid column     
        } catch (NumberFormatException e) {
            return new int[]{-1, -1};
        }
        
        //check if column is out of bounds
        if ((number < 0) || (number > columns)) {
            return new int[]{-1, -1};
        }
        
        return new int[]{letter.charAt(0) - 97, number - 1};
        
    }
}

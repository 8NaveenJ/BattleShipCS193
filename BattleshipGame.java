import java.util.Arrays;
import java.util.Scanner;

public class BattleshipGame {

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
  private void selectShipPlacements(String[][] playerShipMatrix) {
      Scanner s = new Scanner(System.in);
      
  }
  
}

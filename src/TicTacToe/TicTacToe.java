package TicTacToe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  static ArrayList<Integer> Spieler = new ArrayList<Integer>();
  static ArrayList<Integer> cpuPostion = new ArrayList<Integer>();

  public static void main(String[] args) throws IOException {
    char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
        , {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}};

    printGameBoard(gameBoard);

    // InputStreamReader isr = new InputStreamReader(System.in);
    //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter your choice from (1-9):");
      int choice = input.nextInt();
      while (Spieler.contains(choice) || cpuPostion.contains(Spieler)) {
        System.out.println("position is taken ,enter another choice ");
        choice = input.nextInt();
      }
      boardChoices(gameBoard, choice, "Tom");
      String result = checkWinner();
      if (result.length() > 0) {
        System.out.println(result);
        break;
      }
      Random random = new Random();
      int computerChoice = random.nextInt(9) + 1;
      while (Spieler.contains(computerChoice) || cpuPostion.contains(computerChoice)) {
        computerChoice = random.nextInt(9) + 1;
      }
      boardChoices(gameBoard, computerChoice, "Computer");

      printGameBoard(gameBoard);
      result = checkWinner();
      if (result.length() > 0) {
        System.out.println(result);
        break;
      }

    }
  }

  public static void printGameBoard(char[][] array) {

    for (char[] row : array) {
      //   for(char c:row) {

      System.out.println(row);
      //    }
      //  System.out.println();
    }
  }


  public static void boardChoices(char[][] gameBoard, int choice, String user) {

    char symbol = ' ';

    if (user.equals("Tom")) {
      symbol = 'X';
      Spieler.add(choice);
    } else if (user.equals("Computer")) {
      symbol = 'O';
      cpuPostion.add(choice);
    }
    switch (choice) {
      case 1:
        gameBoard[0][0] = symbol;
        break;
      case 2:
        gameBoard[0][2] = symbol;
        break;
      case 3:
        gameBoard[0][4] = symbol;
        break;
      case 4:
        gameBoard[2][0] = symbol;
        break;
      case 5:
        gameBoard[2][2] = symbol;
        break;
      case 6:
        gameBoard[2][4] = symbol;
        break;
      case 7:
        gameBoard[4][0] = symbol;
        break;
      case 8:
        gameBoard[4][2] = symbol;
        break;
      case 9:
        gameBoard[4][4] = symbol;
        break;
      default:
        break;

    }
  }

  public static String checkWinner() {
    List topRow = Arrays.asList(1, 2, 3);
    List midRow = Arrays.asList(4, 5, 6);
    List downrow = Arrays.asList(7, 8, 9);
    List leftCol = Arrays.asList(1, 4, 7);
    List midCol = Arrays.asList(2, 5, 8);
    List rightCol = Arrays.asList(3, 6, 9);

    List<List> winCond = new ArrayList<List>();
    winCond.add(topRow);
    winCond.add(midRow);
    winCond.add(downrow);
    winCond.add(leftCol);
    winCond.add(midCol);
    winCond.add(rightCol);

    for (List l : winCond) {
      if (Spieler.containsAll(l)) {
        return "Great ,you won :)";
      } else if (cpuPostion.containsAll(l)) {
        return "Game over ,Computer won :(";
      } else if (Spieler.size() + cpuPostion.size() == 9) {
        return "No Winner in the Game";

      }
    }
    return "";
  }

}

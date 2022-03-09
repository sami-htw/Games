/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.util.Scanner;

/**
 *
 * @author sami
 */
public class VierGewinnt {

    static Scanner input = new Scanner(System.in);

    static char answer = ' ';

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("select the high(from 5 to 8)");
        int high = input.nextInt();
        if (high < 5 | high > 8) {
            System.err.println("Error ! not acceptable");
            return;
        }
        System.out.println("select the width (from 5 to 8)");
        int width = input.nextInt();
        if (width < 5 | width > 8) {
            System.err.println("Error ! not acceptable");
            return;
        }

        char Board[][] = new char[high][width];
        char player = 'X';

        fillboard(Board, '-');

        System.out.println("\nEnter who should start (player X or player B) ,select (X or B) ");
        answer = input.next().charAt(0);
        System.out.println("+" + answer);
        if (answer == 'B' || answer == 'b') {
            player = 'B';
        };

        while (true) {
            
            
            // show the state of the Board
            showGameBoard(Board);

            // Ask player for move
            System.out.println();
            System.out.println("\n player " + player + ", please select a column :");
            int col = input.nextInt();

            if (tryDropPiece(Board, col, player)) {
                if (checkForwin(Board)) {
                    System.out.println("{player " + player + " won}");
                    showGameBoard(Board);
                    return;  //End game;
                }

                player = switchPlayer(player);

            }

        }

    }

    // fill the gameboard with an empty character

    /**
     *
     * @param board
     * @param myChar
     * @return
     */
    public static char[][] fillboard(char[][] board, char myChar) {
        for (int row = 0; row < board.length; row++) {
            java.util.Arrays.fill(board[row], 0, board[row].length, myChar);
        }
        return board;
    }

    /**
     *
     * @param board
     */
    public static void showGameBoard(char[][] board) {

        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print("|");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col] + " |");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------");

        int width = 0;

        for (int i = 0; i < board[width].length; i++) {

            System.out.print("| " + i + " ");

        }
        System.out.print("|");

    }

    /**
     *
     * @param board
     * @param col
     * @param player
     * @return
     */
    public static boolean tryDropPiece(char[][] board, int col, char player) {
        boolean result = false;
        //check if the column is full
        if (board[0][col] != '-') {
            System.out.println("That column is already full.");
            return false;
        }
        //Drop the piece as far as it will go. Find the first empty space, starting from the bottom
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col] == '-') {
                board[row][col] = player;
                return true;
            }
        }
        return result;
    }

    // check for win :

    /**
     *
     * @param Board
     * @return
     */
    public static boolean checkForwin(char[][] Board) {

        boolean result = false;

        // check for win horizontally
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[row].length - 3; col++) {
                if (Board[row][col] != '-' && Board[row][col] == Board[row][col + 1] && Board[row][col] == Board[row][col + 2] && Board[row][col] == Board[row][col + 3]) {
                    return true;
                }
            }
        }

        //  check for win vertically
        for (int col = 0; col < Board[0].length; col++) {
            for (int row = 0; row < Board.length - 3; row++) {
                if (Board[row][col] != '-' && Board[row][col] == Board[row + 1][col] && Board[row][col] == Board[row + 2][col] && Board[row][col] == Board[row + 3][col]) {
                    return true;
                }
            }
        }

        //check for win (diagonally - first direction) (from top left)
        for (int row = 0; row < Board.length - 3; row++) {
            for (int col = 0; col < Board[row].length - 3; col++) {
                if (Board[row][col] != '-' && Board[row][col] == Board[row + 1][col + 1] && Board[row][col] == Board[row + 2][col + 2] && Board[row][col] == Board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        for (int row = 0; row < Board.length - 3; row++) {
            for (int col = 3; col < Board[row].length; col++) {
                if (Board[row][col] != '-' && Board[row][col] == Board[row + 1][col - 1] && Board[row][col] == Board[row + 2][col - 2] && Board[row][col] == Board[row + 3][col - 3]) {
                    return true;
                }
            }
        }

        return result;
    }

    /**
     *
     * @param currentplayer
     * @return
     */
    
    // switch players (X and B)
    public static char switchPlayer(char currentplayer) {

        if (currentplayer == 'X') {
            return 'B';

        } else {
            return 'X';
        }
    }

}

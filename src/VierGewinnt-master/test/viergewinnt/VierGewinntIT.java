/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Osama Ahmad
 */
public class VierGewinntIT {


    /**
     * Test of main method, of class VierGewinnt.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VierGewinnt.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillBoard method, of class VierGewinnt.
     */
    @Test
    public void testFillboard() {
        int high = 7;
        int width = 6;
        char[][] board = new char[high][width];
        char myChar = ' ';
        char[][] result = VierGewinnt.fillboard(board, myChar);

        assertArrayEquals(board, result);
    }

    /**
     * Test of showGameBoard method, of class VierGewinnt.
     */
    @Test
    public void testShowGameBoard() {
        System.out.println("showGameBoard : ");
        int high = 7;
        int width = 6;
        char[][] board = new char[high][width];
        VierGewinnt.showGameBoard(board);
    }

    /**
     * Test of tryDropPiece method, of class VierGewinnt.
     */
    @Test
    public void testTryDropPiece() {
        System.out.println("tryDropPiece");
        int high = 7;
        int width = 6;
        char[][] board = new char[high][width];
        int col = 0;
        char player = ' ';
        boolean expResult = false;
        boolean result = VierGewinnt.tryDropPiece(board, col, player);
        assertEquals(expResult, result);

    }


    @Test
    public void testCheckForwinplayer() {
        System.out.println("checkForwin");
        int high = 7;
        int width = 6;

        char[][] Board = new char[high][width];
        Board[0][0] = 'X';
        Board[0][1] = 'X';
        Board[0][2] = 'X';
        Board[0][3] = 'X';
        boolean expResult = true;
        boolean result = VierGewinnt.checkForwin(Board);
        assertEquals(expResult, result);

    }

    /**
     * Test of switchPlayer method, of class VierGewinnt.
     */
    @Test
    public void testSwitchPlayer() {
        System.out.println("switchPlayer");
        char currentplayer = 'X';
        char expResult = 'B';
        char result = VierGewinnt.switchPlayer(currentplayer);
        assertEquals(expResult, result);
    }

}

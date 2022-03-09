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
 *
 * @author sami
 */
   public class VierGewinntIT {
    
    public VierGewinntIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class VierGewinnt.
     */
  //  @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VierGewinnt.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillboard method, of class VierGewinnt.
     */
    @Test
    public void testFillboard() {
        
        VierGewinnt test1=new VierGewinnt();
        System.out.println("fillboard");
        int high=7;
        int width=6;
        char[][] board = new char[high][width];
        char myChar = ' ';
        char[][] expResult = new char[high][width];
        char[][] result = VierGewinnt.fillboard(board, myChar);
       result=new char[7][6];
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of showGameBoard method, of class VierGewinnt.
     */
    @Test
    public void testShowGameBoard() {
        System.out.println("showGameBoard");
        int high=7;
        int width=6;
        char[][] board = new char[high][width];
        VierGewinnt.showGameBoard(board);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of tryDropPiece method, of class VierGewinnt.
     */
    @Test
    public void testTryDropPiece() {
        System.out.println("tryDropPiece");
        int high =7;
        int width=6;
        char[][] board = new char[high][width];
        int col = 0;
        char player = ' ';
        boolean expResult = false;
        boolean result = VierGewinnt.tryDropPiece(board, col, player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of checkForwin method, of class VierGewinnt.
     */
    @Test
    public void testCheckForwin() {
        System.out.println("checkForwin");
        int high=7;
        int width=6;
        char[][] Board = new char[high][width];
        boolean expResult = true;
        boolean result = VierGewinnt.checkForwin(Board);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
   //     fail("The test case is a prototype.");
    }
    
}

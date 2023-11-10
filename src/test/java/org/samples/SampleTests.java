package org.samples;


import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTests {

    @Test
    public void printSimpleBoard() {
        int[][] board = new int[3][3];
        String result = printBoard(board);
        Approvals.verify(result);
    }



    @Test
    void whenLifeCellIsInTheMiddleAndItHasNoNeighborTheCellDies() {
        int[][] board = new int[3][3];
        board[1][1] = 1;
       Approvals.verify(printBoard(board));
    }

    private static String printBoard(int[][] board) {
        String result = "";
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                result += board[y][x];
            }
            result += "\n";
        }
        return result;
    }
    /**
     * note: this requires GSON which is currently added in the pom.xml file.
     * This is only required if you want to use the VerifyAsJson.
     **/
    @Test
    public void testJson() {
        Person hero = new Person("jayne", "cobb", true, 38);
        Approvals.verifyAsJson(hero);
    }
}

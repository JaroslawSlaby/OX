package com.js.tictactoe.judge;

import com.js.tictactoe.board.Board;
import com.js.tictactoe.board.coords.Coordinates;
import com.js.tictactoe.exceptions.WrongIndexException;
import com.js.tictactoe.exceptions.WrongSizeException;
import com.js.tictactoe.player.Sign;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class JudgeTest {
    private Board board;

    @BeforeMethod
    public void setUp() throws WrongSizeException {
        board = Board.getRectangleBoard(5, 5);
    }

    public void checkIfCorrectlyFilledColumnReturnsTrue() throws WrongIndexException {
        Judge judge = new Judge(board, 5);

        board.insertSign(Coordinates.parseCoordinates("3 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("0 0"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("0 1"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("1 0"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("0 2"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("0 4"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("0 3"), Sign.X);

        boolean isWinner = judge.isWinner(Sign.X);
        assertTrue(isWinner);
    }

    public void checkIfIncorrectlyFilledColumnReturnsFalse() throws WrongIndexException {
        Judge judge = new Judge(board, 4);

        board.insertSign(Coordinates.parseCoordinates("3 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("0 0"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("0 1"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("2 2"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("0 3"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("1 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("0 4"), Sign.X);

        boolean isWinner = judge.isWinner(Sign.X);
        assertFalse(isWinner);
    }

    public void checkIfCorrectlyFilledRowReturnsTrue() throws WrongIndexException {
        Judge judge = new Judge(board, 4);

        board.insertSign(Coordinates.parseCoordinates("1 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("0 4"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("3 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("1 0"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("2 0"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("3 0"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("4 0"), Sign.X);

        boolean isWinner = judge.isWinner(Sign.X);
        assertTrue(isWinner);
    }

    public void checkIfIncorrectlyFilledRowReturnsFalse() throws WrongIndexException {
        Judge judge = new Judge(board, 4);

        board.insertSign(Coordinates.parseCoordinates("1 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("0 4"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("3 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("1 0"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("2 1"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("3 0"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("4 0"), Sign.X);

        boolean isWinner = judge.isWinner(Sign.X);
        assertFalse(isWinner);
    }

    public void checkIDiagonal() throws WrongIndexException {
        Judge judge = new Judge(board, 3);

        board.insertSign(Coordinates.parseCoordinates("0 0"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("1 1"), Sign.X);

        board.insertSign(Coordinates.parseCoordinates("4 4"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("3 3"), Sign.O);
        board.insertSign(Coordinates.parseCoordinates("2 2"), Sign.X);

        boolean isWinner = judge.isWinner(Sign.X);
        assertFalse(isWinner);
    }

    public void checkIDiagonalInOtherWay() throws WrongIndexException {
        Judge judge = new Judge(board, 5);

        board.insertSign(Coordinates.parseCoordinates("4 4"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("3 3"), Sign.X);

        board.insertSign(Coordinates.parseCoordinates("2 2"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("1 1"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("0 0"), Sign.X);

        boolean isWinner = judge.isWinner(Sign.X);
        assertTrue(isWinner);
    }


    public void checkIDiagonalCorrectWay() throws WrongIndexException {
        Judge judge = new Judge(board, 5);

        board.insertSign(Coordinates.parseCoordinates("4 4"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("3 3"), Sign.X);

        board.insertSign(Coordinates.parseCoordinates("2 2"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("1 1"), Sign.X);
        board.insertSign(Coordinates.parseCoordinates("0 0"), Sign.X);

        boolean isWinner = judge.isWinnerInDiagonal1(0, 0, Sign.X).length() == 5;
        assertTrue(isWinner);
    }


}

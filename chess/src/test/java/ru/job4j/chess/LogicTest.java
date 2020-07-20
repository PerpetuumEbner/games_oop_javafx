package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LogicTest {

    @Test
    public void whenMoveCorrect() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertTrue(logic.move(Cell.C1, Cell.G5));
    }

    @Test
    public void whenMoveNotCorrect() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertFalse(logic.move(Cell.C1, Cell.G7));
    }
}
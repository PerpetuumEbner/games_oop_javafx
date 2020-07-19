package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = findBy(source);
        if (index != -1) {
            Cell[] steps = new Cell[0];
            try {
                steps = figures[index].way(source, dest);
            } catch (Exception e) {
                System.out.println("An error occurred while moving the shape.");
            }
            check(steps);
            rst = true;
        }
        return rst;
    }

    public void check(Cell[] steps) {
        for (Cell step : steps) {
            findBy(step);
            if (findBy(step) != -1) {
                System.out.println("A figure was found on the way.");
            }
        }
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != figures.length; index++) {
            if (figures[index] != null && figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(figures) +
                '}';
    }
}

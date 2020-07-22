package job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != table.length; index++) {
            Figure3T cell = table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)
                || fillBy(Figure3T::hasMarkX, 0, 2, 1, 0)
                || fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)
                || fillBy(Figure3T::hasMarkX, 2, 0, 0, 1)
                || fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || fillBy(Figure3T::hasMarkX, 2, 0, -1, 1);
    }

    public boolean isWinnerO() {
        return fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || fillBy(Figure3T::hasMarkO, 0, 2, 1, 0)
                || fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || fillBy(Figure3T::hasMarkO, 2, 0, 0, 1)
                || fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || fillBy(Figure3T::hasMarkO, 2, 0, -1, 1);
    }

    public boolean hasGap() {
        return fillBy(figure3T -> figure3T.hasMarkX() || figure3T.hasMarkO(), 0, 0, 1, 0)
                == new Figure3T().hasMarkX() || new Figure3T().hasMarkO()

                || fillBy(figure3T -> figure3T.hasMarkX() || figure3T.hasMarkO(), 0, 1, 1, 0)
                == new Figure3T().hasMarkX() || new Figure3T().hasMarkO()

                || fillBy(figure3T -> figure3T.hasMarkX() || figure3T.hasMarkO(), 0, 2, 1, 0)
                == new Figure3T().hasMarkX() || new Figure3T().hasMarkO();
    }
}
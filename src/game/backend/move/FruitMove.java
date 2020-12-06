package game.backend.move;

import game.backend.Figure;
import game.backend.FigureDetector;
import game.backend.Grid;
import game.backend.element.Candy;

public class FruitMove extends Move {

    private int i, j;
    private Figure f;

    private FigureDetector detector;
    private Grid grid;

    public FruitMove(Grid grid) {
        super(grid);
        this.grid = grid;
    }

    @Override
    public boolean internalValidation() {
        this.detector = new FigureDetector(grid);
        if (grid.get(i1, j1) instanceof Candy) {
            i = i1;
            j = j1;
        } else if (grid.get(i2, j2) instanceof Candy){
            i = i2;
            j = j2;
        } else
            return false;
        return (f = detector.checkFigure(i, j)) != null;
    }

    @Override
    public void removeElements() {
        // System.out.println(String.format("%d - %d", i, j));
        if (f != null)
            detector.removeFigure(i, j, f);
    }
}

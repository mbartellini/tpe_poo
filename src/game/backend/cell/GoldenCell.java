package game.backend.cell;

import game.backend.Grid;

public class GoldenCell extends Cell {

    private boolean golden;

    public GoldenCell(Grid grid) {
        super(grid);
    }

    @Override
    public boolean isGolden(){
        return golden;
    }

    public void turnGolden(){
        golden = true;
    }

}

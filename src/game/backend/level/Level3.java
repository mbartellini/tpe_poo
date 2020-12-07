package game.backend.level;

import game.backend.GameState;
import game.backend.cell.Cell;
import game.backend.cell.GoldenCell;

/** Clase que modela el nivel 3, que incorpra la funcionalidad numero uno: Golden Board.
 */

public class Level3 extends LevelGenerator {

    private final static int MAX_MOVES = 20;
    private int goldenCells;

    @Override
    protected GameState newState() {
        return new Level3State(MAX_MOVES);
    }

    @Override
    protected Cell cellSupplier() {
        return new GoldenCell(this);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean aux = super.tryMove(i1, j1, i2, j2);
        if(aux){
            if(i1 == i2){
                turnColGolden(i1);
            } else {
                turnRowGolden(j1);
            }
        }
        return aux;
    }

    private void turnColGolden(int i){
        int amount = 0;
        for(int j = 0; j < SIZE; j++){
            Cell c = getCell(i, j);
            if(!c.isGolden()) {
                c.turnGolden();
                amount++;
            }
        }
        paintGolden(amount);
    }

    private void turnRowGolden(int i){
        int amount = 0;
        for(int j = 0; j < SIZE; j++){
            Cell c = getCell(j, i);
            if(!c.isGolden()) {
                c.turnGolden();
                amount++;
            }
        }
        paintGolden(amount);
    }

    public void paintGolden(int amount){
        goldenCells += amount;
    }

    public int getGoldenCells(){
        return goldenCells;
    }

    private class Level3State extends GameState {

        public Level3State(int maxMoves) {
            super(maxMoves);
        }

        @Override
        public boolean playerWon() {
            return goldenCells == SIZE * SIZE;
        }

        @Override
        public String getStateString() {
            return String.format("Celdas restantes: %d - ", SIZE * SIZE - getGoldenCells()) + super.getStateString();
        }
    }
}

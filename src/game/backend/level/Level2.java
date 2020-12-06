package game.backend.level;

import game.backend.GameListener;
import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.CandyFruitGeneratorCell;
import game.backend.cell.CandyGeneratorCell;
import game.backend.element.Element;
import game.backend.element.Fruit;
import game.backend.element.Nothing;

/**
 * Clase que modela el segundo nivel, que incorpora la funcionalidad número cinco, frutas.
 * La grilla comienza en un estado común, similar al del nivel uno, y por cada movimiento válido se baja
 * una fruta cualquiera (cereza o avellana) en lugar de alguno de los caramelos que normalmente caería.
 */

public class Level2 extends LevelGenerator {

    private final static int REQUIRED_FRUITS = 3;
    private final static int MAX_MOVES = 20;
    private int consumedFruits;

    @Override
    public void initialize(){
        addListener(new GameListener() {
            @Override
            public void gridUpdated() {
                for (int j = 0; j < SIZE; j++){
                    Element e = get(SIZE - 1, j);
                    if (e.getKey().equals("FRUIT")) { /* Forma mas OO? */
                        consumeFruit();
                        setContent(SIZE - 1, j, new Nothing());
                        state().addScore(e.getScore());
                    }
                }
                fallElements();
            }

            @Override
            public void cellExplosion(Element e) {
                //
            }
        });
        super.initialize();
    }

    @Override
    protected GameState newState() {
        return new Level2State(MAX_MOVES);
    }

    @Override
    protected CandyGeneratorCell getGeneratorCell() {
        return new CandyFruitGeneratorCell(this);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        // Como se genera una fruta por movimiento, a partir de que ya se generaron la cantidad
        // de frutas requeridas, se deja de pedir frutas
        if(state().getMoves() < REQUIRED_FRUITS)
            CandyFruitGeneratorCell.askFruit();
        return super.tryMove(i1, j1, i2, j2);
    }

    public int getFruits(){
        return consumedFruits;
    }

    public void consumeFruit(){
        consumedFruits++;
    }

    private class Level2State extends GameState {

        public Level2State(int maxMoves) {
            super(maxMoves);
        }

        @Override
        public boolean playerWon() {
            return getFruits() >= REQUIRED_FRUITS;
        }
    }

}

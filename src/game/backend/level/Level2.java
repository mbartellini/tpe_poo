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

    private static int REQUIRED_FRUITS = 3;
    private static int FRUIT_LIMIT = 3;
    private static int MAX_MOVES = 20;

    @Override
    public void initialize(){
        addListener(new GameListener() {
            @Override
            public void gridUpdated() {
                for (int j = 0; j < SIZE; j++){
                    Element e = get(SIZE - 1, j);
                    if (e instanceof Fruit) { /* Forma mas OO? */
                        ((Level2State)state()).consumeFruit();
                        setContent(SIZE - 1, j, new Nothing());
                        state().addScore(e.getScore());
                        fallElements();
                    }
                }
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
        return new Level2State(REQUIRED_FRUITS, MAX_MOVES);
    }

    @Override
    protected CandyGeneratorCell getGeneratorCell() {
        return new CandyFruitGeneratorCell(this);
    }


    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        CandyFruitGeneratorCell.askFruit();
        return super.tryMove(i1, j1, i2, j2);
    }

    private static class Level2State extends GameState {
        private final int requiredFruits;
        private int consumedFruits;

        public Level2State(int requiredFruits, int maxMoves) {
            super(maxMoves);
            this.requiredFruits = requiredFruits;
        }

        public int getFruits(){
            return consumedFruits;
        }

        public void consumeFruit(){
            consumedFruits++;
        }

        public boolean playerWon() {
            return getFruits() >= requiredFruits;
        }
    }

}

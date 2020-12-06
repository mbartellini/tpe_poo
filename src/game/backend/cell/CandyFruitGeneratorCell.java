package game.backend.cell;

import game.backend.Grid;
import game.backend.element.*;

import java.util.Random;

public class CandyFruitGeneratorCell extends CandyGeneratorCell {

    private static boolean needFruit = false;

    public CandyFruitGeneratorCell(Grid grid) {
        super(grid);
    }

    public static void askFruit() {
        needFruit = true;
    }

    private Element getRandomFruit() {
        Random r = new Random();
        int i = r.nextInt(2);
        return (i%2 == 0) ? new Hazelnut() : new Cherry();
    }

    @Override
    public Element getContent() {
        if (needFruit) {
            needFruit = false;
            return getRandomFruit();
        }
        return super.getContent();
    }


}
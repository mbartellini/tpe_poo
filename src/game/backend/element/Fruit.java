package game.backend.element;

/**
 * Clase que modela las frutas (hazelnut and cherry) de la funcionalidad numero cinco.
 */

public class Fruit extends Element {

    private FruitType fruitType;

    public Fruit() {
    }

    public Fruit(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    public String getKey() {
        return "FRUIT";
    }

    @Override
    public boolean isExplodeable(){
        return false;
    }

    @Override
    public long getScore() {
        return 500;
    }

    @Override
    public String getFullKey() {
        return fruitType.toString();
    }
}

package game.backend.element;

/**
 * Clase que modela las frutas (hazelnut and cherry) de la funcionalidad numero cinco.
 */

public class Fruit extends Element {

    public Fruit() {
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    public String getKey() {
        return "FRUIT";
    }

}

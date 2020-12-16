package game.backend.element;

public enum FruitType {

    HAZELNUT("HAZELNUT"),
    CHERRY("CHERRY");

    private String name;

    FruitType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}

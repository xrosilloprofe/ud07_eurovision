package es.ieslavereda;

public enum Puntuacion {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), TEN(10), TWELVE(12);

    private int value;

    Puntuacion(int value){ this.value=value;}

    public int getValue() {
        return value;
    }
}

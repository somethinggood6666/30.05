package by.epam.shchemelev.entities;

import by.epam.shchemelev.enums.Color;

import java.io.Serializable;
import java.util.Objects;

public class Ball implements Serializable {
    private Color color;
    private float weight;

    public Color getColor() {
        return color;
    }

    public float getWeight() {
        return weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Ball(Color color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    public Ball() {
    }

    @Override
    public String toString() {
        return "Ball`s color: " + color + " , ball`s weight: " + weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Ball ball = (Ball) object;
        return Float.compare(ball.weight, weight) == 0 && Objects.equals(color, ball.color);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + getColor().hashCode();
        result = 37 * result + Float.floatToIntBits(getWeight());

        return result;
    }

}

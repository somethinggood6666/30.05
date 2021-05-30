package by.epam.shchemelev;

import java.awt.*;
import java.util.Objects;

public class Ball {
    private Color color;
    private float weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Float.compare(ball.weight, weight) == 0 && Objects.equals(color, ball.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, weight);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Ball(Color color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}

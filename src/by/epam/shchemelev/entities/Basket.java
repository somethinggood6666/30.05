package by.epam.shchemelev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket implements Serializable {
    private List<Ball> balls = new ArrayList<>();

    public Basket() {
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public Ball getBallByIndex(int index) {
        return balls.get(index);
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public void setBallByIndex(int index, Ball ball) {
        balls.set(index, ball);
    }

    @Override
    public String toString() {
        if (balls.isEmpty()){
            return "Basket is empty";
        }
        StringBuilder result = new StringBuilder("Balls in this basket:\n");
        for (int i = 0; i < balls.size(); i++) {
            result.append(i).append(": Color - ")
                    .append(balls.get(i).getColor())
                    .append(", Weight - ")
                    .append(balls.get(i).getWeight())
                    .append("\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Basket basket = (Basket) object;
        return Objects.equals(balls, basket.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}

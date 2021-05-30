package by.epam.shchemelev;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private List<Ball> balls = new ArrayList<>();

    public void addBall(Ball ball){
        balls.add(ball);
    }

    public void removeBall(Ball ball){
        balls.remove(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public int getBallsAmountByColor(Color color){
        int result = 0;
        for (Ball ball: balls){
            if (ball.getColor() == color){
                result++;
            }
        }
        return result;
    }

    public float getBallsWeight(){
        float weight = 0;
        for(Ball ball: balls){
            weight += ball.getWeight();
        }
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(balls, basket.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Balls in this basket:\n");
        for (int i = 0; i < balls.size(); i++) {
            result.append(i).append(": Color - ").append(balls.get(i).getColor()).append(", Weight - ").append(balls.get(i).getWeight()).append("\n");
        }
        return result.toString();
    }
}

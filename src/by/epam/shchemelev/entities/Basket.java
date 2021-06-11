package by.epam.shchemelev.entities;

import by.epam.shchemelev.service.BasketService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket implements Serializable {
    private List<Ball> balls = new ArrayList<>();
    private static final int BALLS_LIMIT = 30;
    private static final float WEIGHT_LIMIT = 20;

    public boolean addBall(Ball ball){
        if (ball == null){
            return false;
        }
        if (BasketService.calculateBallsWeight(this) + ball.getWeight() >= WEIGHT_LIMIT){
            return false;
        }
        if (this.getBalls().size() + 1 >= BALLS_LIMIT){
            return false;
        }
        return balls.add(ball);
    }

    public boolean removeBall(int index) {
        if (index >= balls.size()){
            return false;
        }
        balls.remove(index);
        return true;
    }

    public Basket() {
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
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
        int result = 17;
        for (Ball ball: balls){
            result = 37 * result + ball.hashCode();
        }

        return result;
    }
}

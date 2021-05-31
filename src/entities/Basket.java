package entities;

import by.epam.shchemelev.Color;
import by.epam.shchemelev.exceptions.OutOfWeightException;
import by.epam.shchemelev.exceptions.TooMuchBallsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private List<Ball> balls = new ArrayList<>();
    private final int BALLS_LIMIT = 30;
    private final float WEIGHT_LIMIT = 20f;

    public void addBall(Ball ball) throws OutOfWeightException, TooMuchBallsException {
        if (getBallsWeight() + ball.getWeight() > WEIGHT_LIMIT){
            throw new OutOfWeightException("The allowed weight of balls in the basket is exceeded");
        }
        if (balls.size() + 1 > BALLS_LIMIT){
            throw new TooMuchBallsException("The allowed amount of balls in the basket is exceeded");
        }
        balls.add(ball);
    }

    public void removeBall(int index){
        balls.remove(index);
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

    public int getBallsAmount(){
        return balls.size();
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
        if (balls.isEmpty()){
            return "Basket is empty";
        }
        StringBuilder result = new StringBuilder("Balls in this basket:\n");
        for (int i = 0; i < balls.size(); i++) {
            result.append(i).append(": Color - ").append(balls.get(i).getColor()).append(", Weight - ").append(balls.get(i).getWeight()).append("\n");
        }
        result.append("Total weight of the balls: ").append(getBallsWeight()).append("\n");
        result.append("Total balls amount: ").append(getBallsAmount()).append("\n");
        return result.toString();
    }
}

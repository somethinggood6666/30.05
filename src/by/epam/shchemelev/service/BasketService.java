package by.epam.shchemelev.service;

import by.epam.shchemelev.entities.Ball;
import by.epam.shchemelev.entities.Basket;
import by.epam.shchemelev.enums.Color;
import by.epam.shchemelev.exceptions.OutOfWeightException;
import by.epam.shchemelev.exceptions.TooMuchBallsException;

public class BasketService {
    private static final int BALLS_LIMIT = 30;
    private static final float WEIGHT_LIMIT = 20f;

    public static void addBall(Basket basket, Ball ball)
            throws OutOfWeightException, TooMuchBallsException {
        if (calculateBallsWeight(basket) + ball.getWeight() > WEIGHT_LIMIT){
            throw new OutOfWeightException("The allowed weight of balls in the basket is exceeded");
        }
        if (basket.getBalls().size() + 1 > BALLS_LIMIT){
            throw new TooMuchBallsException("The allowed amount of balls in the basket is exceeded");
        }
        basket.getBalls().add(ball);
    }

    public static void removeBall(Basket basket, int index){
        basket.getBalls().remove(index);
    }

    public static float calculateBallsWeight(Basket basket){
        float weight = 0;
        for(Ball ball: basket.getBalls()){
            weight += ball.getWeight();
        }
        return weight;
    }

    public static int calculateBallsAmount(Basket basket){
        return basket.getBalls().size();
    }

    public static int calculateBallsAmountByColor(Basket basket, Color color){
        int result = 0;
        for (Ball ball: basket.getBalls()){
            if (ball.getColor() == color){
                result++;
            }
        }
        return result;
    }

}

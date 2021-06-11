package by.epam.shchemelev.service;

import by.epam.shchemelev.entities.Ball;
import by.epam.shchemelev.entities.Basket;
import by.epam.shchemelev.enums.Color;
import by.epam.shchemelev.exceptions.BasketDoesntExistsException;

public class BasketService {

    public static float calculateBallsWeight(Basket basket){
        if (basket == null){
            try {
                throw new BasketDoesntExistsException("There is no basket to add at");
            } catch (BasketDoesntExistsException e) {
                e.printStackTrace();
            }
        }
        float weight = 0;
        for(Ball ball: basket.getBalls()){
            weight += ball.getWeight();
        }
        return weight;
    }

    public static int calculateBallsAmount(Basket basket)
            throws BasketDoesntExistsException {
        if (basket == null){
            throw new BasketDoesntExistsException("There is no basket to add at");
        }
        return basket.getBalls().size();
    }

    public static int calculateBallsAmountByColor(Basket basket, Color color)
            throws BasketDoesntExistsException {
        if (basket == null){
            throw new BasketDoesntExistsException("There is no basket to add at");
        }
        int result = 0;
        for (Ball ball: basket.getBalls()){
            if (ball.getColor() == color){
                result++;
            }
        }
        return result;
    }

}

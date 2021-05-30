package by.epam.shchemelev;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Ball ball1 = new Ball(Color.ORANGE, 164f);
        Ball ball2 = new Ball(Color.WHITE, 144.9f);
        Ball ball3 = new Ball(Color.BLUE, 164f);
        Ball ball4 = new Ball(Color.BLUE, 155.3f);
        Ball ball5 = new Ball(Color.BLACK, 110.4f);
        Ball ball6 = new Ball(Color.RED, 11f);

        Basket basket = new Basket();
        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        basket.addBall(ball4);
        basket.addBall(ball5);
        basket.addBall(ball6);

        int blueBallsCount = basket.getBallsAmountByColor(Color.BLUE);
        float ballsWeight = basket.getBallsWeight();
    }
}

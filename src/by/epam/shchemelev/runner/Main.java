package by.epam.shchemelev.runner;

import by.epam.shchemelev.enums.Color;
import by.epam.shchemelev.exceptions.*;
import by.epam.shchemelev.service.BasketService;
import by.epam.shchemelev.tools.InputTools;
import by.epam.shchemelev.entities.Ball;
import by.epam.shchemelev.entities.Basket;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static List<Basket> baskets = new ArrayList<>();

    public static void main(String[] args) {

        int choice = 0;
        while (choice != 7) {
            System.out.println("Choose the action:");
            System.out.println("To create the basket type 1");
            System.out.println("To add the ball type 2");
            System.out.println("To delete the ball type 3");
            System.out.println("To see basket`s content type 4");
            System.out.println("To know amount of the blue balls type 5");
            System.out.println("To know total weight of balls in the basket type 6");
            System.out.println("To exit type 7");
            choice = InputTools.inputIntegerNumberInRange(1, 7);

            switch (choice) {
                case 1 -> createNewBasket();
                case 2 -> addBallToBasket();
                case 3 -> removeBallFromBasket();
                case 4 -> showBaskets();
                case 5 -> getBlueBallsAmount();
                case 6 -> getBallsWeight();
            }
        }
    }

    private static void getBallsWeight() {
        requireNotEmptyBasket();
        int basketNumber = getBasketNumber();
        System.out.println("Total weight of balls in the " + basketNumber + " basket is:");
        try {
            System.out.println(BasketService.calculateBallsWeight(baskets.get(basketNumber)) + "\n");
        } catch (BasketDoesntExistsException e) {
            e.printStackTrace();
        }
    }

    private static void getBlueBallsAmount() {
        requireNotEmptyBasket();
        int basketNumber = getBasketNumber();
        System.out.println("The amount of blue balls in the " + basketNumber + " basket is:");
        try {
            System.out.println(BasketService.calculateBallsAmountByColor(baskets.get(basketNumber), Color.BLUE) + "\n");
        } catch (BasketDoesntExistsException e) {
            e.printStackTrace();
        }
    }

    private static void removeBallFromBasket() {
        requireNotEmptyBasket();
        int basketNumber = getBasketNumber();
        int ballsAmount = 0;
        try {
            ballsAmount = BasketService.calculateBallsAmount(baskets.get(basketNumber)) - 1;
        } catch (BasketDoesntExistsException e) {
            e.printStackTrace();
        }
        if (ballsAmount == -1){
            System.out.println("The basket is empty");
            return;
        }
        System.out.println("What ball would you like to delete?");
        int ballNumber = InputTools.inputIntegerNumberInRange(0, ballsAmount);
        try {
            BasketService.removeBall(baskets.get(basketNumber), ballNumber);
        } catch (BasketDoesntExistsException e) {
            e.printStackTrace();
        }
        System.out.println("The ball was successfully deleted! \n\n");
    }

    private static void requireNotEmptyBasket(){
        if (baskets.size() == 0){
            try {
                throw new NoSingleBasketException("There is not a single basket!");
            } catch (NoSingleBasketException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private static int getBasketNumber(){
        int basketNumber;
        if (baskets.size() != 1) {
            System.out.println("Choose the basket\n");
            showBaskets();
            basketNumber = InputTools.inputIntegerNumberInRange(0, baskets.size() - 1);
        } else {
            basketNumber = 0;
        }
        return basketNumber;
    }

    private static void createNewBasket() {
        baskets.add(new Basket());
        System.out.println("New basket created!\n\n");
    }


    private static void addBallToBasket() {
        requireNotEmptyBasket();
        int basketNumber = getBasketNumber();
        System.out.println("Choose the balls`s color");
        Color[] colors = Color.values();
        for (int j = 0; j < colors.length; j++) {
            System.out.println(j + ": " + colors[j]);
        }
        int colorIndex = InputTools.inputIntegerNumberInRange(0, colors.length - 1);

        System.out.println("Input the ball`s weight");
        float weight = InputTools.inputFloatNumber();

        Ball ball = new Ball(colors[colorIndex], weight);
        try {
            try {
                BasketService.addBall(baskets.get(basketNumber), ball);
            } catch (BallDoesntExistsException | BasketDoesntExistsException e) {
                e.printStackTrace();
            }
        } catch (OutOfWeightException | TooMuchBallsException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("The ball was successfully added!\n\n");
    }

    private static void showBaskets(){
        if (baskets.size() == 0){
            System.out.println("No baskets yet");
        } else {
            for (int i = 0; i < baskets.size(); i++) {
                System.out.println(i + " basket:");
                System.out.println(baskets.get(i) + "\n");
            }
        }
    }
}

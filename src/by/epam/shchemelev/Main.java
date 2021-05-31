package by.epam.shchemelev;

import by.epam.shchemelev.exceptions.NoSingleBasketException;
import by.epam.shchemelev.exceptions.OutOfWeightException;
import by.epam.shchemelev.exceptions.TooMuchBallsException;
import by.epam.shchemelev.tools.InputTools;
import entities.Ball;
import entities.Basket;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static List<Basket> baskets = new ArrayList<>();

    public static void main(String[] args) {

        int choice = 0;
        while (choice != 5) {
            System.out.println("Выберите действие:");
            System.out.println("Чтобы создать корзину - введите 1");
            System.out.println("Чтобы добавить мяч - введите 2");
            System.out.println("Чтобы убрать мяч - введите 3");
            System.out.println("Чтобы просмотреть содержимое корзин - введите 4");
            System.out.println("Чтобы завершить работу - введите 5");
            choice = InputTools.inputIntegerNumberInRange(1, 5);

            switch (choice) {
                case 1 -> createNewBasket();
                case 2 -> addBallToBasket();
                case 3 -> removeBallFromBasket();
                case 4 -> showBaskets();
            }
        }
    }

    private static void removeBallFromBasket() {
        System.out.println("Из какой корзины вы бы хотели убрать шар?");
        int basketNumber = getBasketNumber();
        System.out.println("Какой мяч вы бы хотели убрать?");
        int ballNumber = InputTools.inputIntegerNumberInRange(0, baskets.get(basketNumber).getBallsAmount() - 1);
        baskets.get(basketNumber).removeBall(ballNumber);
        System.out.println("Мяч был убран из корзины! \n\n");

    }

    private static void createNewBasket() {
        baskets.add(new Basket());
        System.out.println("Новая корзина создана!\n\n");
    }

    private static int getBasketNumber() {
        showBaskets();
        return InputTools.inputIntegerNumberInRange(0, baskets.size() - 1);
    }

    private static void addBallToBasket() {
        if (baskets == null){
            try {
                throw new NoSingleBasketException("Не существует корзин для добавления мяча");
            } catch (NoSingleBasketException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        int basketNumber;
        if (baskets.size() != 1) {
            System.out.println("В какую корзину добавить мяч?\n");
            basketNumber = getBasketNumber();
        } else {
            basketNumber = 0;
        }
        System.out.println("Выберите цвет мяча");
        Color[] colors = Color.values();
        for (int j = 0; j < colors.length; j++) {
            System.out.println(j + ": " + colors[j]);
        }
        int colorIndex = InputTools.inputIntegerNumberInRange(0, colors.length - 1);

        System.out.println("Введите вес мяча");
        float weight = InputTools.inputFloatNumber();

        Ball ball = new Ball(colors[colorIndex], weight);
        try {
            baskets.get(basketNumber).addBall(ball);
        } catch (OutOfWeightException | TooMuchBallsException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Мяч был успешно добавлен!\n\n");
    }

    private static void showBaskets(){
        for (int i = 0; i < baskets.size(); i++){
            System.out.println(i + " basket:");
            System.out.println(baskets.get(i) + "\n");
        }
    }
}

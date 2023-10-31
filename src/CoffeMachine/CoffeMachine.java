import java.util.Scanner;

public class CoffeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;

        while (true) {
            System.out.println("\nThe coffee machine has:");
            System.out.println(water + " of water");
            System.out.println(milk + " of milk");
            System.out.println(coffeeBeans + " of coffee beans");
            System.out.println(disposableCups + " of disposable cups");
            System.out.println(money + " of money");

            System.out.println("\nWrite action (buy, fill, take):");
            String action = scanner.next();

            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int choice = scanner.nextInt();
                makeCoffee(choice, water, milk, coffeeBeans, disposableCups, money);
            } else if (action.equals("fill")) {
                System.out.println("Write how many ml of water you want to add:");
                int addedWater = scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                int addedMilk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                int addedCoffeeBeans = scanner.nextInt();
                System.out.println("Write how many disposable coffee cups you want to add:");
                int addedCups = scanner.nextInt();
                fillMachine(addedWater, addedMilk, addedCoffeeBeans, addedCups, water, milk, coffeeBeans, disposableCups);
            } else if (action.equals("take")) {
                takeMoney(money);
            }
        }
    }

    public static void makeCoffee(int choice, int water, int milk, int coffeeBeans, int disposableCups, int money) {
        int cost = 0;
        String product = "";

        switch (choice) {
            case 1:  // Espresso
                cost = 4;
                if (water >= 250 && coffeeBeans >= 16 && disposableCups >= 1) {
                    product = "espresso";
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups--;
                    money += cost;
                }
                break;
            case 2:  // Latte
                cost = 7;
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && disposableCups >= 1) {
                    product = "latte";
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups--;
                    money += cost;
                }
                break;
            case 3:  // Cappuccino
                cost = 6;
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && disposableCups >= 1) {
                    product = "cappuccino";
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups--;
                    money += cost;
                }
                break;
            default:
                break;
        }

        if (!product.isEmpty()) {
            System.out.println("I have enough resources, making you a " + product);
        } else {
            System.out.println("Sorry, not enough resources to make your choice");
        }
    }

    public static void fillMachine(int addedWater, int addedMilk, int addedCoffeeBeans, int addedCups,
                                   int water, int milk, int coffeeBeans, int disposableCups) {
        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedCups;
    }

    public static void takeMoney(int money) {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}

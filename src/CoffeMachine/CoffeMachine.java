import java.util.Scanner;

public class CoffeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    buyCoffee(scanner, water, milk, coffeeBeans, disposableCups, money);
                    break;
                case "fill":
                    fillMachine(scanner, water, milk, coffeeBeans, disposableCups);
                    break;
                case "take":
                    takeMoney(money);
                    break;
                case "remaining":
                    displayResources(water, milk, coffeeBeans, disposableCups, money);
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    }

    public static void buyCoffee(Scanner scanner, int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        switch (choice) {
            case "1":  // Espresso
                makeCoffee(water, milk, coffeeBeans, disposableCups, money, 250, 0, 16, 4);
                break;
            case "2":  // Latte
                makeCoffee(water, milk, coffeeBeans, disposableCups, money, 350, 75, 20, 7);
                break;
            case "3":  // Cappuccino
                makeCoffee(water, milk, coffeeBeans, disposableCups, money, 200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void makeCoffee(int water, int ingredient1, int ingredient2, int cups, int money,
                                  int neededWater, int neededIngredient1, int neededIngredient2, int cost) {
        if (water < neededWater) {
            System.out.println("Sorry, not enough water!");
        } else if (ingredient1 < neededIngredient1) {
            System.out.println("Sorry, not enough " + getIngredientName(ingredient1) + "!");
        } else if (ingredient2 < neededIngredient2) {
            System.out.println("Sorry, not enough " + getIngredientName(ingredient2) + "!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= neededWater;
            ingredient1 -= neededIngredient1;
            ingredient2 -= neededIngredient2;
            cups--;
            money += cost;
        }
    }

    public static String getIngredientName(int ingredient) {
        if (ingredient == 540) {
            return "milk";
        } else if (ingredient == 120) {
            return "coffee beans";
        }
        return "water";
    }

    public static void fillMachine(Scanner scanner, int water, int milk, int coffeeBeans, int disposableCups) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        disposableCups += scanner.nextInt();
    }

    public static void takeMoney(int money) {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void displayResources(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}

import java.util.Scanner;

public class CoffeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvailable = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvailable = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansAvailable = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsDesired = scanner.nextInt();

        int cupsPossibleByWater = waterAvailable / 200;
        int cupsPossibleByMilk = milkAvailable / 50;
        int cupsPossibleByBeans = coffeeBeansAvailable / 15;

        int maxCupsPossible = Math.min(cupsPossibleByWater, Math.min(cupsPossibleByMilk, cupsPossibleByBeans));

        if (cupsDesired == 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCupsPossible - cupsDesired) + " more than that)");
        } else if (cupsDesired <= maxCupsPossible) {
            if (cupsDesired == maxCupsPossible) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + (maxCupsPossible - cupsDesired) + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + maxCupsPossible + " cups of coffee");
        }
    }
}

package CreditCalculator;
public class CreditCalculator {
    public static void main(String[] args) {
        // Create an instance of the CalculatorLogic class
        CalculatorLogic calculatorLogic = new CalculatorLogic();

        // Get input parameters from command-line arguments
        String type = System.getProperty("type");
        String principal = System.getProperty("principal");
        String periods = System.getProperty("periods");
        String interest = System.getProperty("interest");
        String payment = System.getProperty("payment");

        // Pass input parameters to the CalculatorLogic for further processing
        calculatorLogic.dataAnalyze(type, principal, periods, interest, payment);
    }
}
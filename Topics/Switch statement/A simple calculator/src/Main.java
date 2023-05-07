import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String userInput = scanner.nextLine();

        int indexOfSpace = userInput.indexOf(" ");
        String firstNumber = userInput.substring(0, indexOfSpace);
        String operation = userInput.substring(indexOfSpace+1, indexOfSpace+2);
        String secondNumber = userInput.substring(indexOfSpace+3, userInput.length());



        long actualNumber1 = Long.parseLong(firstNumber);
        long actualNumber2 = Long.parseLong(secondNumber);
        switch (operation)
        {
            case "+":
                System.out.println(actualNumber1+actualNumber2);
                break;
            case "-":
                System.out.println(actualNumber1-actualNumber2);
                break;
            case "*":
                System.out.println(actualNumber1*actualNumber2);
                break;
            case "/":
            {
                if (actualNumber2==0)
                {
                    System.out.println("Division by 0!");
                    System.exit(0);

                }
                System.out.println(actualNumber1 / actualNumber2);
                break;
            }
            default:
                System.out.println("Unknown operator");








        }

    }
}
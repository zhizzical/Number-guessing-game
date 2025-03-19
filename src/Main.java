import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNum = rand.nextInt(101); //the range is from 0-100

        int tries = 0; //counts the tries until you get it right
        //randomized messages to make it less boring!
        String[] highGuess = {"Too high! Are you trying to guess infinity?",
                "Whoops, too high! Did you mean to guess the moon?",
                "Nah, that's too much. Aim lower!"};

        String[] lowGuess = {"Nope, too small. Think BIGGER!",
                "You tryna dig to the Earth's core? Guess higher!",
                "That’s too low! Come on, reach for the stars!"};

        while (true) {
            System.out.println("Enter your guess (0-100) or (-1) to exit: ");

            if (scanner.hasNextInt()) { //has to be an integer
                int guess = scanner.nextInt();
                tries++; //counts the times you type in a number
                if (guess == -1){ //-1 to exit the program
                    System.out.println("Quitting already? Goodbye!");
                    System.exit(0);
                }
                if (guess> 0 && guess < 100) { //making sure the guess is between 0-100

                    if (guess == randomNum) {
                        System.out.println("BOOM! You got it! Are you a mind reader or what?");
                        System.out.println("You got the answer by " + tries + " tries.");
                        break;
                    } else if (guess < randomNum) {
                        System.out.println(lowGuess[rand.nextInt(lowGuess.length)]);
                    } else {
                        System.out.println(highGuess[rand.nextInt(highGuess.length)]);
                    }

                } else {
                    System.out.println("out of bounds! Try again.");
                }
            } else {
                System.out.println("Please enter a number between 0 and 100.");
                scanner.next(); //to prevent the program from crashing
            }

        }
    }
}
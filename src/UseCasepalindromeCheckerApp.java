import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {

    static class PalindromeChecker {

        private String input;

        public PalindromeChecker(String input) {
            this.input = input;
        }

        public boolean checkPalindrome() {
            String normalized = input.replaceAll("\\s+", "").toLowerCase();

            int start = 0;
            int end = normalized.length() - 1;

            while (start < end) {
                if (normalized.charAt(start) != normalized.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String userInput = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker(userInput);

        if (checker.checkPalindrome()) {
            System.out.println("The given string is a Palindrome (OOP approach)");
        } else {
            System.out.println("The given string is NOT a Palindrome (OOP approach)");
        }

        sc.close();
    }
}
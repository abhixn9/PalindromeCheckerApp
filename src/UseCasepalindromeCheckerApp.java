import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    public static boolean hardcodedCheck(String str) {
        return str.equals(new StringBuilder(str).toString());
    }

    public static boolean reverseLoopCheck(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }

    public static boolean twoPointerCheck(String str) {
        char[] arr = str.toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }

    public static boolean dequeCheck(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to test performance:");
        String input = sc.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        hardcodedCheck(input);
        endTime = System.nanoTime();
        System.out.println("Hardcoded check time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        reverseLoopCheck(input);
        endTime = System.nanoTime();
        System.out.println("Reverse loop check time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        twoPointerCheck(input);
        endTime = System.nanoTime();
        System.out.println("Two-pointer char array check time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        stackCheck(input);
        endTime = System.nanoTime();
        System.out.println("Stack-based check time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        dequeCheck(input);
        endTime = System.nanoTime();
        System.out.println("Deque-based check time: " + (endTime - startTime) + " ns");

        sc.close();
    }
}
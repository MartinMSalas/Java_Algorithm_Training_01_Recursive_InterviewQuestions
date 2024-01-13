import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        //System.out.println((sumOfDigits(666)));
        //System.out.println(sumOfDigitsRecursive(-666));
        //System.out.println(powerOfaNumberRecursive(3, 6));
        //System.out.println(powerOfaNumber(3, 6));
//        System.out.println(calculatePrimeNumbers(100));
//        System.out.println(calculateGCD(129992, 159992));
//        System.out.println(calculateGCDRecursive(129992, 159992));
//        System.out.println(calculateGCDRecursiveEuclideanStart(129992, 159992));
//        System.out.println(calculateBinaryFromInt(3010));
//        System.out.println(calculateBinaryFromIntRecursiveStart(3010));
//        System.out.println(reverseString("Hello World!"));
//        System.out.println(reverseStringRecursive("Hello World!"));
//        System.out.println(palindrome("aasaas"));
//        System.out.println(palindromeRecursiveStart("aaaa"));
        //System.out.println(firstLetterUppercase("martin miguel salas"));
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,5,6,7,2,4,7,8));

        //System.out.println(sumAndProductOfArray(numberList));
        //System.out.println(pairs(numberList));
        System.out.println(reverseArray(numberList));
    }
    private static ArrayList<Integer> reverseArray(ArrayList<Integer> listOfNumbers){
        ArrayList<Integer> reversedArray = new ArrayList<>();
        for (int i=listOfNumbers.size()-1; i>=0;i--){
            reversedArray.add(listOfNumbers.get(i));
        }
        return reversedArray;
    }
    private static ArrayList<Integer> pairs(ArrayList<Integer> listOfNumbers){
        // BigO complexity O(n^2)
        ArrayList<Integer> pairsList = new ArrayList<>();
        for(Integer number: listOfNumbers){
            for (Integer otherNumber: listOfNumbers){
                pairsList.add(number*10+otherNumber);
            }
        }
        return pairsList;
    }
    private static int sumAndProductOfArray(ArrayList<Integer> arrayList){
        int resultSum=0;
        int resultProduct =1;
        for (Integer integer : arrayList) {
            resultSum += integer;
            resultProduct *= integer;
        }
        return resultSum;
    }
    private static String firstLetterUppercase(String str){
        String[] strSplit = str.split(" ");
        String result = "";
        for (String string : strSplit){
            result = result + " " + Character.toUpperCase(string.charAt(0)) +string.substring(1);
        }
        return result.trim();
    }
    private static boolean palindromeRecursiveStart(String str){
        String reversed = reverseStringRecursive(str);
        return reversed.equals(str);

    }
    private static boolean palindrome(String str){
        boolean result = true;
        int maxIterations = str.length()/2-1;

        for (int i = 0; i<maxIterations;i++){
            if(str.charAt(i)!=str.charAt(maxIterations-i)){
                result = false;
            };
        }
        return result;
    }
    private static String reverseString(String str) {
        String reversed = "";

        for (int i= str.length(); i >= 1; i--){
            reversed = reversed + str.charAt(i-1);
        }

        return reversed;
    }

    private static String reverseStringRecursive(String str){
        if(str.length() == 1) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    private static ArrayList<Integer> calculateBinaryFromIntRecursiveStart(int n){
        ArrayList<Integer> binary = new ArrayList<>();
        if(n<2){
            if(n<0)
                binary.add(-1);
            else
                binary.add(n);
            return binary;
        }
        return calculateBinaryFromIntRecursive(binary,n);

    }
    private static ArrayList<Integer> calculateBinaryFromIntRecursive(ArrayList<Integer> array,int n){

        if(n > 1){
            array.add(n%2);
            return calculateBinaryFromIntRecursive(array, n/2);
        }
        array.add(n);
        return array;
    }

    private static ArrayList<Integer> calculateBinaryFromInt(int n){
        ArrayList<Integer> binary = new ArrayList<>();
        while(n/2 > 0){
            binary.add(n%2);
            n /= 2;
        }
        binary.add(n);
        return binary;
    }
    private static int calculateGCDRecursive(int a, int b){
        if(a == 0) return b;
        if(b == 0) return a;
        if(a == b) return a;

        if(a > b) return calculateGCDRecursive(a-b, b);
        return calculateGCDRecursive(a, b-a);
    }
    private static int calculateGCDRecursiveEuclideanStart(int a, int b){
        if (a<0 || b<0) return -1;
        if (a < b)
            return calculateGCDRecursiveEuclidean(b, a);
        return calculateGCDRecursiveEuclidean(a, b);
    }
    private static int calculateGCDRecursiveEuclidean(int a, int b){
        return b == 0 ? a : calculateGCDRecursiveEuclidean(b, a%b);
    }
    private static int calculateGCD(int a, int b){
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if(a%i == 0 && b%i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    public static ArrayList<Integer> calculatePrimeNumbers(int n){
        ArrayList<Integer> primeNumbers = new ArrayList<>(Arrays.asList(2, 3, 5));
        if (n <= 5) {
            return primeNumbers;
        }
        for (int i = 6; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primeNumbers.add(i);
        }
        return primeNumbers;
    }
    public static int sumOfDigits(int n){
        int sum = 0;
        while(n/10 > 0){
            sum += n%10;
            n /= 10;
        }
        sum += n;
        return sum;
    }
    public static int sumOfDigitsRecursive(int n){  
        if(n/10 == 0) return n;
        return n%10 + sumOfDigitsRecursive(n/10);
    }
    public static int powerOfaNumberRecursive(int base, int power){
        if(power == 0) return 1;
        return base * powerOfaNumberRecursive(base, power-1);
    }
    public static int powerOfaNumber(int base, int power){
        int result = 1;

        for (int i = 0; i < power; i++) {
            result *= base;
        }
        return result;
    }


}
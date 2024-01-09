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
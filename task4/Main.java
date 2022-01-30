import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];
        List<Integer> nums = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                int number = Integer.parseInt(sc.nextLine());
                nums.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };

        int sum = nums.stream().reduce(0,(a,b)->  a + b);
        int average = sum / nums.size();
        int finalNumber;
        if (sum % nums.size() == 0)
            finalNumber = average;
        else {
            int numbersLessAverage = (int) nums.stream().filter(x -> x <= average).count();
            int numbersMoreAverage = (int) nums.stream().filter(x -> x > average).count();
            if (numbersLessAverage > numbersMoreAverage)
                finalNumber = average;
            else finalNumber = average + 1;
        }
        int res = 0;
        for (int el:nums) {
            res += Math.abs(el - finalNumber);
        }
        System.out.println(res);
    }
}

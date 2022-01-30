import java.io.*;
import java.util.Scanner;

public class Main {

    public static int pointPositionRelativeToCircle (float xc, float yc, float radius, float x, float y)
    {
        if ((x - xc)*(x - xc) + (y - yc)*(y - yc) == radius*radius)
            return 0;
        else if ((x - xc)*(x - xc) + (y - yc)*(y - yc) < radius*radius)
            return 1;
        else return 2;
    }

    public static void main(String[] args) {
        String firstFileName = args[0];
        String secondFileName = args[1];
        float xc = 0, yc = 0, radius = 0;
        try {
            Scanner sc = new Scanner(new File(firstFileName));
            String[] center = sc.nextLine().split(" ");
            xc = Float.parseFloat(center[0]);
            yc = Float.parseFloat(center[1]);
            radius = Float.parseFloat(sc.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };

        try {
            Scanner sc = new Scanner(new File(secondFileName));
            while (sc.hasNextLine()) {
                String[] point = sc.nextLine().split(" ");
                float x = Float.parseFloat(point[0]);
                float y = Float.parseFloat(point[1]);
                int res = pointPositionRelativeToCircle(xc, yc, radius, x, y);
                System.out.println(res);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
    }
}

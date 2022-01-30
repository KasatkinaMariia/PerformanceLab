public class Main {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        StringBuilder res = new StringBuilder();
        int k = 1;
        do {
            res.append(k);
            k = (k + (m - 1)) % n;
            if (k == 0)
                k = n;
        } while (k != 1);
        System.out.println(res);
    }
}

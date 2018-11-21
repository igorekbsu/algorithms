package robin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LastPrice {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("/home/igor/src/algorithms/hr/src/robin/last_price"));
        while (in.hasNext()) {
            in.nextLine();in.nextLine();
            System.out.println(in.nextLine().replace("$", ""));
        }
    }
}

package robin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new FileInputStream("/home/igor/src/algorithms/hr/src/robin/file"));
        var positions = new HashMap<>();
        float sum = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            char sign = line.charAt(0);
            if (sign == '+' || sign == '-') {
                String dollars = line.strip().replace(",", "").replace("$", "");
                sum += Double.parseDouble(dollars);
            }
        }
        // 69980.37
        System.out.println(sum);
        // siri 76.2
        // apple dividend 30.66
        // ohi dividend 2.64
        // fit 235.5 236.5 70.05 9.36 4.62 4459.9 439.98  - 5.15 - 7362.85
        // fit profit 1912.09
    }
}

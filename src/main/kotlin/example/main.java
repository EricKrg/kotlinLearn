package example;

import java.io.*;
import java.math.BigDecimal;
import java.util.Random;
import java.util.function.Function;

public class main {
    public static void main(String[] args) {
        System.out.println("hello schmello");
        String name = "Eric";
        String surname = "Kr";

        System.out.println(String.format("Hello %s  %s", name,surname));

        System.out.println(String.format("Hello %s your last name is %s chars long",
                                            name,surname.length()));
        // CASTING
        Object result;
        Integer random = new Random().nextInt(5);
        // set result
        if (random.equals(1)) {
            result = new BigDecimal(10);
        } else  {
            result = "not one!";
        }
        // cast and do something
        if (result instanceof BigDecimal) {
            result = ((BigDecimal) result).add( new BigDecimal(10));
        } else {
            result = ((String) result).toUpperCase();
        }
        System.out.println(result);
        addNum(1.0);
        aCoolLambda("1", Integer::parseInt);

        test();
    }

    // overloaded
    public static Double addNum(Double one) {
        return one + 3.9;
    }

    public static Double addNum(Double one, Double two) {
        return one + two;
    }

    // lambda
    public static void aCoolLambda(String input, Function<String, Integer> action) {
        System.out.println(action.apply(input));
    }

    // ternary
    String name = "Eric";
    String con = "Eric".equals(name) ? "y" : "n";
    //  try catch file open
    public void openAFile() { // could also throw these ex.
        // file open
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);
        } catch( FileNotFoundException eFile) {
            System.out.println("File not found");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException | NullPointerException eIO) {
                System.out.println("Could not close");
            }
        }
    }

    public static void test() {
        Double myDouble = 123.456;
        System.out.println(myDouble.toString().split("\\.")[1].length());
        String doubleNum = "123.0455";
        int splitted = doubleNum.split("\\.")[1].length();
        System.out.println(splitted);
    }

}

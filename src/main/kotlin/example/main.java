package example;

import com.sun.beans.editors.DoubleEditor;

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
    }

    // overloaded
    public static Double addNum(Double one) {
        return one + 3.9;
    }

    public static Double addNum(Double one, Double two) {
        return one + two;
    }

    public static void stringAction(String input) {
        System.out.println(input.toUpperCase());
    }
    // lambda
    public static void aCoolLambda(String input, Function<String, Integer> action) {
        System.out.println(action.apply(input));
    }


}

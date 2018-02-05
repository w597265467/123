package test;

import org.apache.poi.ss.formula.functions.T;

import java.util.function.Consumer;
import java.util.function.Function;

public class TestColon {

    public static void main(String[] arg) {
        Function<Number, String> getString = String::valueOf;
        String apply = getString.apply(12344.2231);
        System.out.println(apply);
        Consumer<T> toString = Object::toString;
    }


}

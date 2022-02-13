package lambdastudy;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.crypto.ExemptionMechanismException;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {
    @FunctionalInterface
    interface MyFunction {
        public abstract int max(int a, int b);
    }

    @FunctionalInterface
    interface MyFunction2 {
        public abstract void myMethod();
    }

    static void testMethod(MyFunction2 f) {
        f.myMethod();
    }

    static class MyClass {

    }

    static class MyClass2 {
        int a;

        public MyClass2(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Function<Integer, int[]> f10 = x -> new int[x];
        Function<Integer, int[]> f11 = int[]::new;

        Function<Integer, MyClass2> f8 = (i) -> new MyClass2(i);
        Function<Integer, MyClass2> f9 = MyClass2::new;

        Supplier<MyClass> s1 = () -> new MyClass();
        Supplier<MyClass> s2 = MyClass::new;

        MyClass obj = new MyClass();
        Function<String, Boolean> f6 =  (x) -> obj.equals(x);
        Function<String, Boolean> f7 = obj::equals;

        Function<String, Integer> ff = s -> Integer.parseInt(s);
        Function<String, Integer> fff = Integer::parseInt;

        BiFunction<String, String, Boolean> f4 = (ss1, ss2) -> ss1.equals(ss2);
        BiFunction<String, String, Boolean> f5 = String::equals;

        Predicate<String> isEmptyStr = (s) -> s.length() == 0;
        String s = "";

        if(isEmptyStr.test(s))
            System.out.println("this is an empty String.");


        MyFunction2 f2 = (MyFunction2)(()->{}); // 형변환 생략가능
//        Object obj = (Object)(()->{}); // 에러. 함수형 인터페이스로만 형변환 가능.

        MyFunction2 func = () -> System.out.println("Myfunction2");

        testMethod(func);
        testMethod(() -> System.out.println("lambda method"));

        MyFunction f = (a, b) -> a > b ? a : b;

        System.out.println("f(10,11) = " + f.max(10,11));

        int[] arr = new int[5];
        Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1);

        Arrays.stream(arr)
                .forEach(System.out::println);
    }
}

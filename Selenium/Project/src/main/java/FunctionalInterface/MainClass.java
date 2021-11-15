package FunctionalInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

        /*Addition ad = new Addition();
        System.out.println(ad.add());*/

       /* DemoFuncInterface demo = new DemoFuncInterface() {
            @Override
            public int add() {
                return 4+7;
            }
        };

        System.out.println(demo.add());*/

        DemoFuncInterface demo = ()-> {
            return 4 + 7;
        };
        System.out.println(demo.add());

        List<Integer> listt = new ArrayList<>();
        listt.add(4);
        listt.add(5);
        listt.add(6);
        listt.add(7);
        listt.add(8);

        List<Integer> resultOdd = listt.stream().filter(i -> i%2!=0).collect(Collectors.toList());
        System.out.println(resultOdd);
        System.out.println(listt.stream().max(Comparator.naturalOrder()).get());
        List<Integer> result = listt.stream().filter(i-> i%2==0).collect(Collectors.toList());
        System.out.println(result);
        List<Integer> result1 = listt.stream().map(i->i*2).collect(Collectors.toList());
        System.out.println(result1);

        List<Float> result2 = listt.stream().map(Integer::floatValue).collect(Collectors.toList());
        System.out.println(result2);


    }
}

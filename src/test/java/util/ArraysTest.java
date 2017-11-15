package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: onaple
 * Date: 2017/11/15
 * Time: 09:43
 */
public class ArraysTest {
    @Test
    public void test0(){
        List<String> strings = Arrays.asList("we", "are", "friend");
        System.out.println(strings);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers);

        int index = Arrays.binarySearch(integers.toArray(), 3);
        System.out.println(index);

        index = Arrays.binarySearch(new int[] {1, 3, 4, 9}, 5);
        System.out.println("***"+index);

        String[] names = {"wangxu", "onaple", "wx", "u"};
        String[] copy = Arrays.copyOf(names, 2);
        System.out.println(copy.length);
        System.out.println(Arrays.toString(copy));

        Arrays.sort(names);
        System.out.println(Arrays.toString(names));


        int[] array1 = new int[8];
        Arrays.fill(array1, 1);
        System.out.println(Arrays.toString(array1));

        int [][] stuGrandes1 = {
                {10,12,21},
                {12,342,12}
        };


        int [][] stuGrandes2 = {
                {10,12,21},
                {12,342,12}
        };

        System.out.println(Arrays.deepEquals(stuGrandes1, stuGrandes2));
        System.out.println(Arrays.equals(stuGrandes1, stuGrandes2));
        System.out.println(Arrays.toString(stuGrandes1));
        System.out.println(Arrays.deepToString(stuGrandes1));

        System.out.println(1 << 13);





    }
}

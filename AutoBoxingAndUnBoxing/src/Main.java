import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // AutoBoxing is the process of creating reference value types (objects, aka instancess of classes)
        // from primtiive data types, such as int, double etc
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            li.add(i);
        // Although you add the int values as primitive types, rather than Integer objects, to li, the code compiles.
        // Because li is a list of Integer objects, not a list of int values, you may wonder why the Java compiler does not issue a compile-time error.
        // The compiler does not generate an error because it creates an Integer object from i and adds the object to li.
        // Thus, the compiler converts the previous code to the following at runtime


        //Unboxing is the opposite, consider
        Integer i = new Integer(5);
        int f = absoluteValue(i);

        // There also is a caching attached to this process of autoboxing for example, consider:

        Integer int1 = 7;

        Integer int2 = 7;

        // this will be true, because by default JVM caches the range of: -128 to 127, which can be changed by setting the JVM argument:
        // -XX: AutoBoxCacheMax=size
        if (int1 == int2) {
            System.out.println("int1 and int2 are the same");
        }
        // you can see that even known int1 is allocted via new, there's a cache that holds all ints, up to 127 in the same memory area
        // but compare this

        // autoboxing, an object is created, because the type is Integer
        Integer int3 = 128;

        Integer int4 = 128;

        // here two reference-value tpyes, aka objects, are compared, so since it's not the same memory location
        // this is not true
        if (int3 == int4) {
            System.out.println("int3 and int4 are the same");
        }

        // But also note

        Integer int5 = new Integer(12345);

        int int6 = 12345;

        // results in un-boxing and a regular int comparison is done
        // so here two primitve types are compared, which is why it's tru
        if (int5 == int6) {
            System.out.println("int5 and int6 are the same");
        }

        // further reading:
        // https://dzone.com/articles/java-integer-cache-why-integervalueof127-integerva
    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }
}

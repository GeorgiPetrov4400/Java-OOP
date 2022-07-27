import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Method[] allMethods = clazz.getDeclaredMethods();

        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return class %s%n",
                        method.getName(), method.getReturnType().getName()));


        Arrays.stream(allMethods).
                filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
                        method.getName(), method.getParameterTypes()[0].getName()));

    }
}

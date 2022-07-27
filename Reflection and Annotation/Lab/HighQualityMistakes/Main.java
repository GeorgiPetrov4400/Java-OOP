import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n", method.getName()));

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n", method.getName()));

//        Method[] allMethods = clazz.getDeclaredMethods();
//
//        Arrays.stream(allMethods)
//                .filter(method -> method.getName().startsWith("get"))
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(method -> System.out.printf("%s will return class %s%n",
//                        method.getName(), method.getReturnType().getName()));
//
//
//        Arrays.stream(allMethods).
//                filter(method -> method.getName().startsWith("set"))
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
//                        method.getName(), method.getParameterTypes()[0].getName()));

    }
}

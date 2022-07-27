
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = Reflection.class;

        System.out.println(clazz.toString());
        System.out.println(clazz.getSuperclass().toString());

        Class[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Constructor constructor = clazz.getDeclaredConstructor();

        Reflection reflection = (Reflection) constructor.newInstance();
        System.out.println(reflection);
    }
}

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class InspectLinkedList {
    public static void main(String[] args) {
        inspectClass(LinkedList.class);
    }

    private static void inspectClass(Class<?> clazz) {
        // Вывод информации о полях класса
        System.out.println("Поля класса:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("  " + field);
        }

        // Вывод информации о родительском классе
        System.out.println("\nРодительский класс:");
        System.out.println("  " + clazz.getSuperclass());

        // Вывод информации о методах класса
        System.out.println("\nМетоды класса:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("  " + method);
        }

        // Вывод информации о конструкторах класса
        System.out.println("\nКонструкторы класса:");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("  " + constructor);
        }

        // Вывод информации о внутренних классах
        System.out.println("\nВнутренние классы:");
        Class<?>[] innerClasses = clazz.getDeclaredClasses();
        for (Class<?> innerClass : innerClasses) {
            System.out.println("  " + innerClass);
        }
    }
}

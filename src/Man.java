import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Man {
    private String name;
    private int age;
    private String occupation;

    public Man(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void introduce() {
        System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет, и я " + occupation + ".");
    }

    public void work() {
        System.out.println("Я усердно работаю и много получаю!");
    }

    private void relax() {
        System.out.println("Я отдыхаю каждый день дома ");
    }

    public static void main(String[] args) {
        Man man = new Man("Джон", 30, "Инженер");
        printClassInfo(man);
        invokeAllMethods(man);
    }

    private static void printClassInfo(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("Имя класса: " + clazz.getSimpleName());

        System.out.println("Поля:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("  " + field.getName() + " (" + field.getType().getSimpleName() + ")");
        }

        System.out.println("Методы:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("  " + method.getName());
        }
    }

    private static void invokeAllMethods(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            try {
                if (method.getParameterCount() == 0) {
                    method.setAccessible(true);
                    method.invoke(obj);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

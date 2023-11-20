import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    public void eat() {
        System.out.println("Кот ест");
    }

    public void sleep(int hours) {
        System.out.println("Кот спит " + hours + " часов");
    }
}

public class CatReflection {

    public static Cat catCreator() {
        try {
            Class<?> catClass = Class.forName("Cat");
            return (Cat) catClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void catLife() {
        Cat cat = catCreator();
        if (cat != null) {
            Method eatMethod;
            Method sleepMethod;

            try {
                eatMethod = cat.getClass().getMethod("eat");
                sleepMethod = cat.getClass().getMethod("sleep", int.class);

                eatMethod.invoke(cat);
                sleepMethod.invoke(cat, 8);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        catLife();
    }
}

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AcademyInfo {
    int year() default 0;
}

public class MyAnnotation {
    @AcademyInfo(year = 2023)
    public void methodWithAnnotation() {

    }

    public void methodWithoutAnnotation() {

    }

    public static void main(String[] args) {
        MyAnnotation example = new MyAnnotation();
        inspectMethods(example.getClass());
    }

    private static void inspectMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            AcademyInfo annotation = method.getAnnotation(AcademyInfo.class);

            if (annotation != null) {
                System.out.println("Метод " + method.getName() + " имеет аннотацию AcademyInfo с годом: " + annotation.year());
            } else {
                System.out.println("Метод " + method.getName() + " не имеет аннотации AcademyInfo.");
            }
        }
    }
}

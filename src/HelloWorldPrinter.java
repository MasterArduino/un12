import java.lang.reflect.Method;

public class HelloWorldPrinter {
    private void printHelloWorld() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        try {

            HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();


            Class<?> clazz = helloWorldPrinter.getClass();


            Method method = clazz.getDeclaredMethod("printHelloWorld");


            method.setAccessible(true);


            method.invoke(helloWorldPrinter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

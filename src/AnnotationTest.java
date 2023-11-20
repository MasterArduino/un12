class AnnotationTest {
    @Deprecated
    public String old() {
        return "Привет Guru";
    }
}
 class CallOld {
    @SuppressWarnings("deprecation")
    public void call() {
        AnnotationTest test = new AnnotationTest();
        System.out.println(test.old());
    }

    public static void main(String[] args) {
        CallOld caller = new CallOld();
        caller.call();
    }
}

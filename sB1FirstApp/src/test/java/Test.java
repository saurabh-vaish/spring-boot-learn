/**
 * @author Saurabh Vaish
 * @Date 22-11-2021
 */


@FunctionalInterface
interface A{
    abstract void print();
}


public class Test {

    public static void main(String[] args) {
        A hello = () -> System.out.println("Hello");

        hello.print();
    }
}

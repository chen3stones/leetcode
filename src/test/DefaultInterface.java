package test;

public interface DefaultInterface {
    default void eat(){
        System.out.println("eat");
    }
    void sleep();
}

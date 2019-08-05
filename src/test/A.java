package test;

public class A {
    static {
        System.out.println("A");
    }
    static {
        System.out.println("AA");
    }
    public A(){
        System.out.println("a");
    }
    protected void protect(){
        System.out.println("A protect");
    }
    protected int a = 1;
}

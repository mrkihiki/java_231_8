package org.example;

public class Annot {
    @MyAnnotation(numberOfCalls =2)
    public void publicMethod1(String mes){
        System.out.println("publicMethod1 "+mes);
    }
    public int publicMethod2(int a,int b){
        return a+b;
    }
    protected void protectedMethod1(String mes){
        System.out.println("protectedMethod1 "+mes);
    }
    @MyAnnotation(numberOfCalls =1)
    protected int protectedMethod2(int a,int b){
        return a-b;
    }
    private void privateMethod1(String mes){
        System.out.println("privateMethod1 "+mes);
    }
    @MyAnnotation(numberOfCalls =3)
    private int privateMethod2(int a,int b){
        return a*b;
    }

}

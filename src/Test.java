/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiwanka
 */
public class Test {

    
    public static void main(String[] args) {
       
        A a1 = new A1();
        A a2 = new A2();
        A a3 = new A3();
       
        a1.setNext(a2);
        a2.setNext(a3);
        
        X x = new X(3);
        a1.process(x);
    }
    
}

class X{
    int i;
    
    public X(int i){
        this.i = i;
    }
}

//We use HAS-A relationship to develop chain
abstract class A {
   protected A a;
    
    public void setNext(A a){
        this.a = a;
    }
    
    public abstract void process(X x);         
}

class A1 extends A{

    @Override
    public void process(X x) {
        
        System.out.println("Processing");
        if(x.i>5){
            this.a.process(x);
        }else{
            System.out.println("Error1");
        
    }
    
}
}
class A2 extends A{

    @Override
    public void process(X x) {
        
        System.out.println("Processing");
        if(x.i%2==0){
            this.a.process(x);
        }else{
            System.out.println("Error2");
        
    }
    
}
}
class A3 extends A{

    @Override
    public void process(X x) {
        
        System.out.println("Processing");
        if(x.i<20){
            System.out.println("Success");//End the chain
        }else{
            System.out.println("Error3");
        
    }
    
}
}



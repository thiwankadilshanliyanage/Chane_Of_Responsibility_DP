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
       
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        A a4 = new A();
        
        a1.setA(a2);
        a2.setA(a3);
        a3.setA(a4);
        
    }
    
}

class X{
    int i = 10;
}

//We use HAS-A relationship to develop chain
abstract class A {
   protected A a;
    
    public void setA(A a){
        this.a = a;
    }
    
    public abstract void process(X x);         
}

class A1 extends A{

    @Override
    public void process(X x) {
        {
        System.out.println("Processing");
        if(x.i>5){
            this.a.process(x);
        }else{
            System.out.println("Error");
        }
    }
    
}
}
class A2 extends A{

    @Override
    public void process(X x) {
        {
        System.out.println("Processing");
        if(x.i%2==0){
            this.a.process(x);
        }else{
            System.out.println("Error");
        }
    }
    
}
}
class A3 extends A{

    @Override
    public void process(X x) {
        {
        System.out.println("Processing");
        if(x.i<20){
            this.a.process(x);
        }else{
            System.out.println("Error");
        }
    }
    
}
}



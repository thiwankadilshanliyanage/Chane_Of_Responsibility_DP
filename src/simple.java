public class simple {
    public static void main(String[] args) {
       
        ConcreateHandler1  handler1 = new ConcreateHandler1();
        ConcreateHandler2  handler2 = new ConcreateHandler2();
        ConcreateHandler3  handler3 = new ConcreateHandler3();
        
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        
        Client client = new Client(7);
        handler1.process(client);
        
    }
    
}

class Client{
    int i;
    
    public Client(int i){
        this.i = i;
    }
}

//We use HAS-A relationship to develop chain
abstract class Handler {
   protected Handler handler;
    
    public void setNext(Handler handler){
        this.handler = handler;
    }
    
    public abstract void process(Client client);         
}

class ConcreateHandler1  extends Handler{

    @Override
    public void process(Client client) {
        
        System.out.println("Processing");
        if(client.i>5){
            this.handler.process(client);
        }else{
            System.out.println("Error1");
        
    }
    
}
}
class ConcreateHandler2 extends Handler{

    @Override
    public void process(Client client) {
        
        System.out.println("Processing");
        if(client.i%2==0){
            this.handler.process(client);
        }else{
            System.out.println("Error2");
        
    }
    
}
}
class ConcreateHandler3 extends Handler{

    @Override
    public void process(Client client) {
        
        System.out.println("Processing");
        if(client.i<20){
            System.out.println("Success");//End the chain
        }else{
            System.out.println("Error3");
        
    }
    
}
}

/**
 *
 * @author Thiwanka
 */
public class Chain_pattern_Prac {
    public static void main(String[] args) {
       
        Filter1  f1 = new Filter1();
        Filter2  f2 = new Filter2();
        Filter3  f3 = new Filter3();
        
        
        f1.setNext(f2);
        f2.setNext(f3);
        
        JSP jsp = new JSP("username =abc password =123","www.abc.com/a.jsp");
        f1.process(jsp);
        
    }
    
}

class JSP{
    String Parameters;
    String URL;
    
    public JSP(String Para,String URL){
        this.Parameters = Para;
        this.URL = URL;
    }
}

//We use HAS-A relationship to develop chain
abstract class Filter {
   protected Filter filter;
    
    public void setNext(Filter filter){
        this.filter = filter;
    }
    
    public abstract void process(JSP jsp);         
}

class Filter1  extends Filter{

    @Override
    public void process(JSP jsp) {
        
        System.out.println("Processing");
        if(jsp.URL.contains(".jsp")){
            this.filter.process(jsp);
        }else{
            System.out.println("Error1");
        
    }
    
}
}
class Filter2 extends Filter{

    @Override
    public void process(JSP jsp) {
        
        System.out.println("Processing");
        if(jsp.Parameters.contains("username")&& jsp.Parameters.contains("password")){
            this.filter.process(jsp);
        }else{
            System.out.println("Error2");
        
    }
    
}
}
class Filter3 extends Filter{

    @Override
    public void process(JSP jsp) {
        
        System.out.println("Processing");
        if(jsp.Parameters.equals("username =abc password =123")){
            System.out.println("Success");//End the chain
        }else{
            System.out.println("Error3");
        
    }
    
}
}

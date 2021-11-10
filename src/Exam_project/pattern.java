
package Exam_project;

import java.util.regex.Matcher;

/**
 *
 * @author Thiwanka
 */
public class pattern {
    
    public static void main(String[] args) {
        User i=new User("fg", "asdasdassa", "Ja5sfJa5s", "dan@gmail.com");
        Name n=new Name();
        Mobile m=new Mobile();
        Password p=new Password();
        Email e=new Email();
        n.setNext(m);
        m.setNext(p);
        p.setNext(e);
        n.process(i);
    }
    
}

class User{
    
    String name;
    String mobile;
    String password;
    String email;
    
    int count=0;

    public User(String name, String mobile, String password, String email) {
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.email = email;
    }
    
}

abstract class Responibility{
    
    protected Responibility responibility;
    
    public void setNext(Responibility responibility){
        this.responibility=responibility;
    }
    
    public abstract void process(User user);
    
}

class Name extends Responibility{
    
    @Override
    public void process(User user) {
        if(!user.name.isEmpty()){
            user.count++;
            System.out.println(user.count);
            this.responibility.process(user);
        }else{
            System.out.println(user.count);
        }
    }
    
}

class Mobile extends Responibility{
    
    @Override
    public void process(User user) {
        
        if(!user.mobile.isEmpty()){
            
            if(user.mobile.length()==10){
                
                user.count++;
                System.out.println(user.count);
                this.responibility.process(user);
                
            }else{
                System.out.println(user.count);
            }
            
        }else{
            System.out.println(user.count);
        }
        
    }
    
}

class Password extends Responibility{
    
    @Override
    public void process(User user) {
        
        String regex = "^(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[0-9]).{8,25}$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.password);
        
            if(user.password.length()>=8){
                if (matcher.matches()){
                    user.count++;
                    System.out.println(user.count);
                    this.responibility.process(user);
                    
                }else{
                    System.out.println(user.count);
                }
                
            }else{
                System.out.println(user.count);
            }
        
    }
    
}

class Email extends Responibility{
        
    @Override
    public void process(User user) {
        
        String regex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.email);
        
        if(!user.email.isEmpty()){
            
            if(matcher.matches()){
                user.count++;
                System.out.println(user.count);
            }else{
                System.out.println(user.count);
            }
            
        }else{
            System.out.println(user.count);
        }
        
    }
    
}

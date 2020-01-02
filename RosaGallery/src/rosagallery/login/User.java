/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.login;

/**
 *
 * @author mrosa
 */
public class User {
    
    private String un;
    private String pw;
    private String username;
    private String password;
    private String name;
    private String email;
    private String id;
    private String address;
    
    public User(String un, String pw){
        this.un = un;
        this.pw = pw;
    }
    
    public User(String name, String email, String address, String username, String password){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        
    }
    
    public User(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public String getUn(){
        return un;
    }
    
    public String getPw(){
        return pw;
    }
    
    public String getName2(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getAddress(){
        return address;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alok
 */
class Operator {
    
    public static void main(String[] args) {
        def user = new User('Bob')
        
        println  user.name
        println  user.@name
        
        def str = 'example of method reference'            
        def fun = str.&toUpperCase                         
        def upper = fun()                                  
        println str.toUpperCase()
        println upper
    }
    
    static class User {
        public final String name                 
        User(String name) { this.name = name}
        String getName() { "Name: $name" }       
    }

}


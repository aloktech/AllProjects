/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alok
 */
// Simple class without package
class Syntax {
    /*
     * Multi line
     */
    public static void main(String[] args) {
        println "Hello"
        println 'Hello'

        def map = [:]

        map."an identifier with a space and double quotes" = "ALLOWED"
        map.'with-dash-signs-and-single-quotes' = "ALLOWED"
        
        println map.'with-dash-signs-and-single-quotes'

        assert map."an identifier with a space and double quotes" == "ALLOWED"
        assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"
        
        def firstname = "Homer"
        map."Simson-${firstname}" = "Homer Simson"

        println map.'Simson-Homer'
        
        def result = takeString('Hello')
        println result
        
        def name = 'Groovy'
        def template = """
            Dear Mr ${name},

            You're the winner of the lottery!

            Yours sincerly,

            Dave
        """
        
        println template
        
        def name1 = "Guillaume"
        def date = "April, 1st"

        def dollarSlashy = $/
            Hello $name1,
            today we're ${date}.

            $ dollar sign
            $$ escaped dollar sign
            \ backslash
            / forward slash
            $/ escaped forward slash
            $/$ escaped dollar slashy string delimiter
        /$
        
        println dollarSlashy
    }
    
    static String takeString(String message) {
        println message
        return message
    }
    
}


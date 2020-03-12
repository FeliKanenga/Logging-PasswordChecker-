import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


class passwordException extends Exception {
    public passwordException(String problem) {
        super(problem);
    }
}
public class  passwordChecker {
    final static Logger logger = LogManager.getLogger(passwordChecker.class.getName());

     static boolean passwordShouldExist = true;
     static boolean passwordLonger8 = true;
     static boolean passwordLowercaseLetter = true ;
     static boolean passwordUppercaseLetter = true ;
     static boolean passwordOneDigit = true ;
     static boolean passwordSpecialCharacter = true;

    public static boolean passwordIsValid(String pass)throws passwordException {

        if(pass.isEmpty()){
            passwordShouldExist = false;
            logger.error("Password field is empty");
        }
        if(pass.length() < 8 ){
            passwordLonger8 = false;
            logger.error("Password should be longer than 8 Characters");
        }

        if(!pass.matches("(.*[a-z].*)")){
            passwordLowercaseLetter = false ;
            logger.error("password should have at least one lowercase letter");
        }

        if(!pass.matches("(.*[A-Z].*)")){
            passwordUppercaseLetter = false;
            logger.error("password should have at least one uppercase letter");
        }

        if(!pass.matches("(.*\\d.*)")){
             passwordOneDigit = false;
            logger.error("password should at least have one digit");
        }
        if(!pass.matches("(.+[^\\W+\\d+]).+")){
            passwordSpecialCharacter = false;
            logger.error("password should have at least one special character");
        }
        return true;
    }

    public static boolean passwordIsOk(){

        if(passwordShouldExist&&passwordLonger8){
            if(passwordSpecialCharacter||passwordOneDigit||
                    passwordLowercaseLetter||passwordUppercaseLetter)
            logger.debug("Password is Okay ");
            return true;
        }
        else{
            logger.debug("Pass is not okay");
            return false;
        }

    }

    public static void main(String[] args) throws passwordException {


        Scanner password = new Scanner(System.in);
        int count = 3;
        for (int i = 1; i <= 3 ; i++) {
            if(i == 1){
                System.out.println("--------------------------------------------------------------");
            System.out.println(
                    "   - password should field should not be empty\n" +
                            "   - password should be longer than than 8 characters\n" +
                            "   - password should have at least one lowercase letter\n" +
                            "   - password should have at least one uppercase letter\n" +
                            "   - password should at least have one digit\n" +
                            "   - password should have at least one special character");
            System.out.println("--------------------------------------------------------------");
            }
            System.out.println();
            System.out.println("Please read the password conditions above");
            System.out.println("Enter password" );
            String pass = password.nextLine();
            System.out.println("Please re-enter your password");
            String pass2 = password.nextLine();
            count--;
            if(pass.equals(pass2)){
                passwordIsValid(pass);
                    System.out.println();
                    passwordIsOk();
                break;
                } else{
                System.out.println();
                System.out.println("Password not identical, have " + count +
                        " attempts left");
            }

            }

            if(count == 0)
                System.out.println("Please run the program again and " +
                        "read the conditions carefully");
        }
    }




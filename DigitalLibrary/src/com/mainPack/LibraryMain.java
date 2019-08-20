
package com.mainPack;

import com.atox.functions.AdminLogin;
import com.atox.functions.UserLogin;
import java.util.Scanner;

/**
 *
 * @author Tabassum.Hasan
 */
public class LibraryMain 
{
    public static void main(String[] args) 
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Welcome to Digital Library of AtoX College");
        System.out.println("**********Menu******************");
        
      do
      {
        System.out.println("Enter 1 for Admin Login and 2 for User login and 3 for exit:");
        int choice=s.nextInt();
        
        switch(choice)
        {
            case 1:
                AdminLogin l=new AdminLogin();
                l.checkLogin();
                break;
            case 2:
                UserLogin u=new UserLogin();
                u.login();
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice... Please enter your choice again...");
                
        }
        
      }while(true);
        
        
    }
            
}

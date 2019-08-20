
package com.atox.functions;

import com.atox.connect.CreateConnection;
import com.atox.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tabassum.Hasan
 */
public class AdminLogin 
{
    String uname;
    String pwd;
    public void acceptDetails()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter username:");
        uname=s.next();
        
        System.out.println("Enter password:");
        pwd=s.next();
               
    }
    public void checkLogin() 
    {
        acceptDetails();
        CreateConnection c=CreateConnection.getInstance();
        Connection con;
        try {
            con = c.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select * from adminlogin where username=? and password=?");
            
            pstmt.setString(1, uname);
            pstmt.setString(2, pwd);
            
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next())
            {
                System.out.println("Welcome "+uname);
                User u=new User(uname,pwd);
                
                getReport();
            }
            else
            {
                System.out.println("Sorry Invalid login");
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
                
        
    }
    public void getReport()
    {
        do
        {
            Scanner s=new Scanner(System.in);
            System.out.println("**********Menu**************");
            System.out.println("Enter 1 for getting the maximum searched book");
            System.out.println("Enter 2 for getting the maximum searched author");
            System.out.println("Enter 3 for total number of users who looged in");
            System.out.println("Enter 4 for total number of books who looged in");
            System.out.println("Enter 5 for exit");
            int choice =s.nextInt();
            
            Report r=new Report();
            switch(choice)
            {
                case 1:
                    System.out.println("The maximum searched book is:"+r.maxBookCount());
                    break;
                case 2:
                    System.out.println("The maximum searched author is:"+r.authorCount());
                    break;
                case 3:
                    System.out.println("The user count is:"+r.userCount());
                    break;
                case 4:
                    System.out.println("The total number of books searched are:"+r.bookCount());
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter ur choice again....");
            }
                
        }while(true);
        
        
        
    }
    
}

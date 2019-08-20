/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atox.functions;

import com.atox.connect.CreateConnection;
import com.atox.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Tabassum.Hasan
 */
public class UserLogin 
{

    String uname;
    String pwd;
    CreateConnection c;
        Connection con;
    public void acceptDetails()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter username:");
        uname=s.next();
        
        System.out.println("Enter password:");
        pwd=s.next();
               
    }
    public void login() 
    {
        acceptDetails();
        c=CreateConnection.getInstance();
        
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

                search();
            }
            else
            {
                System.out.println("Sorry Invalid login");
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
                
        
    }

    private void search() 
    {
        System.out.println("Enter 1 for book search 2 for author search");
        Scanner s=new Scanner(System.in);
        int choice=s.nextInt();
        
        switch(choice)
        {
            case 1:
                System.out.println("The book details are as follows:");
                updateBook();
            case 2:
                System.out.println("The author details are as follows:");
                updateAuthor();
            case 3:
            default:
        }
    }
    public void updateBook()
    {
        Scanner s=new Scanner(System.in);
        c=CreateConnection.getInstance();
        String bookname=s.next();
        
        try {
            con = c.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select * from book where bookname=?");
            
            pstmt.setString(1,bookname);
           
            
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next())
            {
                System.out.println("Book name"+rs.getString(2));
                PreparedStatement pstmt1=con.prepareStatement("update book set count=count+1 where bookname=?");
                pstmt1.setString(1,bookname);
            }
            else
            {
                System.out.println("Sorry Invalid book");
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    public void updateAuthor()
    {
//        String authorname;
//        try {
//            con = c.getConnection();
//            PreparedStatement pstmt=con.prepareStatement("select * from author where authorname=?");
//            
//            pstmt.setString(1,authorname);
//           
//            
//            ResultSet rs=pstmt.executeQuery();
//            
//            if(rs.next())
//            {
//                System.out.println("Book name"+rs.getString(2));
//                PreparedStatement pstmt1=con.prepareStatement("update book set count=count+1 where bookname=?");
//                pstmt1.setString(1,bookname);
//            }
//            else
//            {
//                System.out.println("Sorry Invalid book");
//            }
//            
//        } catch (SQLException ex) {
//           ex.printStackTrace();
//        }
    }
   
    
}

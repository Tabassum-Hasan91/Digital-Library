
package com.atox.functions;

import com.atox.connect.CreateConnection;
import com.atox.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tabassum.Hasan
 */
public class Report 
{
    Connection con;
    CreateConnection c;
    public void connect()
    {
        c=CreateConnection.getInstance();
        
        
    }
    public int bookCount()
    {
        try {
            con = c.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select sum(count) from book");
                      
            ResultSet rs=pstmt.executeQuery();
            
            rs.next();
            int count=rs.getInt(1);
            return count;
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return 0;
    }
    public String userCount()
    {
        try {
            con = c.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select username from userlogin where count=(select max(count) from userlogin)");
                      
            ResultSet rs=pstmt.executeQuery();
            
            rs.next();
            String username=rs.getString(1);
            return username;
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
    public String maxBookCount()
    {
        try {
            con = c.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select bookname from book where count=(select max(count) from book)");
                      
            ResultSet rs=pstmt.executeQuery();
            
            rs.next();
            String bookname=rs.getString(1);
            return bookname;
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
    public String authorCount()
    {
        try {
            con = c.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select authorname from book where count=(select max(count) from author)");
                      
            ResultSet rs=pstmt.executeQuery();
            
            rs.next();
            String authorname=rs.getString(1);
            return authorname;
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}

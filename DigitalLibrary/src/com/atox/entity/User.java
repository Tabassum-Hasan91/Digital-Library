
package com.atox.entity;

/**
 *
 * @author Tabassum.Hasan
 */
public class User 
{
    String uname;
    String password;
    static int count;

    public User(String uname, String pwd) 
    {
        this.uname=uname;
        this.password=password;
        count++;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 *
 * @author Sudip Maiti
 */
public class REGISTRATION_DATAOBEJECT {
    public static int inventory_management_system (String fname, String LAST_NAME, String EMAIL, 
            String MOBILE_NO, String MNG_ID,String PASSWORD, String CONFIRM_PASSWORD, String ADDRESS,String GENDER,String T_D,String DOB){
        int status=0;
              try{
                   Connection con=DATABASE_CONNECTION.getConnection();  
                   
                   PreparedStatement ps=con.prepareStatement("INSERT INTO register(FIRST_NAME, LAST_NAME, EMAIL, MOBILE_NO, MNG_ID,PASSWORD,CONFIRM_PASSWORD,ADDRESS,GENDER,T_D,DOB) VALUES (?,?,?,?,?,?,?,?,?,?,?) ");
                   ps.setString(1, fname);
                   ps.setString(2, LAST_NAME);
                   ps.setString(3, EMAIL);
                   ps.setString(4, MOBILE_NO);
                   ps.setString(5, MNG_ID);
                   ps.setString(6, PASSWORD);
                   ps.setString(7, CONFIRM_PASSWORD);                   
                   ps.setString(8, ADDRESS);
                   ps.setString(9, GENDER);
                   ps.setString(10, T_D);
                   ps.setString(11, DOB);
                   status=ps.executeUpdate();
                   con.close();
              }catch(Exception e){
                  System.out.println(e);
              }
              System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+status);
              return status;

   }
    public static String validate(String mngid,String password) throws SQLException
    {
        boolean status =false;
        boolean sta =false;
        String abc="noo";
      //  boolean val=fal;
        try{
           // INSERT INTO `admin`(`sl`, `mng_id`, `fname`, `lname`, `Phone`, `email`, `Password`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]')
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from admin where mng_id = ? and Password=?");
            ps.setString(1, mngid);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
           if(status == true){
             PreparedStatement ps1=con.prepareStatement("select * from admin where mng_id = ? and status= '1'");   
                 ps1.setString(1, mngid);
                ResultSet rs1=ps1.executeQuery();
                 
                       sta =rs1.next();
                      // abc=String.valueOf(status)+2;
                     if(sta){
                         abc="yess";
                     }else{
                abc="cp";
           } 
                      
           // System.out.println("hiiiiiiii"+abc);
           // status=false;
            
        
            con.close();
           }
        }
        catch(Exception e){System.out.println(e);}
        // System.out.println("return"+abc);
        return abc;
        
    
    }      
public static boolean vali (String EMAIL,String MOBILE_NO) throws SQLException
    {
        boolean status =false;
        try{
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from register where EMAIL = ? or MOBILE_NO =? ");
            ps.setString(1, EMAIL);
            ps.setString(1, MOBILE_NO);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
           }
        catch(Exception e){System.out.println(e);}
        return status;
    }

public static int remove_emp_system (String manager_name, String mng_id, String date, 
            String time, String emp_id,String emp_name, String reason){
        int status=0;
              try{
                   Connection con=DATABASE_CONNECTION.getConnection();  
                   PreparedStatement ps=con.prepareStatement("INSERT INTO remove_employee(manager_name, mng_id, date, time, emp_id, emp_name, reason) VALUES (?,?,?,?,?,?,?)");
                   ps.setString(1, manager_name);
                   ps.setString(2, mng_id);
                   ps.setString(3, date);
                   ps.setString(4, time);
                   ps.setString(5, emp_id);
                   ps.setString(6, emp_name);
                   ps.setString(7, reason);
                 
                   status=ps.executeUpdate();
                   con.close();
              }catch(Exception e){
                  System.out.println(e);
              }
              System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+status);
              return status;
}
}
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
public class ADD_NEW_EMP_DATAOBEJECT {
    public static int create_emp (String FIRST_NAME, String LAST_NAME, String EMAIL, 
            String MOBILE_NO, String EMP_ID,String ADDRESS){
        int status=0;
              try{
                   Connection con=DATABASE_CONNECTION.getConnection();  
                 //  INSERT INTO `emp`(`emp_id`, `emp_fname`, `emp_lname`, `emp_phone`, `emp_email`, `emp_address`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]')
                   PreparedStatement ps=con.prepareStatement("INSERT INTO emp (`emp_id`, `emp_fname`, `emp_lname`, `emp_phone`, `emp_email`,`emp_address`) VALUES (?,?,?,?,?,?)");
                   ps.setString(2, FIRST_NAME);
                   ps.setString(3, LAST_NAME);
                   ps.setString(5, EMAIL);
                   ps.setString(4, MOBILE_NO);
                   ps.setString(1, EMP_ID);
                  
                   ps.setString(6, ADDRESS);
                                      
                   status=ps.executeUpdate();
                   con.close();
              }catch(Exception e){
                  System.out.println(e);
              }
              System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+status);
              return status;

//INSERT INTO `register`(`FIRST_NAME`, `LAST_NAME`, `EMAIL`, `MOBILE_NO`, `PASSWORD`, `CONFIRM_PASSWORD`, `ADDRESS`, `GENDER`) 
    }
    public static int create_cus (String FIRST_NAME, String LAST_NAME, String EMAIL, 
            String MOBILE_NO, String EMP_ID,String ADDRESS){
        int status=0;
              try{
                   Connection con=DATABASE_CONNECTION.getConnection();  
                 //  INSERT INTO `emp`(`emp_id`, `emp_fname`, `emp_lname`, `emp_phone`, `emp_email`, `emp_address`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]')
                   PreparedStatement ps=con.prepareStatement("INSERT INTO cus (`cus_id`, `cus_fname`, `cus_lname`, `cus_ph`, `cus_eml`,`cus_adde`) VALUES (?,?,?,?,?,?)");
                   ps.setString(2, FIRST_NAME);
                   ps.setString(3, LAST_NAME);
                   ps.setString(5, EMAIL);
                   ps.setString(4, MOBILE_NO);
                   ps.setString(1, EMP_ID);
                  
                   ps.setString(6, ADDRESS);
                                      
                   status=ps.executeUpdate();
                   con.close();
              }catch(Exception e){
                  System.out.println(e);
              }
              System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+status);
              return status;

//INSERT INTO `register`(`FIRST_NAME`, `LAST_NAME`, `EMAIL`, `MOBILE_NO`, `PASSWORD`, `CONFIRM_PASSWORD`, `ADDRESS`, `GENDER`) 
    }
    
    
    public static boolean validate(String email,String password) throws SQLException
    {
        boolean status =false;
        try{
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from employee_register where Emp_Id = ? and Password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
           }
        catch(Exception e){System.out.println(e);}
        return status;
    }
}

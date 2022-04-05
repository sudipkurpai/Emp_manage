/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sudip Maiti
 */
public class ID_STORE_FETCH {
    public static int insert_id (String EMP_ID){
        int status=0;
              try{
                   Connection con=DATABASE_CONNECTION.getConnection();  
                   PreparedStatement ps=con.prepareStatement("UPDATE id_store SET emp_id=?");
                  
                   ps.setString(1, EMP_ID); 
                   
                    
                   status=ps.executeUpdate();
                   con.close();
              }catch(Exception e){
                  System.out.println(e);
              }
           //   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+status);
              return status;
    }   public static int cus_id (String EMP_ID){
        int status=0;
              try{
                   Connection con=DATABASE_CONNECTION.getConnection();  
                   PreparedStatement ps=con.prepareStatement("UPDATE id_store SET cus_id=?");
                  
                   ps.setString(1, EMP_ID); 
                   
                    
                   status=ps.executeUpdate();
                   con.close();
              }catch(Exception e){
                  System.out.println(e);
              }
           //   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+status);
              return status;
    }
    public static boolean validate(String mng_id,String emp_id,String Transaction_Id) throws SQLException
    {
        boolean status =false;
        try{
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from id_store");
            ps.setString(1, mng_id);
            ps.setString(2, emp_id);
            ps.setString(3, Transaction_Id);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
           }
        catch(Exception e){System.out.println(e);}
        return status;
    }
    


    public static int invoice (String INVOICE_NO){
        int status=0;
              try{
                   Connection con=DATABASE_CONNECTION.getConnection();  
                   PreparedStatement ps=con.prepareStatement("UPDATE id_store SET INVOICE_NO=?");
                   ps.setString(1, INVOICE_NO);
                   
                    
                   status=ps.executeUpdate();
                   con.close();
              }catch(Exception e){
                  System.out.println(e);
              }
              System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+status);
              return status;

}
}
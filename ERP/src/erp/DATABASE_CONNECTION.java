/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Sudip Maiti
 */
public class DATABASE_CONNECTION {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://node1.fastdnsrocket.com/openserv_emp_mng","openserv_admin","=e=S@YtLHV@c");
          con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/emp_mng","root","");

        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}

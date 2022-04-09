package erp;


import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sudip_Maiti
 */
public class Index extends javax.swing.JFrame {
    String gcusid;
    String gserv;
String cus_Id;
String cus;
 BigInteger cus_id =null;
 String emp_Idcee;
String empcee;
 BigInteger emp_idcee =null;
    
    String eml= "";
    String name= "";
    String eid = "";
    String Ph = "";
    public void hello(String emp_id, String emp_name,String e_ph, String email){
    eid=emp_id;
    name=emp_name;
    Ph =e_ph;
    eml=email;
    adn.setText(name);
    adi.setText(eid);
}  
    
    String Epp="";
    public void emp_id(String ee){
        Epp=ee;
    }
   
    String Eppuepp="";
    public void emp_uepp(String ee){
        Eppuepp=ee;
    }

    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();

   
        
         time();
        date();
        
         fName.setVisible(false);
        L_name.setVisible(false);
        Phone.setVisible(false);
        Email.setVisible(false);
      
        addrr.setVisible(false);
        mng_name.setEditable(false);
        mng_id.setEditable(false);
        Emp_id.setEditable(false);
        
       ttf.setEditable(false);
       
        fName1.setVisible(false);
        fName2.setVisible(false);
         home.setVisible(true);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        a1.setVisible(true);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);

        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
        Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
        Update_Emp.setVisible(false);
        Working_list.setVisible(false);
         body21.setVisible(false);
         body22.setVisible(false);
          body23.setVisible(false);
        
        p1.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
                
 DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
    MyHeaderRender.setBackground(Color.decode("#F10086"));
    MyHeaderRender.setForeground(Color.decode("#FCE7FC"));
    int i=0;
    int j= jTable1.getColumnCount();
    

    for(i=0;i<j;i++){
       
    jTable1.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);
    jTable1.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(MyHeaderRender);

    
    }
        
        
    // this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//frame.setUndecorated(true);
//frame.setVisible(true);
   }
    
    
     void id_create(){
        Emp_id.setEditable(false);
         try{
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from id_store");         
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
              //  mng_Id=rs.getString("MNG_ID");
               // System.out.println("MANAGER ID "+mng_Id);
                cus_Id=rs.getString("cus_id");
              //  System.out.println("EMPLOYEE ID "+emp_Id);
              //  Transaction_Id=rs.getString("TRANSACTION_ID");
              //  System.out.println("Transaction_Id "+Transaction_Id);
             //   Product_id=rs.getString("PRODUCT_ID");
               
                rs.close();
                ps.close();
            }else{
                new Warning("NOTHING FOUND IN DATABASE!!!").setVisible(true);
               // JOptionPane.showMessageDialog(null, "NOTHING FOUND IN DATABASE!!!!!!");
            }
            con.close();
           }
        catch(Exception e){System.out.println(e);}
         
        cus_id = new BigInteger(cus_Id);
        BigInteger nxt = new BigInteger("1");
      //  System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+emp_Id);
      //  System.out.println("#################"+emp_id);
        cus_id = cus_id.add(nxt);
     //   System.out.println("%%%%%%%%%%%%%%%%%%%%%%"+emp_id);
        cus = "ERP_C"+cus_id.toString();
    //    System.out.println("%%%%%%%%%%%%%%%%%%%%%%"+emp);
     //   System.out.println("++++++++++++++++"+emp_id);
        Emp_id.setText(cus);
    }
     void date() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy");
         Date d1 = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("EEE");
        dd1.setText(s.format(d));
        dd.setText(s1.format(d1));
    }

    void time() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                tt.setText(s.format(d));
            }
        }
        ).start();

    }
    public void table1() {
    try {
        
             //Data fetch from database
            String sql = "Select * From cus ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           DefaultTableModel model =(DefaultTableModel)table2.getModel(); 
           model.setRowCount(0);
           while (rs.next())
           {
               String name = rs.getString("cus_fname")+" "+rs.getString("cus_lname");
               Object o []={
                  name, rs.getString("cus_id") };
               model.addRow(o);
               
           }
            }catch(Exception e){
            System.out.println("error"+e);
        }
     }
     public void table() {
    try {
        
             //Data fetch from database
            String sql = "Select * From cus ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           DefaultTableModel model =(DefaultTableModel)tablesc.getModel(); 
           model.setRowCount(0);
           while (rs.next())
           {
                    String name = rs.getString("cus_fname")+" "+rs.getString("cus_lname");
                    Object o []={
                        rs.getString("cus_id"),name,rs.getString("cus_ph"),rs.getString("cus_eml"),rs.getString("cus_adde") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
           }
            }catch(Exception e){
            System.out.println("error"+e);
        }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpic = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        p5 = new javax.swing.JPanel();
        a5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        p3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        p4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        p6 = new javax.swing.JPanel();
        a6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        p7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        head = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adn = new javax.swing.JLabel();
        adi = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tt = new javax.swing.JLabel();
        dd = new javax.swing.JLabel();
        dd1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        body = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        CS = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        ES = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        Ws = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        SM = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        MP = new javax.swing.JPanel();
        Cus_List = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablesc = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        serch = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        fName1 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Search_Cus = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        serch1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        fName2 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ttf = new javax.swing.JTextPane();
        fName3 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        Create_Cus = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        fName = new javax.swing.JLabel();
        Phone = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        crt_emp = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        L_name = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        addrr = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone3 = new javax.swing.JTextField();
        Emp_id = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel56 = new javax.swing.JLabel();
        mng_name = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        mng_id = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        Update_Cus = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        fName4 = new javax.swing.JLabel();
        Phone1 = new javax.swing.JLabel();
        Email1 = new javax.swing.JLabel();
        crt_emp1 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        L_name1 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        aaaa = new javax.swing.JLabel();
        firstname1 = new javax.swing.JTextField();
        lastname1 = new javax.swing.JTextField();
        email1 = new javax.swing.JTextField();
        phone4 = new javax.swing.JTextField();
        Emp_id1 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        address1 = new javax.swing.JTextArea();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        serch2 = new javax.swing.JTextField();
        fName5 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        Delete_Cus = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        crt_emp2 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        mng_id1 = new javax.swing.JTextField();
        mng_name1 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        serch3 = new javax.swing.JTextField();
        fName6 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        eid11 = new javax.swing.JLabel();
        enn = new javax.swing.JLabel();
        Emp_List = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableell = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        serchell = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        fName1344 = new javax.swing.JLabel();
        Search_Emp = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        table1see = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        tablesee = new javax.swing.JTable();
        jPanel54 = new javax.swing.JPanel();
        serchsee = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        fNamesepp = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        ttfsee = new javax.swing.JTextPane();
        fName9 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        Create_Emp = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        fNamecee = new javax.swing.JLabel();
        Phonecee = new javax.swing.JLabel();
        Emailcee = new javax.swing.JLabel();
        crt_emp3 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        L_namecee = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        aaaacee = new javax.swing.JLabel();
        firstnamecee = new javax.swing.JTextField();
        lastnamecee = new javax.swing.JTextField();
        emailcee = new javax.swing.JTextField();
        phone3cee = new javax.swing.JTextField();
        Emp_idcee = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        addresscee = new javax.swing.JTextArea();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        mng_id2 = new javax.swing.JTextField();
        mng_name2 = new javax.swing.JTextField();
        Update_Emp = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        fNameuepp = new javax.swing.JLabel();
        Phoneuepp = new javax.swing.JLabel();
        Emailuepp = new javax.swing.JLabel();
        crt_emp4 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        L_nameuepp = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        aaaauepp = new javax.swing.JLabel();
        firstnameuepp = new javax.swing.JTextField();
        lastnameuepp = new javax.swing.JTextField();
        emailuepp = new javax.swing.JTextField();
        phone3uepp = new javax.swing.JTextField();
        Emp_iduepp = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        addressuepp = new javax.swing.JTextArea();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        mng_id3 = new javax.swing.JTextField();
        mng_name3 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        serchuepp = new javax.swing.JTextField();
        fName1uepp = new javax.swing.JLabel();
        jLabel2uepp = new javax.swing.JLabel();
        Delete_Emp = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        crt_emp5 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabledepp = new javax.swing.JTable();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        mng_id4 = new javax.swing.JTextField();
        mng_name4 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        serchdepp = new javax.swing.JTextField();
        fName1depp = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        eiddepp = new javax.swing.JLabel();
        enndepp = new javax.swing.JLabel();
        Working_list = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tablewll = new javax.swing.JTable();
        jPanel62 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        stawll = new javax.swing.JComboBox<>();
        jPanel65 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        serchell1 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        fName1345 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        hidetext = new java.awt.Label();
        Assign = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        t2 = new javax.swing.JComboBox<>();
        jLabel128 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        td = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        ascn = new javax.swing.JLabel();
        ascph = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        asceml = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ascad = new javax.swing.JTextPane();
        jLabel137 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ascsd = new javax.swing.JTextPane();
        jPanel71 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        ddt = new com.toedter.calendar.JDateChooser();
        t3 = new javax.swing.JComboBox<>();
        jLabel131 = new javax.swing.JLabel();
        Complete = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        csdd = new com.toedter.calendar.JDateChooser();
        jLabel132 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        cstt = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        cscn = new javax.swing.JLabel();
        cscp = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        cseml = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        csad = new javax.swing.JTextPane();
        jLabel149 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        csmet = new javax.swing.JTextPane();
        jPanel76 = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        Co = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        csei = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        cssd = new javax.swing.JTextPane();
        jLabel154 = new javax.swing.JLabel();
        csen = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        csci = new javax.swing.JLabel();
        cscost = new javax.swing.JTextField();
        body12 = new javax.swing.JPanel();
        body23 = new javax.swing.JPanel();
        body22 = new javax.swing.JPanel();
        body21 = new javax.swing.JPanel();

        tpic.setForeground(new java.awt.Color(0, 125, 254));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 204)));

        menu.setBackground(new java.awt.Color(51, 51, 51));

        p1.setBackground(new java.awt.Color(51, 51, 51));
        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });
        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Home");
        p1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 0, 175, 55));

        jLabel19.setText("jLabe");
        p1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 49, 55));

        a1.setForeground(new java.awt.Color(255, 255, 255));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_rhombus_40px_1.png"))); // NOI18N
        p1.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 18, 55));

        p5.setBackground(new java.awt.Color(51, 51, 51));
        p5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p5MouseClicked(evt);
            }
        });
        p5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a5.setForeground(new java.awt.Color(255, 255, 255));
        a5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_rhombus_40px_1.png"))); // NOI18N
        p5.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 18, 55));

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Stock Management");
        p5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 210, 55));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("jLabel17");
        p5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 51, 60));

        p3.setBackground(new java.awt.Color(51, 51, 51));
        p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p3MouseClicked(evt);
            }
        });
        p3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Employee Section");
        p3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 0, 234, 58));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("jLabel15");
        p3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 46, 58));

        a3.setForeground(new java.awt.Color(255, 255, 255));
        a3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_rhombus_40px_1.png"))); // NOI18N
        p3.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 18, 58));

        p4.setBackground(new java.awt.Color(51, 51, 51));
        p4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p4MouseClicked(evt);
            }
        });
        p4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Working Section");
        p4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 190, 55));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("jLabel16");
        p4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 48, 55));

        a4.setForeground(new java.awt.Color(255, 255, 255));
        a4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_rhombus_40px_1.png"))); // NOI18N
        p4.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 18, 55));

        p2.setBackground(new java.awt.Color(51, 51, 51));
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
        });
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Coustomer Section");
        p2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 220, 55));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("jLabel14");
        p2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 2, 48, 55));

        a2.setForeground(new java.awt.Color(255, 255, 255));
        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_rhombus_40px_1.png"))); // NOI18N
        p2.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 18, 57));

        p6.setBackground(new java.awt.Color(51, 51, 51));
        p6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p6MouseClicked(evt);
            }
        });
        p6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a6.setForeground(new java.awt.Color(255, 255, 255));
        a6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_rhombus_40px_1.png"))); // NOI18N
        p6.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 18, 60));

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Manage Password");
        p6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 210, 60));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("jLabel18");
        p6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 53, 52));

        p7.setBackground(new java.awt.Color(51, 51, 51));
        p7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p7MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Logout");

        javax.swing.GroupLayout p7Layout = new javax.swing.GroupLayout(p7);
        p7.setLayout(p7Layout);
        p7Layout.setHorizontalGroup(
            p7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p7Layout.setVerticalGroup(
            p7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        head.setBackground(new java.awt.Color(51, 51, 51));
        head.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_user_40px_2.png"))); // NOI18N
        head.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 0, 60, 55));

        adn.setForeground(new java.awt.Color(255, 255, 255));
        adn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        adn.setText("jLabel2");
        head.add(adn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 0, 100, 25));

        adi.setForeground(new java.awt.Color(255, 255, 255));
        adi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        adi.setText("jLabel2");
        head.add(adi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 20, 100, 25));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        head.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 10, -1, 30));

        tt.setForeground(new java.awt.Color(255, 255, 255));
        tt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tt.setText("jLabel2");
        head.add(tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, 90, 25));

        dd.setForeground(new java.awt.Color(255, 255, 255));
        dd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dd.setText("jLabel2");
        head.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 40, 25));

        dd1.setForeground(new java.awt.Color(255, 255, 255));
        dd1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dd1.setText("jLabel2");
        head.add(dd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 90, 25));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        head.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 10, 30));

        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setBackground(new java.awt.Color(219, 226, 229));

        jPanel2.setBackground(new java.awt.Color(219, 226, 229));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("HOME");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(47, 68, 187));
        jLabel7.setText("Employee That Are Present Today");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plus (2).png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionForeground(new java.awt.Color(51, 153, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(47, 68, 187));
        jLabel47.setText("Today Working List");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plus (2).png"))); // NOI18N

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/editt.png"))); // NOI18N

        jTable2.setBackground(new java.awt.Color(255, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jSeparator6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel49)
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel47)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 810));

        CS.setBackground(new java.awt.Color(219, 226, 229));
        CS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(47, 68, 187));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer List");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CS.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, 183));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(47, 68, 187));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Search Customer");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CS.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, 183));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(47, 68, 187));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Create Customer");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CS.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, 183));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(47, 68, 187));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Update Customer");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CS.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 183));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(47, 68, 187));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Delete Customer");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CS.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, 183));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(47, 68, 187));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Bills");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CS.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, -1, 183));

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel43MouseClicked(evt);
            }
        });

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(47, 68, 187));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Working List");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CS.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, -1, 183));

        body.add(CS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 810));

        ES.setBackground(new java.awt.Color(219, 226, 229));
        ES.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(47, 68, 187));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Employee List");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ES.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, 183));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(47, 68, 187));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Search Employee");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ES.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, 183));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
        });

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(47, 68, 187));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Create Employee");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ES.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, 183));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
            }
        });

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(47, 68, 187));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Update Employee");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ES.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 183));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel23MouseClicked(evt);
            }
        });

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(47, 68, 187));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Delete Employee");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ES.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, 183));

        body.add(ES, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 810));

        Ws.setBackground(new java.awt.Color(219, 226, 229));
        Ws.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(47, 68, 187));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Compleated");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Ws.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 183));

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(47, 68, 187));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("New Assigned");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Ws.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, 183));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(47, 68, 187));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Due");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Ws.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, 183));

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(47, 68, 187));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("On Going");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Ws.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, 183));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(47, 68, 187));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Canceled");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Ws.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, 183));

        body.add(Ws, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 810));

        SM.setBackground(new java.awt.Color(219, 226, 229));
        SM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(47, 68, 187));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Show Stocks");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SM.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, 183));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(47, 68, 187));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Add Stokes");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SM.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, 183));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(104, 104, 104)));

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add user.png"))); // NOI18N

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(47, 68, 187));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Update Stokes");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SM.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, 183));

        body.add(SM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 810));

        MP.setBackground(new java.awt.Color(219, 226, 229));

        javax.swing.GroupLayout MPLayout = new javax.swing.GroupLayout(MP);
        MP.setLayout(MPLayout);
        MPLayout.setHorizontalGroup(
            MPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        MPLayout.setVerticalGroup(
            MPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(MP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Cus_List.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        tablesc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tablesc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cus_id", "Cus_name", "Cus_phone", "Cus_email", "Cus_addr"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablesc);

        jPanel27.setBackground(new java.awt.Color(0, 153, 51));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Create Customer");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jLabel23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel23KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        serch.setBackground(new java.awt.Color(255, 255, 255));
        serch.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serch.setForeground(new java.awt.Color(47, 68, 187));
        serch.setText("Serch Customer by Customer ID");
        serch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serchFocusLost(evt);
            }
        });
        serch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serchKeyReleased(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        fName1.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName1.setForeground(new java.awt.Color(47, 68, 187));
        fName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName1.setText("Serch Customer by Customer ID");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fName1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                            .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(fName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(255, 0, 51));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Delete");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel26.setBackground(new java.awt.Color(0, 125, 254));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Print");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(0, 153, 0));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Update");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Cus_ListLayout = new javax.swing.GroupLayout(Cus_List);
        Cus_List.setLayout(Cus_ListLayout);
        Cus_ListLayout.setHorizontalGroup(
            Cus_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Cus_ListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(421, 421, 421))
        );
        Cus_ListLayout.setVerticalGroup(
            Cus_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cus_ListLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Cus_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        body.add(Cus_List, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Search_Cus.setBackground(new java.awt.Color(47, 68, 187));

        jPanel28.setBackground(new java.awt.Color(47, 68, 187));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setBackground(new java.awt.Color(255, 255, 255));
        table1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table1.setForeground(new java.awt.Color(0, 0, 0));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cus Id", "Cus Name", "Emp Id", "Emp Name", "Date", "Time", "Service Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table1);

        jPanel28.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 770, 170));

        table2.setBackground(new java.awt.Color(255, 255, 255));
        table2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table2.setForeground(new java.awt.Color(0, 0, 0));
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cus Name", "Cus Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table2);

        jPanel28.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 360, 500));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        serch1.setBackground(new java.awt.Color(255, 255, 255));
        serch1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serch1.setForeground(new java.awt.Color(128, 128, 128));
        serch1.setText("Serch Customer by Customer ID");
        serch1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serch1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serch1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serch1FocusLost(evt);
            }
        });
        serch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serch1ActionPerformed(evt);
            }
        });
        serch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serch1KeyReleased(evt);
            }
        });

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel50.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });

        fName2.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName2.setForeground(new java.awt.Color(128, 128, 128));
        fName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName2.setText("Serch Customer by Customer ID");

        jLabel51.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Search Customer !");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fName2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(serch1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(fName2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(serch1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1150, 150));

        ttf.setBackground(new java.awt.Color(255, 255, 255));
        ttf.setBorder(null);
        ttf.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ttf.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(ttf);

        jPanel28.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 770, 220));

        fName3.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName3.setForeground(new java.awt.Color(255, 255, 255));
        fName3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName3.setText(" Service Details");
        jPanel28.add(fName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 390, 30));

        jPanel30.setBackground(new java.awt.Color(0, 125, 254));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Print");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 660, 770, -1));

        javax.swing.GroupLayout Search_CusLayout = new javax.swing.GroupLayout(Search_Cus);
        Search_Cus.setLayout(Search_CusLayout);
        Search_CusLayout.setHorizontalGroup(
            Search_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
            .addGroup(Search_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE))
        );
        Search_CusLayout.setVerticalGroup(
            Search_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
            .addGroup(Search_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Search_CusLayout.createSequentialGroup()
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        body.add(Search_Cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Create_Cus.setBackground(new java.awt.Color(255, 255, 255));

        jPanel31.setBackground(new java.awt.Color(47, 68, 187));
        jPanel31.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 255)));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel53.setText("Create New Customer !");
        jPanel32.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 30, 400, -1));

        fName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fName.setForeground(new java.awt.Color(128, 128, 128));
        fName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName.setText("First Name");
        jPanel32.add(fName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 20));

        Phone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Phone.setForeground(new java.awt.Color(128, 128, 128));
        Phone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Phone.setText("Phone");
        jPanel32.add(Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 260, 20));

        Email.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Email.setForeground(new java.awt.Color(128, 128, 128));
        Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email.setText("Email");
        jPanel32.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 280, 20));

        crt_emp.setBackground(new java.awt.Color(47, 68, 187));
        crt_emp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Create Customer");
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout crt_empLayout = new javax.swing.GroupLayout(crt_emp);
        crt_emp.setLayout(crt_empLayout);
        crt_empLayout.setHorizontalGroup(
            crt_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        crt_empLayout.setVerticalGroup(
            crt_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel32.add(crt_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 560, 50));

        L_name.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        L_name.setForeground(new java.awt.Color(128, 128, 128));
        L_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        L_name.setText("Last Name");
        jPanel32.add(L_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 220, 20));

        jLabel55.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(128, 128, 128));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Customer ID");
        jPanel32.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 20));

        addrr.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addrr.setForeground(new java.awt.Color(128, 128, 128));
        addrr.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addrr.setText("Address");
        jPanel32.add(addrr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 70, 20));

        firstname.setBackground(new java.awt.Color(255, 255, 255));
        firstname.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        firstname.setForeground(new java.awt.Color(128, 128, 128));
        firstname.setText("First Name");
        firstname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        firstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstnameFocusLost(evt);
            }
        });
        jPanel32.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 30));

        lastname.setBackground(new java.awt.Color(255, 255, 255));
        lastname.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lastname.setForeground(new java.awt.Color(128, 128, 128));
        lastname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lastname.setText("Last Name");
        lastname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        lastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastnameFocusLost(evt);
            }
        });
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel32.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 280, 30));

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(128, 128, 128));
        email.setText("Email");
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        jPanel32.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 280, 30));

        phone3.setBackground(new java.awt.Color(255, 255, 255));
        phone3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        phone3.setForeground(new java.awt.Color(128, 128, 128));
        phone3.setText("Phone");
        phone3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        phone3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phone3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone3FocusLost(evt);
            }
        });
        jPanel32.add(phone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 30));

        Emp_id.setBackground(new java.awt.Color(255, 255, 255));
        Emp_id.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Emp_id.setForeground(new java.awt.Color(0, 0, 0));
        Emp_id.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Emp_id.setText("123456798");
        Emp_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        Emp_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emp_idActionPerformed(evt);
            }
        });
        jPanel32.add(Emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, 30));

        address.setBackground(new java.awt.Color(255, 255, 255));
        address.setColumns(10);
        address.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        address.setForeground(new java.awt.Color(0, 0, 0));
        address.setRows(5);
        address.setText("Address");
        address.setBorder(null);
        address.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressFocusLost(evt);
            }
        });
        jScrollPane7.setViewportView(address);

        jPanel32.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 560, -1));

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-group (3).png"))); // NOI18N

        mng_name.setBackground(new java.awt.Color(47, 68, 187));
        mng_name.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_name.setForeground(new java.awt.Color(255, 255, 255));
        mng_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_name.setToolTipText("");
        mng_name.setBorder(null);

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("<Html><p align = center>CREATE <BR> CUSTOMER<p></Html>");

        mng_id.setBackground(new java.awt.Color(47, 68, 187));
        mng_id.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_id.setForeground(new java.awt.Color(255, 255, 255));
        mng_id.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_id.setToolTipText("");
        mng_id.setBorder(null);

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Georgia", 0, 48)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Welcome !");
        jLabel58.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addGap(14, 76, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mng_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mng_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(638, 638, 638))
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(622, 622, 622)))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(mng_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(mng_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 187, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Create_CusLayout = new javax.swing.GroupLayout(Create_Cus);
        Create_Cus.setLayout(Create_CusLayout);
        Create_CusLayout.setHorizontalGroup(
            Create_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
            .addGroup(Create_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Create_CusLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Create_CusLayout.setVerticalGroup(
            Create_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(Create_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Create_CusLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        body.add(Create_Cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Update_Cus.setBackground(new java.awt.Color(255, 255, 255));

        jPanel33.setBackground(new java.awt.Color(0, 102, 255));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fName4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fName4.setForeground(new java.awt.Color(128, 128, 128));
        fName4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName4.setText("First Name");
        jPanel34.add(fName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 20));

        Phone1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Phone1.setForeground(new java.awt.Color(128, 128, 128));
        Phone1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Phone1.setText("Phone");
        jPanel34.add(Phone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 260, 20));

        Email1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Email1.setForeground(new java.awt.Color(128, 128, 128));
        Email1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email1.setText("Email");
        jPanel34.add(Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 280, 20));

        crt_emp1.setBackground(new java.awt.Color(0, 102, 255));
        crt_emp1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Update");
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout crt_emp1Layout = new javax.swing.GroupLayout(crt_emp1);
        crt_emp1.setLayout(crt_emp1Layout);
        crt_emp1Layout.setHorizontalGroup(
            crt_emp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        crt_emp1Layout.setVerticalGroup(
            crt_emp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel34.add(crt_emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 550, 50));

        L_name1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        L_name1.setForeground(new java.awt.Color(128, 128, 128));
        L_name1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        L_name1.setText("Last Name");
        jPanel34.add(L_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 220, 20));

        jLabel60.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(128, 128, 128));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("Customer ID");
        jPanel34.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 20));

        aaaa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        aaaa.setForeground(new java.awt.Color(128, 128, 128));
        aaaa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aaaa.setText("Address");
        jPanel34.add(aaaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 70, 20));

        firstname1.setBackground(new java.awt.Color(255, 255, 255));
        firstname1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        firstname1.setForeground(new java.awt.Color(128, 128, 128));
        firstname1.setText("First Name");
        firstname1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        firstname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstname1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstname1FocusLost(evt);
            }
        });
        jPanel34.add(firstname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 260, 30));

        lastname1.setBackground(new java.awt.Color(255, 255, 255));
        lastname1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lastname1.setForeground(new java.awt.Color(128, 128, 128));
        lastname1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lastname1.setText("Last Name");
        lastname1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        lastname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastname1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastname1FocusLost(evt);
            }
        });
        lastname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname1ActionPerformed(evt);
            }
        });
        jPanel34.add(lastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 280, 30));

        email1.setBackground(new java.awt.Color(255, 255, 255));
        email1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        email1.setForeground(new java.awt.Color(128, 128, 128));
        email1.setText("Email");
        email1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        email1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                email1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                email1FocusLost(evt);
            }
        });
        jPanel34.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 280, 30));

        phone4.setBackground(new java.awt.Color(255, 255, 255));
        phone4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        phone4.setForeground(new java.awt.Color(128, 128, 128));
        phone4.setText("Phone");
        phone4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        phone4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phone4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone4FocusLost(evt);
            }
        });
        jPanel34.add(phone4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, 30));

        Emp_id1.setBackground(new java.awt.Color(255, 255, 255));
        Emp_id1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Emp_id1.setForeground(new java.awt.Color(0, 0, 0));
        Emp_id1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Emp_id1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        Emp_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emp_id1ActionPerformed(evt);
            }
        });
        jPanel34.add(Emp_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 260, 30));

        jScrollPane9.setBorder(null);

        address1.setBackground(new java.awt.Color(255, 255, 255));
        address1.setColumns(10);
        address1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        address1.setForeground(new java.awt.Color(0, 0, 0));
        address1.setRows(5);
        address1.setText("Address");
        address1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        address1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        address1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                address1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                address1FocusLost(evt);
            }
        });
        jScrollPane9.setViewportView(address1);

        jPanel34.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 244, 550, -1));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 610, 540));

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Georgia", 0, 48)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Welcome !");
        jLabel61.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel33.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 290, 70));

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update-business-user.png"))); // NOI18N
        jPanel33.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 420, 310));

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("CUSTOMER");
        jPanel33.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 410, 50));

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("UPDATE");
        jPanel33.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 410, 50));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setBackground(new java.awt.Color(0, 0, 0));
        jLabel65.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Update Customer !");
        jPanel35.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, -1));

        serch2.setBackground(new java.awt.Color(255, 255, 255));
        serch2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serch2.setForeground(new java.awt.Color(128, 128, 128));
        serch2.setText("Serch Customer by Customer ID");
        serch2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        serch2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serch2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serch2FocusLost(evt);
            }
        });
        jPanel35.add(serch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, 30));

        fName5.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName5.setForeground(new java.awt.Color(128, 128, 128));
        fName5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName5.setText("Serch Customer by Customer ID");
        jPanel35.add(fName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 30));

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel66.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
        });
        jPanel35.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 46, 40));

        jPanel33.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 610, 140));

        javax.swing.GroupLayout Update_CusLayout = new javax.swing.GroupLayout(Update_Cus);
        Update_Cus.setLayout(Update_CusLayout);
        Update_CusLayout.setHorizontalGroup(
            Update_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
        );
        Update_CusLayout.setVerticalGroup(
            Update_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Update_CusLayout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        body.add(Update_Cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Delete_Cus.setBackground(new java.awt.Color(255, 255, 255));

        jPanel36.setBackground(new java.awt.Color(14, 73, 181));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crt_emp2.setBackground(new java.awt.Color(0, 102, 255));
        crt_emp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        jLabel67.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Delete Customer");
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout crt_emp2Layout = new javax.swing.GroupLayout(crt_emp2);
        crt_emp2.setLayout(crt_emp2Layout);
        crt_emp2Layout.setHorizontalGroup(
            crt_emp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
        crt_emp2Layout.setVerticalGroup(
            crt_emp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel37.add(crt_emp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 570, 50));

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        table.setForeground(new java.awt.Color(47, 68, 187));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Emp Name", "Emp Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(table);

        jPanel37.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 340));

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 610, 450));

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("Georgia", 0, 48)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Welcome !");
        jLabel68.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel36.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 290, 70));

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-user.png"))); // NOI18N
        jPanel36.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 420, 310));

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("CUSTOMER");
        jPanel36.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 410, 50));

        mng_id1.setBackground(new java.awt.Color(14, 73, 181));
        mng_id1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_id1.setForeground(new java.awt.Color(255, 255, 255));
        mng_id1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_id1.setToolTipText("");
        mng_id1.setBorder(null);
        jPanel36.add(mng_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 30));

        mng_name1.setBackground(new java.awt.Color(14, 73, 181));
        mng_name1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_name1.setForeground(new java.awt.Color(255, 255, 255));
        mng_name1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_name1.setToolTipText("");
        mng_name1.setBorder(null);
        jPanel36.add(mng_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 40));

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("DELETE");
        jPanel36.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 410, 50));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel72.setText("Delete Customer !");
        jPanel38.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, -1));

        serch3.setBackground(new java.awt.Color(255, 255, 255));
        serch3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serch3.setForeground(new java.awt.Color(128, 128, 128));
        serch3.setText("Serch Customer by Customer ID");
        serch3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serch3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serch3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serch3FocusLost(evt);
            }
        });
        serch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serch3ActionPerformed(evt);
            }
        });
        serch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serch3KeyReleased(evt);
            }
        });
        jPanel38.add(serch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, 30));

        fName6.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName6.setForeground(new java.awt.Color(128, 128, 128));
        fName6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName6.setText("Serch Customer by Customer ID");
        jPanel38.add(fName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 30));

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel73.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel73MouseClicked(evt);
            }
        });
        jPanel38.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 46, 40));

        jPanel36.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 610, 140));
        jPanel36.add(eid11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));
        jPanel36.add(enn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 630, -1, -1));

        javax.swing.GroupLayout Delete_CusLayout = new javax.swing.GroupLayout(Delete_Cus);
        Delete_Cus.setLayout(Delete_CusLayout);
        Delete_CusLayout.setHorizontalGroup(
            Delete_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
        );
        Delete_CusLayout.setVerticalGroup(
            Delete_CusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );

        body.add(Delete_Cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Emp_List.setBackground(new java.awt.Color(0, 0, 255));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableell.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tableell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp_id", "Emp_name", "Emp_phone", "Emp_email", "emp_addr"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(tableell);

        jPanel39.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 96, 1070, 634));

        jPanel40.setBackground(new java.awt.Color(0, 153, 0));

        jLabel74.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Update");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 748, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));

        jLabel75.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Delete");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel39.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 748, -1, -1));

        jPanel41.setBackground(new java.awt.Color(0, 125, 254));

        jLabel76.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Print");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel39.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 748, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 153, 51));

        jLabel77.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Add Emp");
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel39.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 46, -1, -1));

        serchell.setBackground(new java.awt.Color(255, 255, 255));
        serchell.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serchell.setForeground(new java.awt.Color(47, 68, 187));
        serchell.setText("Serch Employee by Employee ID");
        serchell.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serchell.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serchellFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serchellFocusLost(evt);
            }
        });
        serchell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serchellKeyReleased(evt);
            }
        });
        jPanel39.add(serchell, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 320, 30));

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel78.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
        });
        jPanel39.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 44, 46, 40));

        fName1344.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName1344.setForeground(new java.awt.Color(47, 68, 187));
        fName1344.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName1344.setText("Serch Employee by Employee ID");
        jPanel39.add(fName1344, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 390, 30));

        javax.swing.GroupLayout Emp_ListLayout = new javax.swing.GroupLayout(Emp_List);
        Emp_List.setLayout(Emp_ListLayout);
        Emp_ListLayout.setHorizontalGroup(
            Emp_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        Emp_ListLayout.setVerticalGroup(
            Emp_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        body.add(Emp_List, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Search_Emp.setBackground(new java.awt.Color(204, 0, 51));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1see.setBackground(new java.awt.Color(255, 255, 255));
        table1see.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table1see.setForeground(new java.awt.Color(0, 0, 0));
        table1see.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp Id", "Emp Name", "Cus Id", "Cus Name", "Date", "Time", "Service Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1see.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1seeMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(table1see);

        jPanel53.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 182, 770, 170));

        tablesee.setBackground(new java.awt.Color(255, 255, 255));
        tablesee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablesee.setForeground(new java.awt.Color(0, 0, 0));
        tablesee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp Name", "Emp Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablesee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableseeMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tablesee);

        jPanel53.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 182, 360, 500));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(47, 68, 187)));

        serchsee.setBackground(new java.awt.Color(255, 255, 255));
        serchsee.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serchsee.setForeground(new java.awt.Color(128, 128, 128));
        serchsee.setText("Serch Employee by Employee ID");
        serchsee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serchsee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serchseeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serchseeFocusLost(evt);
            }
        });
        serchsee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serchseeKeyReleased(evt);
            }
        });

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel82.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
        });

        fNamesepp.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fNamesepp.setForeground(new java.awt.Color(128, 128, 128));
        fNamesepp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fNamesepp.setText("Serch Employee by Employee ID");

        jLabel99.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        jLabel99.setText("Search Employee !");

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fNamesepp, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel54Layout.createSequentialGroup()
                                .addComponent(serchsee, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addComponent(jLabel99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(fNamesepp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(serchsee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 12, 1150, 150));

        ttfsee.setBackground(new java.awt.Color(255, 255, 255));
        ttfsee.setBorder(null);
        ttfsee.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ttfsee.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane18.setViewportView(ttfsee);

        jPanel53.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 770, 220));

        fName9.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName9.setForeground(new java.awt.Color(255, 255, 255));
        fName9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName9.setText(" Service Details");
        jPanel53.add(fName9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 390, 30));

        jPanel55.setBackground(new java.awt.Color(0, 125, 254));

        jLabel100.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Print");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel53.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, 770, -1));

        javax.swing.GroupLayout Search_EmpLayout = new javax.swing.GroupLayout(Search_Emp);
        Search_Emp.setLayout(Search_EmpLayout);
        Search_EmpLayout.setHorizontalGroup(
            Search_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
            .addGroup(Search_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Search_EmpLayout.setVerticalGroup(
            Search_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(Search_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body.add(Search_Emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Create_Emp.setBackground(new java.awt.Color(0, 0, 255));

        jPanel42.setBackground(new java.awt.Color(14, 73, 181));
        jPanel42.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel42.setMaximumSize(new java.awt.Dimension(1122, 765));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(14, 73, 181));
        jLabel79.setText("Create New Employee !");
        jPanel51.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 30, 400, -1));

        fNamecee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fNamecee.setForeground(new java.awt.Color(128, 128, 128));
        fNamecee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fNamecee.setText("First Name");
        jPanel51.add(fNamecee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 20));

        Phonecee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Phonecee.setForeground(new java.awt.Color(128, 128, 128));
        Phonecee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Phonecee.setText("Phone");
        jPanel51.add(Phonecee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 260, 20));

        Emailcee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Emailcee.setForeground(new java.awt.Color(128, 128, 128));
        Emailcee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Emailcee.setText("Email");
        jPanel51.add(Emailcee, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 280, 20));

        crt_emp3.setBackground(new java.awt.Color(0, 102, 255));
        crt_emp3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        jLabel80.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Create Employee");
        jLabel80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel80MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout crt_emp3Layout = new javax.swing.GroupLayout(crt_emp3);
        crt_emp3.setLayout(crt_emp3Layout);
        crt_emp3Layout.setHorizontalGroup(
            crt_emp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        crt_emp3Layout.setVerticalGroup(
            crt_emp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel51.add(crt_emp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 560, 50));

        L_namecee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        L_namecee.setForeground(new java.awt.Color(128, 128, 128));
        L_namecee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        L_namecee.setText("Last Name");
        jPanel51.add(L_namecee, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 220, 20));

        jLabel81.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(128, 128, 128));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Employee ID");
        jPanel51.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 20));

        aaaacee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        aaaacee.setForeground(new java.awt.Color(128, 128, 128));
        aaaacee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aaaacee.setText("Address");
        jPanel51.add(aaaacee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 70, 20));

        firstnamecee.setBackground(new java.awt.Color(255, 255, 255));
        firstnamecee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        firstnamecee.setForeground(new java.awt.Color(128, 128, 128));
        firstnamecee.setText("First Name");
        firstnamecee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        firstnamecee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameceeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstnameceeFocusLost(evt);
            }
        });
        firstnamecee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameceeActionPerformed(evt);
            }
        });
        jPanel51.add(firstnamecee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 30));

        lastnamecee.setBackground(new java.awt.Color(255, 255, 255));
        lastnamecee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lastnamecee.setForeground(new java.awt.Color(128, 128, 128));
        lastnamecee.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lastnamecee.setText("Last Name");
        lastnamecee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        lastnamecee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameceeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastnameceeFocusLost(evt);
            }
        });
        lastnamecee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameceeActionPerformed(evt);
            }
        });
        jPanel51.add(lastnamecee, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 280, 30));

        emailcee.setBackground(new java.awt.Color(255, 255, 255));
        emailcee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        emailcee.setForeground(new java.awt.Color(128, 128, 128));
        emailcee.setText("Email");
        emailcee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        emailcee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailceeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailceeFocusLost(evt);
            }
        });
        jPanel51.add(emailcee, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 280, 30));

        phone3cee.setBackground(new java.awt.Color(255, 255, 255));
        phone3cee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        phone3cee.setForeground(new java.awt.Color(128, 128, 128));
        phone3cee.setText("Phone");
        phone3cee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        phone3cee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phone3ceeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone3ceeFocusLost(evt);
            }
        });
        jPanel51.add(phone3cee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 30));

        Emp_idcee.setBackground(new java.awt.Color(255, 255, 255));
        Emp_idcee.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Emp_idcee.setForeground(new java.awt.Color(0, 0, 0));
        Emp_idcee.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Emp_idcee.setText("123456798");
        Emp_idcee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        Emp_idcee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emp_idceeActionPerformed(evt);
            }
        });
        jPanel51.add(Emp_idcee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, 30));

        addresscee.setBackground(new java.awt.Color(255, 255, 255));
        addresscee.setColumns(10);
        addresscee.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addresscee.setForeground(new java.awt.Color(0, 0, 0));
        addresscee.setRows(5);
        addresscee.setText("Address");
        addresscee.setBorder(null);
        addresscee.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        addresscee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressceeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressceeFocusLost(evt);
            }
        });
        jScrollPane13.setViewportView(addresscee);

        jPanel51.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 560, -1));

        jPanel42.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 600, 750));

        jLabel101.setBackground(new java.awt.Color(255, 255, 255));
        jLabel101.setFont(new java.awt.Font("Georgia", 0, 48)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("Welcome !");
        jLabel101.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel42.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 260, 70));

        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-group (3).png"))); // NOI18N
        jPanel42.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 440, 310));

        jLabel103.setBackground(new java.awt.Color(255, 255, 255));
        jLabel103.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("<Html> <p align = center>  CREATE  <br>   EMPLOYEE</p></Html>");
        jPanel42.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 440, 110));

        mng_id2.setBackground(new java.awt.Color(14, 73, 181));
        mng_id2.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_id2.setForeground(new java.awt.Color(255, 255, 255));
        mng_id2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_id2.setToolTipText("");
        mng_id2.setBorder(null);
        jPanel42.add(mng_id2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 30));

        mng_name2.setBackground(new java.awt.Color(14, 73, 181));
        mng_name2.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_name2.setForeground(new java.awt.Color(255, 255, 255));
        mng_name2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_name2.setToolTipText("");
        mng_name2.setBorder(null);
        jPanel42.add(mng_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 40));

        javax.swing.GroupLayout Create_EmpLayout = new javax.swing.GroupLayout(Create_Emp);
        Create_Emp.setLayout(Create_EmpLayout);
        Create_EmpLayout.setHorizontalGroup(
            Create_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        Create_EmpLayout.setVerticalGroup(
            Create_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );

        body.add(Create_Emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Update_Emp.setBackground(new java.awt.Color(204, 0, 51));

        jPanel52.setBackground(new java.awt.Color(14, 73, 181));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fNameuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fNameuepp.setForeground(new java.awt.Color(128, 128, 128));
        fNameuepp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fNameuepp.setText("First Name");
        jPanel56.add(fNameuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 20));

        Phoneuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Phoneuepp.setForeground(new java.awt.Color(128, 128, 128));
        Phoneuepp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Phoneuepp.setText("Phone");
        jPanel56.add(Phoneuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 260, 20));

        Emailuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Emailuepp.setForeground(new java.awt.Color(128, 128, 128));
        Emailuepp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Emailuepp.setText("Email");
        jPanel56.add(Emailuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 280, 20));

        crt_emp4.setBackground(new java.awt.Color(0, 102, 255));
        crt_emp4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        jLabel104.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Update");
        jLabel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel104MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout crt_emp4Layout = new javax.swing.GroupLayout(crt_emp4);
        crt_emp4.setLayout(crt_emp4Layout);
        crt_emp4Layout.setHorizontalGroup(
            crt_emp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        crt_emp4Layout.setVerticalGroup(
            crt_emp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel56.add(crt_emp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 550, 50));

        L_nameuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        L_nameuepp.setForeground(new java.awt.Color(128, 128, 128));
        L_nameuepp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        L_nameuepp.setText("Last Name");
        jPanel56.add(L_nameuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 220, 20));

        jLabel105.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(128, 128, 128));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel105.setText("Employee ID");
        jPanel56.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, 20));

        aaaauepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        aaaauepp.setForeground(new java.awt.Color(128, 128, 128));
        aaaauepp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aaaauepp.setText("Address");
        jPanel56.add(aaaauepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 70, 20));

        firstnameuepp.setBackground(new java.awt.Color(255, 255, 255));
        firstnameuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        firstnameuepp.setForeground(new java.awt.Color(128, 128, 128));
        firstnameuepp.setText("First Name");
        firstnameuepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        firstnameuepp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameueppFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstnameueppFocusLost(evt);
            }
        });
        jPanel56.add(firstnameuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 260, 30));

        lastnameuepp.setBackground(new java.awt.Color(255, 255, 255));
        lastnameuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lastnameuepp.setForeground(new java.awt.Color(128, 128, 128));
        lastnameuepp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lastnameuepp.setText("Last Name");
        lastnameuepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        lastnameuepp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameueppFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastnameueppFocusLost(evt);
            }
        });
        lastnameuepp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameueppActionPerformed(evt);
            }
        });
        jPanel56.add(lastnameuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 280, 30));

        emailuepp.setBackground(new java.awt.Color(255, 255, 255));
        emailuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        emailuepp.setForeground(new java.awt.Color(128, 128, 128));
        emailuepp.setText("Email");
        emailuepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        emailuepp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailueppFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailueppFocusLost(evt);
            }
        });
        jPanel56.add(emailuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 280, 30));

        phone3uepp.setBackground(new java.awt.Color(255, 255, 255));
        phone3uepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        phone3uepp.setForeground(new java.awt.Color(128, 128, 128));
        phone3uepp.setText("Phone");
        phone3uepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        phone3uepp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phone3ueppFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone3ueppFocusLost(evt);
            }
        });
        jPanel56.add(phone3uepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, 30));

        Emp_iduepp.setBackground(new java.awt.Color(255, 255, 255));
        Emp_iduepp.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Emp_iduepp.setForeground(new java.awt.Color(0, 0, 0));
        Emp_iduepp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Emp_iduepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 204)));
        Emp_iduepp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emp_idueppActionPerformed(evt);
            }
        });
        jPanel56.add(Emp_iduepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 260, 30));

        addressuepp.setBackground(new java.awt.Color(255, 255, 255));
        addressuepp.setColumns(10);
        addressuepp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addressuepp.setForeground(new java.awt.Color(0, 0, 0));
        addressuepp.setRows(5);
        addressuepp.setText("Address");
        addressuepp.setBorder(null);
        addressuepp.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        addressuepp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressueppFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressueppFocusLost(evt);
            }
        });
        jScrollPane14.setViewportView(addressuepp);

        jPanel56.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 550, -1));

        jPanel52.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 610, 450));

        jLabel106.setBackground(new java.awt.Color(255, 255, 255));
        jLabel106.setFont(new java.awt.Font("Georgia", 0, 48)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Welcome !");
        jLabel106.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel52.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 290, 70));

        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update-business-user.png"))); // NOI18N
        jPanel52.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 420, 310));

        jLabel108.setBackground(new java.awt.Color(255, 255, 255));
        jLabel108.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("EMPLOYEE");
        jPanel52.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 410, 50));

        mng_id3.setBackground(new java.awt.Color(14, 73, 181));
        mng_id3.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_id3.setForeground(new java.awt.Color(255, 255, 255));
        mng_id3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_id3.setToolTipText("");
        mng_id3.setBorder(null);
        jPanel52.add(mng_id3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 30));

        mng_name3.setBackground(new java.awt.Color(14, 73, 181));
        mng_name3.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_name3.setForeground(new java.awt.Color(255, 255, 255));
        mng_name3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_name3.setToolTipText("");
        mng_name3.setBorder(null);
        jPanel52.add(mng_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 40));

        jLabel109.setBackground(new java.awt.Color(255, 255, 255));
        jLabel109.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("UPDATE");
        jPanel52.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 410, 50));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 0, 0));
        jLabel110.setText("Update Employee !");
        jPanel57.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, -1));

        serchuepp.setBackground(new java.awt.Color(255, 255, 255));
        serchuepp.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serchuepp.setForeground(new java.awt.Color(128, 128, 128));
        serchuepp.setText("Serch Employee by Employee ID");
        serchuepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serchuepp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serchueppFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serchueppFocusLost(evt);
            }
        });
        jPanel57.add(serchuepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, 30));

        fName1uepp.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName1uepp.setForeground(new java.awt.Color(128, 128, 128));
        fName1uepp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName1uepp.setText("Serch Employee by Employee ID");
        jPanel57.add(fName1uepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 30));

        jLabel2uepp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel2uepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel2uepp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2ueppMouseClicked(evt);
            }
        });
        jPanel57.add(jLabel2uepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 46, 40));

        jPanel52.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 610, 140));

        javax.swing.GroupLayout Update_EmpLayout = new javax.swing.GroupLayout(Update_Emp);
        Update_Emp.setLayout(Update_EmpLayout);
        Update_EmpLayout.setHorizontalGroup(
            Update_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
        );
        Update_EmpLayout.setVerticalGroup(
            Update_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );

        body.add(Update_Emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Delete_Emp.setBackground(new java.awt.Color(0, 0, 255));

        jPanel58.setBackground(new java.awt.Color(14, 73, 181));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crt_emp5.setBackground(new java.awt.Color(0, 102, 255));
        crt_emp5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        jLabel111.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("Delete Employee");
        jLabel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel111MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout crt_emp5Layout = new javax.swing.GroupLayout(crt_emp5);
        crt_emp5.setLayout(crt_emp5Layout);
        crt_emp5Layout.setHorizontalGroup(
            crt_emp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
        crt_emp5Layout.setVerticalGroup(
            crt_emp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel59.add(crt_emp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 570, 50));

        tabledepp.setBackground(new java.awt.Color(255, 255, 255));
        tabledepp.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        tabledepp.setForeground(new java.awt.Color(47, 68, 187));
        tabledepp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Emp Name", "Emp Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabledepp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledeppMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tabledepp);

        jPanel59.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 340));

        jPanel58.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 610, 450));

        jLabel112.setBackground(new java.awt.Color(255, 255, 255));
        jLabel112.setFont(new java.awt.Font("Georgia", 0, 48)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("Welcome !");
        jLabel112.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel58.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 290, 70));

        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-user.png"))); // NOI18N
        jPanel58.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 420, 310));

        jLabel114.setBackground(new java.awt.Color(255, 255, 255));
        jLabel114.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("EMPLOYEE");
        jPanel58.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 410, 50));

        mng_id4.setBackground(new java.awt.Color(14, 73, 181));
        mng_id4.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_id4.setForeground(new java.awt.Color(255, 255, 255));
        mng_id4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_id4.setToolTipText("");
        mng_id4.setBorder(null);
        jPanel58.add(mng_id4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 30));

        mng_name4.setBackground(new java.awt.Color(14, 73, 181));
        mng_name4.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        mng_name4.setForeground(new java.awt.Color(255, 255, 255));
        mng_name4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mng_name4.setToolTipText("");
        mng_name4.setBorder(null);
        jPanel58.add(mng_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 40));

        jLabel115.setBackground(new java.awt.Color(255, 255, 255));
        jLabel115.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("DELETE");
        jPanel58.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 410, 50));

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setBackground(new java.awt.Color(0, 0, 0));
        jLabel116.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 0, 0));
        jLabel116.setText("Delete Employee !");
        jPanel60.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, -1));

        serchdepp.setBackground(new java.awt.Color(255, 255, 255));
        serchdepp.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serchdepp.setForeground(new java.awt.Color(128, 128, 128));
        serchdepp.setText("Serch Employee by Employee ID");
        serchdepp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serchdepp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serchdeppFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serchdeppFocusLost(evt);
            }
        });
        serchdepp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serchdeppKeyReleased(evt);
            }
        });
        jPanel60.add(serchdepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, 30));

        fName1depp.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName1depp.setForeground(new java.awt.Color(128, 128, 128));
        fName1depp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName1depp.setText("Serch Employee by Employee ID");
        jPanel60.add(fName1depp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 30));

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel117.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel117MouseClicked(evt);
            }
        });
        jPanel60.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 46, 40));

        jPanel58.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 610, 140));
        jPanel58.add(eiddepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));
        jPanel58.add(enndepp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 630, -1, -1));

        javax.swing.GroupLayout Delete_EmpLayout = new javax.swing.GroupLayout(Delete_Emp);
        Delete_Emp.setLayout(Delete_EmpLayout);
        Delete_EmpLayout.setHorizontalGroup(
            Delete_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
        );
        Delete_EmpLayout.setVerticalGroup(
            Delete_EmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );

        body.add(Delete_Emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Working_list.setBackground(new java.awt.Color(204, 0, 51));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablewll.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tablewll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service_Id", "Cust_Id", "Cust_Name", "Emp Id", "Emp Name", "Service ", "Date", "Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablewll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablewllMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tablewll);

        jPanel61.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 100, 1130, 590));

        jPanel62.setBackground(new java.awt.Color(0, 153, 0));
        jPanel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel62MouseClicked(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("New");

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 720, -1, -1));

        jPanel63.setBackground(new java.awt.Color(255, 0, 51));
        jPanel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel63MouseClicked(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("Delete");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel119, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 720, -1, -1));

        jPanel64.setBackground(new java.awt.Color(0, 125, 254));

        jLabel120.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("Print");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel120, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, -1, -1));

        stawll.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --", "Pending", "Active", "Complete" }));
        stawll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 125, 254)));
        jPanel61.add(stawll, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 210, 38));

        jPanel65.setBackground(new java.awt.Color(0, 0, 255));
        jPanel65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel65MouseClicked(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("Assign");

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel121, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 720, -1, -1));

        jPanel66.setBackground(new java.awt.Color(153, 0, 204));
        jPanel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel66MouseClicked(evt);
            }
        });

        jLabel122.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("Compleate");

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel122, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 720, -1, -1));

        serchell1.setBackground(new java.awt.Color(255, 255, 255));
        serchell1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        serchell1.setForeground(new java.awt.Color(47, 68, 187));
        serchell1.setText("Serch Customer by Customer ID");
        serchell1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        serchell1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serchell1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serchell1FocusLost(evt);
            }
        });
        serchell1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serchell1KeyReleased(evt);
            }
        });
        jPanel61.add(serchell1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 58, 320, 30));

        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jLabel123.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(47, 68, 187)));
        jLabel123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel123MouseClicked(evt);
            }
        });
        jPanel61.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 48, 46, 40));

        fName1345.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        fName1345.setForeground(new java.awt.Color(47, 68, 187));
        fName1345.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fName1345.setText("Serch Customer by Customer ID");
        jPanel61.add(fName1345, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 390, 30));

        jPanel68.setBackground(new java.awt.Color(0, 153, 0));
        jPanel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel68MouseClicked(evt);
            }
        });

        jLabel125.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Update");

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel125, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 720, -1, -1));

        button1.setLabel("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel61.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 740, -1, -1));
        jPanel61.add(hidetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 70, -1));

        javax.swing.GroupLayout Working_listLayout = new javax.swing.GroupLayout(Working_list);
        Working_list.setLayout(Working_listLayout);
        Working_listLayout.setHorizontalGroup(
            Working_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1178, Short.MAX_VALUE)
            .addGroup(Working_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Working_listLayout.setVerticalGroup(
            Working_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
            .addGroup(Working_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE))
        );

        body.add(Working_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Assign.setBackground(new java.awt.Color(0, 0, 255));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        jLabel124.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(0, 0, 0));
        jLabel124.setText("Date");

        jLabel126.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setText("Time");

        jPanel69.setBackground(new java.awt.Color(0, 125, 254));

        jLabel127.setBackground(new java.awt.Color(0, 125, 254));
        jLabel127.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("Assign For Service");

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
            .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel69Layout.createSequentialGroup()
                    .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        t2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Emp Name --", " " }));
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jLabel128.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 0, 0));
        jLabel128.setText("Select Employee Name");

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 125, 254)));

        td.setBackground(new java.awt.Color(255, 255, 255));
        td.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        td.setForeground(new java.awt.Color(0, 125, 254));
        td.setBorder(null);
        td.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdActionPerformed(evt);
            }
        });

        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user (1).png"))); // NOI18N
        jLabel129.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel129MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(td)
            .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel130.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 0, 0));
        jLabel130.setText("Coustomer Name");

        ascn.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        ascn.setForeground(new java.awt.Color(0, 0, 0));
        ascn.setText("xyz xyz");

        ascph.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        ascph.setForeground(new java.awt.Color(0, 0, 0));
        ascph.setText("xyz xyz");

        jLabel133.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(0, 0, 0));
        jLabel133.setText("Coustomer Mobile No");

        jLabel134.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(0, 0, 0));
        jLabel134.setText("Coustomer Email ID");

        asceml.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        asceml.setForeground(new java.awt.Color(0, 0, 0));
        asceml.setText("xyz xyz");

        jLabel136.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(0, 0, 0));
        jLabel136.setText("Coustomer Address");

        ascad.setBackground(new java.awt.Color(255, 255, 255));
        ascad.setBorder(null);
        ascad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ascad.setForeground(new java.awt.Color(0, 0, 0));
        ascad.setText("xyz xyz xyz");
        jScrollPane8.setViewportView(ascad);

        jLabel137.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(0, 0, 0));
        jLabel137.setText("Service Description");

        ascsd.setBackground(new java.awt.Color(255, 255, 255));
        ascsd.setBorder(null);
        ascsd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ascsd.setForeground(new java.awt.Color(0, 0, 0));
        ascsd.setText("xyz xyz xyz");
        jScrollPane10.setViewportView(ascsd);

        jPanel71.setBackground(new java.awt.Color(0, 102, 51));
        jPanel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel71MouseClicked(evt);
            }
        });

        jLabel138.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel138.setText("Save");

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel138, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanel72.setBackground(new java.awt.Color(0, 125, 254));

        jLabel139.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel139.setText("Print");

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel139, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        ddt.setDateFormatString("dd-MM-yyyy");

        t3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Emp Name --", " " }));

        jLabel131.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 0, 0));
        jLabel131.setText("Select Employee Id");

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel134))
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addComponent(ascn, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(ascph, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(asceml, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8)
                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10)
                    .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel67Layout.createSequentialGroup()
                                .addComponent(ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel67Layout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel126)
                                .addGap(130, 130, 130)
                                .addComponent(jLabel128)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel131)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel124)
                            .addGroup(jPanel67Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel128))))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel131)
                        .addGap(4, 4, 4)
                        .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel130)
                    .addComponent(jLabel133)
                    .addComponent(jLabel134))
                .addGap(6, 6, 6)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ascn)
                    .addComponent(ascph)
                    .addComponent(asceml))
                .addGap(34, 34, 34)
                .addComponent(jLabel136)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel137)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout AssignLayout = new javax.swing.GroupLayout(Assign);
        Assign.setLayout(AssignLayout);
        AssignLayout.setHorizontalGroup(
            AssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AssignLayout.setVerticalGroup(
            AssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        body.add(Assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        Complete.setBackground(new java.awt.Color(204, 0, 51));

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));

        csdd.setForeground(new java.awt.Color(0, 125, 254));
        csdd.setDateFormatString("dd-MM-yyyy");
        csdd.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jLabel132.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(0, 0, 0));
        jLabel132.setText("Date");

        jLabel135.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(0, 0, 0));
        jLabel135.setText("Time");

        jPanel74.setBackground(new java.awt.Color(0, 125, 254));

        jLabel140.setBackground(new java.awt.Color(0, 125, 254));
        jLabel140.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel140.setText("Complete Service");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
            .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
            .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 125, 254)));

        cstt.setBackground(new java.awt.Color(255, 255, 255));
        cstt.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        cstt.setForeground(new java.awt.Color(0, 125, 254));
        cstt.setBorder(null);
        cstt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csttActionPerformed(evt);
            }
        });

        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user (1).png"))); // NOI18N
        jLabel141.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel141MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cstt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(cstt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jLabel142.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(0, 0, 0));
        jLabel142.setText("Coustomer Name");

        cscn.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        cscn.setForeground(new java.awt.Color(0, 0, 0));
        cscn.setText("xyz xyz");

        cscp.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        cscp.setForeground(new java.awt.Color(0, 0, 0));
        cscp.setText("xyz xyz");

        jLabel145.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(0, 0, 0));
        jLabel145.setText("Coustomer Mobile No");

        jLabel146.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(0, 0, 0));
        jLabel146.setText("Coustomer Email ID");

        cseml.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        cseml.setForeground(new java.awt.Color(0, 0, 0));
        cseml.setText("xyz xyz");

        jLabel148.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(0, 0, 0));
        jLabel148.setText("Coustomer Address");

        csad.setBackground(new java.awt.Color(255, 255, 255));
        csad.setBorder(null);
        csad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        csad.setForeground(new java.awt.Color(0, 0, 0));
        csad.setText("xyz xyz xyz");
        jScrollPane20.setViewportView(csad);

        jLabel149.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(0, 0, 0));
        jLabel149.setText("Meterials");

        csmet.setBackground(new java.awt.Color(255, 255, 255));
        csmet.setBorder(null);
        csmet.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        csmet.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane21.setViewportView(csmet);

        jPanel76.setBackground(new java.awt.Color(0, 102, 51));
        jPanel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel76MouseClicked(evt);
            }
        });

        jLabel150.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel150.setText("Save");

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel150, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel150, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        Co.setBackground(new java.awt.Color(0, 125, 254));

        jLabel151.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel151.setText("Print");

        javax.swing.GroupLayout CoLayout = new javax.swing.GroupLayout(Co);
        Co.setLayout(CoLayout);
        CoLayout.setHorizontalGroup(
            CoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel151, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
        );
        CoLayout.setVerticalGroup(
            CoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel151, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        csei.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        csei.setForeground(new java.awt.Color(0, 0, 0));
        csei.setText("xyz xyz");

        jLabel153.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(0, 0, 0));
        jLabel153.setText("Employee Id");

        cssd.setBackground(new java.awt.Color(255, 255, 255));
        cssd.setBorder(null);
        cssd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cssd.setForeground(new java.awt.Color(0, 0, 0));
        cssd.setText("xyz xyz xyz");
        jScrollPane22.setViewportView(cssd);

        jLabel154.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(0, 0, 0));
        jLabel154.setText("Service Description");

        csen.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        csen.setForeground(new java.awt.Color(0, 0, 0));
        csen.setText("xyz xyz");

        jLabel156.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(0, 0, 0));
        jLabel156.setText("Employee Name");

        jLabel157.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(0, 0, 0));
        jLabel157.setText("Cost");

        jLabel158.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(0, 0, 0));
        jLabel158.setText("Coustomer Id");

        csci.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        csci.setForeground(new java.awt.Color(0, 0, 0));
        csci.setText("xyz xyz");

        cscost.setBackground(new java.awt.Color(255, 255, 255));
        cscost.setForeground(new java.awt.Color(0, 0, 0));
        cscost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel132)
                .addGap(280, 280, 280)
                .addComponent(jLabel135))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(csdd, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel153)
                .addGap(213, 213, 213)
                .addComponent(jLabel156)
                .addGap(148, 148, 148)
                .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(csei, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(csen, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cscost, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230)
                .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel146))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(cscn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(csci, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(cscp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(cseml, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Co, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel132)
                    .addComponent(jLabel135))
                .addGap(8, 8, 8)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(csdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel153))
                    .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel157))
                .addGap(2, 2, 2)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(csei, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(csen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cscost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel149)
                    .addComponent(jLabel154))
                .addGap(8, 8, 8)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel142)
                    .addComponent(jLabel158)
                    .addComponent(jLabel145)
                    .addComponent(jLabel146))
                .addGap(6, 6, 6)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cscn)
                    .addComponent(csci)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cscp)
                            .addComponent(cseml))))
                .addGap(30, 30, 30)
                .addComponent(jLabel148)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Co, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout CompleteLayout = new javax.swing.GroupLayout(Complete);
        Complete.setLayout(CompleteLayout);
        CompleteLayout.setHorizontalGroup(
            CompleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CompleteLayout.setVerticalGroup(
            CompleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        body.add(Complete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body12.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body12Layout = new javax.swing.GroupLayout(body12);
        body12.setLayout(body12Layout);
        body12Layout.setHorizontalGroup(
            body12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body12Layout.setVerticalGroup(
            body12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body23.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body23Layout = new javax.swing.GroupLayout(body23);
        body23.setLayout(body23Layout);
        body23Layout.setHorizontalGroup(
            body23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body23Layout.setVerticalGroup(
            body23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body22.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body22Layout = new javax.swing.GroupLayout(body22);
        body22.setLayout(body22Layout);
        body22Layout.setHorizontalGroup(
            body22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body22Layout.setVerticalGroup(
            body22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body21.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body21Layout = new javax.swing.GroupLayout(body21);
        body21.setLayout(body21Layout);
        body21Layout.setHorizontalGroup(
            body21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body21Layout.setVerticalGroup(
            body21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 809, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1482, 866));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        // TODO add your handling code here:
         home.setVisible(true);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        a1.setVisible(true);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);

        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
        Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
        Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        p1.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
        
    }//GEN-LAST:event_p1MouseClicked

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        // TODO add your handling code here:
         a2.setVisible(true);
        a1.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        p2.setBackground(Color.decode("#03A9DD"));
        p1.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
        
        home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(true);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
       
        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
    }//GEN-LAST:event_p2MouseClicked

    private void p3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3MouseClicked
        // TODO add your handling code here:
        a3.setVisible(true);
        a2.setVisible(false);
        a1.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        p3.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p1.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
        
        home.setVisible(false);
        ES.setVisible(true);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
       
        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
    }//GEN-LAST:event_p3MouseClicked

    private void p4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4MouseClicked
        // TODO add your handling code here:
        a4.setVisible(true);
        a2.setVisible(false);
        a3.setVisible(false);
        a1.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        p4.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p1.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(true);
        SM.setVisible(false);
        MP.setVisible(false);
       
        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
    }//GEN-LAST:event_p4MouseClicked

    private void p5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseClicked
        // TODO add your handling code here:
        a5.setVisible(true);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a1.setVisible(false);
        a6.setVisible(false);
        p5.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p1.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
        home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(true);
        MP.setVisible(false);
       
        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
    }//GEN-LAST:event_p5MouseClicked

    private void p6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p6MouseClicked
        // TODO add your handling code here:
        a6.setVisible(true);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a1.setVisible(false);
        p6.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p1.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(true);
        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
    }//GEN-LAST:event_p6MouseClicked

    private void p7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p7MouseClicked
        // TODO add your handling code here:
        p7.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p1.setBackground(Color.decode("#333333"));
        a1.setVisible(true);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(true);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        Cus_List.setVisible(false);
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
        
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_p7MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        //  this.showForm(new Add_Employee());

        //        main.showForm(new Working_list());
        //        main.setVisible(true);

    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel23KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel23KeyPressed

    private void serchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchFocusGained
        if(serch.getText().equals("Serch Customer by Customer ID")){
            fName1.setVisible(true);
            serch.setText("");
            serch.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serchFocusGained

    private void serchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchFocusLost
        // TODO add your handling code here:
        if(serch.getText().equals("")){
            fName1.setVisible(false);
            serch.setText("Serch Customer by Customer ID");
            serch.setForeground( Color.decode("#2f44bb"));
        }else{
            fName1.setVisible(true);
        }
    }//GEN-LAST:event_serchFocusLost

    private void serchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchKeyReleased
        // TODO add your handling code here:
        String product_idee = serch.getText();
        try {

            //Data fetch from database
            String sql = "Select * From cus where cus_id like '%"+product_idee+"%' or cus_fname like '%"+product_idee+"%' or cus_lname like '%"+product_idee+"%' or cus_eml like '%"+product_idee+"%'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tablesc.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                    String name = rs.getString("cus_fname")+" "+rs.getString("cus_lname");
                    Object o []={
                        rs.getString("cus_id"),name,rs.getString("cus_ph"),rs.getString("cus_eml"),rs.getString("cus_adde") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Customer Not Found").setVisible(true);
                //   JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_serchKeyReleased

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:

        String em_id = serch.getText();
        //        try {
            //
            //            //Data fetch from database
            //            String sql = "Select * From cus Where cus_id = '"+em_id+"'";
            //            Connection con=DATABASE_CONNECTION.getConnection();
            //            PreparedStatement ps=con.prepareStatement(sql);
            //            //  ps.setString(1,"ERP_E1002");
            //            ResultSet rs=ps.executeQuery();
            //            if(rs.next()){
                //                //                String emp_id =rs.getString("emp_id");
                //                //                String f_name =rs.getString("emp_fname");
                //                //                // System.out.println("EMpppppp "+f_name);
                //                //                String l_name =rs.getString("emp_lname");
                //                //                // System.out.println("pppnnn "+l_name);
                //                //                String Phone =rs.getString("emp_phone");
                //                //
                //                //                String Email =rs.getString("emp_email");
                //                //                // System.out.println("emlllll "+l_name);
                //                //                String Address =rs.getString("emp_address");
                //
                //                // JOptionPane.showMessageDialog(this, "Product Found");
                //
                //                rs.close();
                //                ps.close();
                //            }else{
                //                new Warning("Enter Correct Employee Id").setVisible(true);
                //                // System.out.println("Enter Correct Employee Id");
                //            }
            //        }catch(Exception e){
            //            System.out.println("error"+e);
            //        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
       fName1.setVisible(false);
        table();
        
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
    
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);

              
                Cus_List.setVisible(true);
                // Cus_List.setVisible(true);
               // body.setVisible(false);
               
//                body.add(new Cus_LIst());
//                body.repaint();
//                body.revalidate();
        
        
    }//GEN-LAST:event_jPanel3MouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:

        int i = table1.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)table1.getModel();
        // String aa=model.getValueAt(i,0).toString();
        String bb=model.getValueAt(i,0).toString();
        // System.out.println("id"+bb +" name"+aa);
        try {

            //Data fetch from database
            String sql = "Select * From emp_works where cous_id='"+bb+"' ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next())
            {
                // String name = rs.getString("emp_id")+" "+rs.getString("emp_lname");

                String ttf1= rs.getString("service_dtl");
                ttf.setText(ttf1);

            }
        }catch(Exception e){
            System.out.println("error"+e);
        }

    }//GEN-LAST:event_table1MouseClicked

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // TODO add your handling code here:

        int i = table2.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)table2.getModel();
        // String aa=model.getValueAt(i,0).toString();
        String bb=model.getValueAt(i,1).toString();
        // System.out.println("id"+bb +" name"+aa);
        try {

            //Data fetch from database
            String sql = "Select * From emp_works where cous_id='"+bb+"' ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model1 =(DefaultTableModel)table1.getModel();
            model1.setRowCount(0);
            if (rs.next()){
                do{

                    // String name = rs.getString("emp_id")+" "+rs.getString("emp_lname");
                    Object o []={
                        rs.getString("cous_id"),rs.getString("cous_name"),rs.getString("emp_id"),rs.getString("emp_name"),rs.getString("date"),rs.getString("time"),rs.getString("service_dtl") };
                    model1.addRow(o);

                }while (rs.next());
            }else{
                new Warning("No record Found").setVisible(true);

            }
        }catch(Exception e){
            System.out.println("error"+e);
        }

    }//GEN-LAST:event_table2MouseClicked

    private void serch1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serch1FocusGained
        if(serch1.getText().equals("Serch Customer by Customer ID")){
            fName2.setVisible(true);
            serch1.setText("");
            serch1.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serch1FocusGained

    private void serch1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serch1FocusLost
        // TODO add your handling code here:
        if(serch1.getText().equals("")){
            fName2.setVisible(false);
            serch1.setText("Serch Customer by Customer ID");
            serch1.setForeground(new Color(128,128,128));
        }else{
            fName2.setVisible(true);
        }
    }//GEN-LAST:event_serch1FocusLost

    private void serch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serch1KeyReleased
        // TODO add your handling code here:

        String product_idee = serch.getText();
        try {

            //Data fetch from database
            String sql = "Select * From cus where cus_id like '%"+product_idee+"%' or cus_fname like '%"+product_idee+"%' or cus_lname like '%"+product_idee+"%' or cus_eml like '%"+product_idee+"%'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tablesc.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                    String name = rs.getString("cus_fname")+" "+rs.getString("cus_lname");
                    Object o []={
                        name,rs.getString("cus_id") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Customer Not Found").setVisible(true);
                //   JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_serch1KeyReleased

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:

        //        String em_id = serch.getText();
        //        try {
            //
            //            //Data fetch from database
            //            String sql = "Select * From emp Where emp_id = '"+em_id+"'";
            //            Connection con=DATABASE_CONNECTION.getConnection();
            //            PreparedStatement ps=con.prepareStatement(sql);
            //            //  ps.setString(1,"ERP_E1002");
            //            ResultSet rs=ps.executeQuery();
            //            if(rs.next()){
                //                String emp_id =rs.getString("emp_id");
                //                String f_name =rs.getString("emp_fname");
                //                // System.out.println("EMpppppp "+f_name);
                //                String l_name =rs.getString("emp_lname");
                //                // System.out.println("pppnnn "+l_name);
                //                String Phone =rs.getString("emp_phone");
                //
                //                String Email =rs.getString("emp_email");
                //                // System.out.println("emlllll "+l_name);
                //                String Address =rs.getString("emp_address");
                //
                ////                firstname.setText(f_name);
                ////
                ////                lastname.setText(l_name);
                ////
                ////                phone3.setText(Phone);
                ////                Emp_id.setText(emp_id);
                ////                email.setText(Email);
                ////                address.setText(Address);
                //
                //                // JOptionPane.showMessageDialog(this, "Product Found");
                //
                //                rs.close();
                //                ps.close();
                //            }else{
                //                new Warning("Enter Correct Employee Id").setVisible(true);
                //                // System.out.println("Enter Correct Employee Id");
                //            }
            //        }catch(Exception e){
            //            System.out.println("error"+e);
            //        }
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        
        
         table1();
        
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(true);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
     
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);

              
                Cus_List.setVisible(false);
        
        
    }//GEN-LAST:event_jPanel8MouseClicked

    private void serch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serch1ActionPerformed

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
        
        id_create();
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(true);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
       
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        // TODO add your handling code here:
        
        String fName = firstname.getText();
        String lName = lastname.getText();
        String ph = phone3.getText();
        String mail = email.getText();

        String add = address.getText();
        String empp=Emp_id.getText();
       

        if(fName.equals("First Name")||lName.equals("Last Name")||ph.equals("Phone")||mail.equals("Email")||add.equals("Address")||fName.equals("")||lName.equals("")||ph.equals("")||mail.equals("")||add.equals("")){
            // JOptionPane.showMessageDialog(this, "");
            new Warning("Fill up all field first").setVisible(true);
        }else{
            int i = ADD_NEW_EMP_DATAOBEJECT.create_cus (fName, lName, mail, ph,empp, add);

            int j = ID_STORE_FETCH.cus_id(cus_id.toString());
            if(i>0 || j>0){
                System.out.println("Data inserted");
                Succes su= new Succes();
                su.ot("Customer Created Succesfully");
                su.setVisible(true);

                firstname.setText("");
                lastname.setText("");
                phone3.setText("");
                email.setText("");

                address.setText("");

            }else{
                //  System.out.println("Data NOT inserted");
                new Error("Please Try Again!").setVisible(true);
            }

        }
    }//GEN-LAST:event_jLabel54MouseClicked

    private void firstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusGained
        // TODO add your handling code here:
        if(firstname.getText().equals("First Name")){
            fName.setVisible(true);
            firstname.setText("");
            firstname.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_firstnameFocusGained

    private void firstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusLost
        // TODO add your handling code here:
        if(firstname.getText().equals("")){
            fName.setVisible(false);
            firstname.setText("First Name");
            firstname.setForeground(new Color(128,128,128));
        }else{
            fName.setVisible(true);
        }
    }//GEN-LAST:event_firstnameFocusLost

    private void lastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameFocusGained
        // TODO add your handling code here:
        if(lastname.getText().equals("Last Name")){
            L_name.setVisible(true);
            lastname.setText("");
            lastname.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_lastnameFocusGained

    private void lastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameFocusLost
        // TODO add your handling code here:
        if(lastname.getText().equals("")){
            L_name.setVisible(false);
            lastname.setText("Last Name");
            lastname.setForeground(new Color(128,128,128));
        }else{
            L_name.setVisible(true);
        }
    }//GEN-LAST:event_lastnameFocusLost

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        // TODO add your handling code here:
        if(email.getText().equals("Email")){
            Email.setVisible(true);
            email.setText("");
            email.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:
        if(email.getText().equals("")){
            Email.setVisible(false);
            email.setText("Email");
            email.setForeground(new Color(128,128,128));
        }else{
            Email.setVisible(true);
        }
    }//GEN-LAST:event_emailFocusLost

    private void phone3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone3FocusGained
        // TODO add your handling code here:
        if(phone3.getText().equals("Phone")){
            Phone.setVisible(true);
            phone3.setText("");
            phone3.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_phone3FocusGained

    private void phone3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone3FocusLost
        // TODO add your handling code here:
        if(phone3.getText().equals("")){
            Phone.setVisible(false);
            phone3.setText("Phone");
            phone3.setForeground(new Color(128,128,128));
        }else{
            Phone.setVisible(true);
        }
    }//GEN-LAST:event_phone3FocusLost

    private void Emp_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Emp_idActionPerformed

    private void addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusGained
        // TODO add your handling code here:
        if(address.getText().equals("Address")){
            addrr.setVisible(true);
            address.setText("");
            address.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_addressFocusGained

    private void addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusLost
        // TODO add your handling code here:
        if(address.getText().equals("")){
            addrr.setVisible(false);
            address.setText("Address");
            address.setForeground(new Color(128,128,128));
        }else{
            addrr.setVisible(true);
        }
    }//GEN-LAST:event_addressFocusLost

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
        // TODO add your handling code here:
        String fName = firstname1.getText();
        String lName = lastname1.getText();
        String ph = phone4.getText();
        String mail = email1.getText();

        String add = address1.getText();
        String empp= Emp_id1.getText();
      

        if(fName.equals("First Name")||lName.equals("Last Name")||ph.equals("Phone")||mail.equals("Email")||add.equals("Address")||fName.equals("")||lName.equals("")||ph.equals("")||mail.equals("")||add.equals("")){
            // JOptionPane.showMessageDialog(this, "");
            new Warning("Fill up all field first").setVisible(true);
        }else{

            int i=0;
            try{
                Connection con=DATABASE_CONNECTION.getConnection();
                PreparedStatement ps=con.prepareStatement("UPDATE `cus` SET `cus_fname`='"+fName+"',`cus_lname`='"+lName+"',`cus_ph`='"+ph+"',`cus_eml`='"+mail+"',`cus_adde`='"+add+"' where cus_id ='"+empp+"'");
                i=ps.executeUpdate();
                con.close();
            }catch(Exception e){
                System.out.println(e);
            }
            // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+i);

            if(i>0){
                Succes su=new Succes();
                su.ot("Customer Profile Update Sucessfully ");
                su.setVisible(true);

                // JOptionPane.showMessageDialog(this, "Employee Profile Update Sucessfully ");

            }else{
                new Error("Please Try Again").setVisible(true);
                // JOptionPane.showMessageDialog(this, "Employee Profile Not Update Sucessfully");
            }
        }
    }//GEN-LAST:event_jLabel59MouseClicked

    private void firstname1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname1FocusGained
        // TODO add your handling code here:
        if(firstname1.getText().equals("First Name")){
            fName4.setVisible(true);
            firstname1.setText("");
            firstname1.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_firstname1FocusGained

    private void firstname1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname1FocusLost
        // TODO add your handling code here:
        if(firstname1.getText().equals("")){
            fName4.setVisible(false);
            firstname1.setText("First Name");
            firstname1.setForeground(new Color(128,128,128));
        }else{
            fName4.setVisible(true);
        }
    }//GEN-LAST:event_firstname1FocusLost

    private void lastname1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastname1FocusGained
        // TODO add your handling code here:
        if(lastname1.getText().equals("Last Name")){
            L_name1.setVisible(true);
            lastname1.setText("");
            lastname1.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_lastname1FocusGained

    private void lastname1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastname1FocusLost
        // TODO add your handling code here:
        if(lastname1.getText().equals("")){
            L_name1.setVisible(false);
            lastname1.setText("Last Name");
            lastname1.setForeground(new Color(128,128,128));
        }else{
            L_name1.setVisible(true);
        }
    }//GEN-LAST:event_lastname1FocusLost

    private void lastname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname1ActionPerformed

    private void email1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusGained
        // TODO add your handling code here:
        if(email1.getText().equals("Email")){
            Email1.setVisible(true);
            email1.setText("");
            email1.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_email1FocusGained

    private void email1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusLost
        // TODO add your handling code here:
        if(email1.getText().equals("")){
            Email1.setVisible(false);
            email1.setText("Email");
            email1.setForeground(new Color(128,128,128));
        }else{
            Email1.setVisible(true);
        }
    }//GEN-LAST:event_email1FocusLost

    private void phone4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone4FocusGained
        // TODO add your handling code here:
        if(phone4.getText().equals("Phone")){
            Phone1.setVisible(true);
            phone4.setText("");
            phone4.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_phone4FocusGained

    private void phone4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone4FocusLost
        // TODO add your handling code here:
        if(phone4.getText().equals("")){
            Phone1.setVisible(false);
            phone4.setText("Phone");
            phone4.setForeground(new Color(128,128,128));
        }else{
            Phone1.setVisible(true);
        }
    }//GEN-LAST:event_phone4FocusLost

    private void Emp_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Emp_id1ActionPerformed

    private void address1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address1FocusGained
        // TODO add your handling code here:
        if(address1.getText().equals("Address")){
            aaaa.setVisible(true);
            address1.setText("");
            address1.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_address1FocusGained

    private void address1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address1FocusLost
        // TODO add your handling code here:
        if(address1.getText().equals("")){
            aaaa.setVisible(false);
            address1.setText("Address");
            address1.setForeground(new Color(128,128,128));
        }else{
            aaaa.setVisible(true);
        }
    }//GEN-LAST:event_address1FocusLost

    private void serch2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serch2FocusGained
        if(serch2.getText().equals("Serch Customer by Customer ID")){
            fName5.setVisible(true);
            serch2.setText("");
            serch2.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serch2FocusGained

    private void serch2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serch2FocusLost
        // TODO add your handling code here:
        if(serch2.getText().equals("")){
            fName5.setVisible(false);
            serch2.setText("Serch Customer by Customer ID");
            serch2.setForeground(new Color(128,128,128));
        }else{
            fName5.setVisible(true);
        }
    }//GEN-LAST:event_serch2FocusLost

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        // TODO add your handling code here:

        String em_id = serch2.getText();
        try {

            //Data fetch from database
            String sql = "Select * From cus Where cus_id = '"+em_id+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            //  ps.setString(1,"ERP_E1002");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String emp_id =rs.getString("cus_id");
                String f_name =rs.getString("cus_fname");
                // System.out.println("EMpppppp "+f_name);
                String l_name =rs.getString("cus_lname");
                // System.out.println("pppnnn "+l_name);
                String Phone =rs.getString("cus_ph");

                String Email =rs.getString("cus_eml");
                // System.out.println("emlllll "+l_name);
                String Address =rs.getString("cus_adde");
                String sev =rs.getString("cus_servic");
                firstname1.setText(f_name);

                lastname1.setText(l_name);

                phone4.setText(Phone);
                Emp_id1.setText(emp_id);
                email1.setText(Email);
                address1.setText(Address);
              

                // JOptionPane.showMessageDialog(this, "Product Found");

                rs.close();
                ps.close();
            }else{
                new Warning("Enter Correct Customer Id").setVisible(true);
                // System.out.println("Enter Correct Employee Id");
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_jLabel66MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
               fName5.setVisible(false);

         fName4.setVisible(false);
        L_name1.setVisible(false);
        Phone1.setVisible(false);
        Email1.setVisible(false);
       
               aaaa.setVisible(false);

        Emp_id1.setEditable(false);
        
        
       
        
        
       a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(true);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
      
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
        
        
        //System.out.println("empp"+Epp);
        if(Epp!=""){
        update();
        }
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
        // TODO add your handling code here:
        String pnn=enn.getText();
        String rea=eid11.getText();
        if (rea.equals("")){

            new Warning("Click Table row To Delete").setVisible(true);
            // JOptionPane.showMessageDialog(this, "Click Table row To Delete");
        }else {
            eid11.setText("");
            int Yes = JOptionPane.showConfirmDialog(null, "Are Your Sure Want to Remove Customer "+pnn+" ?");
            if(Yes == 0){

                try{

                    String sql="delete from cus where cus_id = '"+rea+"'";
                    Connection con=DATABASE_CONNECTION.getConnection();
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.execute();
                    // ResultSet rs=ps.executeQuery();
                    // ps.setString(1,idd);

                    ps.close();
                    con.close();

                    table();
                    Succes su = new Succes();
                    su.ot("Delete Customer Succesfully");
                    su.setVisible(true);
                    //  JOptionPane.showMessageDialog(this, "Delete Product Succesfully");

                }catch(Exception exe){
                    System.out.println("exxxx"+exe);

                }
            }else{
                int No = 0;
                if(No==0){

                }
            }
        }

    }//GEN-LAST:event_jLabel67MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int i = table.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        String bb=model.getValueAt(i,0).toString();
        String aa= model.getValueAt(i,1).toString();
        //  System.out.println("id"+bb +" name"+aa);
        enn.setText(aa);
        eid11.setText(bb);
    }//GEN-LAST:event_tableMouseClicked

    private void serch3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serch3FocusGained
        if(serch3.getText().equals("Serch Customer by Customer ID")){
            fName6.setVisible(true);
            serch3.setText("");
            serch3.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serch3FocusGained

    private void serch3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serch3FocusLost
        // TODO add your handling code here:
        if(serch3.getText().equals("")){
            fName6.setVisible(false);
            serch3.setText("Serch Customer by Customer ID");
            serch3.setForeground(new Color(128,128,128));
        }else{
            fName6.setVisible(true);
        }
    }//GEN-LAST:event_serch3FocusLost

    private void serch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serch3ActionPerformed

    private void serch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serch3KeyReleased
        // TODO add your handling code here:
        String product_idee = serch3.getText();
        try {

            //Data fetch from database
            String sql = "Select * From cus where cus_id like '%"+product_idee+"%' or cus_fname like '%"+product_idee+"%' or cus_lname like '%"+product_idee+"%' or cus_eml like '%"+product_idee+"%'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)table.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                    String name = rs.getString("cus_fname")+" "+rs.getString("cus_lname");
                    Object o []={
                        rs.getString("cus_id"),name,rs.getString("cus_adde") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Customer Not Found").setVisible(true);

                // JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_serch3KeyReleased

    private void jLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseClicked
        // TODO add your handling code here:

        //        String em_id = serch.getText();
        //        try {
            //
            //            //Data fetch from database
            //            String sql = "Select * From cus Where cus_id = '"+em_id+"'";
            //            Connection con=DATABASE_CONNECTION.getConnection();
            //            PreparedStatement ps=con.prepareStatement(sql);
            //            //  ps.setString(1,"ERP_E1002");
            //            ResultSet rs=ps.executeQuery();
            //            if(rs.next()){
                ////                String emp_id =rs.getString("emp_id");
                ////                String f_name =rs.getString("emp_fname");
                ////                // System.out.println("EMpppppp "+f_name);
                ////                String l_name =rs.getString("emp_lname");
                ////                // System.out.println("pppnnn "+l_name);
                ////                String Phone =rs.getString("emp_phone");
                ////
                ////                String Email =rs.getString("emp_email");
                ////                // System.out.println("emlllll "+l_name);
                ////                String Address =rs.getString("emp_address");
                //
                //
                //
                //                // JOptionPane.showMessageDialog(this, "Product Found");
                //
                //                rs.close();
                //                ps.close();
                //            }else{
                //                new Warning("Enter Correct Employee Id").setVisible(true);
                //                // System.out.println("Enter Correct Employee Id");
                //            }
            //        }catch(Exception e){
            //            System.out.println("error"+e);
            //        }
    }//GEN-LAST:event_jLabel73MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
        table3();
         eid11.setVisible(false);
        enn.setVisible(false);
       fName6.setVisible(false);
       
       
       a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(true);
        body12.setVisible(false);
        Assign.setVisible(false);
     
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        // TODO add your handling code here:
        //  this.showForm(new Add_Employee());

    }//GEN-LAST:event_jLabel77MouseClicked

    private void serchellFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchellFocusGained
        if(serchell.getText().equals("Serch Employee by Employee ID")){
            fName1344.setVisible(true);
            serchell.setText("");
            serchell.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serchellFocusGained

    private void serchellFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchellFocusLost
        // TODO add your handling code here:
        if(serchell.getText().equals("")){
            fName1344.setVisible(false);
            serchell.setText("Serch Employee by Employee ID");
            serchell.setForeground( Color.decode("#2f44bb"));
        }else{
            fName1344.setVisible(true);
        }
    }//GEN-LAST:event_serchellFocusLost

    private void serchellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchellKeyReleased
        // TODO add your handling code here:
        String product_idee = serchell.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp where emp_id like '%"+product_idee+"%' or emp_fname like '%"+product_idee+"%' or emp_lname like '%"+product_idee+"%' or emp_email like '%"+product_idee+"%'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tableell.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                    String name = rs.getString("emp_fname")+" "+rs.getString("emp_lname");
                    Object o []={
                        rs.getString("emp_id"),name,rs.getString("emp_phone"),rs.getString("emp_email"),rs.getString("emp_address") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Employee Not Found").setVisible(true);
                //   JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_serchellKeyReleased

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        // TODO add your handling code here:

        String em_id = serchell.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp Where emp_id = '"+em_id+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            //  ps.setString(1,"ERP_E1002");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                //                String emp_id =rs.getString("emp_id");
                //                String f_name =rs.getString("emp_fname");
                //                // System.out.println("EMpppppp "+f_name);
                //                String l_name =rs.getString("emp_lname");
                //                // System.out.println("pppnnn "+l_name);
                //                String Phone =rs.getString("emp_phone");
                //
                //                String Email =rs.getString("emp_email");
                //                // System.out.println("emlllll "+l_name);
                //                String Address =rs.getString("emp_address");

                // JOptionPane.showMessageDialog(this, "Product Found");

                rs.close();
                ps.close();
            }else{
                new Warning("Enter Correct Employee Id").setVisible(true);
                // System.out.println("Enter Correct Employee Id");
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_jLabel78MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
        fName1344.setVisible(false);
        tableell();
        
           a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        Assign.setVisible(false);
       
        Emp_List.setVisible(true);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
        
    }//GEN-LAST:event_jPanel19MouseClicked

    private void table1seeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1seeMouseClicked
        // TODO add your handling code here:

        int i = table1see.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)table1see.getModel();
        // String aa=model.getValueAt(i,0).toString();
        String bb=model.getValueAt(i,0).toString();
        // System.out.println("id"+bb +" name"+aa);
        try {

            //Data fetch from database
            String sql = "Select * From emp_works where emp_id='"+bb+"' ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next())
            {
                // String name = rs.getString("emp_id")+" "+rs.getString("emp_lname");

                String ttf1= rs.getString("service_dtl");
                ttfsee.setText(ttf1);

            }
        }catch(Exception e){
            System.out.println("error"+e);
        }

    }//GEN-LAST:event_table1seeMouseClicked

    private void tableseeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableseeMouseClicked
        // TODO add your handling code here:

        int i = tablesee.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)tablesee.getModel();
        // String aa=model.getValueAt(i,0).toString();
        String bb=model.getValueAt(i,1).toString();
        // System.out.println("id"+bb +" name"+aa);
        try {

            //Data fetch from database
            String sql = "Select * From emp_works where emp_id='"+bb+"' ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model1 =(DefaultTableModel)table1see.getModel();
            model1.setRowCount(0);
            if (rs.next()){
                do{

                    // String name = rs.getString("emp_id")+" "+rs.getString("emp_lname");
                    Object o []={
                        rs.getString("emp_id"),rs.getString("emp_name"),rs.getString("cous_id"),rs.getString("cous_name"),rs.getString("date"),rs.getString("time"),rs.getString("service_dtl") };
                    model1.addRow(o);

                }while (rs.next());
            }else{
                new Warning("No record Found").setVisible(true);

            }
        }catch(Exception e){
            System.out.println("error"+e);
        }

    }//GEN-LAST:event_tableseeMouseClicked

    private void serchseeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchseeFocusGained
        if(serchsee.getText().equals("Serch Employee by Employee ID")){
            fNamesepp.setVisible(true);
            serchsee.setText("");
            serchsee.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serchseeFocusGained

    private void serchseeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchseeFocusLost
        // TODO add your handling code here:
        if(serchsee.getText().equals("")){
            fNamesepp.setVisible(false);
            serchsee.setText("Serch Employee by Employee ID");
            serchsee.setForeground(new Color(128,128,128));
        }else{
            fNamesepp.setVisible(true);
        }
    }//GEN-LAST:event_serchseeFocusLost

    private void serchseeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchseeKeyReleased
        // TODO add your handling code here:

        String product_idee = serchsee.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp where emp_id like '%"+product_idee+"%' or emp_fname like '%"+product_idee+"%' or emp_lname like '%"+product_idee+"%' or emp_email like '%"+product_idee+"%'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tablesee.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                    String name = rs.getString("emp_fname")+" "+rs.getString("emp_lname");
                    Object o []={
                        name,rs.getString("emp_id") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Employee Not Found").setVisible(true);
                //   JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_serchseeKeyReleased

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        // TODO add your handling code here:

        //        String em_id = serch.getText();
        //        try {
            //
            //            //Data fetch from database
            //            String sql = "Select * From emp Where emp_id = '"+em_id+"'";
            //            Connection con=DATABASE_CONNECTION.getConnection();
            //            PreparedStatement ps=con.prepareStatement(sql);
            //            //  ps.setString(1,"ERP_E1002");
            //            ResultSet rs=ps.executeQuery();
            //            if(rs.next()){
                //                String emp_id =rs.getString("emp_id");
                //                String f_name =rs.getString("emp_fname");
                //                // System.out.println("EMpppppp "+f_name);
                //                String l_name =rs.getString("emp_lname");
                //                // System.out.println("pppnnn "+l_name);
                //                String Phone =rs.getString("emp_phone");
                //
                //                String Email =rs.getString("emp_email");
                //                // System.out.println("emlllll "+l_name);
                //                String Address =rs.getString("emp_address");
                //
                ////                firstname.setText(f_name);
                ////
                ////                lastname.setText(l_name);
                ////
                ////                phone3.setText(Phone);
                ////                Emp_id.setText(emp_id);
                ////                email.setText(Email);
                ////                address.setText(Address);
                //
                //                // JOptionPane.showMessageDialog(this, "Product Found");
                //
                //                rs.close();
                //                ps.close();
                //            }else{
                //                new Warning("Enter Correct Employee Id").setVisible(true);
                //                // System.out.println("Enter Correct Employee Id");
                //            }
            //        }catch(Exception e){
            //            System.out.println("error"+e);
            //        }
    }//GEN-LAST:event_jLabel82MouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        // TODO add your handling code here:
          ttfsee.setEditable(false);
        tablesepp();
        fNamesepp.setVisible(false);
        
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(true);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jLabel80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseClicked
        // TODO add your handling code here:
        String fName = firstnamecee.getText();
        String lName = lastnamecee.getText();
        String ph = phone3cee.getText();
        String mail = emailcee.getText();

        String add = addresscee.getText();
        String empp=Emp_idcee.getText();

        if(fName.equals("First Name")||lName.equals("Last Name")||ph.equals("Phone")||mail.equals("Email")||add.equals("Address")||fName.equals("")||lName.equals("")||ph.equals("")||mail.equals("")||add.equals("")){
            // JOptionPane.showMessageDialog(this, "");
            new Warning("Fill up all field first").setVisible(true);
        }else{
            int i = ADD_NEW_EMP_DATAOBEJECT.create_emp(fName, lName, mail, ph,empp, add);

            int j = ID_STORE_FETCH.insert_id(emp_idcee.toString());
            if(i>0 || j>0){
                System.out.println("Data inserted");
                Succes su= new Succes();
                su.ot("Employee Created Succesfully");
                su.setVisible(true);

                firstnamecee.setText("");
                lastnamecee.setText("");
                phone3cee.setText("");
                emailcee.setText("");

                addresscee.setText("");

            }else{
                //  System.out.println("Data NOT inserted");
                new Error("Please Try Again!").setVisible(true);
            }

        }
    }//GEN-LAST:event_jLabel80MouseClicked

    private void firstnameceeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameceeFocusGained
        // TODO add your handling code here:
        if(firstnamecee.getText().equals("First Name")){
            fNamecee.setVisible(true);
            firstnamecee.setText("");
            firstnamecee.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_firstnameceeFocusGained

    private void firstnameceeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameceeFocusLost
        // TODO add your handling code here:
        if(firstnamecee.getText().equals("")){
            fNamecee.setVisible(false);
            firstnamecee.setText("First Name");
            firstnamecee.setForeground(new Color(128,128,128));
        }else{
            fNamecee.setVisible(true);
        }
    }//GEN-LAST:event_firstnameceeFocusLost

    private void firstnameceeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameceeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameceeActionPerformed

    private void lastnameceeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameceeFocusGained
        // TODO add your handling code here:
        if(lastnamecee.getText().equals("Last Name")){
            L_namecee.setVisible(true);
            lastnamecee.setText("");
            lastnamecee.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_lastnameceeFocusGained

    private void lastnameceeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameceeFocusLost
        // TODO add your handling code here:
        if(lastnamecee.getText().equals("")){
            L_namecee.setVisible(false);
            lastnamecee.setText("Last Name");
            lastnamecee.setForeground(new Color(128,128,128));
        }else{
            L_namecee.setVisible(true);
        }
    }//GEN-LAST:event_lastnameceeFocusLost

    private void lastnameceeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameceeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameceeActionPerformed

    private void emailceeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailceeFocusGained
        // TODO add your handling code here:
        if(emailcee.getText().equals("Email")){
            Emailcee.setVisible(true);
            emailcee.setText("");
            emailcee.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_emailceeFocusGained

    private void emailceeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailceeFocusLost
        // TODO add your handling code here:
        if(emailcee.getText().equals("")){
            Emailcee.setVisible(false);
            emailcee.setText("Email");
            emailcee.setForeground(new Color(128,128,128));
        }else{
            Emailcee.setVisible(true);
        }
    }//GEN-LAST:event_emailceeFocusLost

    private void phone3ceeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone3ceeFocusGained
        // TODO add your handling code here:
        if(phone3cee.getText().equals("Phone")){
            Phonecee.setVisible(true);
            phone3cee.setText("");
            phone3cee.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_phone3ceeFocusGained

    private void phone3ceeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone3ceeFocusLost
        // TODO add your handling code here:
        if(phone3cee.getText().equals("")){
            Phonecee.setVisible(false);
            phone3cee.setText("Phone");
            phone3cee.setForeground(new Color(128,128,128));
        }else{
            Phonecee.setVisible(true);
        }
    }//GEN-LAST:event_phone3ceeFocusLost

    private void Emp_idceeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_idceeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Emp_idceeActionPerformed

    private void addressceeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressceeFocusGained
        // TODO add your handling code here:
        if(addresscee.getText().equals("Address")){
            aaaacee.setVisible(true);
            addresscee.setText("");
            addresscee.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_addressceeFocusGained

    private void addressceeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressceeFocusLost
        // TODO add your handling code here:
        if(addresscee.getText().equals("")){
            aaaacee.setVisible(false);
            addresscee.setText("Address");
            addresscee.setForeground(new Color(128,128,128));
        }else{
            aaaacee.setVisible(true);
        }
    }//GEN-LAST:event_addressceeFocusLost

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        // TODO add your handling code here:
        
         a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(true);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
        
        
        id_createcee();
        
          fNamecee.setVisible(false);
        L_namecee.setVisible(false);
        Phonecee.setVisible(false);
        Emailcee.setVisible(false);
      
        mng_name.setEditable(false);
        mng_id.setEditable(false);
        Emp_idcee.setEditable(false);
         aaaacee.setVisible(false);
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jLabel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseClicked
        // TODO add your handling code here:
        String fName = firstnameuepp.getText();
        String lName = lastnameuepp.getText();
        String ph = phone3uepp.getText();
        String mail = emailuepp.getText();

        String add = addressuepp.getText();
        String empp= Emp_iduepp.getText();

        if(fName.equals("First Name")||lName.equals("Last Name")||ph.equals("Phone")||mail.equals("Email")||add.equals("Address")||fName.equals("")||lName.equals("")||ph.equals("")||mail.equals("")||add.equals("")){
            // JOptionPane.showMessageDialog(this, "");
            new Warning("Fill up all field first").setVisible(true);
        }else{

            int i=0;
            try{
                Connection con=DATABASE_CONNECTION.getConnection();
                PreparedStatement ps=con.prepareStatement("UPDATE `emp` SET `emp_fname`='"+fName+"',`emp_lname`='"+lName+"',`emp_phone`='"+ph+"',`emp_email`='"+mail+"',`emp_address`='"+add+"' where emp_id ='"+empp+"'");
                i=ps.executeUpdate();
                con.close();
            }catch(Exception e){
                System.out.println(e);
            }
            // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+i);

            if(i>0){
                Succes su=new Succes();
                su.ot("Employee Profile Update Sucessfully ");
                su.setVisible(true);

                // JOptionPane.showMessageDialog(this, "Employee Profile Update Sucessfully ");

            }else{
                new Error("Please Try Again").setVisible(true);
                // JOptionPane.showMessageDialog(this, "Employee Profile Not Update Sucessfully");
            }
        }
    }//GEN-LAST:event_jLabel104MouseClicked

    private void firstnameueppFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameueppFocusGained
        // TODO add your handling code here:
        if(firstnameuepp.getText().equals("First Name")){
            fNameuepp.setVisible(true);
            firstnameuepp.setText("");
            firstnameuepp.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_firstnameueppFocusGained

    private void firstnameueppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameueppFocusLost
        // TODO add your handling code here:
        if(firstnameuepp.getText().equals("")){
            fNameuepp.setVisible(false);
            firstnameuepp.setText("First Name");
            firstnameuepp.setForeground(new Color(128,128,128));
        }else{
            fNameuepp.setVisible(true);
        }
    }//GEN-LAST:event_firstnameueppFocusLost

    private void lastnameueppFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameueppFocusGained
        // TODO add your handling code here:
        if(lastnameuepp.getText().equals("Last Name")){
            L_nameuepp.setVisible(true);
            lastnameuepp.setText("");
            lastnameuepp.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_lastnameueppFocusGained

    private void lastnameueppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameueppFocusLost
        // TODO add your handling code here:
        if(lastnameuepp.getText().equals("")){
            L_nameuepp.setVisible(false);
            lastnameuepp.setText("Last Name");
            lastnameuepp.setForeground(new Color(128,128,128));
        }else{
            L_nameuepp.setVisible(true);
        }
    }//GEN-LAST:event_lastnameueppFocusLost

    private void lastnameueppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameueppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameueppActionPerformed

    private void emailueppFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailueppFocusGained
        // TODO add your handling code here:
        if(emailuepp.getText().equals("Email")){
            Emailuepp.setVisible(true);
            emailuepp.setText("");
            emailuepp.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_emailueppFocusGained

    private void emailueppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailueppFocusLost
        // TODO add your handling code here:
        if(emailuepp.getText().equals("")){
            Emailuepp.setVisible(false);
            emailuepp.setText("Email");
            emailuepp.setForeground(new Color(128,128,128));
        }else{
            Emailuepp.setVisible(true);
        }
    }//GEN-LAST:event_emailueppFocusLost

    private void phone3ueppFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone3ueppFocusGained
        // TODO add your handling code here:
        if(phone3uepp.getText().equals("Phone")){
            Phoneuepp.setVisible(true);
            phone3uepp.setText("");
            phone3uepp.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_phone3ueppFocusGained

    private void phone3ueppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone3ueppFocusLost
        // TODO add your handling code here:
        if(phone3uepp.getText().equals("")){
            Phoneuepp.setVisible(false);
            phone3uepp.setText("Phone");
            phone3uepp.setForeground(new Color(128,128,128));
        }else{
            Phoneuepp.setVisible(true);
        }
    }//GEN-LAST:event_phone3ueppFocusLost

    private void Emp_idueppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_idueppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Emp_idueppActionPerformed

    private void addressueppFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressueppFocusGained
        // TODO add your handling code here:
        if(addressuepp.getText().equals("Address")){
            aaaauepp.setVisible(true);
            addressuepp.setText("");
            addressuepp.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_addressueppFocusGained

    private void addressueppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressueppFocusLost
        // TODO add your handling code here:
        if(addressuepp.getText().equals("")){
            aaaauepp.setVisible(false);
            addressuepp.setText("Phone");
            addressuepp.setForeground(new Color(128,128,128));
        }else{
            aaaauepp.setVisible(true);
        }
    }//GEN-LAST:event_addressueppFocusLost

    private void serchueppFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchueppFocusGained
        if(serchuepp.getText().equals("Serch Employee by Employee ID")){
            fName1uepp.setVisible(true);
            serchuepp.setText("");
            serchuepp.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serchueppFocusGained

    private void serchueppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchueppFocusLost
        // TODO add your handling code here:
        if(serchuepp.getText().equals("")){
            fName1uepp.setVisible(false);
            serchuepp.setText("Serch Employee by Employee ID");
            serchuepp.setForeground(new Color(128,128,128));
        }else{
            fName1uepp.setVisible(true);
        }
    }//GEN-LAST:event_serchueppFocusLost

    private void jLabel2ueppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2ueppMouseClicked
        // TODO add your handling code here:

        String em_id = serchuepp.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp Where emp_id = '"+em_id+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            //  ps.setString(1,"ERP_E1002");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String emp_id =rs.getString("emp_id");
                String f_name =rs.getString("emp_fname");
                // System.out.println("EMpppppp "+f_name);
                String l_name =rs.getString("emp_lname");
                // System.out.println("pppnnn "+l_name);
                String Phone =rs.getString("emp_phone");

                String Email =rs.getString("emp_email");
                // System.out.println("emlllll "+l_name);
                String Address =rs.getString("emp_address");

                firstnameuepp.setText(f_name);

                lastnameuepp.setText(l_name);

                phone3uepp.setText(Phone);
                Emp_iduepp.setText(emp_id);
                emailuepp.setText(Email);
                addressuepp.setText(Address);

                // JOptionPane.showMessageDialog(this, "Product Found");

                rs.close();
                ps.close();
            }else{
                new Warning("Enter Correct Employee Id").setVisible(true);
                // System.out.println("Enter Correct Employee Id");
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_jLabel2ueppMouseClicked

    private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
        // TODO add your handling code here:
          a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(true);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
        
        fNameuepp.setVisible(false);
        L_nameuepp.setVisible(false);
        Phoneuepp.setVisible(false);
        Emailuepp.setVisible(false);
       aaaauepp.setVisible(false);
       
        Emp_iduepp.setEditable(false);
        
        
        
        
        fName1uepp.setVisible(false);
        //System.out.println("empp"+Epp);
        if(Eppuepp!=""){
        updateuepp();
        }
    }//GEN-LAST:event_jPanel22MouseClicked

    private void jLabel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseClicked
        // TODO add your handling code here:
        String pnn=enndepp.getText();
        String rea=eiddepp.getText();
        if (rea.equals("")){

            new Warning("Click Table row To Delete").setVisible(true);
            // JOptionPane.showMessageDialog(this, "Click Table row To Delete");
        }else {
            eiddepp.setText("");
            int Yes = JOptionPane.showConfirmDialog(null, "Are Your Sure Want to Remove Employee "+pnn+" ?");
            if(Yes == 0){

                try{

                    String sql="delete from emp where emp_id = '"+rea+"'";
                    Connection con=DATABASE_CONNECTION.getConnection();
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.execute();
                    // ResultSet rs=ps.executeQuery();
                    // ps.setString(1,idd);

                    ps.close();
                    con.close();

                    tabledepp();
                    Succes su = new Succes();
                    su.ot("Delete Employee Succesfully");
                    su.setVisible(true);
                    //  JOptionPane.showMessageDialog(this, "Delete Product Succesfully");

                }catch(Exception exe){
                    System.out.println("exxxx"+exe);

                }
            }else{
                int No = 0;
                if(No==0){

                }
            }
        }

    }//GEN-LAST:event_jLabel111MouseClicked

    private void tabledeppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledeppMouseClicked
        // TODO add your handling code here:
        int i = tabledepp.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)tabledepp.getModel();
        String bb=model.getValueAt(i,0).toString();
        String aa= model.getValueAt(i,1).toString();
        System.out.println("id"+bb +" name"+aa);
        enndepp.setText(aa);
        eiddepp.setText(bb);
    }//GEN-LAST:event_tabledeppMouseClicked

    private void serchdeppFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchdeppFocusGained
        if(serchdepp.getText().equals("Serch Employee by Employee ID")){
            fName1depp.setVisible(true);
            serchdepp.setText("");
            serchdepp.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serchdeppFocusGained

    private void serchdeppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchdeppFocusLost
        // TODO add your handling code here:
        if(serchdepp.getText().equals("")){
            fName1depp.setVisible(false);
            serchdepp.setText("Serch Employee by Employee ID");
            serchdepp.setForeground(new Color(128,128,128));
        }else{
            fName1depp.setVisible(true);
        }
    }//GEN-LAST:event_serchdeppFocusLost

    private void serchdeppKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchdeppKeyReleased
        // TODO add your handling code here:
        String product_idee = serchdepp.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp where emp_id like '%"+product_idee+"%' or emp_fname like '%"+product_idee+"%' or emp_lname like '%"+product_idee+"%' or emp_email like '%"+product_idee+"%'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tabledepp.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                    String name = rs.getString("emp_fname")+" "+rs.getString("emp_lname");
                    Object o []={
                        rs.getString("emp_id"),name,rs.getString("emp_address") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Employee Not Found").setVisible(true);

                // JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_serchdeppKeyReleased

    private void jLabel117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel117MouseClicked
        // TODO add your handling code here:

        String em_id = serchdepp.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp Where emp_id = '"+em_id+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            //  ps.setString(1,"ERP_E1002");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                //                String emp_id =rs.getString("emp_id");
                //                String f_name =rs.getString("emp_fname");
                //                // System.out.println("EMpppppp "+f_name);
                //                String l_name =rs.getString("emp_lname");
                //                // System.out.println("pppnnn "+l_name);
                //                String Phone =rs.getString("emp_phone");
                //
                //                String Email =rs.getString("emp_email");
                //                // System.out.println("emlllll "+l_name);
                //                String Address =rs.getString("emp_address");

                // JOptionPane.showMessageDialog(this, "Product Found");

                rs.close();
                ps.close();
            }else{
                new Warning("Enter Correct Employee Id").setVisible(true);
                // System.out.println("Enter Correct Employee Id");
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_jLabel117MouseClicked

    private void jPanel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseClicked
        // TODO add your handling code here:
          a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(true);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
        
        
        
         eiddepp.setVisible(false);
        enndepp.setVisible(false);
        tabledepp();
        fName1depp.setVisible(false);
        
        
        
        
    }//GEN-LAST:event_jPanel23MouseClicked

    private void serchell1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchell1FocusGained
        if(serchell.getText().equals("Serch Customer by Customer ID")){
            fName1344.setVisible(true);
            serchell.setText("");
            serchell.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_serchell1FocusGained

    private void serchell1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serchell1FocusLost
        // TODO add your handling code here:
        if(serchell.getText().equals("")){
            fName1344.setVisible(false);
            serchell.setText("Serch Customer by Customer ID");
            serchell.setForeground( Color.decode("#2f44bb"));
        }else{
            fName1344.setVisible(true);
        }
    }//GEN-LAST:event_serchell1FocusLost

    private void serchell1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchell1KeyReleased
        // TODO add your handling code here:
        String product_idee = serchell.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp_works where cous_id like '%"+product_idee+"%' or cous_name like '%"+product_idee+"%' ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tablewll.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                   
                    Object o []={
                      rs.getString("serv_id"), rs.getString("cous_id"),rs.getString("cous_name"),rs.getString("emp_id"),rs.getString("emp_name"),rs.getString("service_dtl"),rs.getString("date"),rs.getString("time"),rs.getString("status") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Employee Not Found").setVisible(true);
                //   JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_serchell1KeyReleased
public void serlist(){
          try {

            //Data fetch from database
            String sql = "Select * From emp_works  ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            // ps.setString(1,product_idee);
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tablewll.getModel();
            model.setRowCount(0);
            if(rs.next()){
                do
                {
                   
                    Object o []={
                      rs.getString("serv_id"), rs.getString("cous_id"),rs.getString("cous_name"),rs.getString("emp_id"),rs.getString("emp_name"),rs.getString("service_dtl"),rs.getString("date"),rs.getString("time"),rs.getString("status") };
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                    model.addRow(o);
                }while (rs.next());
            }else{
                new Error("Service Not Found").setVisible(true);
                //   JOptionPane.showMessageDialog(this, "Product Not Found");
            }

        }catch(Exception e){
            System.out.println("error"+e);
        }
}
    
    private void jLabel123MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel123MouseClicked
        // TODO add your handling code here:

        String em_id = serchell.getText();
        try {

            //Data fetch from database
            String sql = "Select * From emp Where emp_id = '"+em_id+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            //  ps.setString(1,"ERP_E1002");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                //                String emp_id =rs.getString("emp_id");
                //                String f_name =rs.getString("emp_fname");
                //                // System.out.println("EMpppppp "+f_name);
                //                String l_name =rs.getString("emp_lname");
                //                // System.out.println("pppnnn "+l_name);
                //                String Phone =rs.getString("emp_phone");
                //
                //                String Email =rs.getString("emp_email");
                //                // System.out.println("emlllll "+l_name);
                //                String Address =rs.getString("emp_address");

                // JOptionPane.showMessageDialog(this, "Product Found");

                rs.close();
                ps.close();
            }else{
                new Warning("Enter Correct Employee Id").setVisible(true);
                // System.out.println("Enter Correct Employee Id");
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
    }//GEN-LAST:event_jLabel123MouseClicked

    private void jPanel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseClicked
        // TODO add your handling code here:
        hidetext.setVisible(false);
        hidetext.setText("");
        serlist();
         a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(true);
        Cus_List.setVisible(false);
        
        
    }//GEN-LAST:event_jPanel43MouseClicked

    private void jPanel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel62MouseClicked
        // TODO add your handling code here:
        new Add_service_popup().setVisible(true);
    }//GEN-LAST:event_jPanel62MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        serlist();
    }//GEN-LAST:event_button1ActionPerformed

    private void tablewllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablewllMouseClicked
        // TODO add your handling code here:
        int i = tablewll.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel) tablewll.getModel();
        String bb=model.getValueAt(i,0).toString();
        String aa=model.getValueAt(i,1).toString();
      //  System.out.println("id"+bb +" name"+aa);
        hidetext.setText(bb);
        gserv=bb;
        gcusid=aa;
       
        
    }//GEN-LAST:event_tablewllMouseClicked

    private void jPanel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel68MouseClicked
        // TODO add your handling code here:
        
       
        String rea=hidetext.getText();
        if (rea.equals("")){
          
            new Warning("Click Table row To Update Service").setVisible(true);
           // JOptionPane.showMessageDialog(this, "Click Table row To Delete");
        }else {
            Update_popup up = new Update_popup();
            up.getstr(rea);
            up.setVisible(true);
              hidetext.setText("");
              
              
        }
    }//GEN-LAST:event_jPanel68MouseClicked

    private void jPanel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel63MouseClicked
        // TODO add your handling code here:
        String rea=hidetext.getText();
        if (rea.equals("")){
          
            new Warning("Click Table row To Delete Service Details").setVisible(true);
           // JOptionPane.showMessageDialog(this, "Click Table row To Delete");
        }else {
           
           int Yes = JOptionPane.showConfirmDialog(null, "Are Your Sure Want to Remove this Service Detail "+rea+" ?");
        if(Yes == 0){
               
     
        try{
           String sql1 = "Select * From emp_works where serv_id = '"+rea+"'";
          
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps3=con.prepareStatement(sql1);
            // ps.setString(1,product_idee);
            ResultSet rs0=ps3.executeQuery();
           
             if(rs0.next()){
                 
                 
                  String sid=rs0.getString("serv_id");
                
                 String cid= rs0.getString("cous_id");
                 
                 String cn=rs0.getString("cous_name");
              
                 String eid=rs0.getString("emp_id");
                 String en=rs0.getString("emp_name");
                 String sd = rs0.getString("service_dtl");
                 String dd=rs0.getString("date");
                 String tt=rs0.getString("time");
                String ddd= dd1.getText();
                    //   JOptionPane.showMessageDialog(this, "Product Found");
                 
                 rs0.close();
                 ps3.close();
            
            
            Connection con1=DATABASE_CONNECTION.getConnection();
            
             PreparedStatement ps1=con1.prepareStatement("INSERT INTO `cancil_service`(`serv_id`, `cous_id`, `cous_name`, `emp_id`, `emp_name`, `date`, `time`, `srv_dtl`, `delete_date`) VALUES('"+sid+"','"+cid+"','"+cn+"','"+eid+"','"+en+"','"+dd+"','"+tt+"','"+sd+"','"+ddd+"')");
          //  System.out.println("INSERT INTO `cancil_service`(`serv_id`, `cous_id`, `cous_name`, `emp_id`, `emp_name`, `date`, `time`, `srv_dtl`, `delete_date`) VALUES('"+sid+"','"+cid+"','"+cn+"','"+eid+"','"+en+"','"+dd+"','"+tt+"','"+sd+"','"+ddd+"')");
           int x= ps1.executeUpdate();
            ps1.close();
            con1.close();
            
            
            
            String sql="delete from emp_works where serv_id ='"+rea+"'";
             Connection con2=DATABASE_CONNECTION.getConnection();
                    PreparedStatement ps=con2.prepareStatement(sql);
                  int y = ps.executeUpdate();
                    // ResultSet rs=ps.executeQuery();
                   // ps.setString(1,idd);
                   
                    
                   if(x>0&&y>0){
                  
                    Succes su = new Succes();
                    su.ot("Delete Service Detail Succesfully");
                    su.setVisible(true);
                  //  JOptionPane.showMessageDialog(this, "Delete Product Succesfully");
                   }
                   ps.close();
                    con2.close();
                    }else{
                
             }
               
        }catch(Exception exe){
                System.out.println("exxxx"+exe);
                
             }
        }else{
                int No = 0;
                if(No==0){
                    
                
            }
        }
        
           hidetext.setText("");
              
        }
        
    }//GEN-LAST:event_jPanel63MouseClicked

    private void tdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdActionPerformed

    private void jLabel129MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel129MouseClicked
        // TODO add your handling code here:
        tpic.showPopup(this, 100, 100);
    }//GEN-LAST:event_jLabel129MouseClicked

    private void jPanel65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel65MouseClicked
        // TODO add your handling code here:
         tpic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("hii"+tpic.getSelectedTime());
            td.setText(tpic.getSelectedTime());
            
            }
             
         });
        String rea=hidetext.getText();
        if (rea.equals("")){
          
            new Warning("Click Table row To Assign Service").setVisible(true);
           // JOptionPane.showMessageDialog(this, "Click Table row To Delete");
        }else {
            a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        
        Assign.setVisible(true);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(false);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
        ascad.setEditable(false);
        ascsd.setEditable(false);
        drop_down();
        
        
        try {
        
             //Data fetch from database
           
             //Data fetch from database
            String sql1 = "Select * From cus where cus_id='"+gcusid+"'";
            Connection con1=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps1=con1.prepareStatement(sql1);
            ResultSet rs1=ps1.executeQuery();
           
          
           if(rs1.next())
           {
              
              ascn.setText(rs1.getString("cus_fname")+" "+rs1.getString("cus_lname"));
              ascph.setText(rs1.getString("cus_ph")); 
              asceml.setText(rs1.getString("cus_eml"));
        ascad.setText(rs1.getString("cus_adde"));

           }
            String sql = "Select * From emp_works where serv_id='"+gserv+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           
          
           if(rs.next())
           {
              
              ascsd.setText(rs.getString("service_dtl"));
               
           }
           
           
           
            }catch(Exception e){
            System.out.println("error"+e);
        }
              
              
        }
        
       
        
        
        
    }//GEN-LAST:event_jPanel65MouseClicked

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
        if(t2.getItemCount()!=0){
            String enn =t2.getSelectedItem().toString();
           // System.out.println("enn"+enn);
            try {

                //Data fetch from database
                String sql = "Select * From emp where emp_fname like '"+enn+"' and emp_lname like '"+enn+"' ";
 //System.out.println("Select * From emp where emp_fname like '"+enn+"' and emp_lname like '"+enn+"'");
                Connection con=DATABASE_CONNECTION.getConnection();
                PreparedStatement ps=con.prepareStatement(sql);
               
                ResultSet rs=ps.executeQuery();

                t3.removeAllItems();
                t3.addItem("-- Select --");
                while(rs.next()){

                    String[] aa={
                        rs.getString("emp_id")};

                    //  System.out.println("aaa"+Arrays.toString(aa).replace("[","").replace("]",""));

                    t3.addItem(Arrays.toString(aa).replace("[","").replace("]",""));
                    // t3.setSelectedItem(null);
                }
            }catch(Exception e){
                System.out.println("error2"+e);
            }
        }
    }//GEN-LAST:event_t2ActionPerformed

    private void jPanel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel71MouseClicked
        // TODO add your handling code here:
       SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        String Ddt =  s.format(ddt.getDate());
        String tta =td.getText();
        String adr= t2.getSelectedItem().toString();
        String adr2= t3.getSelectedItem().toString();
        String cnm =ascn.getText();
        String cnph =ascph.getText();
        String cneml =asceml.getText();
        String cnad =ascad.getText();
        String cnsd =ascsd.getText();



        //System.out.println("ddatt"+ddt.getDate());
        
        if(tta.equals("")){
            System.out.println("ddat");
        }else{
                 int i=0;
            try{
                Connection con=DATABASE_CONNECTION.getConnection();
                PreparedStatement ps=con.prepareStatement("UPDATE `emp_works` SET `emp_id`='"+adr2+"',`emp_name`='"+adr+"',`date`='"+Ddt+"',`time`='"+tta+"',`status`='assign' where serv_id ='"+gserv+"'");
                i=ps.executeUpdate();
                con.close();
                if(i>0){
                    Succes su =new Succes();
                    su.ot("Service Assign Succesfull");
                    su.setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }

        }
        
    }//GEN-LAST:event_jPanel71MouseClicked

    private void csttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_csttActionPerformed

    private void jLabel141MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel141MouseClicked
        // TODO add your handling code here:
        tpic.showPopup(this, 100, 100);
    }//GEN-LAST:event_jLabel141MouseClicked

    private void jPanel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel76MouseClicked
        // TODO add your handling code here:
     SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        String Ddt =  s.format(csdd.getDate());
        String cst= cstt.getText();
        String eid= csei.getText();
        String en=csen.getText();
        String  cscos=cscost.getText();
    //    String metr = 
        if(cst.equals("")){
            System.out.println("ddat");
        }else{
                 int i=0;
            try{
                Connection con=DATABASE_CONNECTION.getConnection();
                PreparedStatement ps=con.prepareStatement("UPDATE `emp_works` SET `date`='"+Ddt+"',`time`='"+cst+"',`status`='Complete' where serv_id ='"+gserv+"'");
                i=ps.executeUpdate();
                con.close();
                
               
                PreparedStatement ps1=con.prepareStatement("INSERT INTO `comp_service`(`serv_id`, `date`, `time`, `emp_id`, `emp_name`, `cous_id`, `cous_name`, `cous_ph`, `cous_mail`, `cous_addr`, `serv_desc`, `cost`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]','[value-8]','[value-9]','[value-10]','[value-11]','[value-12]')");
                i=ps1.executeUpdate();
                con.close();
                
                
                
                
            }catch(Exception e){
                System.out.println(e);
            }
if(i>0){
                    Succes su =new Succes();
                    su.ot("Service Assign Succesfull");
                    su.setVisible(true);
                }
        }
    }//GEN-LAST:event_jPanel76MouseClicked

    private void jPanel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel66MouseClicked
        // TODO add your handling code here:
        csad.setEditable(false);
        cssd.setEditable(false);
         tpic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("hii"+tpic.getSelectedTime());
            cstt.setText(tpic.getSelectedTime());
            
            }
             
         });
        String rea=hidetext.getText();
        if (rea.equals("")){
          
            new Warning("Click Table row To Complete Service").setVisible(true);
           // JOptionPane.showMessageDialog(this, "Click Table row To Delete");
        }else {
            try {
        String sql = "Select * From emp_works where serv_id='"+gserv+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           
          
           if(rs.next())
           {
               String sta =rs.getString("status");
              if(sta.equals("assign")){
        
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        
         home.setVisible(false);
        ES.setVisible(false);
        CS.setVisible(false);
        Ws.setVisible(false);
        SM.setVisible(false);
        MP.setVisible(false);
        
        Search_Cus.setVisible(false);
        Create_Cus.setVisible(false);
        Update_Cus.setVisible(false);
        Delete_Cus.setVisible(false);
        body12.setVisible(false);
        
        Assign.setVisible(false);
        Emp_List.setVisible(false);
        Search_Emp.setVisible(false);
       Complete.setVisible(true);
        Delete_Emp.setVisible(false);
        Create_Emp.setVisible(false);
       Update_Emp.setVisible(false);
        Working_list.setVisible(false);
        Cus_List.setVisible(false);
        
        
        
         
               
              cssd.setText(rs.getString("service_dtl"));
               csen.setText(rs.getString("emp_name"));
                csei.setText(rs.getString("emp_id"));
               
           
            
            String sql1 = "Select * From cus where cus_id='"+gcusid+"'";
            Connection con1=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps1=con1.prepareStatement(sql1);
            ResultSet rs1=ps1.executeQuery();
           
          
           if(rs1.next())
           {
              
              cscn.setText(rs1.getString("cus_fname")+" "+rs1.getString("cus_lname"));
               csci.setText(rs1.getString("cus_id")); 
              cscp.setText(rs1.getString("cus_ph")); 
              cseml.setText(rs1.getString("cus_eml"));
        csad.setText(rs1.getString("cus_adde"));

           
            
           }
              }
           else{
               new Warning("Assign Your Service first").setVisible(true);
              }
           }
            }catch(Exception e){
            System.out.println("error"+e);
        }
            
        
        }     
        
        
    }//GEN-LAST:event_jPanel66MouseClicked
  public void drop_down(){
       try {

                String sql = "Select * From emp ";
                Connection con=DATABASE_CONNECTION.getConnection();
                PreparedStatement ps=con.prepareStatement(sql);
               
                ResultSet rs=ps.executeQuery();
                t2.removeAllItems();
                t2.addItem("-- Select --");
                while(rs.next()){
                   String na= rs.getString("emp_fname")+" "+  rs.getString("emp_lname");
                    
                    String aa[]={
                        na
                      } ;

                    //    System.out.println(Arrays.toString(aa).replace("[", "").replace("]", ""));
                    t2.addItem(Arrays.toString(aa).replace("[", "").replace("]", ""));
                    //   t2.setSelectedItem(null);
                }

            }   catch (SQLException ex) {
                System.out.println("1"+ex);
            }
  }
    
    public void  relode(String a){
       
       if(a.equals("oky")){
           System.out.println("haha"+a);
            serlist();
       }
   }
    public void tabledepp() {
    try {
        
             //Data fetch from database
            String sql = "Select * From emp ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           DefaultTableModel model =(DefaultTableModel)tabledepp.getModel(); 
           model.setRowCount(0);
           while (rs.next())
           {
               String name = rs.getString("emp_fname")+" "+rs.getString("emp_lname");
               Object o []={
                   rs.getString("emp_id"),name,rs.getString("emp_address") };
               model.addRow(o);
               
           }
            }catch(Exception e){
            System.out.println("error"+e);
        }
     }
    
    public void updateuepp(){
       
       try {
        
             //Data fetch from database
            String sql = "Select * From emp Where emp_id = '"+Eppuepp+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
          //  ps.setString(1,"ERP_E1002");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String emp_id =rs.getString("emp_id");
                String f_name =rs.getString("emp_fname");
                // System.out.println("EMpppppp "+f_name);
                String l_name =rs.getString("emp_lname");
                // System.out.println("pppnnn "+l_name);
                String Phone =rs.getString("emp_phone");
                 
                String Email =rs.getString("emp_email");
               // System.out.println("emlllll "+l_name);
                String Address =rs.getString("emp_address");
                
                firstnameuepp.setText(f_name);
                
                lastnameuepp.setText(l_name);
                
                phone3uepp.setText(Phone);
                  Emp_iduepp.setText(emp_id);
                emailuepp.setText(Email);
               addressuepp.setText(Address);
                
                
               // JOptionPane.showMessageDialog(this, "Product Found");
                
               
                rs.close();
                ps.close();
            }else{
               new Warning("Enter Correct Employee Id").setVisible(true);
               // System.out.println("Enter Correct Employee Id");
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
           
    }
     void id_createcee(){
        Emp_idcee.setEditable(false);
         try{
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from id_store");         
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
              //  mng_Id=rs.getString("MNG_ID");
               // System.out.println("MANAGER ID "+mng_Id);
                emp_Idcee=rs.getString("emp_id");
              //  System.out.println("EMPLOYEE ID "+emp_Id);
              //  Transaction_Id=rs.getString("TRANSACTION_ID");
              //  System.out.println("Transaction_Id "+Transaction_Id);
             //   Product_id=rs.getString("PRODUCT_ID");
               
                rs.close();
                ps.close();
            }else{
                JOptionPane.showMessageDialog(null, "NOTHING FOUND IN DATABASE!!!!!!");
            }
            con.close();
           }
        catch(Exception e){System.out.println(e);}
         
        emp_idcee = new BigInteger(emp_Idcee);
        BigInteger nxt = new BigInteger("1");
      //  System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+emp_Id);
      //  System.out.println("#################"+emp_id);
        emp_idcee = emp_idcee.add(nxt);
     //   System.out.println("%%%%%%%%%%%%%%%%%%%%%%"+emp_id);
        empcee = "ERP_E"+emp_idcee.toString();
    //    System.out.println("%%%%%%%%%%%%%%%%%%%%%%"+emp);
     //   System.out.println("++++++++++++++++"+emp_id);
        Emp_idcee.setText(empcee);
    }
     
     
    public void tablesepp() {
    try {
        
             //Data fetch from database
            String sql = "Select * From emp ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           DefaultTableModel model =(DefaultTableModel)tablesee.getModel(); 
           model.setRowCount(0);
           while (rs.next())
           {
               String name = rs.getString("emp_fname")+" "+rs.getString("emp_lname");
               Object o []={
                  name, rs.getString("emp_id") };
               model.addRow(o);
               
           }
            }catch(Exception e){
            System.out.println("error"+e);
        }
     }
    public void tableell() {
    try {
        
             //Data fetch from database
            String sql = "Select * From emp ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           DefaultTableModel model =(DefaultTableModel)tableell.getModel(); 
           model.setRowCount(0);
           while (rs.next())
           {
               String name = rs.getString("emp_fname")+" "+rs.getString("emp_lname");
               Object o []={
                   rs.getString("emp_id"),name,rs.getString("emp_phone"),rs.getString("emp_email"),rs.getString("emp_address") };
               model.addRow(o);
               
           }
            }catch(Exception e){
            System.out.println("error"+e);
        }
     }
    public void table3() {
    try {
        
             //Data fetch from database
            String sql = "Select * From cus ";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           DefaultTableModel model =(DefaultTableModel)table.getModel(); 
           model.setRowCount(0);
           while (rs.next())
           {
               String name = rs.getString("cus_fname")+" "+rs.getString("cus_lname");
               Object o []={
                   rs.getString("cus_id"),name,rs.getString("cus_adde") };
               model.addRow(o);
               
           }
            }catch(Exception e){
            System.out.println("error"+e);
        }
     }
      public void update(){
       
       try {
        
             //Data fetch from database
            String sql = "Select * From cus Where cus_id = '"+Epp+"'";
            Connection con=DATABASE_CONNECTION.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
          //  ps.setString(1,"ERP_E1002");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String emp_id =rs.getString("cus_id");
                String f_name =rs.getString("cus_fname");
                // System.out.println("EMpppppp "+f_name);
                String l_name =rs.getString("cus_lname");
                // System.out.println("pppnnn "+l_name);
                String Phone =rs.getString("cus_ph");
                 
                String Email =rs.getString("cus_eml");
               // System.out.println("emlllll "+l_name);
                String Address =rs.getString("cus_adde");
                  String sev =rs.getString("cus_servic");
                firstname1.setText(f_name);
                
                lastname1.setText(l_name);
                
                phone4.setText(Phone);
                  Emp_id1.setText(emp_id);
                email1.setText(Email);
               address1.setText(Address);
                
                
               // JOptionPane.showMessageDialog(this, "Product Found");
                
               
                rs.close();
                ps.close();
            }else{
               new Warning("Enter Correct Customer Id").setVisible(true);
               // System.out.println("Enter Correct Employee Id");
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
      }

      public void call(){
//          JTableHeader header = jTable1.getTableHeader();
//    header.setBackground(Color.MAGENTA);
//    header.setForeground(Color.red);
    
      Font font = new Font("Verdana", Font.BOLD, 15);
      jTable1.setFont(font);
      jTable1.setRowHeight(30);
      jTable1.setBackground(Color.blue);
      jTable1.setForeground(Color.white);
      JTableHeader tableHeader = jTable1.getTableHeader();
      tableHeader.setBackground(Color.MAGENTA);
      tableHeader.setForeground(Color.RED);
    
      }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Index().setVisible(true);
               
            }
        });
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Assign;
    private javax.swing.JPanel CS;
    private javax.swing.JPanel Co;
    private javax.swing.JPanel Complete;
    private javax.swing.JPanel Create_Cus;
    private javax.swing.JPanel Create_Emp;
    private javax.swing.JPanel Cus_List;
    private javax.swing.JPanel Delete_Cus;
    private javax.swing.JPanel Delete_Emp;
    private javax.swing.JPanel ES;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Email1;
    private javax.swing.JLabel Emailcee;
    private javax.swing.JLabel Emailuepp;
    private javax.swing.JPanel Emp_List;
    private javax.swing.JTextField Emp_id;
    private javax.swing.JTextField Emp_id1;
    private javax.swing.JTextField Emp_idcee;
    private javax.swing.JTextField Emp_iduepp;
    private javax.swing.JLabel L_name;
    private javax.swing.JLabel L_name1;
    private javax.swing.JLabel L_namecee;
    private javax.swing.JLabel L_nameuepp;
    private javax.swing.JPanel MP;
    private javax.swing.JLabel Phone;
    private javax.swing.JLabel Phone1;
    private javax.swing.JLabel Phonecee;
    private javax.swing.JLabel Phoneuepp;
    private javax.swing.JPanel SM;
    private javax.swing.JPanel Search_Cus;
    private javax.swing.JPanel Search_Emp;
    private javax.swing.JPanel Update_Cus;
    private javax.swing.JPanel Update_Emp;
    private javax.swing.JPanel Working_list;
    private javax.swing.JPanel Ws;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel aaaa;
    private javax.swing.JLabel aaaacee;
    private javax.swing.JLabel aaaauepp;
    private javax.swing.JTextArea address;
    private javax.swing.JTextArea address1;
    private javax.swing.JTextArea addresscee;
    private javax.swing.JTextArea addressuepp;
    private javax.swing.JLabel addrr;
    private javax.swing.JLabel adi;
    private javax.swing.JLabel adn;
    private javax.swing.JTextPane ascad;
    private javax.swing.JLabel asceml;
    private javax.swing.JLabel ascn;
    private javax.swing.JLabel ascph;
    private javax.swing.JTextPane ascsd;
    private javax.swing.JPanel body;
    private javax.swing.JPanel body12;
    private javax.swing.JPanel body21;
    private javax.swing.JPanel body22;
    private javax.swing.JPanel body23;
    private java.awt.Button button1;
    private javax.swing.JPanel crt_emp;
    private javax.swing.JPanel crt_emp1;
    private javax.swing.JPanel crt_emp2;
    private javax.swing.JPanel crt_emp3;
    private javax.swing.JPanel crt_emp4;
    private javax.swing.JPanel crt_emp5;
    private javax.swing.JTextPane csad;
    private javax.swing.JLabel csci;
    private javax.swing.JLabel cscn;
    private javax.swing.JTextField cscost;
    private javax.swing.JLabel cscp;
    private com.toedter.calendar.JDateChooser csdd;
    private javax.swing.JLabel csei;
    private javax.swing.JLabel cseml;
    private javax.swing.JLabel csen;
    private javax.swing.JTextPane csmet;
    private javax.swing.JTextPane cssd;
    private javax.swing.JTextField cstt;
    private javax.swing.JLabel dd;
    private javax.swing.JLabel dd1;
    private com.toedter.calendar.JDateChooser ddt;
    private javax.swing.JLabel eid11;
    private javax.swing.JLabel eiddepp;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JTextField emailcee;
    private javax.swing.JTextField emailuepp;
    private javax.swing.JLabel enn;
    private javax.swing.JLabel enndepp;
    private javax.swing.JLabel fName;
    private javax.swing.JLabel fName1;
    private javax.swing.JLabel fName1344;
    private javax.swing.JLabel fName1345;
    private javax.swing.JLabel fName1depp;
    private javax.swing.JLabel fName1uepp;
    private javax.swing.JLabel fName2;
    private javax.swing.JLabel fName3;
    private javax.swing.JLabel fName4;
    private javax.swing.JLabel fName5;
    private javax.swing.JLabel fName6;
    private javax.swing.JLabel fName9;
    private javax.swing.JLabel fNamecee;
    private javax.swing.JLabel fNamesepp;
    private javax.swing.JLabel fNameuepp;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField firstname1;
    private javax.swing.JTextField firstnamecee;
    private javax.swing.JTextField firstnameuepp;
    private javax.swing.JPanel head;
    private java.awt.Label hidetext;
    private javax.swing.JPanel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel2uepp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField lastname1;
    private javax.swing.JTextField lastnamecee;
    private javax.swing.JTextField lastnameuepp;
    private javax.swing.JPanel menu;
    private javax.swing.JTextField mng_id;
    private javax.swing.JTextField mng_id1;
    private javax.swing.JTextField mng_id2;
    private javax.swing.JTextField mng_id3;
    private javax.swing.JTextField mng_id4;
    private javax.swing.JTextField mng_name;
    private javax.swing.JTextField mng_name1;
    private javax.swing.JTextField mng_name2;
    private javax.swing.JTextField mng_name3;
    private javax.swing.JTextField mng_name4;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel p6;
    private javax.swing.JPanel p7;
    private javax.swing.JTextField phone3;
    private javax.swing.JTextField phone3cee;
    private javax.swing.JTextField phone3uepp;
    private javax.swing.JTextField phone4;
    private javax.swing.JTextField serch;
    private javax.swing.JTextField serch1;
    private javax.swing.JTextField serch2;
    private javax.swing.JTextField serch3;
    private javax.swing.JTextField serchdepp;
    private javax.swing.JTextField serchell;
    private javax.swing.JTextField serchell1;
    private javax.swing.JTextField serchsee;
    private javax.swing.JTextField serchuepp;
    private javax.swing.JComboBox<String> stawll;
    private javax.swing.JComboBox<String> t2;
    private javax.swing.JComboBox<String> t3;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table1see;
    private javax.swing.JTable table2;
    private javax.swing.JTable tabledepp;
    private javax.swing.JTable tableell;
    private javax.swing.JTable tablesc;
    private javax.swing.JTable tablesee;
    private javax.swing.JTable tablewll;
    private javax.swing.JTextField td;
    private com.raven.swing.TimePicker tpic;
    private javax.swing.JLabel tt;
    private javax.swing.JTextPane ttf;
    private javax.swing.JTextPane ttfsee;
    // End of variables declaration//GEN-END:variables
}

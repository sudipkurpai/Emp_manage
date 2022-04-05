package erp;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

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
    String cus_Id;
String cus;
 BigInteger cus_id =null;
    
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
       adddddd.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
        body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
        body19.setVisible(false);
        body20.setVisible(false);
        p1.setBackground(Color.decode("#03A9DD"));
        p2.setBackground(Color.decode("#333333"));
        p3.setBackground(Color.decode("#333333"));
        p4.setBackground(Color.decode("#333333"));
        p5.setBackground(Color.decode("#333333"));
        p6.setBackground(Color.decode("#333333"));
        p7.setBackground(Color.decode("#333333"));
                

        
        
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
        jScrollPane8 = new javax.swing.JScrollPane();
        sddz = new javax.swing.JTextArea();
        adddddd = new javax.swing.JLabel();
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
        jScrollPane10 = new javax.swing.JScrollPane();
        address2 = new javax.swing.JTextArea();
        aaaa1 = new javax.swing.JLabel();
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
        body14 = new javax.swing.JPanel();
        body15 = new javax.swing.JPanel();
        body18 = new javax.swing.JPanel();
        body19 = new javax.swing.JPanel();
        body17 = new javax.swing.JPanel();
        body20 = new javax.swing.JPanel();
        body13 = new javax.swing.JPanel();
        body16 = new javax.swing.JPanel();
        body12 = new javax.swing.JPanel();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(887, 887, 887))
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
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
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

        jPanel32.add(crt_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 560, 50));

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

        sddz.setBackground(new java.awt.Color(255, 255, 255));
        sddz.setColumns(10);
        sddz.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sddz.setForeground(new java.awt.Color(0, 0, 0));
        sddz.setRows(5);
        sddz.setText("Service Description");
        sddz.setBorder(null);
        sddz.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sddz.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sddzFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sddzFocusLost(evt);
            }
        });
        jScrollPane8.setViewportView(sddz);

        jPanel32.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 560, -1));

        adddddd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        adddddd.setForeground(new java.awt.Color(128, 128, 128));
        adddddd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adddddd.setText("Service Description");
        jPanel32.add(adddddd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 190, 20));

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

        jPanel34.add(crt_emp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 550, 50));

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

        jScrollPane10.setBorder(null);

        address2.setBackground(new java.awt.Color(255, 255, 255));
        address2.setColumns(10);
        address2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        address2.setForeground(new java.awt.Color(0, 0, 0));
        address2.setRows(5);
        address2.setText("Service Description");
        address2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        address2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        address2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                address2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                address2FocusLost(evt);
            }
        });
        jScrollPane10.setViewportView(address2);

        jPanel34.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 550, 90));

        aaaa1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        aaaa1.setForeground(new java.awt.Color(128, 128, 128));
        aaaa1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aaaa1.setText("Service Description");
        jPanel34.add(aaaa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 150, 20));

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

        body14.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout body14Layout = new javax.swing.GroupLayout(body14);
        body14.setLayout(body14Layout);
        body14Layout.setHorizontalGroup(
            body14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body14Layout.setVerticalGroup(
            body14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body15.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body15Layout = new javax.swing.GroupLayout(body15);
        body15.setLayout(body15Layout);
        body15Layout.setHorizontalGroup(
            body15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body15Layout.setVerticalGroup(
            body15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body18.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout body18Layout = new javax.swing.GroupLayout(body18);
        body18.setLayout(body18Layout);
        body18Layout.setHorizontalGroup(
            body18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body18Layout.setVerticalGroup(
            body18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body19.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body19Layout = new javax.swing.GroupLayout(body19);
        body19.setLayout(body19Layout);
        body19Layout.setHorizontalGroup(
            body19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body19Layout.setVerticalGroup(
            body19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body17.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout body17Layout = new javax.swing.GroupLayout(body17);
        body17.setLayout(body17Layout);
        body17Layout.setHorizontalGroup(
            body17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body17Layout.setVerticalGroup(
            body17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body20.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body20Layout = new javax.swing.GroupLayout(body20);
        body20.setLayout(body20Layout);
        body20Layout.setHorizontalGroup(
            body20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body20Layout.setVerticalGroup(
            body20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body13.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout body13Layout = new javax.swing.GroupLayout(body13);
        body13.setLayout(body13Layout);
        body13Layout.setHorizontalGroup(
            body13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body13Layout.setVerticalGroup(
            body13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        body16.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout body16Layout = new javax.swing.GroupLayout(body16);
        body16.setLayout(body16Layout);
        body16Layout.setHorizontalGroup(
            body16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        body16Layout.setVerticalGroup(
            body16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        body.add(body16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
        body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
        body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);

              
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);

              
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        String sd = sddz.getText();

        if(fName.equals("First Name")||lName.equals("Last Name")||ph.equals("Phone")||mail.equals("Email")||add.equals("Address")||sd.equals("Service Description")||fName.equals("")||lName.equals("")||ph.equals("")||mail.equals("")||add.equals("")||sd.equals("")){
            // JOptionPane.showMessageDialog(this, "");
            new Warning("Fill up all field first").setVisible(true);
        }else{
            int i = ADD_NEW_EMP_DATAOBEJECT.create_cus (fName, lName, mail, ph,empp, add,sd);

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

    private void sddzFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sddzFocusGained
        // TODO add your handling code here:
        if(sddz.getText().equals("Service Description")){
            adddddd.setVisible(true);
            sddz.setText("");
            sddz.setForeground(new Color(000,000,000));
        }
    }//GEN-LAST:event_sddzFocusGained

    private void sddzFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sddzFocusLost
        // TODO add your handling code here:
        if(sddz.getText().equals("")){
            adddddd.setVisible(false);
            sddz.setText("Service Description");
            sddz.setForeground(new Color(128,128,128));
        }else{
            adddddd.setVisible(true);
        }
    }//GEN-LAST:event_sddzFocusLost

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
        // TODO add your handling code here:
        String fName = firstname1.getText();
        String lName = lastname1.getText();
        String ph = phone4.getText();
        String mail = email1.getText();

        String add = address1.getText();
        String empp= Emp_id1.getText();
        String servv= address2.getText();

        if(fName.equals("First Name")||lName.equals("Last Name")||ph.equals("Phone")||mail.equals("Email")||add.equals("Address")||servv.equals("Service Description")||servv.equals("")||fName.equals("")||lName.equals("")||ph.equals("")||mail.equals("")||add.equals("")){
            // JOptionPane.showMessageDialog(this, "");
            new Warning("Fill up all field first").setVisible(true);
        }else{

            int i=0;
            try{
                Connection con=DATABASE_CONNECTION.getConnection();
                PreparedStatement ps=con.prepareStatement("UPDATE `cus` SET `cus_fname`='"+fName+"',`cus_lname`='"+lName+"',`cus_ph`='"+ph+"',`cus_eml`='"+mail+"',`cus_adde`='"+add+"',`cus_servic`='"+servv+"' where cus_id ='"+empp+"'");
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

    private void address2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address2FocusGained
        // TODO add your handling code here:
        if(address2.getText().equals("Service Description")){
            aaaa1.setVisible(true);
            address2.setText("");
            address2.setForeground(new Color(000,000,000));
        }

    }//GEN-LAST:event_address2FocusGained

    private void address2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address2FocusLost
        // TODO add your handling code here:
        if(address2.getText().equals("")){
            aaaa1.setVisible(false);
            address2.setText("Service Description");
            address2.setForeground(new Color(128,128,128));
        }else{
            aaaa1.setVisible(true);
        }
    }//GEN-LAST:event_address2FocusLost

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
                address2.setText(sev);

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
        aaaa1.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
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
        body13.setVisible(false);
        body13.setVisible(false);
        body14.setVisible(false);
        body15.setVisible(false);
       body16.setVisible(false);
        body17.setVisible(false);
        body18.setVisible(false);
       body19.setVisible(false);
        body20.setVisible(false);
        Cus_List.setVisible(false);
    }//GEN-LAST:event_jPanel17MouseClicked
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
                address2.setText(sev);
                
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
    private javax.swing.JPanel CS;
    private javax.swing.JPanel Create_Cus;
    private javax.swing.JPanel Cus_List;
    private javax.swing.JPanel Delete_Cus;
    private javax.swing.JPanel ES;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Email1;
    private javax.swing.JTextField Emp_id;
    private javax.swing.JTextField Emp_id1;
    private javax.swing.JLabel L_name;
    private javax.swing.JLabel L_name1;
    private javax.swing.JPanel MP;
    private javax.swing.JLabel Phone;
    private javax.swing.JLabel Phone1;
    private javax.swing.JPanel SM;
    private javax.swing.JPanel Search_Cus;
    private javax.swing.JPanel Update_Cus;
    private javax.swing.JPanel Ws;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel aaaa;
    private javax.swing.JLabel aaaa1;
    private javax.swing.JLabel adddddd;
    private javax.swing.JTextArea address;
    private javax.swing.JTextArea address1;
    private javax.swing.JTextArea address2;
    private javax.swing.JLabel addrr;
    private javax.swing.JLabel adi;
    private javax.swing.JLabel adn;
    private javax.swing.JPanel body;
    private javax.swing.JPanel body12;
    private javax.swing.JPanel body13;
    private javax.swing.JPanel body14;
    private javax.swing.JPanel body15;
    private javax.swing.JPanel body16;
    private javax.swing.JPanel body17;
    private javax.swing.JPanel body18;
    private javax.swing.JPanel body19;
    private javax.swing.JPanel body20;
    private javax.swing.JPanel crt_emp;
    private javax.swing.JPanel crt_emp1;
    private javax.swing.JPanel crt_emp2;
    private javax.swing.JLabel dd;
    private javax.swing.JLabel dd1;
    private javax.swing.JLabel eid11;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JLabel enn;
    private javax.swing.JLabel fName;
    private javax.swing.JLabel fName1;
    private javax.swing.JLabel fName2;
    private javax.swing.JLabel fName3;
    private javax.swing.JLabel fName4;
    private javax.swing.JLabel fName5;
    private javax.swing.JLabel fName6;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField firstname1;
    private javax.swing.JPanel head;
    private javax.swing.JPanel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JPanel menu;
    private javax.swing.JTextField mng_id;
    private javax.swing.JTextField mng_id1;
    private javax.swing.JTextField mng_name;
    private javax.swing.JTextField mng_name1;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel p6;
    private javax.swing.JPanel p7;
    private javax.swing.JTextField phone3;
    private javax.swing.JTextField phone4;
    private javax.swing.JTextArea sddz;
    private javax.swing.JTextField serch;
    private javax.swing.JTextField serch1;
    private javax.swing.JTextField serch2;
    private javax.swing.JTextField serch3;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable tablesc;
    private javax.swing.JLabel tt;
    private javax.swing.JTextPane ttf;
    // End of variables declaration//GEN-END:variables
}

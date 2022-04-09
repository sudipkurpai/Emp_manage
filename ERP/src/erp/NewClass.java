/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Sudip_Maiti
 */
public class NewClass {
    public static void main(String[] argv) throws Exception {
      Integer[][] marks = {
         { 70, 66, 76, 89, 67, 98 },
         { 67, 89, 64, 78, 59, 78 },
         { 68, 87, 71, 65, 87, 86 },
         { 80, 56, 89, 98, 59, 56 },
         { 75, 95, 90, 73, 57, 79 },
         { 69, 49, 56, 78, 76, 77 }
      };
      String col[] = { "S1", "S2", "S3", "S4", "S5", "S6"};
      JTable table = new JTable(marks, col);
      Font font = new Font("Verdana", Font.PLAIN, 12);
      table.setFont(font);
      table.setRowHeight(30);
      table.setBackground(Color.blue);
      table.setForeground(Color.white);
      JTableHeader tableHeader = table.getTableHeader();
      tableHeader.setBackground(Color.black);
      tableHeader.setForeground(Color.white);
      JFrame frame = new JFrame();
      frame.setSize(600, 400);
      frame.add(new JScrollPane(table));
      frame.setVisible(true);
   }
}

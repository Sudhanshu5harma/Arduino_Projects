import java.sql.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;
        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame21.java
 *
 * Created on Feb 2, 2015, 12:22:06 PM
 */

/**
 *
 * @author LOVEKUSH
 */
public class NewJFrame21 extends javax.swing.JFrame {

    /** Creates new form NewJFrame21 */
    public NewJFrame21() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jr1 = new javax.swing.JRadioButton();
        jr2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jt1 = new javax.swing.JTextField();
        jt2 = new javax.swing.JTextField();
        jt3 = new javax.swing.JTextField();
        jt4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jr1.setText("name contain 's'");

        jr2.setText("marks greater than 300");

        jl1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "result with pass", "result pending", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jl1);

        jta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "boardrollno", "name ", "totalmarks", "result"
            }
        ));
        jScrollPane2.setViewportView(jta1);

        jButton1.setText("Display");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("INSERT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jr1)
                    .addComponent(jr2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(669, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(jt4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton2)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jr1)
                .addGap(40, 40, 40)
                .addComponent(jr2)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
DefaultTableModel d=(DefaultTableModel)jta1.getModel();
    try{
  Class.forName("java.sql.Driver");
 Connection c = DriverManager.getConnection("jdbc:mysql://localhost/board","root","");
 Statement s=c.createStatement();
 int b,t,b1,t1;
 String n=null,r=null,n1,r1;
 if (jr1.isSelected()==true)
 { String q="Select * from topper where name like '%s%'" ;
 ResultSet rs = s.executeQuery(q);
 while(rs.next())
 {b=rs.getInt("boardrollno");
  n=rs.getString("name");
  t=rs.getInt("totalmarks");
  r=rs.getString("result");
  d.addRow(new Object[]{b,n,t,r});}
 }
 if (jr2.isSelected()==true)
 { String q1="Select * from topper where totalmarks > 300" ;
 ResultSet rs = s.executeQuery(q1);
 while(rs.next())
 {b1=rs.getInt("boardrollno");
  n1=rs.getString("name");
  t1=rs.getInt("totalmarks");
  r1=rs.getString("result");
  d.addRow(new Object[]{b1,n1,t1,r1});}
 }
 String n2,r2,l=null;
 int b2,t2;
 int w=jl1.getSelectedIndex();
 switch (w)
 {case 0:l="Select * from topper where result ='pass'";
  case 1:l="Select * from topper where result ='pending'";
 }
 ResultSet rs = s.executeQuery(l);
 while(rs.next())
 {b2=rs.getInt("boardrollno");
  n2=rs.getString("name");
  t2=rs.getInt("totalmarks");
  r2=rs.getString("result");
  d.addRow(new Object[]{b2,n2,t2,r2});}
    
    }    catch(Exception e)
        {System.out.print(""+ e.getMessage());}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int b,t;
String n,r;
b=Integer.parseInt(jt1.getText());
t=Integer.parseInt(jt3.getText());
n=jt2.getText();
r=jt4.getText();
        try
{Class.forName("java.sql.Driver");
 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/board","root","");
 Statement s=c.createStatement();
 String q ="insert into topper values ("+b+",'"+n+"',"+t+",'"+r+"')";
int u=s.executeUpdate(q);
if (u>0)
{   JOptionPane.showMessageDialog(null,"insertion completed","thank u ",1);
}
}catch(Exception e)
{System.out.print(""+e.getMessage());}

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame21().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jl1;
    private javax.swing.JRadioButton jr1;
    private javax.swing.JRadioButton jr2;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt2;
    private javax.swing.JTextField jt3;
    private javax.swing.JTextField jt4;
    private javax.swing.JTable jta1;
    // End of variables declaration//GEN-END:variables

}

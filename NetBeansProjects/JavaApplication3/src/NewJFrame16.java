import java.sql.*;
import javax.swing.table.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame16.java
 *
 * Created on Sep 21, 2014, 10:59:27 AM
 */

/**
 *
 * @author LOVEKUSH
 */
public class NewJFrame16 extends javax.swing.JFrame {

    /** Creates new form NewJFrame16 */
    public NewJFrame16() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jn1 = new javax.swing.JTextField();
        jc1 = new javax.swing.JTextField();
        jf1 = new javax.swing.JTextField();
        jm1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "class", "father_name", "mother_name"
            }
        ));
        jScrollPane1.setViewportView(jta);

        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("name");

        jLabel2.setText("class");

        jLabel3.setText("father_name");

        jLabel4.setText("mother_name");

        jm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm1ActionPerformed(evt);
            }
        });

        jButton2.setText("delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton4.setText("insert");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("search and display into table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("DISPlAy");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("CLEAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addGap(151, 151, 151)
                        .addComponent(jButton6)))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jf1)
                    .addComponent(jc1)
                    .addComponent(jn1)
                    .addComponent(jm1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search)
                    .addComponent(jButton4))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton6))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(77, 77, 77)
                        .addComponent(jButton5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(54, 54, 54))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jm1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int c;
String n,m,f;
c=Integer.parseInt(jc1.getText());
n = jn1.getText();
f=jf1.getText();
m=jm1.getText();
try{
    Class.forName("java.sql.Driver");
    Connection d=DriverManager.getConnection("jdbc:mysql://localhost/ip","root","");
    Statement s=d.createStatement();
    String q="insert into ip1 values('"+n+"',"+c+",'"+f+"','"+m+"')";
    s.executeUpdate(q);
    }
catch (Exception e)
{System.out.print(""+ e.getMessage());
}













        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
String n;
n=jn1.getText();
try
{ Class.forName("java.sql.Driver");
    Connection d=DriverManager.getConnection("jdbc:mysql://localhost/ip","root","");
    Statement s=d.createStatement();
    String q = "Select * from ip1 where name = '"+n+"'" ;
   ResultSet rs = s.executeQuery(q);
rs.next();
int i;
String a,b;

i=rs.getInt("class");
jc1.setText(""+i);
a=rs.getString("father_name");
jf1.setText(a);
b=rs.getString("mother_name");
jm1.setText(b);
}
catch (Exception e)
{System.out.print(""+ e.getMessage());
}





        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
String n;
n=jn1.getText();
DefaultTableModel o=(DefaultTableModel)jta.getModel();
try{
    Class.forName("java.sql.Driver");
    Connection d= DriverManager.getConnection("jdbc:mysql://localhost/ip","root","");
    Statement s=d.createStatement();
    String q ="Select * from ip1 where name='"+n+"'";
    ResultSet rs= s.executeQuery(q);
int i;
String a,b;
   while(rs.next())
   {i=rs.getInt("class");
a=rs.getString("father_name");
b=rs.getString("mother_name");
   o.addRow(new Object[]{n,i,a,b});
   }
}
catch (Exception e)
{System.out.print(""+ e.getMessage());
}











        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int c;
        c=Integer.parseInt(jc1.getText());
        try{
    Class.forName("java.sql.Driver");
    Connection d= DriverManager.getConnection("jdbc:mysql://localhost/ip","root","");
    Statement s=d.createStatement();

    String q="delete from ip1 where class ="+c;
  int i;
  i=  s.executeUpdate(q);

}
catch (Exception e)
{System.out.print(""+ e.getMessage());
}








    // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int c;
String n,m,f;
c=Integer.parseInt(jc1.getText());
n = jn1.getText();
f=jf1.getText();
m=jm1.getText();
try{
    Class.forName("java.sql.Driver");
    Connection d=DriverManager.getConnection("jdbc:mysql://localhost/ip","root","");
    Statement s=d.createStatement();
    String q="update ip1 set class ="+c+",father_name ='"+f+"',mother_name='"+m+"'where name='"+n+"'" ;
    s.executeUpdate(q);
    }
catch (Exception e)
{System.out.print(""+ e.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
DefaultTableModel d=(DefaultTableModel)jta.getModel();
 try
 {Class.forName("java.sql.Driver");
 Connection c=DriverManager.getConnection("jdbc:mysql://Localhost/ip","root","");
 Statement s=c.createStatement();
 String q="Select * from ip1 order by class";
 ResultSet rs=s.executeQuery(q);
 while(rs.next()==true)
 {int r=0;
  String n=null;
  n=rs.getString("name");
  r=rs.getInt("class");
  String p=rs.getString("father_name");
  String a=rs.getString("mother_name");

 d.addRow(new Object[]{n,r,p,a});
 }
 } catch (Exception e)
  {System.out.println(""+e.getMessage());}






        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
jf1.setText("");
jm1.setText("");
jn1.setText("");
jc1.setText("");


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame16().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jc1;
    private javax.swing.JTextField jf1;
    private javax.swing.JTextField jm1;
    private javax.swing.JTextField jn1;
    private javax.swing.JTable jta;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables

}


import javax.swing.table.*;
    import java.sql.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame20.java
 *
 * Created on Jan 6, 2015, 1:35:53 AM
 */

/**
 *
 * @author LOVEKUSH
 */
public class NewJFrame20 extends javax.swing.JFrame {

    /** Creates new form NewJFrame20 */
    public NewJFrame20() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jr1 = new javax.swing.JRadioButton();
        jr2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("DISPLAY WITH LIST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DISPLAY WITH RADIO BUTTON");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jr1.setText("DATE BEFORE 2014-05-01");

        jr2.setText("P_NAME START WITH A ");

        jl1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "D_NAME IS DR.JHA", "WHERE D_ID IS 119" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jl1);

        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sno", "p_name", "d_name", "date", "d_id"
            }
        ));
        jScrollPane2.setViewportView(jt1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jr2)
                            .addComponent(jr1))
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jr1)
                        .addGap(18, 18, 18)
                        .addComponent(jr2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
DefaultTableModel o =(DefaultTableModel)jt1.getModel();
        try
{ Class.forName("java.sql.Driver");
 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/sudsharma","root","");
 Statement s=c.createStatement();
 String q=null;
 int w = jl1.getSelectedIndex();
 switch(w)
 {
     case 0 : q ="Select * from hos where d_name='dr.jha'";
  break;
     case 1 : q="select * from hos where d_id =119 ";
     break;
 }
 ResultSet rs=s.executeQuery(q);
 String p,d;
 int m,i,t;
 while(rs.next())
 {m=rs.getInt("sno");
  p=rs.getString("p_name");
  d=rs.getString("d_name");
  t=rs.getInt("date");
  i=rs.getInt("d_id");
  o.addRow (new Object[]{m,p,d,t,i});
 }
        } catch(Exception e)
{System.out.print(""+e.getMessage());}





        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
DefaultTableModel d=(DefaultTableModel)jt1.getModel();
try
{ Class.forName("java.sql.Driver");
  Connection c=DriverManager.getConnection("jdbc:mysql://localhost/sudsharma","root","");
  Statement s=c.createStatement();
  String q=null;
  if (jr1.isSelected()==true)
      q="Select * from hos where date <'2104-05-01'";
  if (jr2.isSelected()==true)
      q="select * from hos where d_name like 'a%'";
ResultSet rs=s.executeQuery(q);
String p,u;
 int m,i,t;
 while(rs.next())
 {m=rs.getInt("sno");
  p=rs.getString("p_name");
  u=rs.getString("d_name");
  t=rs.getInt("date");
  i=rs.getInt("d_id");
  d.addRow (new Object[]{m,p,d,t,i});
   }
}catch(Exception e)
{   System.out.println("" + e.getMessage());
}



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame20().setVisible(true);
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
    private javax.swing.JTable jt1;
    // End of variables declaration//GEN-END:variables

}

package ox_project;

import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

public class F_register extends javax.swing.JFrame {

    /**
     * Creates new form F_register
     */
    public F_register() {
        initComponents();
    }

    // เอาไว้เช็คไอดีซ้ำ
    public static boolean booleancheckID = false;
    
    public void submitRegister(){
        
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:abc123456@ds237922.mlab.com:37922/ox_59160117");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
      
        MongoCollection<Document> user = db.getCollection("user");
        
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("ID",tx_id.getText())
                .append("Pass", tx_pass.getText())
                .append("Name", tx_Name.getText())
               
        );
        user.insertMany(seedData);
            JLabel label = new JLabel("สมัครเรียบร้อย");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label);
        
        client.close(); 
    }
    
    public boolean checkrepass(){
        if(tx_pass.getText().equals(tx_repass.getText())){
            System.out.println("ซ้ำ");
            return true;
        }else {
            return false;
        }
    }
    
    public void checkID(){
        
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:abc123456@ds237922.mlab.com:37922/ox_59160117");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("user");
       
        try {
            
            Document myDoc = user.find(eq("ID", tx_id.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckID = true;
            
        } catch (Exception e) {
            System.out.println("ดักว่าไอดีไม่ซ้ำ");
            //ดักไอดีซ้ำและคืนค่า Boolean
            booleancheckID = false;
        }      
    }
    public boolean checkEmpty(){
        if(tx_id.getText().equals("")||tx_pass.getText().equals("")||tx_Name.getText().equals("")){
           
            return true;
        }else {
            return false;
        }     
    }
    
    public void reset(){
        tx_Name.setText("");
        tx_id.setText("");
        tx_pass.setText("");
        tx_repass.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        btn_summit = new keeptoo.KButton();
        tx_id = new javax.swing.JTextField();
        tx_Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tx_pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tx_repass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_summit.setText("Register");
        btn_summit.setkBackGroundColor(new java.awt.Color(16, 218, 114));
        btn_summit.setkEndColor(new java.awt.Color(16, 218, 114));
        btn_summit.setkHoverEndColor(new java.awt.Color(16, 218, 114));
        btn_summit.setkHoverForeGround(new java.awt.Color(16, 218, 114));
        btn_summit.setkHoverStartColor(new java.awt.Color(16, 218, 114));
        btn_summit.setkSelectedColor(new java.awt.Color(16, 218, 114));
        btn_summit.setkStartColor(new java.awt.Color(16, 218, 114));
        btn_summit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_summitActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btn_summit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 140, 40));

        tx_id.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(tx_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 300, -1));

        tx_Name.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(tx_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 300, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User :");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pass :");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name :");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        tx_pass.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(tx_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 300, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ConfirmPass :");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        tx_repass.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        kGradientPanel1.add(tx_repass, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 300, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 70)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("REGISTER");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_summitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_summitActionPerformed
        // TODO add your handling code here:
        checkrepass();  
        checkID();
        checkEmpty();
        checkrepass();       
        if(booleancheckID){
            JLabel label = new JLabel("มีไอดีนี้อยู่ในระบบแล้ว");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
           
            reset();
        }else{
            if(checkEmpty()){
                JLabel label = new JLabel("กรุณากรอกข้อมูลให้ครบถ้วน");
                label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                reset();
             
            }else if(!checkEmpty()){
            if(!checkrepass()){
                JLabel label = new JLabel("Password ไม่ตรงกัน");
                label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                reset();
            }
            else{
                submitRegister();
                reset();
            }
             
            }
        }       
    }//GEN-LAST:event_btn_summitActionPerformed

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
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btn_summit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField tx_Name;
    private javax.swing.JTextField tx_id;
    private javax.swing.JPasswordField tx_pass;
    private javax.swing.JPasswordField tx_repass;
    // End of variables declaration//GEN-END:variables
}

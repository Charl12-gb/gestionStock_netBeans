/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionstock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gboyo
 */
public class Article extends javax.swing.JFrame {

    private static final String username = "pJava";
    private static final String password = "pJava12";
    private static final String dataConn = "jdbc:mysql://localhost:3306/gestionstock";
    
    Connection sqlCon = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    
   /**
     * Creates new form Article
     */
    public Article() {
        initComponents();
        upDateDB();
    }

    public void upDateDB(){
           try{
               Class.forName("com.mysql.jdbc.Driver");
                sqlCon = DriverManager.getConnection(dataConn,username, password);
                pst = sqlCon.prepareStatement("select * from article");
                
                rs = pst.executeQuery();
                ResultSetMetaData stData = rs.getMetaData();
                
                q = stData.getColumnCount();
                
                DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
                        RecordTable.setRowCount(0);
                        
                 while(rs.next()){
                     Vector columnData = new Vector();
                     
                     for(i=0; i<q; i++){
                         columnData.add(rs.getString("id"));
                         columnData.add(rs.getString("refpro"));
                         columnData.add(rs.getString("description"));
                         columnData.add(rs.getString("prix"));
                         columnData.add(rs.getString("prixpromo"));
                         columnData.add(rs.getString("qtestock"));
                     }
                     RecordTable.addRow(columnData);
                 }
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, ex);
           }
       }
    
    public void clean(){
        refpro.setText(null);
        desc.setText(null);
        prixArt.setText(null);
        prixPromo.setText(null);
        qteStock.setText(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        refpro = new javax.swing.JTextField();
        prixArt = new javax.swing.JTextField();
        prixPromo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        qteStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        rechercheChamp = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Article");
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ARTICLE");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("REFERENCE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PRIX");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("PRIX PROMO");

        prixArt.setText("0");

        prixPromo.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DESCRIPTION");

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        qteStock.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Qte Stock : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(refpro, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prixArt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(prixPromo)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(qteStock))
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refpro, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(prixPromo)
                    .addComponent(prixArt))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(qteStock)
                                .addGap(3, 3, 3)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "R??f??rence", "Description", "Prix", "Prix Promo", "Qte Stock"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(204, 0, 51));
        jButton3.setText("FERMER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rechercheChamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheChampActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Entrez le nom de l'article");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "R??f??rence", "Description", "Prix", "Prix Promo", "Qte Stock"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(379, 379, 379)
                                .addComponent(jButton3))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rechercheChamp, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rechercheChamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        Accueil accueil = new Accueil();
        accueil.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String ref = refpro.getText().toString();
       String des = desc.getText().toString();
       String prix = prixArt.getText().toString();
       String prixP = prixPromo.getText().toString();
       String st = qteStock.getText().toString();
        
        if(ref.equals("") ){
            JOptionPane.showMessageDialog(null, "La r??f??rence de l'article svp");
        }
        else if(prix.equals("") ){
            JOptionPane.showMessageDialog(null, "Prix de l'article");
        }
        else if(des.equals("") ){
            JOptionPane.showMessageDialog(null, "Description de l'article");
        }
        else{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                sqlCon = DriverManager.getConnection(dataConn,username, password);
                pst = sqlCon.prepareStatement("insert into article(refpro, description, prix, prixpromo, qtestock) values(?,?,?,?,?)");
                pst.setString(1, ref);
                pst.setString(2, des);
                pst.setString(3, prix);
                pst.setString(4, prixP);
                pst.setString(5, st);
                
                pst.executeUpdate();
                
                clean();
                
                JOptionPane.showMessageDialog(this, "Enregistrement valide");
                upDateDB();
                
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }catch(SQLException ex){
                java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRow = jTable1.getSelectedRow();
        
        refpro.setText(RecordTable.getValueAt(SelectedRow, 1).toString());
        desc.setText(RecordTable.getValueAt(SelectedRow, 2).toString());
        prixArt.setText(RecordTable.getValueAt(SelectedRow, 3).toString());
        prixPromo.setText(RecordTable.getValueAt(SelectedRow, 4).toString());
        qteStock.setText(RecordTable.getValueAt(SelectedRow, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clean();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRow = jTable1.getSelectedRow();
        
        try{
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRow, 0).toString());
            deleteItem = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ? ","Attention",JOptionPane.YES_NO_OPTION);
            if(deleteItem == JOptionPane.YES_OPTION){
                Class.forName("com.mysql.jdbc.Driver");
                sqlCon = DriverManager.getConnection(dataConn,username, password);
                pst = sqlCon.prepareStatement("delete from article where id=?");
                
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Article Supprimer");
                upDateDB();
                
                clean();
            }
        }catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRow = jTable1.getSelectedRow();
        
        String ref = refpro.getText().toString();
        String des = desc.getText().toString();
        String prix = prixArt.getText().toString();
        String prixP = prixPromo.getText().toString();
        String qte = qteStock.getText().toString();
        
        if(ref.equals("") ){
            JOptionPane.showMessageDialog(null, "La r??f??rence de l'article svp");
        }
        else if(prix.equals("") ){
            JOptionPane.showMessageDialog(null, "Prix de l'article");
        }
        else if(des.equals("") ){
            JOptionPane.showMessageDialog(null, "Description de l'article");
        }else{
            try{
                id = Integer.parseInt(RecordTable.getValueAt(SelectedRow, 0).toString());
                Class.forName("com.mysql.jdbc.Driver");
                sqlCon = DriverManager.getConnection(dataConn,username, password);
                pst = sqlCon.prepareStatement("update article set refpro=?, description=?, prix=?, prixpromo=?, qtestock=? where id="+id);
                
                pst.setString(1, ref);
                pst.setString(2, des);
                pst.setString(3, prix);
                pst.setString(4, prixP);
                pst.setString(5, qte);
                
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Modification effectu??e");
                upDateDB();
                
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }catch(SQLException ex){
                java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String val = rechercheChamp.getText().toString();
        
        if(val.equals("") ){
            JOptionPane.showMessageDialog(null, "Quoi rechercher ? ");
        }
        else{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                sqlCon = DriverManager.getConnection(dataConn,username, password);
                pst = sqlCon.prepareStatement("select * from article where refpro=?");
                pst.setString(1, val);
                
                rs = pst.executeQuery();
                ResultSetMetaData stData = rs.getMetaData();
                
                int q1 = stData.getColumnCount();
                
                DefaultTableModel RecordTable2 = (DefaultTableModel)jTable2.getModel();
                        RecordTable2.setRowCount(0);
                        
                 while(rs.next()){
                     Vector columnData1 = new Vector();
                     
                     for(int p=0; p<q1; p++){
                         columnData1.add(rs.getString("id"));
                         columnData1.add(rs.getString("refpro"));
                         columnData1.add(rs.getString("description"));
                         columnData1.add(rs.getString("prix"));
                         columnData1.add(rs.getString("prixpromo"));
                         columnData1.add(rs.getString("qtestock"));
                     }
                     RecordTable2.addRow(columnData1);
                 }
                
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }catch(SQLException ex){
                java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rechercheChampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheChampActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercheChampActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel)jTable2.getModel();
        int SelectedRow = jTable2.getSelectedRow();
        
        refpro.setText(RecordTable.getValueAt(SelectedRow, 1).toString());
        desc.setText(RecordTable.getValueAt(SelectedRow, 2).toString());
        prixArt.setText(RecordTable.getValueAt(SelectedRow, 3).toString());
        prixPromo.setText(RecordTable.getValueAt(SelectedRow, 4).toString());
        qteStock.setText(RecordTable.getValueAt(SelectedRow, 5).toString());
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Article().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea desc;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField prixArt;
    private javax.swing.JTextField prixPromo;
    private javax.swing.JTextField qteStock;
    private javax.swing.JTextField rechercheChamp;
    private javax.swing.JTextField refpro;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import Controller.DAO;
import DATA.QuanLyBao;
import DATA.QuanLySach;
import DATA.QuanLyTapChi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author loqco
 */
public class FindNewSpaperFast extends javax.swing.JFrame {

    /**
     * Creates new form FastFind
     */
    public FindNewSpaperFast() {
        initComponents();
        Show();

    }
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnReload = new javax.swing.JButton();
        btnReload1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tìm kiếm báo");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Nhập Tên hoặc mã báo");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        btnReload.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Refresh.png"))); // NOI18N
        btnReload.setText("Load");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        btnReload1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReload1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Exit.png"))); // NOI18N
        btnReload1.setText("Cancel");
        btnReload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReload1ActionPerformed(evt);
            }
        });

        tbBao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài liệu", "Mã báo", "Tên báo", "Ngày phát hành", "Tên NXB", "Tên tài liệu", "Số bản phát hành"
            }
        ));
        tbBao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReload)
                        .addGap(17, 17, 17)
                        .addComponent(btnReload1)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(316, 316, 316)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReload1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(86, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    public ArrayList<QuanLyBao> BaoList() {
        ArrayList<QuanLyBao> BaoList = new ArrayList<QuanLyBao>();
        con = DAO.getConnection();
        String show = "select TaiLieu.MaTaiLieu, MaBao, TenBao, NgayPhatHanh, TenNXB,TenTaiLieu, SoBan from Bao inner join TaiLieu on Bao.MaTaiLieu = TaiLieu.MaTaiLieu";
        try {
            st = con.createStatement();
            rs = st.executeQuery(show);
            QuanLyBao quanlybao;
            while (rs.next()) {
                quanlybao = new QuanLyBao(rs.getString("MaTaiLieu"), rs.getString("MaBao"), rs.getString("TenBao"), rs.getString("NgayPhatHanh"), rs.getString("TenNXB"), rs.getInt("SoBan"), rs.getString("TenTaiLieu"));
                BaoList.add(quanlybao);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return BaoList;
    }

    public ArrayList<QuanLyBao> BaoList_Find() {
        ArrayList<QuanLyBao> BaoList = new ArrayList<QuanLyBao>();
        con = DAO.getConnection();
        String show = "select TaiLieu.MaTaiLieu, MaBao, TenBao, NgayPhatHanh, TenNXB,TenTaiLieu, SoBan from Bao inner join TaiLieu on Bao.MaTaiLieu = TaiLieu.MaTaiLieu Where TenBao LIKE N'" + txtTimKiem.getText() + "%' OR MaBao LIKE N'%" + txtTimKiem.getText() + "%'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(show);
            QuanLyBao quanlybao;
            while (rs.next()) {
                quanlybao = new QuanLyBao(rs.getString("MaTaiLieu"), rs.getString("MaBao"), rs.getString("TenBao"), rs.getString("NgayPhatHanh"), rs.getString("TenNXB"), rs.getInt("SoBan"), rs.getString("TenTaiLieu"));
                BaoList.add(quanlybao);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return BaoList;
    }

    public void Show() {
        ArrayList<QuanLyBao> list = BaoList();
        DefaultTableModel model = (DefaultTableModel) tbBao.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaTaiLieu();
            row[1] = list.get(i).getMaBao();
            row[2] = list.get(i).getTenBao();
            row[3] = list.get(i).getNgayPhatHanh();
            row[4] = list.get(i).getTenNXB();
            row[5] = list.get(i).getTenTaiLieu();
            row[6] = list.get(i).getSoBan();
            model.addRow(row);
        }
    }
    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        try {
            ArrayList<QuanLyBao> findbao = BaoList_Find();
            DefaultTableModel model = (DefaultTableModel) tbBao.getModel();
            model.setRowCount(0);
            Object[] row = new Object[7];
            for (int i = 0; i < findbao.size(); i++) {
                row[0] = findbao.get(i).getMaTaiLieu();
                row[1] = findbao.get(i).getMaBao();
                row[2] = findbao.get(i).getTenBao();
                row[3] = findbao.get(i).getNgayPhatHanh();
                row[4] = findbao.get(i).getTenNXB();
                row[5] = findbao.get(i).getTenTaiLieu();
                row[6] = findbao.get(i).getSoBan();
                model.addRow(row);
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbBao.getModel();
        model.setRowCount(0);
        Show();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnReload1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReload1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnReload1ActionPerformed

    private void tbBaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBaoMouseClicked
       
    }//GEN-LAST:event_tbBaoMouseClicked

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
            java.util.logging.Logger.getLogger(FindNewSpaperFast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindNewSpaperFast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindNewSpaperFast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindNewSpaperFast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindNewSpaperFast().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnReload1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBao;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

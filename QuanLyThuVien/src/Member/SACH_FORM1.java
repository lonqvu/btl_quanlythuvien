/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

import quanlythuvien.*;
import Controller.DAO;
import DATA.QuanLySach;
import java.awt.Color;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import quanlythuvien.TAPCHI_FORM;
import java.lang.Exception;
import java.sql.SQLException;

/**
 *
 * @author loqco
 */
public class SACH_FORM1 extends javax.swing.JFrame {

    /**
     * Creates new form SACH_FORM
     */
    public SACH_FORM1() {
        initComponents();
        Show();
    }
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public ArrayList<QuanLySach> BooksList() {
        ArrayList<QuanLySach> BooksList = new ArrayList<QuanLySach>();
        con = DAO.getConnection();
        String show = "select TaiLieu.MaTaiLieu, MaSach, TenSach, TenTacGia, SoTrang, TenNXB,TenTaiLieu, SoBan from Sach inner join TaiLieu on Sach.MaTaiLieu = TaiLieu.MaTaiLieu";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(show);
            QuanLySach quanlysach;
            while (rs.next()) {
                quanlysach = new QuanLySach(rs.getString("MaTaiLieu"), rs.getString("MaSach"), rs.getString("TenSach"), rs.getString("TenTacGia"), rs.getInt("SoTrang"), rs.getString("TenNXB"), rs.getString("TenTaiLieu"), rs.getInt("SoBan"));
                BooksList.add(quanlysach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BooksList;
    }

    public ArrayList<QuanLySach> BooksList_Find() {
        ArrayList<QuanLySach> BooksList = new ArrayList<QuanLySach>();
        con = DAO.getConnection();
        String show = "select * from Sach inner join TaiLieu on Sach.MaTaiLieu = TaiLieu.MaTaiLieu Where TenSach LIKE N'" + txtTimKiem.getText() + "%'";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(show);
            QuanLySach quanlysach;
            while (rs.next()) {
                quanlysach = new QuanLySach(rs.getString("MaTaiLieu"), rs.getString("MaSach"), rs.getString("TenSach"), rs.getString("TenTacGia"), rs.getInt("SoTrang"), rs.getString("TenNXB"), rs.getString("TenTaiLieu"), rs.getInt("SoBan"));
                BooksList.add(quanlysach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BooksList;
    }

    public void Show() {
        ArrayList<QuanLySach> list = BooksList();
        DefaultTableModel model = (DefaultTableModel) tbSach.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaTaiLieu();
            row[1] = list.get(i).getMaSach();
            row[2] = list.get(i).getTenSach();
            row[3] = list.get(i).getTenTacGia();
            row[4] = list.get(i).getSoTrang();
            row[5] = list.get(i).getTenNXB();
            row[6] = list.get(i).getTenTaiLieu();
            row[7] = list.get(i).getSoBan();
            model.addRow(row);
        }
    }

    public void ExecuteSQL(String sql, String message) {
        con = DAO.getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if (st.executeUpdate(sql) == 1) {
                DefaultTableModel model = (DefaultTableModel) tbSach.getModel();
                model.setRowCount(0);
                Show();
                JOptionPane.showMessageDialog(null, message + " Th??nh c??ng!");

            } else {
                JOptionPane.showMessageDialog(null, message + " Kh??ng th??nh c??ng!");
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Kh??ng th??? th???c thi\nL???i: " + ex.getMessage(), "L???i", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtTenTG = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtSoTrang = new javax.swing.JTextField();
        txtMaTaiLieu = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtSoBan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenTaiLieu = new javax.swing.JTextField();
        b = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        f = new javax.swing.JLabel();
        e = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnReload1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QU???N L?? S??CH");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Books-2-icon.png"))); // NOI18N
        jLabel2.setText("TH??NG TIN S??CH");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Th??ng tin s??ch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("T??n s??ch");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("T??n t??c gi???");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("M?? s??ch");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("S??? trang");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("M?? t??i li???u");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("S??? b???n ph??t h??nh");

        txtTenSach.setEnabled(false);

        txtTenTG.setEnabled(false);
        txtTenTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTGActionPerformed(evt);
            }
        });

        txtMaSach.setEnabled(false);
        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        txtSoTrang.setEnabled(false);

        txtMaTaiLieu.setText("T001");
        txtMaTaiLieu.setEnabled(false);
        txtMaTaiLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTaiLieuActionPerformed(evt);
            }
        });

        txtNXB.setEnabled(false);

        txtSoBan.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("T??n t??i li???u");

        txtTenTaiLieu.setText("S??ch");
        txtTenTaiLieu.setEnabled(false);
        txtTenTaiLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTaiLieuActionPerformed(evt);
            }
        });

        b.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        a.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        c.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        d.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        f.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        e.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("NXB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b)
                    .addComponent(c)
                    .addComponent(d))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenTaiLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaTaiLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f)
                    .addComponent(e))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(a)
                        .addGap(18, 18, 18)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaTaiLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenTaiLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(24, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        tbSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? t??i li???u", "M?? s??ch", "T??n s??ch", "T??n t??c gi???", "S??? trang", "NXB", "T??n t??i li???u", "S??? b???n ph??t h??nh"
            }
        ));
        tbSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSach);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "T??m ki???m", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search-icon (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Refresh.png"))); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(386, 386, 386))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReload1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReload1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTGActionPerformed

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        int i = tbSach.getSelectedRow();
        TableModel model = tbSach.getModel();
        txtMaTaiLieu.setText(model.getValueAt(i, 0).toString());
        txtMaSach.setText(model.getValueAt(i, 1).toString());
        txtTenSach.setText(model.getValueAt(i, 2).toString());
        txtTenTG.setText(model.getValueAt(i, 3).toString());
        txtSoTrang.setText(model.getValueAt(i, 4).toString());
        txtNXB.setText(model.getValueAt(i, 5).toString());
        txtTenTaiLieu.setText(model.getValueAt(i, 6).toString());
        txtSoBan.setText(model.getValueAt(i, 7).toString());


    }//GEN-LAST:event_tbSachMouseClicked

    private void txtMaTaiLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTaiLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTaiLieuActionPerformed

    private void txtTenTaiLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTaiLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTaiLieuActionPerformed

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        try {
            ArrayList<QuanLySach> list = BooksList_Find();
            DefaultTableModel model = (DefaultTableModel) tbSach.getModel();
            model.setRowCount(0);
            Object[] row = new Object[8];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getMaTaiLieu();
                row[1] = list.get(i).getMaSach();
                row[2] = list.get(i).getTenSach();
                row[3] = list.get(i).getTenTacGia();
                row[4] = list.get(i).getSoTrang();
                row[5] = list.get(i).getTenNXB();
                row[6] = list.get(i).getTenTaiLieu();
                row[7] = list.get(i).getSoBan();
                model.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        f.setText("");
        e.setText("");
        txtMaSach.setText("");
        txtTimKiem.setText("");
        txtTenSach.setText("");
        txtTenTG.setText("");
        txtSoTrang.setText("");
        txtNXB.setText("");
        txtSoBan.setText("");
        DefaultTableModel model = (DefaultTableModel) tbSach.getModel();
        model.setRowCount(0);
        Show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnReload1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReload1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnReload1ActionPerformed

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
            java.util.logging.Logger.getLogger(SACH_FORM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SACH_FORM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SACH_FORM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SACH_FORM1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SACH_FORM1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JLabel b;
    private javax.swing.JButton btnReload1;
    private javax.swing.JLabel c;
    private javax.swing.JLabel d;
    private javax.swing.JLabel e;
    private javax.swing.JLabel f;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaTaiLieu;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtSoBan;
    private javax.swing.JTextField txtSoTrang;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTG;
    private javax.swing.JTextField txtTenTaiLieu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.kepemilikan;

import aplikasi.config.KoneksiDB;
import aplikasi.controller.TableViewController;
import aplikasi.entity.Kepemilikan;
import aplikasi.repository.RepoKepemilikan;
import aplikasi.service.ServiceKepemilikan;
import aplikasi.view.MainMenuView;
import aplikasi.view.menu.status.DaftarStatusView;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dhiskar
 */
public class DaftarKepemilikanView extends javax.swing.JInternalFrame {

    private List<Kepemilikan> daftarPelanggan = new ArrayList<>();
    private final RepoKepemilikan repo;
    private final MainMenuView menuController;
    private final TableViewController tableController;

    /**
     * Creates new form DaftarAsetView
     *
     * @param menuController
     */
    public DaftarKepemilikanView(MainMenuView menuController) {
        initComponents();
        this.menuController = menuController;
        this.tableController = new TableViewController(tableView);
        this.repo = new ServiceKepemilikan(KoneksiDB.getDataSource());
        refreshDataTable();

    }

    public void refreshDataTable() {
        try {
            this.tableController.clearData();
            daftarPelanggan = repo.findAll();
            for (Kepemilikan p : daftarPelanggan) {
                Object[] row = {p.getId_kepemilikan(), p.getNama(), p.getTlp(), p.getAlamat(), p.getKet()};
                tableController.getModel().addRow(row);
            }
            tableController.setContentTableAlignment(Arrays.asList(0, 2));
        } catch (SQLException e) {
            Logger.getLogger(DaftarStatusView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void selectLastRow(){
        tableView.setRowSelectionInterval(tableView.getRowCount()-1,tableView.getRowCount()-1);
        tableView.scrollRectToVisible(new Rectangle(tableView.getCellRect(tableView.getRowCount()-1, 0, true)));
    }
    public void refreshDataTableByName() {
        try {
            this.tableController.clearData();
            daftarPelanggan = repo.findByNama(txtCari.getText());
            for (Kepemilikan p : daftarPelanggan) {
                Object[] row = {p.getId_kepemilikan(), p.getNama(), p.getTlp(), p.getAlamat(), p.getKet()};
                tableController.getModel().addRow(row);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaftarStatusView.class.getName()).log(Level.SEVERE, null, e);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pmnuUbah = new javax.swing.JMenuItem();
        pmnuHapus = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        pmnuTambah = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtTlp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKet = new javax.swing.JTextArea();

        pmnuUbah.setText("Ubah");
        pmnuUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuUbahActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuUbah);

        pmnuHapus.setText("Hapus");
        pmnuHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuHapusActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuHapus);
        jPopupMenu1.add(jSeparator1);

        pmnuTambah.setText("Tambah");
        pmnuTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuTambahActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuTambah);

        setTitle("Master Kepemilikan");
        setMinimumSize(new java.awt.Dimension(53, 22));
        setPreferredSize(new java.awt.Dimension(710, 490));
        setVisible(true);

        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 45));

        btnHapus.setText("Hapus");
        btnHapus.setToolTipText("Hapus data, khusus untuk data yang belum ada kaitan dengan tabel lain");
        btnHapus.setFocusable(false);
        btnHapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapus.setMaximumSize(new java.awt.Dimension(120, 35));
        btnHapus.setMinimumSize(new java.awt.Dimension(120, 35));
        btnHapus.setPreferredSize(new java.awt.Dimension(120, 35));
        btnHapus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHapus);

        btnUbah.setText("Ubah");
        btnUbah.setToolTipText("Ubah data yang dipilih");
        btnUbah.setFocusable(false);
        btnUbah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUbah.setMaximumSize(new java.awt.Dimension(120, 35));
        btnUbah.setMinimumSize(new java.awt.Dimension(120, 35));
        btnUbah.setPreferredSize(new java.awt.Dimension(120, 35));
        btnUbah.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUbah);

        btnTambah.setText("Tambah");
        btnTambah.setToolTipText("Tambah data baru");
        btnTambah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTambah.setMaximumSize(new java.awt.Dimension(120, 35));
        btnTambah.setMinimumSize(new java.awt.Dimension(120, 35));
        btnTambah.setPreferredSize(new java.awt.Dimension(120, 35));
        btnTambah.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        btnTambah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnTambahKeyReleased(evt);
            }
        });
        jToolBar1.add(btnTambah);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Kepemilkan"));

        txtCari.setToolTipText("Pencarian berdasarkan nama");
        txtCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCariCaretUpdate(evt);
            }
        });

        lblCari.setText("Cari");
        lblCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMouseClicked(evt);
            }
        });

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Telepon", "Alamat", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableViewMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableViewMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableView);
        if (tableView.getColumnModel().getColumnCount() > 0) {
            tableView.getColumnModel().getColumn(0).setMinWidth(50);
            tableView.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableView.getColumnModel().getColumn(0).setMaxWidth(50);
            tableView.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableView.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(2).setMaxWidth(150);
            tableView.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleName("Daftar Aset");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kepemilikan"));
        jPanel4.setAutoscrolls(true);
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 429));

        jLabel12.setText("Kode");

        jLabel13.setText("Nama");

        jLabel14.setText("Telepon");

        txtKode.setEditable(false);

        txtNama.setEditable(false);
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtTlp.setEditable(false);

        jLabel15.setText("Alamat");

        jLabel16.setText("Keterangan");

        txtAlamat.setEditable(false);
        txtAlamat.setColumns(20);
        txtAlamat.setLineWrap(true);
        txtAlamat.setRows(5);
        jScrollPane2.setViewportView(txtAlamat);

        txtKet.setEditable(false);
        txtKet.setColumns(20);
        txtKet.setLineWrap(true);
        txtKet.setRows(5);
        jScrollPane3.setViewportView(txtKet);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(txtNama))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtTlp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (tableController.isSelected()) {
            Kepemilikan pelangan = daftarPelanggan.get(tableController.getRowSelected());
            int jawab = JOptionPane.showOptionDialog(this, "Ingin Menghaspus data dengan kode " + pelangan.getId_kepemilikan() + " ?", getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (jawab == JOptionPane.YES_OPTION) {

                try {
                    repo.delete(pelangan.getId_kepemilikan());
                    refreshDataTableByName();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Tidak dapat menghapus data kepemilikan", getTitle(), JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DaftarKepemilikanView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data kepemilikan belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (tableController.isSelected()) {
            Kepemilikan kepemilikan = daftarPelanggan.get(tableController.getRowSelected());
//            System.out.println(kepemilikan.getId_kepemilikan()+kepemilikan.getNama()+kepemilikan.getAlamat());
            DataKepemilikanView view = new DataKepemilikanView(menuController, this, kepemilikan, true);
            view.setLocationRelativeTo(null);
            view.setResizable(false);
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Data kepemilikan belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        DataKepemilikanView view = new DataKepemilikanView(menuController, this, true);
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCariCaretUpdate
        refreshDataTableByName();
    }//GEN-LAST:event_txtCariCaretUpdate

    private void tableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseClicked
        if (tableController.isSelected()) {
            Kepemilikan kepemilikan = daftarPelanggan.get(tableController.getRowSelected());
            setFields(kepemilikan);
        } else {
            clearFields();
        }
    }//GEN-LAST:event_tableViewMouseClicked

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void pmnuUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuUbahActionPerformed
        btnUbahActionPerformed(evt);
    }//GEN-LAST:event_pmnuUbahActionPerformed

    private void pmnuHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuHapusActionPerformed
        btnHapusActionPerformed(evt);
    }//GEN-LAST:event_pmnuHapusActionPerformed

    private void pmnuTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuTambahActionPerformed
        btnTambahActionPerformed(evt);
    }//GEN-LAST:event_pmnuTambahActionPerformed

    private void tableViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseReleased
        if (evt.isPopupTrigger()) {
            JTable source = (JTable) evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());
            int column = source.columnAtPoint(evt.getPoint());
            if (!source.isRowSelected(row)) {
                source.changeSelection(row, column, false, false);
            }
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        } 
    }//GEN-LAST:event_tableViewMouseReleased

    private void lblCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMouseClicked
        if (evt.getClickCount()==2) {
            txtCari.setText("");
            txtCari.requestFocus();
        }
    }//GEN-LAST:event_lblCariMouseClicked

    private void btnTambahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTambahKeyReleased
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
            btnTambahActionPerformed(null);
        }
    }//GEN-LAST:event_btnTambahKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JMenuItem pmnuHapus;
    private javax.swing.JMenuItem pmnuTambah;
    private javax.swing.JMenuItem pmnuUbah;
    private javax.swing.JTable tableView;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextArea txtKet;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTlp;
    // End of variables declaration//GEN-END:variables

    public void setFields(Kepemilikan kepemilikan) {
        txtKode.setText(kepemilikan.getId_kepemilikan().toString());
        txtNama.setText(kepemilikan.getNama());
        txtTlp.setText(kepemilikan.getTlp());
        txtAlamat.setText(kepemilikan.getAlamat());
        txtKet.setText(kepemilikan.getKet());

    }

    private void clearFields() {
        txtKode.setText("");
        txtNama.setText("");
        txtTlp.setText("");
        txtAlamat.setText("");
        txtKet.setText("");
    }
}

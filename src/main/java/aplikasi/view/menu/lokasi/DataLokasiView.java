/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.lokasi;

import static aplikasi.config.AllFieldNotEmpty.areAllNotEmpty;
import aplikasi.config.FieldLimit;
import aplikasi.config.FieldMinimal;
import aplikasi.config.KoneksiDB;
import aplikasi.entity.LokasiAset;
import aplikasi.repository.RepoLokasiAset;
import aplikasi.service.ServiceLokasiAset;
import aplikasi.view.MainMenuView;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dhiskar
 */
public class DataLokasiView extends javax.swing.JDialog {

    private List<LokasiAset> daftarLokasi = new ArrayList<>();
    private DaftarLokasiView daftarLokasiViewController;
    private Boolean update;
    private final LokasiAset lokasiAset;
    private FieldMinimal jTextFieldMinimal;
    private final RepoLokasiAset repoLokasiAset = new ServiceLokasiAset(KoneksiDB.getDataSource());

    DataLokasiView(java.awt.Frame parent, DaftarLokasiView daftarLokasiViewController, boolean b) {
        super(parent, b);
        initComponents();
        setUpdate(false);
        this.daftarLokasiViewController = daftarLokasiViewController;
        this.lokasiAset = new LokasiAset();
        this.jTextFieldMinimal = new FieldMinimal();
        textFieldLimit();
        ambilIdTerbesar();
        txtNamaRak.requestFocus();
    }

    DataLokasiView(java.awt.Frame parent, DaftarLokasiView daftarLokasiViewController, LokasiAset lokasiAset, boolean b) {
        super(parent, b);
        initComponents();
        setUpdate(true);
        textFieldLimit();
        setFilds(lokasiAset);
        this.daftarLokasiViewController = daftarLokasiViewController;
        this.lokasiAset = new LokasiAset();
        this.jTextFieldMinimal = new FieldMinimal();
        txtNamaRak.requestFocus();
    }

    public DataLokasiView(java.awt.Frame parent, boolean b) {
        super(parent, b);
        initComponents();
        setUpdate(false);
        this.lokasiAset = new LokasiAset();
        this.jTextFieldMinimal = new FieldMinimal();
        textFieldLimit();
        ambilIdTerbesar();
        txtNamaRak.requestFocus();
    }

    public Boolean isUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    private void textFieldLimit() {
        txtNamaRak.setDocument(new FieldLimit(10));
        txtLokasi.setDocument(new FieldLimit(10));
    }

    private void ambilIdTerbesar() {
        try {
            daftarLokasi = repoLokasiAset.findMaxValue();
            if (daftarLokasi.size() != 0) {
                for (LokasiAset p : daftarLokasi) {
                    int i = p.getId_lokasi() + 1;
                    txtKode.setText(String.valueOf(i));
                }

            } else {
                txtKode.setText("1");
            }
        } catch (Exception e) {
            Logger.getLogger(DataLokasiView.class.getName()).log(Level.SEVERE, null, e);

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

        jToolBar1 = new javax.swing.JToolBar();
        btnSimpan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNamaRak = new javax.swing.JTextField();
        txtLokasi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lokasi");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo3.png")).getImage());

        jToolBar1.setRollover(true);

        btnSimpan.setText("Simpan");
        btnSimpan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSimpan.setMaximumSize(new java.awt.Dimension(120, 35));
        btnSimpan.setMinimumSize(new java.awt.Dimension(120, 35));
        btnSimpan.setPreferredSize(new java.awt.Dimension(120, 35));
        btnSimpan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        btnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSimpanKeyReleased(evt);
            }
        });
        jToolBar1.add(btnSimpan);

        btnKembali.setText("Kembali");
        btnKembali.setFocusable(false);
        btnKembali.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKembali.setMaximumSize(new java.awt.Dimension(120, 35));
        btnKembali.setMinimumSize(new java.awt.Dimension(120, 35));
        btnKembali.setPreferredSize(new java.awt.Dimension(120, 35));
        btnKembali.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKembali);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Lokasi Aset"));

        jLabel1.setText("Kode");

        jLabel2.setText("Nomor Rak ");

        jLabel3.setText("Lokasi ");

        txtKode.setEditable(false);
        txtKode.setFocusable(false);

        txtNamaRak.setToolTipText("Nama Rak minimal 5 karakter, maxomal 10 karakter dan hanya huruf");

        txtLokasi.setToolTipText("Nama Rak minimal 4 karakter, maxomal 10 karakter dan hanya huruf");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaRak, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamaRak, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLokasi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!jTextFieldMinimal.setMinInputValue(txtNamaRak.getText(), 5) || !jTextFieldMinimal.setOnlyLetter(txtNamaRak.getText())) {
             JOptionPane.showMessageDialog(this, "Nama Rak minimal 5 karakter dan hanya huruf !");
             txtNamaRak.requestFocus();
             txtNamaRak.selectAll();
        }else if (!jTextFieldMinimal.setMinInputValue(txtLokasi.getText(), 4)){
             JOptionPane.showMessageDialog(this, "Lokasi minimal 4 karakter !");
             txtLokasi.requestFocus();
             txtLokasi.selectAll();
        } else {
        lokasiAset.setId_lokasi(Integer.valueOf(txtKode.getText()));
        lokasiAset.setNama_rak(txtNamaRak.getText());
        lokasiAset.setLokasi(txtLokasi.getText());

            if (isUpdate()) {
                try {
                    repoLokasiAset.update(lokasiAset);
                    this.dispose();
                    if (daftarLokasiViewController != null) {
                        daftarLokasiViewController.refreshDataTableByName();
                        daftarLokasiViewController.setFields(lokasiAset);
                        daftarLokasiViewController.btnTambahRequesFocus();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Tidak dapat merubah data lokasiAset", getTitle(), JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DataLokasiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    repoLokasiAset.save(lokasiAset);
                    this.dispose();
                    if (daftarLokasiViewController != null) {
                        daftarLokasiViewController.refreshDataTableByName();
                        daftarLokasiViewController.setFields(lokasiAset);
                        daftarLokasiViewController.selectLastRow();

                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Tidak dapat menyimpan data lokasiAset", getTitle(), JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DataLokasiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSimpanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSimpanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSimpanActionPerformed(null);
        }
    }//GEN-LAST:event_btnSimpanKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtLokasi;
    private javax.swing.JTextField txtNamaRak;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        txtKode.setText("");
        txtNamaRak.setText("");
        txtLokasi.setText("");
    }

    private void setFilds(LokasiAset lokasiAset) {
        txtKode.setText(lokasiAset.getId_lokasi().toString());
        txtNamaRak.setText(lokasiAset.getNama_rak());
        txtLokasi.setText(lokasiAset.getLokasi());
    }

}

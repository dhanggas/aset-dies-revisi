/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.laporan;

import aplikasi.config.FieldLimit;
import aplikasi.config.KoneksiDB;
import aplikasi.controller.TableViewController;
import aplikasi.entity.Aset;
import aplikasi.entity.KategoriAset;
import aplikasi.entity.Kepemilikan;
import aplikasi.entity.StatusAset;
import aplikasi.entity.Users;
import aplikasi.repository.RepoAset;
import aplikasi.repository.RepoKategoriAset;
import aplikasi.repository.RepoLokasiAset;
import aplikasi.repository.RepoKepemilikan;
import aplikasi.repository.RepoStatusAset;
import aplikasi.repository.RepoUsers;
import aplikasi.service.ServiceAset;
import aplikasi.service.ServiceKategoriAset;
import aplikasi.service.ServiceLokasiAset;
import aplikasi.service.ServiceKepemilikan;
import aplikasi.service.ServiceStatusAset;
import aplikasi.service.ServiceUsers;
import aplikasi.view.MainMenuView;
import aplikasi.view.menu.aset.DataAsetView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author laptop
 */
public class LaporanAset extends javax.swing.JInternalFrame {

    private final MainMenuView menuController;
    private final RepoAset repoAset;
    private final TableViewController tableController;

    private final RepoKategoriAset repoKategori = new ServiceKategoriAset(KoneksiDB.getDataSource());
    private final RepoKepemilikan repoKepemilikan = new ServiceKepemilikan(KoneksiDB.getDataSource());
    private final RepoStatusAset repoStatus = new ServiceStatusAset(KoneksiDB.getDataSource());
    private final RepoLokasiAset repoLokasi = new ServiceLokasiAset(KoneksiDB.getDataSource());
    private final RepoUsers repoUser = new ServiceUsers(KoneksiDB.getDataSource());

    private List<Aset> daftarAset = new ArrayList<>();
    private List<KategoriAset> daftarKategori = new ArrayList<>();
    private List<Kepemilikan> daftarKepemilikan = new ArrayList<>();
    private List<StatusAset> daftarStatus = new ArrayList<>();
    private List<String> daftarLokasi = new ArrayList<>();
    private List<Users> daftarUser = new ArrayList<>();

    private Users p;

    public LaporanAset(MainMenuView menuController, Users p) {
        this.menuController = menuController;
        this.repoAset = new ServiceAset(KoneksiDB.getDataSource());
        this.p = p;
        initComponents();
        this.tableController = new TableViewController(tableView);
        refresDataKategoriAset();
        refresDataStatus();
        refresDataCustomer();
        refresDataUser();
        refresDataLokasi();
        textFieldLimit();
        refreshDataTables();
    }

    public void refreshDataTables() {
        int total = 0;
        try {
            tableController.clearData();
            this.daftarAset = repoAset.findAll();
            for (Aset aset : daftarAset) {
                Object[] row = {aset.getKode(), aset.getNama(), aset.getKategoriAset().getNama_kategori(),
                    aset.getStatusAset().getStatus(), aset.getLokasiAset().getNama_rak(), aset.getLokasiAset().getLokasi(),
                    aset.getKepemilikan().getNama(), aset.getQty(), aset.getSatuan(), aset.getUsers().getUsername()};
                tableController.getModel().addRow(row);
                total = total + aset.getQty();
            }
            lblTotal.setText(" " + total + " aset dies ditemukan");
            tableController.setContentTableAlignment(Arrays.asList(0, 2, 3, 4, 5, 6, 7, 8, 9));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Tidak dapat mendapatkan data aset", getTitle(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LaporanAset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void textFieldLimit() {
        txtNamaAset.setDocument(new FieldLimit(30));
        txtNamaRak.setDocument(new FieldLimit(10));
    }

    private void refresDataKategoriAset() {
        try {
            txtKategori.removeAllItems();
            txtKategori.addItem("%");
            daftarKategori = repoKategori.findAll();
            for (KategoriAset ka : daftarKategori) {
                txtKategori.addItem(ka.getNama_kategori());
            }
            txtKategori.setSelectedItem("%");
        } catch (SQLException ex) {
            Logger.getLogger(DataAsetView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refresDataStatus() {
        try {
            txtStatus.removeAllItems();
            txtStatus.addItem("%");
            daftarStatus = repoStatus.findAll();
            for (StatusAset ds : daftarStatus) {
                txtStatus.addItem(ds.getStatus());
            }
            txtStatus.setSelectedItem("%");
        } catch (SQLException ex) {
            Logger.getLogger(DataAsetView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void refresDataCustomer() {
        try {
            txtKepemilikan.removeAllItems();
            txtKepemilikan.addItem("%");
            daftarKepemilikan = repoKepemilikan.findAll();
            for (Kepemilikan ds : daftarKepemilikan) {
                txtKepemilikan.addItem(ds.getNama());
            }
            txtKepemilikan.setSelectedItem("%");
        } catch (SQLException ex) {
            Logger.getLogger(DataAsetView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refresDataLokasi() {
        try {
            txtLokasi.removeAllItems();
            txtLokasi.addItem("%");
            daftarLokasi = repoLokasi.findNamaLokasi();
            for (String ds : daftarLokasi) {
                txtLokasi.addItem(ds);
            }
            txtLokasi.setSelectedItem("%");
        } catch (SQLException ex) {
            Logger.getLogger(DataAsetView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refresDataUser() {
        try {
            txtUser.removeAllItems();
            txtUser.addItem("%");
            daftarUser = repoUser.findAll();
            for (Users u : daftarUser) {
                txtUser.addItem(u.getUsername());
            }
            txtUser.setSelectedItem("%");
        } catch (SQLException ex) {
            Logger.getLogger(DataAsetView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshDataTablesWithFilter() {
        int total = 0;
        try {

            tableController.clearData();
            this.daftarAset = repoAset.findFilterAlll(txtNamaAset.getText(), txtKategori.getSelectedItem().toString(), txtStatus.getSelectedItem().toString(), txtNamaRak.getText(), txtLokasi.getSelectedItem().toString(), txtKepemilikan.getSelectedItem().toString(), txtQty.getSelectedItem().toString(), txtUser.getSelectedItem().toString());
            for (Aset aset : daftarAset) {

                Object[] row = {aset.getKode(), aset.getNama(), aset.getKategoriAset().getNama_kategori(),
                    aset.getStatusAset().getStatus(), aset.getLokasiAset().getNama_rak(), aset.getLokasiAset().getLokasi(),
                    aset.getKepemilikan().getNama(), aset.getQty(), aset.getSatuan(), aset.getUsers().getUsername()};
                tableController.getModel().addRow(row);
                total = total + aset.getQty();
            }
            lblTotal.setText(" " + total + " aset dies ditemukan");
            tableController.setContentTableAlignment(Arrays.asList(0, 2, 3, 4, 5, 6, 7, 8, 9));
        } catch (Exception ex) {
//            Logger.getLogger(LaporanDataAset.class.getName()).log(Level.SEVERE, null, ex);
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
        pmnuLihatTransaksi = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        txtKategori = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        txtLokasi = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        txtUser = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        txtKepemilikan = new javax.swing.JComboBox<String>();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        lblTotal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        txtNamaAset = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNamaRak = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQty = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JComboBox<String>();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCetak = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();

        pmnuLihatTransaksi.setText("Lihat Transaksi");
        pmnuLihatTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuLihatTransaksiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuLihatTransaksi);

        setTitle("Laporan Aset");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filter Laporan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(721, 93));

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setMaximumSize(new java.awt.Dimension(327867, 328767));

        jPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 29));
        jPanel5.setPreferredSize(new java.awt.Dimension(515, 29));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(98626, 29));
        jToolBar1.setMinimumSize(new java.awt.Dimension(497, 29));
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 29));

        jLabel2.setText(" Kategori :");
        jLabel2.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel2.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar1.add(jLabel2);

        txtKategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtKategori.setToolTipText("");
        txtKategori.setMaximumSize(new java.awt.Dimension(125, 29));
        txtKategori.setMinimumSize(new java.awt.Dimension(125, 29));
        txtKategori.setPreferredSize(new java.awt.Dimension(125, 29));
        txtKategori.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtKategoriItemStateChanged(evt);
            }
        });
        txtKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKategoriMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtKategoriMouseReleased(evt);
            }
        });
        txtKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKategoriActionPerformed(evt);
            }
        });
        txtKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKategoriKeyPressed(evt);
            }
        });
        jToolBar1.add(txtKategori);

        jLabel5.setText(" Lokasi :");
        jLabel5.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel5.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar1.add(jLabel5);

        txtLokasi.setToolTipText("");
        txtLokasi.setMaximumSize(new java.awt.Dimension(125, 29));
        txtLokasi.setMinimumSize(new java.awt.Dimension(125, 29));
        txtLokasi.setPreferredSize(new java.awt.Dimension(125, 29));
        txtLokasi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtLokasiItemStateChanged(evt);
            }
        });
        jToolBar1.add(txtLokasi);

        jLabel8.setText(" Di input :");
        jLabel8.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel8.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar1.add(jLabel8);

        txtUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtUser.setToolTipText("");
        txtUser.setMaximumSize(new java.awt.Dimension(125, 29));
        txtUser.setMinimumSize(new java.awt.Dimension(125, 29));
        txtUser.setPreferredSize(new java.awt.Dimension(125, 29));
        txtUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtUserItemStateChanged(evt);
            }
        });
        jToolBar1.add(txtUser);

        jLabel6.setText(" Kepemilikan :");
        jLabel6.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel6.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar1.add(jLabel6);

        txtKepemilikan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtKepemilikan.setToolTipText("");
        txtKepemilikan.setMaximumSize(new java.awt.Dimension(200, 29));
        txtKepemilikan.setMinimumSize(new java.awt.Dimension(200, 29));
        txtKepemilikan.setPreferredSize(new java.awt.Dimension(200, 29));
        txtKepemilikan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtKepemilikanItemStateChanged(evt);
            }
        });
        jToolBar1.add(txtKepemilikan);

        jSeparator2.setMaximumSize(new java.awt.Dimension(5, 5));
        jSeparator2.setMinimumSize(new java.awt.Dimension(5, 5));
        jSeparator2.setPreferredSize(new java.awt.Dimension(5, 5));
        jSeparator2.setSeparatorSize(new java.awt.Dimension(5, 5));
        jToolBar1.add(jSeparator2);

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(82, 130, 179));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("lblTotal");
        jToolBar1.add(lblTotal);

        jPanel5.add(jToolBar1, java.awt.BorderLayout.CENTER);

        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 29));
        jPanel4.setPreferredSize(new java.awt.Dimension(1079, 29));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);
        jToolBar2.setPreferredSize(new java.awt.Dimension(100, 29));

        jLabel1.setText(" Nama Aset :");
        jLabel1.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel1.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar2.add(jLabel1);

        txtNamaAset.setToolTipText("");
        txtNamaAset.setMaximumSize(new java.awt.Dimension(125, 29));
        txtNamaAset.setMinimumSize(new java.awt.Dimension(125, 29));
        txtNamaAset.setPreferredSize(new java.awt.Dimension(125, 29));
        txtNamaAset.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNamaAsetCaretUpdate(evt);
            }
        });
        txtNamaAset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaAsetActionPerformed(evt);
            }
        });
        txtNamaAset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaAsetKeyReleased(evt);
            }
        });
        jToolBar2.add(txtNamaAset);

        jLabel4.setText(" No Rak :");
        jLabel4.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel4.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar2.add(jLabel4);

        txtNamaRak.setToolTipText("");
        txtNamaRak.setMaximumSize(new java.awt.Dimension(125, 29));
        txtNamaRak.setMinimumSize(new java.awt.Dimension(125, 29));
        txtNamaRak.setPreferredSize(new java.awt.Dimension(125, 29));
        txtNamaRak.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNamaRakCaretUpdate(evt);
            }
        });
        txtNamaRak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaRakActionPerformed(evt);
            }
        });
        txtNamaRak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaRakKeyReleased(evt);
            }
        });
        jToolBar2.add(txtNamaRak);

        jLabel7.setText(" Qty :");
        jLabel7.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel7.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar2.add(jLabel7);

        txtQty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%", "0", "1" }));
        txtQty.setToolTipText("");
        txtQty.setMaximumSize(new java.awt.Dimension(125, 29));
        txtQty.setMinimumSize(new java.awt.Dimension(125, 29));
        txtQty.setPreferredSize(new java.awt.Dimension(125, 29));
        txtQty.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtQtyItemStateChanged(evt);
            }
        });
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        jToolBar2.add(txtQty);

        jLabel3.setText(" Status :");
        jLabel3.setMaximumSize(new java.awt.Dimension(80, 29));
        jLabel3.setMinimumSize(new java.awt.Dimension(80, 29));
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 29));
        jToolBar2.add(jLabel3);

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtStatus.setToolTipText("");
        txtStatus.setMaximumSize(new java.awt.Dimension(200, 29));
        txtStatus.setMinimumSize(new java.awt.Dimension(200, 29));
        txtStatus.setPreferredSize(new java.awt.Dimension(200, 29));
        txtStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtStatusItemStateChanged(evt);
            }
        });
        jToolBar2.add(txtStatus);

        jSeparator1.setMaximumSize(new java.awt.Dimension(5, 5));
        jSeparator1.setMinimumSize(new java.awt.Dimension(5, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 5));
        jSeparator1.setSeparatorSize(new java.awt.Dimension(5, 5));
        jToolBar2.add(jSeparator1);

        btnCetak.setText("Cetak");
        btnCetak.setFocusable(false);
        btnCetak.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCetak.setMaximumSize(new java.awt.Dimension(100, 29));
        btnCetak.setMinimumSize(new java.awt.Dimension(100, 29));
        btnCetak.setPreferredSize(new java.awt.Dimension(100, 29));
        btnCetak.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        jToolBar2.add(btnCetak);

        btnReset.setText("Reset");
        btnReset.setFocusable(false);
        btnReset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReset.setMaximumSize(new java.awt.Dimension(100, 29));
        btnReset.setMinimumSize(new java.awt.Dimension(100, 29));
        btnReset.setPreferredSize(new java.awt.Dimension(100, 29));
        btnReset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jToolBar2.add(btnReset);

        jPanel4.add(jToolBar2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 112, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Aset"));

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Aset", "Kategori", "Status", "No Rak", "Lokasi Rak", "Kepemilikan", "Qty", "Satuan", "Diinput"
            }
        ));
        tableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableViewMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableView);
        if (tableView.getColumnModel().getColumnCount() > 0) {
            tableView.getColumnModel().getColumn(0).setPreferredWidth(75);
            tableView.getColumnModel().getColumn(0).setMaxWidth(75);
            tableView.getColumnModel().getColumn(1).setMinWidth(150);
            tableView.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(2).setMaxWidth(150);
            tableView.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableView.getColumnModel().getColumn(4).setMaxWidth(80);
            tableView.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableView.getColumnModel().getColumn(5).setMaxWidth(80);
            tableView.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableView.getColumnModel().getColumn(7).setMaxWidth(50);
            tableView.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableView.getColumnModel().getColumn(8).setMaxWidth(50);
            tableView.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableView.getColumnModel().getColumn(9).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void pmnuLihatTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuLihatTransaksiActionPerformed
        if (tableController.isSelected()) {
            Aset aset = daftarAset.get(tableController.getRowSelected());
            LaporanLihatTransaksi view = new LaporanLihatTransaksi(menuController, aset, true);
            view.setLocationRelativeTo(null);
            view.setTitle("Histori Transaksi");
            view.setResizable(false);
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Data Aset belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pmnuLihatTransaksiActionPerformed

    private void txtKategoriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtKategoriItemStateChanged
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtKategoriItemStateChanged

    private void txtKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKategoriMouseClicked

    }//GEN-LAST:event_txtKategoriMouseClicked

    private void txtKategoriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKategoriMouseReleased

    }//GEN-LAST:event_txtKategoriMouseReleased

    private void txtKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKategoriActionPerformed

    private void txtKategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKategoriKeyPressed

    }//GEN-LAST:event_txtKategoriKeyPressed

    private void txtLokasiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtLokasiItemStateChanged
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtLokasiItemStateChanged

    private void txtUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtUserItemStateChanged
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtUserItemStateChanged

    private void txtKepemilikanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtKepemilikanItemStateChanged
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtKepemilikanItemStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            LaporanAset view = new LaporanAset(menuController, p);
            this.menuController.setInnerLayout(view);
        } catch (Exception ex) {
            Logger.getLogger(LaporanAset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (daftarAset.size() > 0) {
            try {
                String url = "/laporan/DataAset.jasper";
                Map<String, Object> map = new HashMap<>();
                map.put("pengguna", p.getNama());
                map.put("jabatan", p.getJabatan().toString());
                JasperPrint print = JasperFillManager.fillReport(
                    getClass().getResourceAsStream(url),
                    map,
                    new JRBeanCollectionDataSource(daftarAset));
                JasperViewer view = new JasperViewer(print, false);
                view.setLocationRelativeTo(null);
                view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(LaporanAset.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data masih kosong", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void txtStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtStatusItemStateChanged
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtStatusItemStateChanged

    private void txtQtyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtQtyItemStateChanged
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtQtyItemStateChanged

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed

    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtNamaRakCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNamaRakCaretUpdate
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtNamaRakCaretUpdate

    private void txtNamaRakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaRakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaRakActionPerformed

    private void txtNamaRakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaRakKeyReleased
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtNamaRakKeyReleased

    private void txtNamaAsetCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNamaAsetCaretUpdate

    }//GEN-LAST:event_txtNamaAsetCaretUpdate

    private void txtNamaAsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaAsetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaAsetActionPerformed

    private void txtNamaAsetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaAsetKeyReleased
        refreshDataTablesWithFilter();
    }//GEN-LAST:event_txtNamaAsetKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JMenuItem pmnuLihatTransaksi;
    private javax.swing.JTable tableView;
    private javax.swing.JComboBox<String> txtKategori;
    private javax.swing.JComboBox<String> txtKepemilikan;
    private javax.swing.JComboBox<String> txtLokasi;
    private javax.swing.JTextField txtNamaAset;
    private javax.swing.JTextField txtNamaRak;
    private javax.swing.JComboBox<String> txtQty;
    private javax.swing.JComboBox<String> txtStatus;
    private javax.swing.JComboBox<String> txtUser;
    // End of variables declaration//GEN-END:variables
}

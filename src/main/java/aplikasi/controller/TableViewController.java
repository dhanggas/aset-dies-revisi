/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dhiskar
 */
public class TableViewController {

    private final JTable table;
    private final DefaultTableModel model;
    private MyCustomTableCellRenderer cellRenderer;

    public TableViewController(JTable table) {
        this.table = table;
        this.table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.model = (DefaultTableModel) table.getModel();
        this.table.setRowHeight(25);
        table.setRowSorter(new TableRowSorter(table.getModel()) {
            @Override
            public boolean isSortable(int column) {
                return false;
            }
        });
        cellRenderer = new MyCustomTableCellRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(208, 225, 242));
        header.setFont(new Font(null, Font.BOLD, 12));
        clearData();
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void clearData() {
        this.model.getDataVector().removeAllElements();
        this.model.fireTableDataChanged();
    }

    public Integer getRowSelected() {
        return table.getSelectedRow();
    }

    public Boolean isSelected() {
        return getRowSelected() >= 0;
    }

    public void setContentTableAlignment(List<Integer> list) {
        int i = 1;
        MyCustomTableCellRenderer cellRenderer2 = new MyCustomTableCellRenderer();
        cellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer2);
        do {
            table.getColumnModel().getColumn(list.get(i)).setCellRenderer(cellRenderer2);
            i++;
        } while (i <= (list.size() - 1));
    }

    public class MyCustomTableCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
            if (isSelected) {
//                cell.setBackground(Color.green);
            } else {
                if (row % 2 == 0) {
                    cell.setBackground(Color.white);
                } else {
                    cell.setBackground(new Color(242, 246, 250));
                }
            }
            return cell;
        }
    }

}

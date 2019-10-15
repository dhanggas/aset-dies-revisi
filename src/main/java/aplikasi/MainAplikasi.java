/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import aplikasi.view.MainMenuView;
import java.util.Locale;
import javax.swing.SwingUtilities;

/**
 *
 * @author dhiskar
 */
public class MainAplikasi {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("in", "ID"));
        SwingUtilities.invokeLater(() -> {
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.setTitle("ASET DIES SORAYA-Aplikasi");
            mainMenu.setLocationRelativeTo(null);
            mainMenu.setVisible(true);
        });
    }
}

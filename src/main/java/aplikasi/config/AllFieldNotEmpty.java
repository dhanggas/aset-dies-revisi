/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.config;

import java.util.List;

/**
 *
 * @author laptopDhiskar
 */
public class AllFieldNotEmpty {

    public static boolean areAllNotEmpty(String... texts) {
        for (String s : texts) {
            if (s == null || "".equals(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAllNotEmpty(List list, String... texts) {
        if (list.isEmpty()) {
            return false;
        } else {

            for (String s : texts) {
                if (s == null || "".equals(s)) {
                    return false;
                }
            }
            return true;
        }
    }
}

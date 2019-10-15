/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.config;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author dhiskar
 */
public class ValueFormatter {

    public static String getCurrency(Number number) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return format.format(number);
    }

    public static String getNumberBulat(Integer number) {
        NumberFormat format = NumberFormat.getNumberInstance(Locale.getDefault());
        format.setGroupingUsed(true);
        format.setMaximumFractionDigits(0);
        format.setMinimumFractionDigits(0);
        return format.format(number);
    }

    public static String getLocalDateLong(LocalDate date) {
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault());
        return dateFormater.format(date);
    }

    public static String getLocalDateShort(LocalDate date) {
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd MMM yy", Locale.getDefault());
        return dateFormater.format(date);
    }
    
    public static String getLocalDateShortest(LocalDate date) {
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyMMdd", Locale.getDefault());
        return dateFormater.format(date);
    }

    public static String getDateSQL(Date date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormatter.format(date);
    }
}

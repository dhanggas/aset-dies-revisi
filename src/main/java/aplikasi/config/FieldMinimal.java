/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.config;

/**
 *
 * @author soraya
 */
public class FieldMinimal {

    public FieldMinimal() {
    }
    

    public Boolean setMinInputValue(String input) {
//      String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,}";
        boolean hsl = input.matches(pattern);
        return hsl;
    }
    public Boolean setOnlyLetter(String input) {
        boolean hsl = input.matches("^[ a-zA-Z]+$");
        return hsl;
    }

    public Boolean setMinInputValue(String input, int minimal) {
        String pattern;
        boolean hsl;
        switch (minimal) {
            case 2:
                pattern = ".{2,}";
                hsl = input.matches(pattern);
                break;
            case 3:
                pattern = ".{3,}";
                hsl = input.matches(pattern);
                break;
            case 4:
                pattern = ".{4,}";
                hsl = input.matches(pattern);
                break;
            case 5:
                pattern = ".{5,}";
                hsl = input.matches(pattern);
                break;
            case 6:
                pattern = ".{6,}";
                hsl = input.matches(pattern);
                break;
            case 7:
                pattern = ".{7,}";
                hsl = input.matches(pattern);
                break;
            case 8:
                pattern = ".{8,}";
                hsl = input.matches(pattern);
                break;
            default:
                hsl =false;
        }
        return hsl;
    }

}

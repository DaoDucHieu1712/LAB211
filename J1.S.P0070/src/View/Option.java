/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EbankManagement;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class Option {
    
    private static EbankManagement eb = new EbankManagement();
    
    static void menu() {
        System.out.println("-------Login Program-------\n"
                + "1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
    }

    void LoginVi() {
        Locale locateVi = new Locale("Vi");
        eb.setLocale(locateVi);
        EbankManagement.LoginSystem();
        System.exit(0);
    }

    void LoginEn() {
        Locale locateEn = new Locale("En");
        eb.setLocale(locateEn);
        EbankManagement.LoginSystem();
        System.exit(0);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class EbankManagement {
    
    private static ResourceBundle rb;
    // dung de doc file properties;
    
    // Set locale
    public void setLocale(Locale locale){
        rb = ResourceBundle.getBundle("Language/language", locale);
    }
    
    //checkformat Account
    public String checkAccountNumber(String accountNumber){
       if(accountNumber.isEmpty()){
           return rb.getString("inputAccErr");
       }
        if (accountNumber.matches("^[0-9]{10}$")) {
            return null;
        }else{
            return rb.getString("inputAccErr");
        }
    
    }
    
    
    //checkformat password
    public String checkPassword(String password){
        if(password.isEmpty()){
            return rb.getString("inputPwErr");
        }
        if (password.matches("^[0-9A-Za-z]{8,31}$")
                &&password.matches("^[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*$")
                &&password.matches("^[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*$")) {
            return null;
        }else{
            return rb.getString("inputPwErr");
        }
    }
    
    //generate Randomcaptcha
    public String generateCaptcha(){
        Random rand = new Random();
//        StringBuilder anphabet = new StringBuilder();
//        for (char i = 'a'; i < 'z'; i++) { 
//            anphabet.append(i);
//        }
//        for (char i = 'A'; i < 'Z'; i++) {
//            anphabet.append(i);
//        }
//        for (char i = '1'; i < '9'; i++) {
//            anphabet.append(i);
//        }
        String anphabet = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBN";
        StringBuilder captCha = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(anphabet.length());
            captCha.append(anphabet.charAt(index));
        }
        
        return captCha.toString();
    }
    
    //Check inputcaptcha
    public String checkCaptcha(String captchaInput, String captchaGenerate){
        if (captchaInput.contains(captchaGenerate)
            &&captchaInput.length() == captchaGenerate.length()) {
            return null;
        }else{
            return rb.getString("captchaErr");
        }
    }
    
    
    // Login System
    public static void LoginSystem(){
        Scanner sc = new Scanner(System.in);
        EbankManagement eb = new EbankManagement();
        String account, pw;
        while (true) {            
            account = Validate.getString(rb.getString("inputAcc"));
            if (eb.checkAccountNumber(account)==null) {
                break;
            }else{
                System.out.println(rb.getString("inputAccErr"));
            }
        }
        
        while (true) {            
            pw = Validate.getString(rb.getString("inputPw"));
            if(eb.checkPassword(pw)==null){
                break;
            }else{
                System.out.println(rb.getString("inputPwErr"));
            }
        }
        
        String captcha = eb.generateCaptcha();
        System.out.println(rb.getString("captchaRand")+ captcha);
        String inputCaptcha; 
        while (true) {     
            inputCaptcha = Validate.getString(rb.getString("inputCaptcha"));
            if (eb.checkCaptcha(captcha, inputCaptcha)==null) {
                System.out.println(rb.getString("login"));
                break;
            }else{
                System.out.println(rb.getString("captchaErr"));
                
        }
        }
    }
    
}

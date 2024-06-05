package com.mycompany.lojacalcados.utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.util.regex.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JSpinner;


public class Validador {
      
    /** 
    * Valida se o valor inserido no JTextField é realmente um número
    * @param objValidar JTextField
    */
    public static void validarNumero(JTextField objValidar) throws NumberFormatException, Exception
    {

        objValidar.setBackground(Color.white);

        if(objValidar.getText().strip().equals((""))) {
            throw new Exception("Preencha o campo de " + objValidar.getName() );
        }

        int numeroValidar = Integer.parseInt(objValidar.getText());
 
    }
    
    /** 
    * Valida se o valor inserido no JSpinner é maior do que 0
    * @param objValidar JSpinner
    */
    public static void validarSpinner(JSpinner objValidar) throws Exception
    {
        objValidar.setBackground(Color.white);

        int nrValidar = Integer.parseInt(objValidar.getValue().toString());

        if(nrValidar < 0)
           throw new Exception("A quantidade não pode ser menor do que 0");
    }
    
    /** 
    * Valida se o valor inserido no JTextField contém somente números 
    * @param objValidar JTextField
    * @return true: contem somente números | false: não contem somente números
    */
    public static boolean validarValor(JTextField objValidar) throws Exception
    {
        try {
            objValidar.setBackground(Color.white);
           
            Double.parseDouble(objValidar.getText());
            
            return true;
        }
        catch(NumberFormatException ex)
        {
           JOptionPane.showMessageDialog(objValidar, "Somente números no campo " + objValidar.getName() );
            objValidar.setBackground(Color.yellow);
            return false;

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(objValidar, ex.getMessage());
            objValidar.setBackground(Color.red);
            return false;

        }
    }
    
    /** 
    * Valida se o valor inserido no JTextField é um e-mail válido
    * @param objValidar JTextField
    */
    public static void validarEmail(JTextField objValidar) throws Exception {
       
        objValidar.setBackground(Color.white);

        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(objValidar.getText());

        if(!matcher.matches())
            throw new Exception("O e-mail inserido é inválido");
    }
    
    /** 
    * Valida se o valor inserido no JFormattedTextField é um número de celular válido
    * @param objValidar JFormattedTextField
    */
    public static void validarNumeroCelular(JFormattedTextField objValidar) throws Exception {
        
        objValidar.setBackground(Color.white);

        String regex = "^\\(\\d{2}\\)\\s\\d{4}-\\d{5}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(objValidar.getText());

        if(!matcher.matches())
            throw new Exception("O telefone inserido é inválido");
            
    }
    
    /** 
    * Valida se o valor inserido no JFormattedTextField é um CPF válido
    * @param objValidar JFormattedTextField
    */
    public static void validarCPF(JFormattedTextField objValidar) throws Exception {        

        objValidar.setBackground(Color.white);

        String regex = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(objValidar.getText());

        if(!matcher.matches())
            throw new Exception("O CPF inserido é inválido");
        
    }
    
    /** 
    * Valida se o valor inserido no JTextField foi preenchido
    * @param objValidar JTextField
    */
    public static void validarObrigatorio(JTextField objValidar) throws Exception
    {

        objValidar.setBackground(Color.white);

        if(objValidar.getText().strip().equals((""))) {
            throw new Exception("Preencha o campo de " + objValidar.getName() );
        }

    }
    
     
    /** 
    * Valida se o JComboBox teve algum item selecionado
    * @param objValidar JComboBox
    */
    public static void validarObrigatorio(JComboBox objValidar) throws Exception
    {

        objValidar.setBackground(Color.white);

        if(objValidar.getSelectedItem()==null ) {
            throw new Exception("Preencha o campo de " + objValidar.getName() );
        }

    }
    
    /** 
    * Valida se o valor inserido no JDateChooser é uma data de nascimento válida e maior do que a data atual
    * @param objValidar JDateChooser
    */
    public static void validarDataNascimento(JDateChooser objValidar) throws Exception {
        
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        Pattern pattern = Pattern.compile(regex);

        var data = objValidar.getDate();

        if (data == null) {
            throw new Exception("Data de nascimento inválida" );
        }

        if (data.after(new Date())) {
             throw new Exception("A data de nascimento não pode ser maior do que hoje" );
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataComoString = sdf.format(data);

        Matcher matcher = pattern.matcher(dataComoString);
        if (!matcher.matches()) {
            throw new Exception("Data de nascimento inválida" );
        }

        String[] partesData = dataComoString.split("/");
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);

        if (ano < 1900) {
            throw new Exception("Data de nascimento inválida" );
        }

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            throw new Exception("Data de nascimento inválida" );
        } else if (mes == 2) { // Fevereiro
            boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
            if ((bissexto && dia > 29) || (!bissexto && dia > 28)) {
                throw new Exception("Data de nascimento inválida" );
            }
        }

    }
}

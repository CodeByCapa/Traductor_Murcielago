/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import static Menu_Editar.Frm_buscar.txt_inserach;
import static Menu_Editar.Frm_reemplazar.txt_inreplace;
import static Menu_Editar.Frm_reemplazar.txt_inreplace1;
import java.text.Normalizer;

/**
 *
 * @author Cristian Padilla
 */
public class Funciones {
    
     public static void Repa(String valor, String letra){
        
       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase(); 
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }

       Frm_iniciar.lbl_rep_A.setText(Integer.toString(times));
       
   }
      public static void Repe(String valor, String letra){
        
       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

       String s= valor2.toLowerCase();
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }
       
       Frm_iniciar.lbl_rep_E.setText(Integer.toString(times));
       
   }
      
       public static void Repi(String valor, String letra){
        
       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase(); 
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }

       Frm_iniciar.lbl_rep_I.setText(Integer.toString(times));
       
   }
       
        public static void Repo(String valor, String letra){
        
       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase(); 
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }

       Frm_iniciar.lbl_rep_O.setText(Integer.toString(times));
       
   }
        
         public static void Repu(String valor, String letra){
        
       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase();
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }

       Frm_iniciar.lbl_rep_U.setText(Integer.toString(times));
       
   }
         
         public static void PAR(String valor){
             String[] valorarray = valor.split(" ");
             int sumPar=0;
             int sumImp=0;
             
         for (String palabra : valorarray) {

             int cont = palabra.length();
             if (cont % 2 == 0 ){
                 sumPar = sumPar + 1;  
             }
             else {
                 sumImp = sumImp + 1;
             }
         }
            
             Frm_iniciar.lbl_cantidad_par.setText(Integer.toString(sumPar));
             Frm_iniciar.lbl_cantidad_impar.setText(Integer.toString(sumImp));
         }
         
         
          public static void Buscar(){
              
       String valor = Frm_iniciar.txt_entrada.getText();
       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase();
       
       String find = txt_inserach.getText();
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(find)){
               times++;  
           }
       }
       System.out.println(times);
       Menu_Editar.Frm_buscar.lbl_conc.setText(Integer.toString(times));
    }
          
       public static void replace(){

       String valor = Frm_iniciar.txt_entrada.getText();
       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

       String s= valor2.toLowerCase();
       
       String find = txt_inreplace.getText();
       String rep = txt_inreplace1.getText();
       
    
       
       for (int i = 0; i <find.length(); i++){

           s = s.replace(find, rep);
       }
       Frm_iniciar.txt_entrada.setText(s);
   }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import java.text.Normalizer;

/**
 *
 * @author Cristian Padilla
 */
public class Codificar {

   public static void Encode(String valor){

       String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
       String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase();
       
       String av ="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
       String tr ="7,B,3,D,5,F,8,H,4,J,K,6,0,N,9,P,Q,2,S,T,1,V,W,X,Y,Z";
       String[] abecedario = av.split(",");
       String[] traductor= tr.split(",");
       
       for (String abecedario1 : abecedario) {
           System.out.println(abecedario1);
       }
       
       for (String traductor1 : traductor) {
           System.out.println(traductor1);
       }
       
       for (int i = 0; i <26; i++){
           s = s.replace(abecedario[i], traductor[i]);
       }
       Frm_iniciar.txt_salida.setText(s); 
   }
}
   


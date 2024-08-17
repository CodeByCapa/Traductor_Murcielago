/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Cristian Padilla
 */
public class Archivo {
    private JFileChooser accion = null;
    private java.io.File archivo = null;
    protected Frm_iniciar frm_iniciar;
    public static String ruta = "C:\\Users\\Cooli\\OneDrive\\Documentos\\NetBeansProjects\\Java-txtEncoder-main\\ext\\";
    
     static Path fileName = Path.of(
            "C:\\Users\\Cooli\\OneDrive\\Documentos\\NetBeansProjects\\Java-txtEncoder-main\\ext\\bitacora.txt");
    
    public static void insert(String s)
        throws IOException 
    {   
        String d = "\r\n";
        Files.writeString(fileName, d,StandardOpenOption.APPEND);
        Files.writeString(fileName, s,StandardOpenOption.APPEND);
        
    }
    
     public void LeerFichero(Frm_iniciar frm_iniciar) {
        this.frm_iniciar = frm_iniciar;

        accion = new JFileChooser();
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("TXT", "txt");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Abrir archivo");
        if (accion.showOpenDialog(frm_iniciar) == JFileChooser.APPROVE_OPTION) {
            archivo = accion.getSelectedFile();
            Frm_iniciar.lbl_nombre.setText(archivo.getName());
            ruta = accion.getSelectedFile().toString();
            try {

                if (archivo.exists()) {
                    try (BufferedReader leeArchivo = new BufferedReader(new FileReader(archivo))) {
                        String Slinea, datos = "";

                        while ((Slinea = leeArchivo.readLine()) != null) {

                            datos = datos + Slinea + "\n";
                        }   Frm_iniciar.txt_entrada.setText("");
                        Frm_iniciar.txt_entrada.setText(datos);
                        Frm_iniciar.txt_entrada.setEditable(true);
                        Frm_iniciar.txt_entrada.requestFocus();
                        Frm_iniciar.txt_entrada.setForeground(Color.white);

                    }
                    Frm_iniciar.abrioArchivo = true;
                    Frm_iniciar.creoNuevo = false;
                } else {
                    System.out.println("Fichero No Existe");
                }
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        }
    }
    
  public void CrearFicheroNuevo(Frm_iniciar frm_iniciar, String SCadena, String nombre) {
        this.frm_iniciar = frm_iniciar;

        accion = new JFileChooser();
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("TXT", "txt");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Guardar archivo " + nombre);
        accion.setSelectedFile(new java.io.File(nombre));
        if (accion.showSaveDialog(frm_iniciar) == JFileChooser.APPROVE_OPTION) {
            ruta = accion.getSelectedFile().toString();
            archivo = new java.io.File(ruta);
            Frm_iniciar.lbl_nombre.setText(archivo.getName());
            try {

                if (archivo.exists()) {
                    archivo.delete();
                }
                FileWriter escribirArchivo;
                try (BufferedWriter wr = new BufferedWriter(new FileWriter(archivo))) {
                    escribirArchivo = new FileWriter(archivo, true);
                    try (BufferedWriter buffer = new BufferedWriter(escribirArchivo)) {
                        buffer.write(SCadena);
                        buffer.newLine();
                    }
                }
                escribirArchivo.close();

                Frm_iniciar.abrioArchivo = true;
                Frm_iniciar.creoNuevo = false;
            } catch (IOException ex) {
            }
        }
    }
     
      public void GuardarFichero(String SCadena, String nombre) {

        System.out.println(ruta);
        archivo = new java.io.File(ruta);
        try {

            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter escribirArchivo;
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(archivo))) {
                escribirArchivo = new FileWriter(archivo, true);
                try (BufferedWriter buffer = new BufferedWriter(escribirArchivo)) {
                    buffer.write(SCadena);
                    buffer.newLine();
                }
            }
            escribirArchivo.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }



    
}

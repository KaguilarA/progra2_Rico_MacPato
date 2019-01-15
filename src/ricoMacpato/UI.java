/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricoMacpato;

/**
 *
 * @author kevin
 */

import java.io.*;
import java.text.DecimalFormat;

public class UI {
    /**
     * @param args the command line arguments
     */
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    
    public static void main(String[] args) throws IOException {
        menu();
    }
    
    static void menu() throws IOException{
        out.println();
        out.println();
        out.println();
        out.println("<--- Seleccione una opcion para ejecutar --->");
        out.println("1.  Registrar una propiedad");
        out.println("2.  Ver propiedades registradas");
        out.println("3.  Eliminar una propiedad");
        out.println("4.  Salir");
        out.println();
        out.println("Seleccione su opci\u00f3n: ");
        int optionSelected = Integer.parseInt(in.readLine());
        
        switch (optionSelected) { 
        case 1: 
            registerProperty();
            break; 
        case 2: 
            displayProperties(); 
            break; 
        case 3: 
            deleteProperties();
            break; 
        case 4: 
            out.println("¡Gracias por utilizar el software MacPato!");
            break;  
        default: 
            out.println("Opcion no validad");
            out.println(optionSelected);
            menu();
            break; 
        }   
    }
    
    static void displayProperties() throws IOException{
        out.println("Opcion de mostrar la lista de propiedades");
        menu();
        
    }
    
    static void registerProperty() throws IOException{
        boolean validate, registerNewProperty;
        int nPropertyCode, nPropertyRooms, nPropertyRent;
        String sPropertyName;
        
        out.println("Opcion de registrar una propiedad");

        out.println("<--- Ingrese el codigo de la nueva propiedad --->");
        nPropertyCode = Integer.parseInt(in.readLine());
        
        validate = validateCode(nPropertyCode);
        
        if(validate == true){
            out.println("<--- Ingrese la cantidad de habitaciones de la nueva propiedad --->");
            nPropertyRooms = Integer.parseInt(in.readLine());
            
            out.println("<--- Ingrese la cantidad de renta de la nueva propiedad --->");
            nPropertyRent = Integer.parseInt(in.readLine());
            
            out.println("<--- Ingrese el nombre de la nueva propiedad --->");
            sPropertyName = in.readLine();
            
            
            registerNewProperty = CL.registerNewProperty(nPropertyCode, nPropertyRooms, nPropertyRent, sPropertyName);
            
            if(registerNewProperty == true){
                out.println("<--- Registro Exitoso --->");
            }else {
                out.println("<--- Ha ocurrido un error. Intentelo de nuevo mas tarde --->");
            }
        }else {
            out.println("<--- La propiedad con el codigo " + nPropertyCode + " ya se encuentra registradad dentro de software MacPato --->");
        }
        menu();
    }
    
    static void deleteProperties() throws IOException{
        out.println("Opcion de eliminar una propiedad una propiedad");
        menu();
    }

    private static boolean validateCode(int nPropertyCode) {
        boolean validate;
        out.println("Opcion de eliminar una propiedad una propiedad");
        validate = CL.validateRepeatProperty(nPropertyCode);
        return validate;
    }
}

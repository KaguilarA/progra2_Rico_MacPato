package ricoMacpato;

/**
 *
 * @author Kevin Aguilar
 */

import java.io.*;
import java.util.ArrayList;

public class UI {
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
        
        proccesOption(optionSelected);
    }
    
    private static void proccesOption(int optionSelected) throws IOException {
        switch (optionSelected) { 
        case 1: 
            registerProperty();
            break; 
        case 2: 
            displayProperties();
            menu();
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
    
    private static boolean validateCode(int nPropertyCode) {
        boolean validate;
        validate = CL.validateRepeatProperty(nPropertyCode);
        return validate;
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
            out.println("<--- Ingrese el nombre de la nueva propiedad --->");
            sPropertyName = in.readLine();
            out.println("<--- Ingrese la cantidad de habitaciones de la nueva p"
                    + "ropiedad --->");
            nPropertyRooms = Integer.parseInt(in.readLine());
            out.println("<--- Ingrese la cantidad de renta de la nueva propieda"
                    + "d --->");
            nPropertyRent = Integer.parseInt(in.readLine());
            
            registerNewProperty = CL.registerNewProperty(nPropertyCode, 
                    nPropertyRooms, nPropertyRent, sPropertyName);
            if(registerNewProperty == true){
                out.println("<--- Registro Exitoso --->");
            }else {
                out.println("<--- Ha ocurrido un error. Intentelo de nuevo mas "
                        + "tarde --->");
            }
        }else {
            out.println("<--- La propiedad con el codigo " + nPropertyCode + 
                    " ya se encuentra registradad dentro de software MacPato -"
                    + "-->");
        }
        menu();
    }

    static void displayProperties() throws IOException{
        ArrayList<Property> aPropertyList  = new ArrayList<Property>();
        out.println("Opcion de mostrar la lista de propiedades");
        aPropertyList = CL.getAllProperties();
        String leftAlignFormat = "| %-25s | %-8d | %-23s | %-8d |%n";
        out.println("|---------------------------+----------+------------------"
                + "-------+----------|");
        out.println("| Nombre de la propiedad    | Código   |  Cant de Habitaci"
                + "ones   |  Renta   |");
        out.println("|---------------------------+----------+------------------"
                + "-------+----------|");
        aPropertyList.stream().forEach((property) -> {
            out.printf(leftAlignFormat, property.getPropertyName(),
                    property.getPropertyCode(), 
                    property.getPropertyRoomsLength(), 
                    property.getPropertyRent());
            out.println("|---------------------------+----------+------------------"
                + "-------+----------|");
        });
    }

    static void deleteProperties() throws IOException{
        int nPropertyCode, nValidate;
        out.println("Opcion de eliminar una propiedad una propiedad");
        displayProperties();
        out.println("<--- Ingrese el código de la propiedad que desea eliminar "
                + "--->");
        nPropertyCode = Integer.parseInt(in.readLine());
        out.println("<--- ¿Desea eliminar la propiedad " + 
                CL.getPropertyName(nPropertyCode) + "? --->");
        out.println("1.  Aceptar");
        out.println("2.  Cancelar");
        nValidate = Integer.parseInt(in.readLine());
        proccesDeleteOption(nValidate, nPropertyCode);
    }
    
    private static void proccesDeleteOption(int optionSelected, 
            int nPropertyCode) throws IOException {
        switch (optionSelected) { 
        case 1: 
            out.println("Se ha eliminado la propiedad con éxito");
            CL.deleteProperty(nPropertyCode);
            menu();
            break; 
        case 2: 
            out.println("No se ha eliminado la propiedad "+ 
                CL.getPropertyName(nPropertyCode));
            menu();
            break;  
        default: 
            out.println("Opcion no validad");
            out.println(optionSelected);
            menu();
            break; 
        }
    }
}

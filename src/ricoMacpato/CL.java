/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricoMacpato;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class CL {
    
    static ArrayList aPropertyList, aPropertyString;

    static boolean registerNewProperty(int nPropertyCode, int nPropertyRooms, int nPropertyRent, String sPropertyName) {
        Property tempProperty = new Property(nPropertyCode,nPropertyRooms, nPropertyRent, sPropertyName);
        
        aPropertyList.add(tempProperty);

        return true;
    }

    static boolean validateRepeatProperty(int nPropertyCode) {
        return true;
    }

    static boolean getAllProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

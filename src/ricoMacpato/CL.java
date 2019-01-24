package ricoMacpato;

import java.util.ArrayList;

/**
 *
 * @author Kevin Aguilar
 */
public class CL {
    static ArrayList<Property> aPropertyList  = new ArrayList<Property>();
    static ArrayList<String>  aPropertyString  = new ArrayList<String>();

    static boolean registerNewProperty(int nPropertyCode, int nPropertyRooms,
            int nPropertyRent, String sPropertyName) {
        Boolean validate = validateRepeatProperty(nPropertyCode);
        if(validate == true) {
            Property tempProperty = new Property(nPropertyCode,nPropertyRooms, 
                    nPropertyRent, sPropertyName);
            aPropertyList.add(tempProperty);
        }
        return validate;
    }

    static boolean validateRepeatProperty(int nPropertyCode) {
        Boolean validate = true;
        for(Property property : aPropertyList) {
            if(property.getPropertyCode() == nPropertyCode) {
                validate = false;
            }
        }
        return validate;
    }

    static ArrayList getAllStringProperties() {
        aPropertyString.clear();
        for(Property property : aPropertyList) {
            aPropertyString.add(property.toString());
        }
        return aPropertyString;
    }

    static ArrayList getAllProperties() {
        return aPropertyList;
    }

    static String getPropertyName(int nPropertyCode) {
        String name = null;
        for(Property property : aPropertyList) {
            if(property.getPropertyCode() == nPropertyCode) {
                name = property.getPropertyName();
            }
        }
        return name;
    }

    static void deleteProperty(int nPropertyCode) {
        for(Property property : aPropertyList) {
            if(property.getPropertyCode() == nPropertyCode) {
                aPropertyList.remove(property);
            }
        }
    }
}

package ricoMacpato;

/**
 *
 * @author Kevin Aguilar
 */
public class Property {
    protected int propertyCode, propertyRoomsLength, propertyRent;
    protected String propertyName;

    public Property() {
    }

    public Property(int propertyCode, int propertyRoomsLength, int propertyRent, String propertyName) {
        this.propertyCode = propertyCode;
        this.propertyRoomsLength = propertyRoomsLength;
        this.propertyRent = propertyRent;
        this.propertyName = propertyName;
    }
    
    // Getters

    public int getPropertyCode() {
        return propertyCode;
    }

    public int getPropertyRoomsLength() {
        return propertyRoomsLength;
    }

    public int getPropertyRent() {
        return propertyRent;
    }

    public String getPropertyName() {
        return propertyName;
    }
    
    // Setter

    public void setPropertyCode(int propertyCode) {
        this.propertyCode = propertyCode;
    }

    public void setPropertyRoomsLength(int propertyRoomsLength) {
        this.propertyRoomsLength = propertyRoomsLength;
    }

    public void setPropertyRent(int propertyRent) {
        this.propertyRent = propertyRent;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    // ToString

    @Override
    public String toString() {
        return "{" + "propertyCode: " + propertyCode + ", propertyRoomsLength: " + propertyRoomsLength + ", propertyRent: " + propertyRent + ", propertyName: " + propertyName + '}';
    }
    
}

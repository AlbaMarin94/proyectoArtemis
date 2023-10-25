package enums;

public enum Crud {

    CREATE("create"), READ("read"), UPDATE("update"), DELETE("delete");

    private String value;

    Crud(String string) {
        // TODO Auto-generated constructor stub
        this.value = string;
    }

    public static Crud findByValue(String operacion) {
        // TODO Auto-generated method stub
        
        Crud values[] = Crud.values();
        
        for (Crud crud : values) {
            if (crud.getValue().equalsIgnoreCase(operacion)) {
                return crud;
            }
        }
        return null;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    
}

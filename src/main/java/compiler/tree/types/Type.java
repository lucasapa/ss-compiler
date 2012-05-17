package compiler.tree.types;

public enum Type {

    INTEGER("INTEGER"),
    STRING("STRING"),
    FLOAT("FLOAT");


    private final String name;

    private Type(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Type promotion(Type t1, Type t2) {

        if (t1 == STRING || t2 == STRING) {
            return Type.STRING;
        } else if (t1 == FLOAT || t2 == FLOAT) {
            return Type.FLOAT;

        } else {
            return Type.INTEGER;
        }
    }

}
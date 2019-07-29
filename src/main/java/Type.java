public enum Type {

    EXPENDITURE("expenditure"),INCOME("income");

    private String description;

    Type(String description) {
        this.description = description;
    }

    static public String convert(Type type){
        return type.description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

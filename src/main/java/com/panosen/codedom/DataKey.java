package com.panosen.codedom;

public class DataKey {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static DataKey ofInteger(Integer value) {
        DataKey dataKey = new DataKey();
        dataKey.value = value != null ? value.toString() : "0";
        return dataKey;
    }

    public static DataKey ofLong(Long value) {
        DataKey dataKey = new DataKey();
        dataKey.value = value != null ? value.toString() : "0";
        return dataKey;
    }

    public static DataKey ofInteger(String value) {
        DataKey dataKey = new DataKey();
        dataKey.value = value;
        return dataKey;
    }

    public static DataKey singleQuotationString(String value) {
        DataKey dataKey = new DataKey();
        dataKey.value = Marks.SINGLE_QUOTATION + value + Marks.SINGLE_QUOTATION;
        return dataKey;
    }

    public static DataKey doubleQuotationString(String value) {
        DataKey dataKey = new DataKey();
        dataKey.value = Marks.DOUBLE_QUOTATION + value + Marks.DOUBLE_QUOTATION;
        return dataKey;
    }
}

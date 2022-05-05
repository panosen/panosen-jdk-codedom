package com.panosen.codedom;

public class DataValue extends DataItem {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static DataValue ofInteger(Integer value) {
        DataValue dataValue = new DataValue();
        dataValue.value = value != null ? value.toString() : "0";
        return dataValue;
    }

    public static DataValue ofLong(Long value) {
        DataValue dataValue = new DataValue();
        dataValue.value = value != null ? value.toString() : "0";
        return dataValue;
    }

    public static DataValue ofInteger(String value) {
        DataValue dataValue = new DataValue();
        dataValue.value = value;
        return dataValue;
    }

    public static DataValue ofString(String value) {
        DataValue dataValue = new DataValue();
        dataValue.value = value;
        return dataValue;
    }

    public static DataValue ofBoolean(Boolean value) {
        DataValue dataValue = new DataValue();
        if (value != null) {
            dataValue.value = value ? "true" : "false";
        }
        return dataValue;
    }

    public static DataValue singleQuotationString(String value) {
        DataValue dataValue = new DataValue();
        dataValue.value = Marks.SINGLE_QUOTATION + value + Marks.SINGLE_QUOTATION;
        return dataValue;
    }

    public static DataValue doubleQuotationString(String value) {
        DataValue dataValue = new DataValue();
        dataValue.value = Marks.DOUBLE_QUOTATION + value + Marks.DOUBLE_QUOTATION;
        return dataValue;
    }
}

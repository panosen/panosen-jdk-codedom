package com.panosen.codedom.engine;

import com.panosen.codedom.*;

import java.util.Iterator;
import java.util.Map;

@Deprecated
public class CodeEngine {

    public void generateDataObject(DataObject dataObject, CodeWriter codeWriter, GenerateOptions options) {
        if (dataObject == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(Marks.LEFT_BRACE);

        generateMap(dataObject.getDataItemMap(), codeWriter, options);

        codeWriter.write(Marks.RIGHT_BRACE);
    }

    public void generateSortedDataObject(SortedDataObject dataObject, CodeWriter codeWriter, GenerateOptions options) {
        if (dataObject == null) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.write(Marks.LEFT_BRACE);

        generateMap(dataObject.getDataItemMap(), codeWriter, options);

        codeWriter.write(Marks.RIGHT_BRACE);
    }

    private void generateDataItem(DataItem dataItem, CodeWriter codeWriter, GenerateOptions options) {
        if(dataItem instanceof DataValue){
            generateDataValue((DataValue) dataItem, codeWriter, options);
            return;
        }
        if(dataItem instanceof DataArray){
            generateDataArray((DataArray) dataItem, codeWriter, options);
            return;
        }
        if(dataItem instanceof DataObject){
            generateDataObject((DataObject) dataItem, codeWriter, options);
            return;
        }
        if(dataItem instanceof SortedDataObject){
            generateSortedDataObject((SortedDataObject) dataItem, codeWriter, options);
            return;
        }
    }

    private void generateDataValue(DataValue dataValue, CodeWriter codeWriter, GenerateOptions options) {
        if (dataValue.getValue() == null) {
            codeWriter.write("null");
        } else {
            codeWriter.write(dataValue.getValue());
        }
    }

    private void generateDataArray(DataArray dataArray, CodeWriter codeWriter, GenerateOptions options) {
        if (dataArray.getItems() == null || dataArray.getItems().isEmpty()) {
            codeWriter.write("[]");
        } else {
            codeWriter.write("[");

            boolean first = true;
            Iterator<DataItem> enumerator = dataArray.getItems().iterator();
            boolean moveNext = enumerator.hasNext();
            while (moveNext) {
                DataItem current = enumerator.next();
                generateDataItem(current, codeWriter, options);

                moveNext = enumerator.hasNext();
                if (moveNext) {
                    codeWriter.write(", ");
                }
            }

            codeWriter.write("]");
        }
    }

    private void generateMap(Map<DataKey, DataItem> dataItemMap, CodeWriter codeWriter, GenerateOptions options) {
        if (dataItemMap == null || dataItemMap.isEmpty()) {
            return;
        }
        if (codeWriter == null) {
            return;
        }
        if (options == null) {
            options = new GenerateOptions();
        }

        codeWriter.writeLine();

        options.pushIndent();

        Iterator<Map.Entry<DataKey, DataItem>> enumerator = dataItemMap.entrySet().iterator();
        boolean moveNext = enumerator.hasNext();
        while (moveNext) {
            Map.Entry<DataKey, DataItem> item = enumerator.next();
            codeWriter.write(options.getIndentString()).write(item.getKey().getValue());

            if (options.isInsertWhitespaceAfterKey()) {
                codeWriter.write(Marks.WHITESPACE);
            }

            codeWriter.write(Marks.COLON).write(Marks.WHITESPACE);

            if (item.getValue() == null) {
                codeWriter.write("null");
            } else {
                generateDataItem(item.getValue(), codeWriter, options);
            }

            moveNext = enumerator.hasNext();
            if (moveNext) {
                codeWriter.write(",");
            }
            codeWriter.writeLine();
        }

        options.popIndent();

        codeWriter.write(options.getIndentString());
    }
}
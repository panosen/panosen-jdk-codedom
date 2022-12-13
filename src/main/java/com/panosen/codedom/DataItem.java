package com.panosen.codedom;

/**
 * DataObject 或 DataValue 或 DataArray 或 SortedDataObject
 */
public abstract class DataItem {

    /**
     * DataItem 类型
     * @return DataItem类型
     */
    public abstract DataItemType getDataItemType();
}

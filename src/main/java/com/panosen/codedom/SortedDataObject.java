package com.panosen.codedom;

import java.util.TreeMap;

public class SortedDataObject extends DataItem {

    @Override
    public DataItemType getDataItemType() {
        return DataItemType.SortedDataObject;
    }

    /**
     * 每一个项是一个 DataValue 或 DataArray 或 DataObject 或 SortedDataObject
     */
    public TreeMap<DataKey, DataItem> dataItemMap;

    public TreeMap<DataKey, DataItem> getDataItemMap() {
        return dataItemMap;
    }

    public void setDataItemMap(TreeMap<DataKey, DataItem> dataItemMap) {
        this.dataItemMap = dataItemMap;
    }

    public SortedDataObject add(DataKey dataKey, DataItem dataItem) {
        if (this.dataItemMap == null) {
            this.dataItemMap = new TreeMap<>();
        }

        this.dataItemMap.putIfAbsent(dataKey, dataItem);

        return this;
    }

    public SortedDataObject addDataValue(DataKey dataKey, DataValue dataValue) {
        return add(dataKey, dataValue);
    }

    public DataValue addDataValue(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = new TreeMap<>();
        }

        DataValue dataValue = new DataValue();

        this.dataItemMap.putIfAbsent(dataKey, dataValue);

        return dataValue;
    }

    public SortedDataObject addDataArray(DataKey dataKey, DataArray dataArray) {
        return add(dataKey, dataArray);
    }

    /*
     * 添加一个数组，并返回该数组
     **/
    public DataArray addDataArray(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = new TreeMap<>();
        }

        DataArray dataArray = new DataArray();

        this.dataItemMap.putIfAbsent(dataKey, dataArray);

        return dataArray;
    }

    public SortedDataObject addDataObject(DataKey dataKey, DataObject subDataObject) {
        return add(dataKey, subDataObject);
    }

    /*
     * 添加一个对象，并返回该对象
     **/
    public DataObject addDataObject(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = new TreeMap<>();
        }

        DataObject subDataObject = new DataObject();

        this.dataItemMap.putIfAbsent(dataKey, subDataObject);

        return subDataObject;
    }

    /*
     * 添加一个对象
     **/
    public SortedDataObject addSortedDataObject(DataKey dataKey, SortedDataObject subSortedDataObject) {
        return add(dataKey, subSortedDataObject);
    }

    /*
     * 添加一个对象，并返回该对象
     **/
    public SortedDataObject addSortedDataObject(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = new TreeMap<>();
        }

        SortedDataObject subSortedDataObject = new SortedDataObject();

        this.dataItemMap.putIfAbsent(dataKey, subSortedDataObject);

        return subSortedDataObject;
    }
}

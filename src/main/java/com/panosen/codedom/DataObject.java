package com.panosen.codedom;

import com.google.common.collect.Maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataObject extends DataItem {

    @Override
    public DataItemType getDataItemType() {
        return DataItemType.DataObject;
    }

    /**
     * 每一个项是一个 DataValue 或 DataArray 或 DataObject 或 SortedDataObject
     */
    public LinkedHashMap<DataKey, DataItem> dataItemMap;

    public LinkedHashMap<DataKey, DataItem> getDataItemMap() {
        return dataItemMap;
    }

    public void setDataItemMap(LinkedHashMap<DataKey, DataItem> dataItemMap) {
        this.dataItemMap = dataItemMap;
    }

    public DataObject add(DataKey dataKey, DataItem dataItem) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newLinkedHashMap();
        }

        this.dataItemMap.putIfAbsent(dataKey, dataItem);

        return this;
    }

    public DataObject addDataValue(DataKey dataKey, DataValue dataValue) {
        return add(dataKey, dataValue);
    }

    public DataValue addDataValue(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newLinkedHashMap();
        }

        DataValue dataValue = new DataValue();

        this.dataItemMap.putIfAbsent(dataKey, dataValue);

        return dataValue;
    }

    public DataObject addDataArray(DataKey dataKey, DataArray dataArray) {
        return add(dataKey, dataArray);
    }

    /*
     * 添加一个数组，并返回该数组
     **/
    public DataArray addDataArray(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newLinkedHashMap();
        }

        DataArray dataArray = new DataArray();

        this.dataItemMap.putIfAbsent(dataKey, dataArray);

        return dataArray;
    }

    public DataObject addDataObject(DataKey dataKey, DataObject subDataObject) {
        return add(dataKey, subDataObject);
    }

    /*
     * 添加一个对象，并返回该对象
     **/
    public DataObject addDataObject(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newLinkedHashMap();
        }

        DataObject subDataObject = new DataObject();

        this.dataItemMap.putIfAbsent(dataKey, subDataObject);

        return subDataObject;
    }

    /*
     * 添加一个对象
     **/
    public DataObject addSortedDataObject(DataKey dataKey, SortedDataObject subSortedDataObject) {
        return add(dataKey, subSortedDataObject);
    }

    /*
     * 添加一个对象，并返回该对象
     **/
    public SortedDataObject addSortedDataObject(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newLinkedHashMap();
        }

        SortedDataObject subSortedDataObject = new SortedDataObject();

        this.dataItemMap.putIfAbsent(dataKey, subSortedDataObject);

        return subSortedDataObject;
    }
}

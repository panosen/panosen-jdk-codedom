package com.panosen.codedom;

import com.google.common.collect.Maps;

import java.util.Map;

public class DataObject extends DataItem {

    /**
     * 每一个项是一个 DataValue 或 DataArray 或 DataObject
     */
    public Map<DataKey, DataItem> dataItemMap;

    public Map<DataKey, DataItem> getDataItemMap() {
        return dataItemMap;
    }

    public void setDataItemMap(Map<DataKey, DataItem> dataItemMap) {
        this.dataItemMap = dataItemMap;
    }

    public DataObject add(DataKey dataKey, DataItem dataItem) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newHashMap();
        }

        this.dataItemMap.putIfAbsent(dataKey, dataItem);

        return this;
    }

    public DataObject addDataValue(DataKey dataKey, DataValue dataValue) {
        return add(dataKey, dataValue);
    }

    public DataValue addDataValue(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newHashMap();
        }

        DataValue dataValue = new DataValue();

        this.dataItemMap.putIfAbsent(dataKey, dataValue);

        return dataValue;
    }

    public DataObject addDataArray(DataKey dataKey, DataArray dataArray) {
        return add(dataKey, dataArray);
    }

    /// <summary>
    /// 添加一个数组，并返回该数组
    /// </summary>
    public DataArray AddDataArray(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newHashMap();
        }

        DataArray dataArray = new DataArray();

        this.dataItemMap.putIfAbsent(dataKey, dataArray);

        return dataArray;
    }

    public DataObject addDataObject(DataKey dataKey, DataObject subDataObject) {
        return add(dataKey, subDataObject);
    }

    /// <summary>
    /// 添加一个对象，并返回该对象
    /// </summary>
    public DataObject AddDataObject(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newHashMap();
        }

        DataObject subDataObject = new DataObject();

        this.dataItemMap.putIfAbsent(dataKey, subDataObject);

        return subDataObject;
    }

    /// <summary>
    /// 添加一个对象
    /// </summary>
    public DataObject addSortedDataObject(DataKey dataKey, SortedDataObject subSortedDataObject) {
        return add(dataKey, subSortedDataObject);
    }

    /// <summary>
    /// 添加一个对象，并返回该对象
    /// </summary>
    public SortedDataObject AddSortedDataObject(DataKey dataKey) {
        if (this.dataItemMap == null) {
            this.dataItemMap = Maps.newHashMap();
        }

        SortedDataObject subSortedDataObject = new SortedDataObject();

        this.dataItemMap.putIfAbsent(dataKey, subSortedDataObject);

        return subSortedDataObject;
    }
}

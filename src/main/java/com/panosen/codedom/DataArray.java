package com.panosen.codedom;

import java.util.ArrayList;
import java.util.List;

public class DataArray extends DataItem {

    private List<DataItem> items;

    public List<DataItem> getItems() {
        return items;
    }

    public void setItems(List<DataItem> items) {
        this.items = items;
    }

    /**
     * addDataValue
     *
     * @param dataValue dataValue
     * @return DataArray
     */
    public DataArray addDataValue(DataValue dataValue) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(dataValue);

        return this;
    }

    /**
     * addDataObject
     *
     * @param dataObject dataObject
     * @return DataArray
     */
    public DataArray addDataObject(DataObject dataObject) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(dataObject);

        return this;
    }

    /**
     * addDataObject
     *
     * @return DataObject
     */
    public DataObject addDataObject() {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        DataObject dataObject = new DataObject();

        this.items.add(dataObject);

        return dataObject;
    }

    /**
     * addSortedDataObject
     *
     * @param sortedDataObject sortedDataObject
     * @return DataArray
     */
    public DataArray addSortedDataObject(SortedDataObject sortedDataObject) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(sortedDataObject);

        return this;
    }

    /**
     * addSortedDataObject
     *
     * @return SortedDataObject
     */
    public SortedDataObject addSortedDataObject() {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        SortedDataObject sortedDataObject = new SortedDataObject();

        this.items.add(sortedDataObject);

        return sortedDataObject;
    }

    /**
     * addRange
     *
     * @param items       items
     * @param <TDataItem> TdataItem
     * @return DataArray
     */
    public <TDataItem extends DataItem> DataArray addRange(List<TDataItem> items) {
        if (items == null || items.isEmpty()) {
            return this;
        }

        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.addAll(items);

        return this;
    }
}

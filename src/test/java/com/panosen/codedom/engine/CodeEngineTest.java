package com.panosen.codedom.engine;

import com.panosen.codedom.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;

public class CodeEngineTest {

    @Test
    public void generateDataObject() {

        DataObject dataObject = new DataObject();
        dataObject.addDataValue(DataKey.doubleQuotationString("name"), DataValue.ofString("tom"));
        dataObject.addDataValue(DataKey.doubleQuotationString("age"), DataValue.ofInteger(18));
        dataObject.addDataValue(DataKey.doubleQuotationString("age"), DataValue.doubleQuotationString("ok"));

        {
            DataArray dataArray = dataObject.addDataArray(DataKey.doubleQuotationString("jack"));
            dataArray.addDataValue(DataValue.ofInteger(3));
            dataArray.addDataValue(DataValue.doubleQuotationString("aa"));
            dataArray.addDataValue(DataValue.doubleQuotationString("bb"));
        }

        {
            DataObject bbb = dataObject.addDataObject(DataKey.doubleQuotationString("bbb"));
            bbb.addDataValue(DataKey.doubleQuotationString("b2"), DataValue.doubleQuotationString("aa"));
            bbb.addDataValue(DataKey.doubleQuotationString("b1"), DataValue.ofInteger(3));
            bbb.addDataValue(DataKey.doubleQuotationString("b3"), DataValue.doubleQuotationString("cc"));
        }

        {
            SortedDataObject aaa = dataObject.addSortedDataObject(DataKey.doubleQuotationString("aaa"));
            aaa.addDataValue(DataKey.doubleQuotationString("a2"), DataValue.doubleQuotationString("aa"));
            aaa.addDataValue(DataKey.doubleQuotationString("a1"), DataValue.ofInteger(3));
            aaa.addDataValue(DataKey.doubleQuotationString("a3"), DataValue.doubleQuotationString("cc"));
        }

        {
            SortedDataObject ccc = dataObject.addSortedDataObject(DataKey.doubleQuotationString("ccc"));
            for (int i = 0; i < 3; i++) {
                DataObject kkk = ccc.addDataObject(DataKey.doubleQuotationString("c" + i));
                kkk.addDataValue(DataKey.doubleQuotationString("k"), DataValue.ofInteger(i + 1));
            }
        }

        {
            DataArray ddd = dataObject.addDataArray(DataKey.doubleQuotationString("ddd"));
            for (int i = 0; i < 3; i++) {
                DataObject kkk = ddd.addDataObject();
                kkk.addDataValue(DataKey.doubleQuotationString("fff"), DataValue.ofInteger(i + 1));
            }
        }

        CodeEngine jsCodeEngine = new CodeEngine();

        StringWriter stringWriter = new StringWriter();

        jsCodeEngine.generateDataObject(dataObject, new CodeWriter(stringWriter), new GenerateOptions());

        String actual = stringWriter.toString();
        String expected = prepareExpected();

        Assert.assertEquals(actual, expected);

        System.out.println(stringWriter.toString());
    }

    private String prepareExpected() {
        return "{" + System.lineSeparator() +
                "    \"name\": tom," + System.lineSeparator() +
                "    \"age\": 18," + System.lineSeparator() +
                "    \"age\": \"ok\"," + System.lineSeparator() +
                "    \"jack\": [3, \"aa\", \"bb\"]," + System.lineSeparator() +
                "    \"bbb\": {" + System.lineSeparator() +
                "        \"b2\": \"aa\"," + System.lineSeparator() +
                "        \"b1\": 3," + System.lineSeparator() +
                "        \"b3\": \"cc\"" + System.lineSeparator() +
                "    }," + System.lineSeparator() +
                "    \"aaa\": {" + System.lineSeparator() +
                "        \"a1\": 3," + System.lineSeparator() +
                "        \"a2\": \"aa\"," + System.lineSeparator() +
                "        \"a3\": \"cc\"" + System.lineSeparator() +
                "    }," + System.lineSeparator() +
                "    \"ccc\": {" + System.lineSeparator() +
                "        \"c0\": {" + System.lineSeparator() +
                "            \"k\": 1" + System.lineSeparator() +
                "        }," + System.lineSeparator() +
                "        \"c1\": {" + System.lineSeparator() +
                "            \"k\": 2" + System.lineSeparator() +
                "        }," + System.lineSeparator() +
                "        \"c2\": {" + System.lineSeparator() +
                "            \"k\": 3" + System.lineSeparator() +
                "        }" + System.lineSeparator() +
                "    }," + System.lineSeparator() +
                "    \"ddd\": [{" + System.lineSeparator() +
                "        \"fff\": 1" + System.lineSeparator() +
                "    }, {" + System.lineSeparator() +
                "        \"fff\": 2" + System.lineSeparator() +
                "    }, {" + System.lineSeparator() +
                "        \"fff\": 3" + System.lineSeparator() +
                "    }]" + System.lineSeparator() +
                "}";
    }
}
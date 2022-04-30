package com.panosen.codedom;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;

public class CodeWriterTest {

    private final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void write() {
        StringWriter stringWriter = new StringWriter();
        CodeWriter codeWriter = new CodeWriter(stringWriter);

        codeWriter.write("abc");
        String actual = stringWriter.toString();

        String expected = "abc";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeLine() {
        StringWriter stringWriter = new StringWriter();
        CodeWriter codeWriter = new CodeWriter(stringWriter);

        codeWriter.writeLine("abc");
        String actual = stringWriter.toString();

        String expected = "abc" + LINE_SEPARATOR;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteLine() {
        StringWriter stringWriter = new StringWriter();
        CodeWriter codeWriter = new CodeWriter(stringWriter);

        codeWriter.writeLine();
        String actual = stringWriter.toString();

        Assert.assertEquals(LINE_SEPARATOR, actual);
    }
}
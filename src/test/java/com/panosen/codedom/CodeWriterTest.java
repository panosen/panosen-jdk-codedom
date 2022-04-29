package com.panosen.codedom;

import org.junit.Assert;
import org.junit.Test;

public class CodeWriterTest {

    private final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void write() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(stringBuilder);

        codeWriter.write("abc");
        String actual = stringBuilder.toString();

        String expected = "abc";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeLine() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(stringBuilder);

        codeWriter.writeLine("abc");
        String actual = stringBuilder.toString();

        String expected = "abc" + LINE_SEPARATOR;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteLine() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(stringBuilder);

        codeWriter.writeLine();
        String actual = stringBuilder.toString();

        Assert.assertEquals(LINE_SEPARATOR, actual);
    }
}
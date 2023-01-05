package com.panosen.codedom;

import java.io.StringWriter;

/**
 * CodeWriter
 */
public class CodeWriter {

    private final StringWriter stringWriter;

    public CodeWriter(StringWriter stringWriter) {
        this.stringWriter = stringWriter;
    }

    /**
     * 写入字符串，可以为 null
     *
     * @param value value
     * @return CodeWriter
     */
    public CodeWriter write(String value) {
        if (value != null && !value.isEmpty()) {
            stringWriter.append(value);
        }
        return this;
    }

    /**
     * 写入字符串，可以为 null
     *
     * @param value value
     * @return CodeWriter
     */
    public CodeWriter writeLine(String value) {
        if (value != null && !value.isEmpty()) {
            stringWriter.append(value);
        }
        stringWriter.append(System.lineSeparator());
        return this;
    }

    /**
     * 写入换行符
     *
     * @return CodeWriter
     */
    public CodeWriter writeLine() {
        stringWriter.append(System.lineSeparator());
        return this;
    }
}

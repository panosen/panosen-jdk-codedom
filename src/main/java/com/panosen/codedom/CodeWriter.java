package com.panosen.codedom;

import com.google.common.base.Strings;

import java.io.StringWriter;

/**
 * CodeWriter
 */
public class CodeWriter {

    private final StringBuilder stringBuilder;

    public CodeWriter(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    /**
     * 写入字符串，可以为 null
     *
     * @param value value
     * @return CodeWriter
     */
    public CodeWriter write(String value) {
        if (!Strings.isNullOrEmpty(value)) {
            stringBuilder.append(value);
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
        if (!Strings.isNullOrEmpty(value)) {
            stringBuilder.append(value);
        }
        stringBuilder.append(System.lineSeparator());
        return this;
    }

    /**
     * 写入换行符
     *
     * @return CodeWriter
     */
    public CodeWriter writeLine() {
        stringBuilder.append(System.lineSeparator());
        return this;
    }
}

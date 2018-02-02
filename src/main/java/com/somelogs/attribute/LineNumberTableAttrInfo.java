package com.somelogs.attribute;

import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Attribute: LineNumberTable
 *
 * @author LBG - 2018/1/17 0017
 */
@Getter
@Setter
public class LineNumberTableAttrInfo extends AttributeInfo {

    private short lineNumberTableLength;
    private List<LineNumberInfo> lineNumberInfoList;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        lineNumberTableLength = inputStream.readShort();
        lineNumberInfoList = new ArrayList<>(lineNumberTableLength);
        for (int i = 0; i < lineNumberTableLength; i++) {
            LineNumberInfo numberInfo = new LineNumberInfo();
            numberInfo.setStart(inputStream.readShort());
            numberInfo.setLineNumber(inputStream.readShort());
            lineNumberInfoList.add(numberInfo);
        }
    }

    @Override
    public String getPrintContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("{type=LineNumberTable, table=[");
        for (LineNumberInfo info : lineNumberInfoList) {
            sb.append(info).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]}");
        return sb.toString();
    }

    @Getter
    @Setter
    private class LineNumberInfo {

        /**
         * byte code line number
         */
        private int start;

        /**
         * java source file line number
         */
        private int lineNumber;

        @Override
        public String toString() {
            return "{start=" + start + ", lineNumber=" + lineNumber + "}";
        }
    }
}

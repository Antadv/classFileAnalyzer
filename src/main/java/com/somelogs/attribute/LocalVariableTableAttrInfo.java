package com.somelogs.attribute;

import com.somelogs.constantpool.ConstantPool;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Attribute: LocalVariableTable
 *
 * @author LBG - 2018/1/17 0017
 */
@Setter
@Getter
public class LocalVariableTableAttrInfo extends AttributeInfo {

    private short localVariableTableLength;
    private List<LocalVariableInfo> variableInfoList;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        localVariableTableLength = inputStream.readShort();
        variableInfoList = new ArrayList<>(localVariableTableLength);
        for (int i = 0; i < localVariableTableLength; i++) {
            LocalVariableInfo info = new LocalVariableInfo();
            info.setStart(inputStream.readShort());
            info.setLength(inputStream.readShort());
            info.setName(ConstantPool.getStringByIndex(inputStream.readShort()));
            info.setDescriptor(ConstantPool.getStringByIndex(inputStream.readShort()));
            info.setIndex(inputStream.readShort());
            variableInfoList.add(info);
        }
    }

    @Override
    public String getPrintContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("{type=LocalVariableTable, LocalVariableInfo=[");
        for (LocalVariableInfo info : variableInfoList) {
            sb.append(info.toString()).append(", ");
        }
        if (variableInfoList.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]}");
        return sb.toString();
    }

    @Setter
    @Getter
    private class LocalVariableInfo {
        private int start;
        private int length;
        private String name;
        private String descriptor;
        private int index;

        @Override
        public String toString() {
            return "{start=" + start + ", " +
                    "length=" + length + ", " +
                    "name=" + name + ", " +
                    "descriptor=" + descriptor + ", " +
                    "index=" + index + "}";
        }
    }
}

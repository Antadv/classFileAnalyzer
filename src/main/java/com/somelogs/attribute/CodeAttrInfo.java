package com.somelogs.attribute;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Attribute: Code
 *
 * @author LBG - 2018/1/17 0017
 */
@Setter
@Getter
@ToString
public class CodeAttrInfo extends AttributeInfo {

    private short maxStack;
    private short maxLocals;
    private int codeLength;
    private String[] opcodes;
    private List<ExceptionInfo> exceptionInfoList;
    private List<AttributeInfo> attributeInfoList;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        maxStack = inputStream.readShort();
        maxLocals = inputStream.readShort();
        codeLength = inputStream.readInt();
        opcodes = new String[codeLength];
        if (codeLength > 0) {
            for (int i = 0; i < codeLength; i++) {
                opcodes[i] = Integer.toHexString(inputStream.readByte() & 0xFF);
            }
        }
        exceptionInfoList = new ArrayList<>(inputStream.readShort());
        if (exceptionInfoList.size() > 0) {
            ExceptionInfo exceptionInfo = new ExceptionInfo();
            exceptionInfo.setStart(inputStream.readShort());
            exceptionInfo.setEnd(inputStream.readShort());
            exceptionInfo.setHandler(inputStream.readShort());
            exceptionInfo.setType(inputStream.readShort());
            exceptionInfoList.add(exceptionInfo);
        }
        short attrCount = inputStream.readShort();
        attributeInfoList = new ArrayList<>(attrCount);
        for (int i = 0; i < attrCount; i++) {
            AttributeInfo attrInfo = AttributeInfo.readAttributeInfo(inputStream);
            attributeInfoList.add(attrInfo);
        }
    }

    @Override
    public String getPrintContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("{type=Code, ")
            .append("maxStack=").append(maxStack)
            .append(", maxLocals=").append(maxLocals)
            .append(", codeLength=").append(codeLength);

        sb.append(", opcodes=[");
        for (String opcode : opcodes) {
            sb.append(opcode).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("], ");
        sb.append("exceptions=[");
        for (ExceptionInfo info : exceptionInfoList) {
            sb.append(info.toString());
        }
        sb.append("], ");
        sb.append("attribute=[");
        for (AttributeInfo info : attributeInfoList) {
            sb.append(info.getPrintContent()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]}");
        return sb.toString();
    }

    @Getter
    @Setter
    private class ExceptionInfo {
        private int start;
        private int end;
        private int handler;
        private int type;

        @Override
        public String toString() {
            return "{start=" + start + ", " +
                    "end=" + end + ", " +
                    "handler=" + handler + ", " +
                    "type=" + type + "}";
        }
    }
}

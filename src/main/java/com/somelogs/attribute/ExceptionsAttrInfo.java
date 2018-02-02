package com.somelogs.attribute;

import com.somelogs.constantpool.ConstantPool;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Attribute: Exceptions
 * exceptions throw in method signature
 *
 * @author LBG - 2018/1/17 0017
 */
@Setter
@Getter
public class ExceptionsAttrInfo extends AttributeInfo {

    private short exceptionNumber;
    private ExceptionIndexTable[] exceptionTable;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        exceptionNumber = inputStream.readShort();
        exceptionTable = new ExceptionIndexTable[exceptionNumber];
        for (int i = 0; i < exceptionNumber; i++) {
            ExceptionIndexTable table = new ExceptionIndexTable();
            String exceptionName = ConstantPool.getStringByIndex(inputStream.readShort());
            table.setExceptionName(exceptionName);
            exceptionTable[i] = table;
        }
    }

    @Override
    public String getPrintContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("{type=Exceptions, exceptions=[");
        for (ExceptionIndexTable exp : exceptionTable) {
            sb.append(exp).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]}");
        return sb.toString();
    }

    @Getter
    @Setter
    private class ExceptionIndexTable {
        private String exceptionName;

        @Override
        public String toString() {
            return exceptionName;
        }
    }
}

package com.somelogs.attribute;

import com.somelogs.accessflag.InnerClassAccessFlag;
import com.somelogs.constantpool.ConstantPool;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Attribute: InnerClass
 *
 * @author LBG - 2018/1/17 0017
 */
@Setter
@Getter
public class InnerClassesAttrInfo extends AttributeInfo {

    private short classNumber;
    private InnerClassInfo[] innerClasses;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        classNumber = inputStream.readShort();
        innerClasses = new InnerClassInfo[classNumber];
        for (int i = 0; i < classNumber; i++) {
            InnerClassInfo info = new InnerClassInfo();
            info.setInnerClassName(ConstantPool.getStringByIndex(inputStream.readShort()));
            info.setOutClassName(ConstantPool.getStringByIndex(inputStream.readShort()));
            info.setInnerName(ConstantPool.getStringByIndex(inputStream.readShort()));
            info.setFlags(new InnerClassAccessFlag().getAccessFlags(inputStream.readShort()));
            innerClasses[i] = info;
        }
    }

    @Override
    public String getPrintContent() {
        return null;
    }

    @Data
    private class InnerClassInfo {
        private String innerClassName;
        private String outClassName;
        private String innerName;
        private String flags;
    }
}

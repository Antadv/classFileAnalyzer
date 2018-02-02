package com.somelogs.attribute;

import com.somelogs.constantpool.ConstantPool;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Attribute: SourceFile
 *
 * @author LBG - 2018/1/17 0017
 */
@Getter
@Setter
public class SourceFileAttrInfo extends AttributeInfo {

    private String sourceFileName;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        sourceFileName = ConstantPool.getStringByIndex(inputStream.readShort());
    }

    @Override
    public String getPrintContent() {
        return "{type=SourceFile, fileName=" + sourceFileName + "}";
    }
}

package com.somelogs.attribute;

import com.somelogs.constantpool.ConstantPool;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Attribute: ConstantValue
 * Constant value type can only be primitive type or String
 *
 * @author LBG - 2018/1/17 0017
 */
@Setter
@Getter
public class ConstantValueAttrInfo extends AttributeInfo {

    private String value;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        value = ConstantPool.getStringByIndex(inputStream.readShort());
    }

    @Override
    public String getPrintContent() {
        return "{type=" + attributeName + ", value=" + value + "}";
    }
}

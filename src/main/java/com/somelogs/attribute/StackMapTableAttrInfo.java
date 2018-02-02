package com.somelogs.attribute;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Attribute: StackMapTable
 *
 * @author LBG - 2018/1/17 0017
 */
@Getter
@Setter
public class StackMapTableAttrInfo extends AttributeInfo {

    private int entryNumber;
    private List<StackMapFrame> frameList;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        entryNumber = inputStream.readShort();
        for (int i = 0; i < attributeLength - 2; i++) {
            inputStream.readByte();
        }
    }

    @Override
    public String getPrintContent() {
        return null;
    }

    @Data
    private class StackMapFrame {
    }
}

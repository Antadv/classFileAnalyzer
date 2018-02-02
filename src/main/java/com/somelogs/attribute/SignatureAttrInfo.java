package com.somelogs.attribute;

import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Attribute: Signature
 *
 * @author LBG - 2018/1/17 0017
 */
@Setter
@Getter
public class SignatureAttrInfo extends AttributeInfo {

    private short signatureIndex;

    @Override
    public void readMore(DataInputStream inputStream) throws IOException {
        signatureIndex = inputStream.readShort();
    }

    @Override
    public String getPrintContent() {
        return null;
    }
}

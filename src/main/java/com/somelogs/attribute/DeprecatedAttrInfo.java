package com.somelogs.attribute;

import java.io.DataInputStream;

/**
 * Attribute: Deprecated
 *
 * @author LBG - 2018/1/17 0017
 */
public class DeprecatedAttrInfo extends AttributeInfo {

    @Override
    public void readMore(DataInputStream inputStream) {}

    @Override
    public String getPrintContent() {
        return "{type=Deprecated}";
    }
}

package com.somelogs.attribute;

import java.io.DataInputStream;

/**
 * Attribute: Synthetic
 *
 * @author LBG - 2018/1/17 0017
 */
public class SyntheticAttrInfo extends AttributeInfo {

    @Override
    public void readMore(DataInputStream inputStream) {
    }

    @Override
    public String getPrintContent() {
        return null;
    }
}

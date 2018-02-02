package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_Float_Info
 *
 * @author LBG - 2018/1/15 0015 17:24
 */
@Setter
@Getter
@ToString
public class ConstantFloatInfo extends ConstantPoolInfo {

    private float value;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        value = inputStream.readFloat();
        content = String.valueOf(value);
    }
}

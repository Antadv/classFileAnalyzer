package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_Long_info
 *
 * @author LBG - 2018/1/15 0015
 */
@Getter
@Setter
public class ConstantLongInfo extends ConstantPoolInfo {

    private long value;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        value = inputStream.readLong();
        content = String.valueOf(value) + "L";
    }
}

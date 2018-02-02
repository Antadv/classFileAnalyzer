package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_Integer_info
 *
 * @author LBG - 2018/1/15 0015 17:22
 */
@Setter
@Getter
@ToString
public class ConstantIntegerInfo extends ConstantPoolInfo {

    private int value;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        value = inputStream.readInt();
        content = String.valueOf(value);
    }
}

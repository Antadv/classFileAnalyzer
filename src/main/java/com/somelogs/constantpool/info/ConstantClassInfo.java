package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_Class_Info
 *
 * @author LBG - 2018/1/15 0015 17:29
 */
@Setter
@Getter
@ToString
public class ConstantClassInfo extends ConstantPoolInfo {

    private short index;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        index = inputStream.readShort();
    }
}

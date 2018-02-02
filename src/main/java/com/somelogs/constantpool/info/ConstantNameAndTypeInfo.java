package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_NameAndType_info
 *
 * @author LBG - 2018/1/15 0015 17:42
 */
@Getter
@Setter
@ToString
public class ConstantNameAndTypeInfo extends ConstantPoolInfo {

    private short constantIndex;
    private short descriptorIndex;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        constantIndex = inputStream.readShort();
        descriptorIndex = inputStream.readShort();
    }
}

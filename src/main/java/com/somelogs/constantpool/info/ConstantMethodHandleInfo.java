package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_Method_Handle_info
 *
 * @author LBG - 2018/1/15 0015
 */
@Getter
@Setter
@ToString
public class ConstantMethodHandleInfo extends ConstantPoolInfo {

    /**
     * reference kind
     */
    private byte referenceKind;

    /**
     * reference index
     */
    private short referenceIndex;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        referenceKind = inputStream.readByte();
        referenceIndex = inputStream.readShort();
    }
}

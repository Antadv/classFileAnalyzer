package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * this class type contains three kinds of Constant info
 *
 *  <li>Constant_Fieldref_info</li>
 *  <li>Constant_Methodref_info</li>
 *  <li>Constant_Interface_Methodref_info</li>
 *
 * @author LBG - 2018/1/18 0018
 */
@Setter
@Getter
public class ConstantRefInfo extends ConstantPoolInfo {

    private short classIndex;
    private short descriptorIndex;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        classIndex = inputStream.readShort();
        descriptorIndex = inputStream.readShort();
    }
}

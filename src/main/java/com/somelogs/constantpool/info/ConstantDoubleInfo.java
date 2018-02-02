package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_Double_Info
 *
 * @author LBG - 2018/1/15 0015 17:29
 */
@Getter
@Setter
@ToString
public class ConstantDoubleInfo extends ConstantPoolInfo {

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        content = String.valueOf(inputStream.readDouble());
    }
}

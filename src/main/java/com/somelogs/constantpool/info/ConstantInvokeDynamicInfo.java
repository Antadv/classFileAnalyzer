package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Constant_Invoke_Dynamic_info
 *
 * @author LBG - 2018/1/15 0015
 */
@Setter
@Getter
@ToString
public class ConstantInvokeDynamicInfo extends ConstantPoolInfo {

    /**
     * bootstrap_method_attr_index
     */
    private short bootstrapMethodAttrIndex;

    /**
     * name_and_type_index
     */
    private short nameAndTypeIndex;

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        bootstrapMethodAttrIndex = inputStream.readShort();
        nameAndTypeIndex = inputStream.readShort();
    }
}

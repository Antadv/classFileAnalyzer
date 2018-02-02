package com.somelogs.constantpool;

import com.somelogs.constantpool.info.*;
import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Base Constant Pool Info
 *
 * @author LBG - 2018/1/16 0016
 */
@Data
public abstract class ConstantPoolInfo {

    public static final short CONSTANT_UTF8_INFO = 1;
    public static final short CONSTANT_INTEGER_INFO = 3;
    public static final short CONSTANT_FLOAT_INFO = 4;
    public static final short CONSTANT_LONG_INFO = 5;
    public static final short CONSTANT_DOUBLE_INFO = 6;
    public static final short CONSTANT_CLASS_INFO = 7;
    public static final short CONSTANT_STRING_INFO = 8;
    public static final short CONSTANT_FIELD_REF_INFO = 9;
    public static final short CONSTANT_METHOD_REF_INFO = 10;
    public static final short CONSTANT_INTERFACE_METHOD_REF_INFO = 11;
    public static final short CONSTANT_NAME_AND_TYPE_INFO = 12;
    public static final short CONSTANT_METHOD_HANDLE_INFO = 15;
    public static final short CONSTANT_METHOD_TYPE_INFO = 16;
    public static final short CONSTANT_INVOKE_DYNAMIC_INFO = 18;

    protected byte tag;

    /**
     * string to show
     */
    protected String content;

    public abstract void read(DataInputStream inputStream) throws IOException;

    /**
     * get constant pool info
     */
    public static ConstantPoolInfo getCpInfoByTag(byte tag) {
        ConstantPoolInfo cpInfo;
        switch (tag) {
            case ConstantPoolInfo.CONSTANT_UTF8_INFO:
                cpInfo = new ConstantUtf8Info();
                break;
            case ConstantPoolInfo.CONSTANT_INTEGER_INFO:
                cpInfo = new ConstantIntegerInfo();
                break;
            case ConstantPoolInfo.CONSTANT_FLOAT_INFO:
                cpInfo = new ConstantFloatInfo();
                break;
            case ConstantPoolInfo.CONSTANT_LONG_INFO:
                cpInfo = new ConstantLongInfo();
                break;
            case ConstantPoolInfo.CONSTANT_DOUBLE_INFO:
                cpInfo = new ConstantDoubleInfo();
                break;
            case ConstantPoolInfo.CONSTANT_CLASS_INFO:
                cpInfo = new ConstantClassInfo();
                break;
            case ConstantPoolInfo.CONSTANT_STRING_INFO:
                cpInfo = new ConstantStringInfo();
                break;
            case ConstantPoolInfo.CONSTANT_FIELD_REF_INFO:
                cpInfo = new ConstantRefInfo();
                break;
            case ConstantPoolInfo.CONSTANT_METHOD_REF_INFO:
                cpInfo = new ConstantRefInfo();
                break;
            case ConstantPoolInfo.CONSTANT_INTERFACE_METHOD_REF_INFO:
                cpInfo = new ConstantRefInfo();
                break;
            case ConstantPoolInfo.CONSTANT_NAME_AND_TYPE_INFO:
                cpInfo = new ConstantNameAndTypeInfo();
                break;
            case ConstantPoolInfo.CONSTANT_METHOD_HANDLE_INFO:
                cpInfo = new ConstantMethodHandleInfo();
                break;
            case ConstantPoolInfo.CONSTANT_METHOD_TYPE_INFO:
                cpInfo = new ConstantMethodTypeInfo();
                break;
            case ConstantPoolInfo.CONSTANT_INVOKE_DYNAMIC_INFO:
                cpInfo = new ConstantInvokeDynamicInfo();
                break;
            default:
                throw new RuntimeException("unknown tag " + tag);
        }
        return cpInfo;
    }
}

package com.somelogs.accessflag;

/**
 * common access flag
 *
 * @author LBG - 2018/1/18 0018
 */
public abstract class AccessFlag {

    static final short ACC_PUBLIC = 0x0001;
    static final short ACC_PRIVATE = 0x0002;
    static final short ACC_PROTECTED = 0x0004;

    static final short ACC_FINAL = 0x0010;
    static final short ACC_SYNTHETIC = 0x1000;
    static final short ACC_ENUM = 0x4000;

    public abstract String getAccessFlags(short flag);

    protected String getAccessModifier(short flag) {
        String flagStr;
        if ((flag & ACC_PUBLIC) != 0) {
            flagStr = "public ";
        } else if ((flag & ACC_PRIVATE) != 0) {
            flagStr = "private ";
        } else if ((flag & ACC_PROTECTED) != 0) {
            flagStr = "protected ";
        } else {
            flagStr = " ";
        }
        return flagStr;
    }

}

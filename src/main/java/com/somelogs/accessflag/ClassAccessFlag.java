package com.somelogs.accessflag;

/**
 * class access flag
 *
 * @author LBG - 2018/1/17 0017
 */
public class ClassAccessFlag extends AccessFlag {

    private static final short ACC_SUPER = 0x0020;
    private static final short ACC_INTERFACE = 0x0200;
    private static final short ACC_ABSTRACT = 0x0400;
    private static final short ACC_ANNOTATION = 0x2000;

    @Override
    public String getAccessFlags(short flag) {
        StringBuilder flags = new StringBuilder();
        if ((flag & ACC_PUBLIC) != 0) {
            flags.append("ACC_PUBLIC ");
        }
        if ((flag & ACC_FINAL) != 0) {
            flags.append("ACC_FINAL ");
        }
        if ((flag & ACC_SUPER) != 0) {
            flags.append("ACC_SUPER ");
        }
        if ((flag & ACC_INTERFACE) != 0) {
            flags.append("ACC_INTERFACE ");
        }
        if ((flag & ACC_ABSTRACT) != 0) {
            flags.append("ACC_ABSTRACT ");
        }
        if ((flag & ACC_SYNTHETIC) != 0) {
            flags.append("ACC_SYNTHETIC ");
        }
        if ((flag & ACC_ANNOTATION) != 0) {
            flags.append("ACC_ANNOTATION ");
        }
        if ((flag & ACC_ENUM) != 0) {
            flags.append("ACC_ENUM ");
        }
        return flags.toString();
    }

}

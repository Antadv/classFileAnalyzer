package com.somelogs.accessflag;

/**
 * Inner class access flag
 *
 * @author LBG - 2018/1/18 0018
 */
public class InnerClassAccessFlag extends ClassAccessFlag {

    @Override
    public String getAccessFlags(short flag) {
        String flags = super.getAccessFlags(flag);
        if ((flag & ACC_PRIVATE) != 0) {
            flags = flags + "ACC_PRIVATE";
        }
        return flags;
    }
}

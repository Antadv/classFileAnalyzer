package com.somelogs.constantpool;

/**
 * Constant type enum: {tag, typeName}
 *
 * @author LBG - 2018/1/17 0017
 */
public enum ConstantTypeEnum {

    UTF8(1, "Utf8"),
    INTEGER(3, "Integer"),
    FLOAT(4, "Float"),
    LONG(5, "Long"),
    DOUBLE(6, "Double"),
    CLASS(7, "Class"),
    STRING(8, "String"),
    FIELD_REF(9, "Fieldref"),
    METHOD_REF(10, "Methodref"),
    INTERFACE_METHOD_REF(11, "InterfaceMethodref"),
    NAME_AND_TYPE(12, "NameAndType"),
    METHOD_HANDLE(15, "MethodHandle"),
    METHOD_TYPE(16, "MethodType"),
    INVOKE_DYNAMIC(18, "InvokeDynamic");

    private int tag;
    private String typeName;

    ConstantTypeEnum(int tag, String typeName) {
        this.tag = tag;
        this.typeName = typeName;
    }

    public int getTag() {
        return tag;
    }

    public String getTypeName() {
        return typeName;
    }

    public static String getNameByTag(int tag) {
        for (ConstantTypeEnum type : ConstantTypeEnum.values()) {
            if (type.getTag() == tag) {
                return type.getTypeName();
            }
        }
        return null;
    }
}

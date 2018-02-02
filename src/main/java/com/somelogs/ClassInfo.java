package com.somelogs;

import com.somelogs.attribute.AttributeInfo;
import com.somelogs.constantpool.ConstantPool;
import com.somelogs.table.FieldMethodInfo;
import lombok.Data;

import java.util.List;

/**
 * class info
 *
 * @author LBG - 2018/1/15 0015 16:42
 */
@Data
public class ClassInfo {

    private int magic;
    private short minorVersion;
    private short majorVersion;
    private short constantPoolCount;
    private ConstantPool cpInfo;
    private String accessFlags;
    private String classFullyQualifiedName;
    private String superClassFullyQualifiedName;
    private List<String> interfaceList;
    private FieldMethodInfo[] fieldTable;
    private FieldMethodInfo[] methodTable;
    private AttributeInfo[] attrTable;

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("magic: ").append(Integer.toHexString(magic)).append("\n")
                .append("minor version: ").append(minorVersion).append("\n")
                .append("major version: ").append(majorVersion).append("\n")
                .append("Access flags: ").append(accessFlags).append("\n").append("\n")
                .append("Constant pool:").append("\n")
                .append(cpInfo.getContent()).append("\n")
                .append("Class FQN: ").append(classFullyQualifiedName).append("\n")
                .append("Super class FQN: ").append(superClassFullyQualifiedName).append("\n").append("\n");

        sb.append("Interfaces: ").append(interfaceList.size()).append("\n");
        for (String interfaceName : interfaceList) {
            sb.append(interfaceName).append("\n").append("\n");
        }
        sb.append("Fields Count: ").append(fieldTable.length).append("\n");
        for (FieldMethodInfo info : fieldTable) {
            sb.append(info.toString()).append("\n");
        }
        sb.append("\n").append("Method Count: ").append(methodTable.length).append("\n");
        for (FieldMethodInfo info : methodTable) {
            sb.append(info.toString()).append("\n");
        }
        sb.append("\n").append("Attribute Count: ").append(attrTable.length).append("\n");
        for (AttributeInfo info : attrTable) {
            sb.append(info.getPrintContent()).append("\n");
        }
        System.out.println(sb.toString());
    }
}

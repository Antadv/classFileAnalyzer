package com.somelogs.constantpool;

import com.somelogs.constantpool.info.*;
import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * constant pool
 *
 * @author LBG - 2018/1/15 0015 17:19
 */
@Data
public class ConstantPool {

    private int cpCount;
    private static Map<Integer, ConstantPoolInfo> cpInfoMap;

    public ConstantPool(int cpCount) {
        this.cpCount = cpCount;
        cpInfoMap = new LinkedHashMap<>(cpCount);
    }

    public static String getStringByIndex(short index) {
        return cpInfoMap.get((int) index).getContent();
    }

    public String getContent() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, ConstantPoolInfo> entry : cpInfoMap.entrySet()) {
            ConstantPoolInfo info = entry.getValue();
            builder.append("#")
                    .append(entry.getKey())
                    .append("=")
                    .append(ConstantTypeEnum.getNameByTag(info.getTag()))
                    .append(" ")
                    .append(info.getContent())
                    .append("\n");

        }
        return builder.toString();
    }

    public void analyze(DataInputStream inputStream) throws IOException {
        addCpInfo2Map(inputStream);
        parseIndexWithConstant();
        parseIndexWithRef();
    }

    private void addCpInfo2Map(DataInputStream inputStream) throws IOException {
        int i = 1;
        while (i <= cpCount) {
            byte tag = inputStream.readByte();
            ConstantPoolInfo info = ConstantPoolInfo.getCpInfoByTag(tag);
            info.setTag(tag);
            info.read(inputStream);
            cpInfoMap.put(i, info);
            // 8 字节的常量占用两个成员表空间
            if (tag == ConstantPoolInfo.CONSTANT_LONG_INFO
                    || tag == ConstantPoolInfo.CONSTANT_DOUBLE_INFO) {
                i += 2;
            } else {
                i++;
            }
        }
    }

    private void parseIndexWithConstant() {
        for (ConstantPoolInfo poolInfo : cpInfoMap.values()) {
            if (poolInfo instanceof ConstantClassInfo) {
                ConstantClassInfo info = (ConstantClassInfo) poolInfo;
                info.setContent(getStringByIndex(info.getIndex()));
            } else if (poolInfo instanceof ConstantStringInfo) {
                ConstantStringInfo info = (ConstantStringInfo) poolInfo;
                info.setContent(getStringByIndex(info.getIndex()));
            } else if (poolInfo instanceof ConstantNameAndTypeInfo) {
                ConstantNameAndTypeInfo info = (ConstantNameAndTypeInfo) poolInfo;
                String simpleName = getStringByIndex(info.getConstantIndex());
                String descriptor = getStringByIndex(info.getDescriptorIndex());
                info.setContent(simpleName + ":" + descriptor);
            }
        }
    }

    private void parseIndexWithRef() {
        for (ConstantPoolInfo poolInfo : cpInfoMap.values()) {
            if (poolInfo instanceof ConstantRefInfo) {
                ConstantRefInfo info = (ConstantRefInfo) poolInfo;
                String classDesc = getStringByIndex(info.getClassIndex());
                String descriptor = getStringByIndex(info.getDescriptorIndex());
                poolInfo.setContent(classDesc + "." + descriptor);

            } else if (poolInfo instanceof ConstantMethodTypeInfo) {

            } else if (poolInfo instanceof ConstantMethodHandleInfo) {

            } else if (poolInfo instanceof ConstantInvokeDynamicInfo) {

            }
        }
    }
}


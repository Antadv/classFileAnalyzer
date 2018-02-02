package com.somelogs.table;

import com.somelogs.attribute.AttributeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * field table Or Method table
 *
 * @author LBG - 2018/1/17 0017
 */
@Setter
@Getter
@ToString
public class FieldMethodInfo {

    private String accessFlag;
    private String simpleName;
    private String descriptor;
    private List<AttributeInfo> attributeInfoList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(accessFlag)
            .append(descriptor)
            .append(" ")
            .append(simpleName)
            .append("\n");

        for (AttributeInfo info : attributeInfoList) {
            sb.append("\t").append(info.getPrintContent()).append("\n");
        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }
}

package com.somelogs.constantpool.info;

import com.somelogs.constantpool.ConstantPoolInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;

/**
 * Constant_Utf8_Info
 *
 * @author LBG - 2018/1/15 0015
 */
@Setter
@Getter
@ToString
public class ConstantUtf8Info extends ConstantPoolInfo {

    @Override
    public void read(DataInputStream inputStream) throws IOException {
        content = inputStream.readUTF();
    }

    //@Override
    //public void read(InputStream inputStream) {
    //    U2 length = U2.read(inputStream);
    //    byte[] bytes = new byte[length.getValue()];
    //    try {
    //        inputStream.read(bytes);
    //        content = readUTF(bytes);
    //    } catch (IOException e) {
    //        throw new RuntimeException(e);
    //    }
    //}

    private static String readUTF(byte[] bytes) throws UTFDataFormatException {
        int c, char2, char3;
        int count = 0;
        int chararr_count = 0;
        char[] chararr = new char[bytes.length];

        while (count < bytes.length) {
            c = (int) bytes[count] & 0xff;
            if (c > 127) break;
            count++;
            chararr[chararr_count++] = (char) c;
        }

        while (count < bytes.length) {
            c = (int) bytes[count] & 0xff;
            switch (c >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    count++;
                    chararr[chararr_count++] = (char) c;
                    break;
                case 12:
                case 13:
                    count += 2;
                    if (count > bytes.length)
                        throw new UTFDataFormatException(
                                "malformed input: partial character at end");
                    char2 = (int) bytes[count - 1];
                    if ((char2 & 0xC0) != 0x80)
                        throw new UTFDataFormatException(
                                "malformed input around byte " + count);
                    chararr[chararr_count++] = (char) (((c & 0x1F) << 6) |
                            (char2 & 0x3F));
                    break;
                case 14:
                    count += 3;
                    if (count > bytes.length)
                        throw new UTFDataFormatException(
                                "malformed input: partial character at end");
                    char2 = (int) bytes[count - 2];
                    char3 = (int) bytes[count - 1];
                    if (((char2 & 0xC0) != 0x80) || ((char3 & 0xC0) != 0x80))
                        throw new UTFDataFormatException(
                                "malformed input around byte " + (count - 1));
                    chararr[chararr_count++] = (char) (((c & 0x0F) << 12) |
                            ((char2 & 0x3F) << 6) |
                            ((char3 & 0x3F)));
                    break;
                default:
                    throw new UTFDataFormatException(
                            "malformed input around byte " + count);
            }
        }
        return new String(chararr, 0, chararr_count);
    }
}

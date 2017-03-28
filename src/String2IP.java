import com.sun.deploy.util.StringUtils;

import static java.lang.Character.getNumericValue;

/**
 * Created by laileon on 2017/3/28.
 */
public class String2IP {
    //<< 左移运算符，num << 1,相当于num乘以2的0次方
    //>> 右移运算符，num >> 1,相当于num除以2的0次方
    //>>> 无符号右移，忽略符号位，空位都以0补齐
    public static void main(String[] args) {
//        System.out.println(ipToLong("1.1.1.129"));
//        System.out.println(longToIP(16843137));
//        System.out.println(Integer.toBinaryString(16843137));
//        System.out.println(Integer.valueOf(string2binary("7ab7ab7a2b6ab"), 2));
        System.out.println(getIpAddress("7ab7ab7a2b6ab"));

    }

    //将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
    private static long ipToLong(String strIp) {
        long[] ip = new long[4];
        //先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        //将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    //将十进制整数形式转换成127.0.0.1形式的ip地址
    private static String longToIP(long longIp) {
        StringBuilder sb = new StringBuilder("");
        //直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        //将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        //将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        //将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    private static String string2binary(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                char c = getChar(str, i);
                sb.append(c);
            } else {
                for (int j = 0; j < getNumericValue(str.charAt(i)); j++) {
                    char c = getChar(str, i + 1);
                    sb.append(c);
                }
                i++;
            }
        }
        return sb.toString();
    }

    private static char getChar(String str, int i) {
        char c;
        if (str.charAt(i) == 'a') {
            c = '0';
        } else {
            c = '1';
        }
        return c;
    }

    private static String getIpAddress(String input){
        return longToIP(Long.valueOf(string2binary("7ab7ab7a2b6ab"), 2));
    }


}

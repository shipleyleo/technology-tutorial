package com.leo.example.commonutils.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public StringUtils() {
    }

    public static String substringOfUnicode(String str, int length) {
        if (str != null && !str.isEmpty() && length > 0 && str.length() * 2 >= length) {
            StringBuilder result = new StringBuilder();
            int i = 0;
            int l = str.length();

            for(int count = 0; i < l; ++i) {
                char x = str.charAt(i);
                count += x > 127 ? 2 : 1;
                if (count > length) {
                    break;
                }

                result.append(x);
            }

            return result.toString();
        } else {
            return str;
        }
    }

    public static String qj2bj(String input) {
        if (input == null) {
            return null;
        } else {
            char[] c = input.toCharArray();

            for(int i = 0; i < c.length; ++i) {
                if (c[i] == 12288) {
                    c[i] = ' ';
                } else if (c[i] > '\uff00' && c[i] < '｟') {
                    c[i] -= 'ﻠ';
                }
            }

            return new String(c);
        }
    }

    public static String bj2qj(String input) {
        if (input == null) {
            return null;
        } else {
            char[] c = input.toCharArray();

            for(int i = 0; i < c.length; ++i) {
                if (c[i] == ' ') {
                    c[i] = 12288;
                } else if (c[i] < 127) {
                    c[i] += 'ﻠ';
                }
            }

            return new String(c);
        }
    }

    public static String ifNull(String a, String b) {
        return isEmpty(a) ? b : a;
    }

    public static String toString(Object v) {
        return v == null ? "" : v.toString();
    }

    public static int getLength2(String value) {
        if (isEmpty(value)) {
            return 0;
        } else {
            int size = 0;
            int length = value.length();

            for(int i = 0; i < length; ++i) {
                size += value.charAt(i) > 127 ? 2 : 1;
            }

            return size;
        }
    }

    public static String join(Object[] arr, String separator, String left, String right, String start, String end) {
        if (CollectionUtils.isEmpty(arr)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder(arr.length * 10);
            if (!isEmpty(start)) {
                sb.append(start);
            }

            Object[] var10 = arr;
            int var9 = arr.length;

            for(int var8 = 0; var8 < var9; ++var8) {
                Object a = var10[var8];
                if (!isEmpty(left)) {
                    sb.append(left);
                }

                sb.append(a);
                if (!isEmpty(right)) {
                    sb.append(right);
                }

                sb.append(separator);
            }

            sb.setLength(sb.length() - separator.length());
            if (!isEmpty(end)) {
                sb.append(end);
            }

            return sb.toString();
        }
    }
}

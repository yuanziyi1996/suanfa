package 工作测试;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import java.util.*;

/**
 * @author ziyi.yuan
 * @date 2020/4/24 10:28 上午
 */
public class 拼音排序{
    private static Map<String,String> map = new HashMap<>();
    /**
     * 获取汉字字符串的首字母，英文字符不变
     * 例如：阿飞→af
     */
    public static String getPinYinHeadChar(String chines) {
        StringBuffer sb = new StringBuffer();
        char[] chars = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 128) {
                try {
                    sb.append(PinyinHelper.toHanyuPinyinStringArray(chars[i], defaultFormat)[0].charAt(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 获取汉字字符串的第一个字母
     */
    public static String getPinYinFirstLetter(String str) {
        StringBuffer sb = new StringBuffer();
        char c = str.charAt(0);
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
        if (pinyinArray != null) {
            sb.append(pinyinArray[0].charAt(0));
        } else {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 获取汉字字符串的汉语拼音，英文字符不变
     */
    public static String getPinYin(String chines) {
        StringBuilder builder = new StringBuilder();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    builder.append(PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                builder.append(nameChar[i]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("楚天歌");
        list1.add("江1流儿");
        list1.add("江流2儿");
        list1.add("江流a儿");
        list1.add("1Tom");
        list1.add("Tom");
        list1.add("Jerry");
        list1.add("12345");
        list1.add("54321");
        list1.add("_(:з」∠)_");
        list1.add("……%￥#￥%#");

        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.forEach(s->{
            String pinyin = 拼音排序.getPinYin(s); // 根据姓名获取拼音
            String firstLetter = pinyin.substring(0, 1).toUpperCase(); // 获取拼音首字母并转成大写
            if (!firstLetter.matches("[A-Z]")) { // 如果不在A-Z中则默认为“#”
                list3.add(s);
            }else {
                list2.add(s);
            }
        });
        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        list2.addAll(list3);
        System.out.println(list2);


//        Collections.sort(list); // 对list进行排序，需要让User实现Comparable接口重写compareTo方法
//        System.out.println(list.stream().map(User::getName).collect(Collectors.toList()));
    }

}

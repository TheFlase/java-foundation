package com.test.mianshi;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import cn.hutool.core.collection.CollUtil;

import java.util.*;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/6/2020
 **/
public class T1_StrIfSame {
    public static void main(String[] args) {
//        String tempStr = "aabcded";
//        System.out.println(T1_StrIfSame.isUnique(tempStr));
//        int a=1,b=2;boolean c;
//        System.out.println(c=a==b);
//        System.out.println(c);
//        char c;
//
//        for(c='z';c<'a';c-=4){
//
//            if(c<='o') break;
//
//        }
//        System.out.println(c);
//        int j=0,i=3;
//
//        while(--i>0){
//            j+=j-=i;
//        }
//        System.out.println(j);

//        int i=12; System.out.print(i+=i-=i*=1);
//        int i=2;
//        System.out.println(i+=i-=i*i);

//        String a = "aaa123bbbccc";
//        String b = "aa";
//        List<String> resultList = Arrays.asList("aaa","bbb");
//        System.out.println(resultList.contains(a));
//        System.out.println(resultList.contains(b));

//        List<Long> list = Arrays.asList(1L,2L,3L,5L);
//        List<Long> idList = new ArrayList<>();
//        idList.add(2L);
//        idList.add(5L);
//        System.out.println("移除前："+list.toString());
//        CollUtil.removeAny(list,2L);
//        System.out.println("移除后:"+list.toString());

        String aa = "abc";
        String[] split = aa.split(",");
        for(String item:split){
            System.out.println(item);
        }


    }
    public static boolean isUnique(String astr) {
        boolean result = true;
        String[] strArray = astr.split("");
        for(int i=0;i<strArray.length;i++){
            System.out.println("外循环计算第"+i+"次");
            System.out.println("    内循环");
            for(int j=1;j<strArray.length;j++){
                System.out.println("第"+(j-1)+"次");
                if(strArray[i].equals(strArray[j])){
                    return false;
                }
            }
        }
        return result;
    }
}

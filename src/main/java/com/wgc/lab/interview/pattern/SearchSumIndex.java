package com.wgc.lab.interview.pattern;

import java.util.*;


/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2/28/2020
 **/
public class SearchSumIndex {
    private static int NUMBER_SIZE = 20;
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(NUMBER_SIZE);
        int[] numberInt = new int[NUMBER_SIZE];
        Map<String,Integer> numberMap= new HashMap<String,Integer>();
        for(int i=0;numberMap.size()<NUMBER_SIZE;i++){
            int a = new Random().nextInt(100);
            while (numberMap.get(String.valueOf(a)) == null){
                intList.add(a);
                numberMap.put(String.valueOf(a),a);
                break;
            }
        }

        for(int i=0;i<intList.size();i++){
            numberInt[i]=intList.get(i);
        }
        System.out.println("随机生成的20位数是:"+ Arrays.toString(numberInt));



        numberMap.clear();
        Map<String,String> resultMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();

        //把数组每个数的索引存起来
        for(int i=0;i<numberInt.length;i++){
            numberMap.put(String.valueOf(numberInt[i]),i);
        }
        //生成目标值
        int add1 = new Random().nextInt(100);
        int add2 = new Random().nextInt(100);
        int target = add1+add2;
        System.out.println("目标和是："+target);

        for(int i=0;i<numberInt.length;i++){
            for(int j=0;j<numberInt.length-i-1;j++){
                sb.delete(0,sb.length());
                sb.append(i).append("_").append(j);
                if(resultMap.get(String.valueOf(i)) != null||null != resultMap.get(String.valueOf(j))){
                    continue;
                }
                if((numberInt[i]+numberInt[j])==target){
                    resultMap.put(String.valueOf(i),sb.toString());
                    resultMap.put(String.valueOf(j),sb.toString());
                }
            }
        }
        String[] resultStrArray = new String[2];
        Map<String,String> tempResult = new HashMap<>();
        for(String item:resultMap.values()){
            tempResult.put(item,item);
        }
        if(!tempResult.isEmpty()){
            System.out.println("下标索引为:");
            for(String item:tempResult.values()){
                resultStrArray = item.split("_");
                System.out.println("["+resultStrArray[0]+","+resultStrArray[1]+"]");
            }
        }else {
            System.out.println("该随机生成的数组中任意两个数之和都不等于"+target);
        }

    }
}

package com.wauoen.offer.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找出现次数大于n/2的元素
 * @author wauoen
 *
 */
public class MajorityElement {
	
	public static void main(String args[]){
		
		int[] nums = {3,6,4,8,5,5,5,5,5};
		System.out.println(majorityElement2(nums)+"");
		
		
	}
	
	public static int majorityElement2(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
	
	public static int majorityElement(int[] num){
		
		int times = num.length / 2;
		
		Map<Integer,Integer> kvs = new HashMap<>();
		for (int i : num) {
			try {
				kvs.put(i, kvs.get(i)+1);
			} catch (NullPointerException e) {
				kvs.put(i, 1);
			}
			
			if(kvs.get(i) > times){
				return i;
			}
		}
		
		return -1;
	}

}

package main.solution;

public class LeetCode_135 {
	public int candy(int[] ratings) {
		int n = ratings.length;
		int ret = 1;
		// inc 递增序列长度；dec递减序列长度；pre上一个同学分配的糖果数
		int inc = 1, dec = 0, pre = 1;
		for(int i=1;i<n;i++) {
			if(ratings[i] >= ratings[i-1]) {
				dec = 0;
				pre = ratings[i] == ratings[i-1] ? 1 : pre + 1;
				ret += pre;
				inc = pre;
			} else {
				dec++;
				if(dec == inc) {
					dec++;
				}
				ret += dec;
				pre = 1;
			}
		}
		return ret;
	}
}
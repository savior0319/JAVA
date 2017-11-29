package Ex2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.SynchronousQueue;

public class RankManager {
	String[] strArr1;
	String[] strArr2;
	float[] floatArr;
	String str;
	
	public String[] getOdds(String inputStr){
		strArr1 = inputStr.split("\r\n");
		floatArr = new float[strArr1.length-1];
		for (int i = 2; i < strArr1.length-1; i++) {
			strArr2 = strArr1[i].split("\t");
			String odds = calOdds(strArr2[1],strArr2[2],strArr2[3]);
			floatArr[i-2] = Float.parseFloat(odds);
			strArr1[i] = strArr1[i]+odds+"%\t";
		}
		strArr1[0] = strArr1[0]+"\t승률\t순위";
		strArr1[1] = strArr1[1]+"-----------------";
		Arrays.sort(floatArr);
		
		return strArr1;
	}
	
	public String getRank(String[] strArr){
		int rank = 1;
		for (int i = 2; i < strArr.length; i++) {
			for (int j = 1; j < strArr.length-1; j++) {
				if (strArr[i].contains(String.valueOf(floatArr[j]))) {
					strArr[i] = strArr[i]+rank+"등";
					rank++;
				}
			}
		}
		for (String string : strArr) {
			System.out.println(string);
		}
		return str;
	}
	public String calOdds(String win, String draw, String lose){
		float odds = Float.parseFloat(win)/(Float.parseFloat(win)+Float.parseFloat(draw)+Float.parseFloat(lose))*100;
		return String.format("%.2f", odds); // 서브 스트링 사용해도 무관
	}
}

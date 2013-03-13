package com.jdtx.sort;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class Sort {

	Hashtable<Double, String> hashtable;
	List<Double> list = new ArrayList<Double>();

	/**
	 * 排序 Map<数字组合，相乘的结果>
	 * 
	 * @return
	 */
	public void readToString(String source, int subLength) {
		hashtable = new Hashtable<Double, String>();
		// 把字符串转换成 数组
		char[] c = source.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			int j = 0;
			for (j = i; j < i + subLength && (i + subLength) <= c.length; j++) {
				sb.append(c[j]);
			}

			// temp 里面就存储的全部是 五位数字
			String value = sb.toString();
			char[] cTemp = sb.toString().toCharArray();
			// 把所有的东西 全部算出来 并且 全部放到图里面去
			double result = 1.0;
			for (int k = 0; k < cTemp.length; k++) {
				int intValue = Integer.parseInt(String.valueOf(cTemp[k]));
				result *= intValue;
			}
			//放到list 中去
			list.add(result);
			// --------------
			// 到这里就把所有的数字全部算出来了--------------------------------------------------
			hashtable.put(result, value);

			// sb 制0
			sb.setLength(0);
		}
		//把list转换成 数组
		double [] values=new double[list.size()]; 
		for(int h=0;h<list.size();h++){
			values[h]=list.get(h);
		}
		//得到最大的s
		double max=Sort.sort(values);
		System.out.println(hashtable.get(max));
	}

	public static double sort(double[] values) {

		double temp;

		for (int i = 0; i < values.length; ++i) {

			for (int j = 0; j < values.length - i - 1; ++j) {

				if (values[j] < values[j + 1]) {
					temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;

				}

			}
		}
		return values[0];
	}

	public static void main(String[] args) {
		String str = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		Sort s = new Sort();
		s.readToString(str, 5);
	}
}

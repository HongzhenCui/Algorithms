package ģ��һ;

import java.util.Scanner;

/**
 * ţţ������һ���㷨�飬�㷨��һ����nҳ��ҳ���1��n��ţţ��������һ���㷨��Ŀ��
 * ���Ȿ�㷨��ҳ����0~9ÿ�����ֱַ�����˶��ٴΣ�
 * ��������:�������һ������n(1 �� n �� 1,000,000,000)
 * 
 * �������: �������һ��10����������0~9��Щ������ҳ���г��ֵĴ������Կո�ָ�����ĩ�޿ո�
 * 
 * ��������: 999
 * 
 * �������: 189 300 300 300 300 300 300 300 300 300
 */
public class Q1_07_ҳ��ͳ��_����ͨ�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();

			// long[] k = new long[10];
			long[] k = getNum(n);
			System.out.println(k[0] + " " + k[1] + " " + k[2] + " " + k[3] + " " + k[4] + " " + k[5] + " " + k[6] + " "
					+ k[7] + " " + k[8] + " " + k[9]);
		}
	}

	public static long[] getNum(long n) {
		// long iNum = 0;
		long[] lon = new long[10];
		if (n == 0) {
			return lon;
		}
		if (n % 10 < 9) {
			lon = getNum(n - 1);
			while (n != 0) {
				lon[(int) (n % 10)]++;
				n = n / 10;
			}
			return lon;
		}
		//n%10==9�����
		lon = getNum(n / 10);
		for (int i = 0; i < 10; i++) {
			if (i > 0) {
				lon[i] = lon[i] * 10 + n / 10 + 1;// (int)(i>0)
			} else {
				lon[i] = lon[i] * 10 + n / 10 + 0;// (int)(i>0)
			}
		}

		return lon;
	}
}

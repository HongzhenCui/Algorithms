package ģ��һ;

import java.util.Scanner;

/**
 * ţţ�ĺ�����������ֽ��д��n+1���������������Ĩ������һ����������ţţ����Ĩ������������ʲô��
 * ţţ֪������д������������֮����һ����������������ţţ����Ҫ�³����п�����Ĩ���������������磺
 * 10 7 12 8 11 ��ôĨ����������ֻ������9 5 6 7 8 ��ôĨ����������������4Ҳ������9
 * 
 * ��������: �������2�У�
 * ��һ��Ϊ����n(1 <= n <= 50)����Ĩ��һ����֮��ʣ�µ����ָ���
 * �ڶ���Ϊn������num[i] (1 <= num[i] <= 1000000000)
 * 
 * �������: ��һ����������п�����Ĩ��������,��С�������,�ÿո�ָ�,��ĩ�޿ո����û�п��ܵ����������mistake
 * 
 * ��������: 2 3 6
 * 
 * �������: mistake
 */
public class Q1_03_��������_����ͨ�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str1 = sc.nextLine();//��������n
			int n = Integer.parseInt(str1);

			String string = sc.nextLine();//������������
			String[] strings = string.split(" ");
			int[] num = new int[n];

			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(strings[i]);//���������б���Ϊ����
			}

			for (int i = 0; i < n - 1; i++) {//����ð�����������е�Ԫ�ؽ�������
				for (int j = 0; j < n - 1; j++) {
					if (num[j] > num[j + 1]) {
						int temp = num[j];
						num[j] = num[j + 1];
						num[j + 1] = temp;
					}
				}
			}
			int k = -1;
			int p = 0;
			int q = 0;
			int t = 0;
			for (int i = 0; i < n - 1; i++) {
				if (num[i + 1] - num[i] == 1) {//�����Ƿ���������
					q++;
				} else if (num[i + 1] - num[i] > 2) {//ͳ������������ȱ���������ּ����ϵ����
					// System.out.println("mistake");
					t++;
					break;
				} else if (num[i + 1] - num[i] == 2) {//ͳ������������ȱ���������ֵ����
					k = (num[i + 1] + num[i]) / 2;//��ֻȱ��һ������ȱ�ٵ�����Ϊk
					p++;

				}
			}
			if (k == -1 && q == n - 1 && t == 0) {
				if (n == 1) {//ֻ������һ������ʱ
					if (num[0] == 1) {//�������Ϊ1ʱ��ֻ�����2
						System.out.println(2);
					} else {//����������˵�ֵ
						System.out.println((num[0] - 1) + " " + (num[0] + 1));
					}

				} else {//�����������Ԫ�ظ�������1��
					if (num[0] == 1) {//�ҵ�һ��Ԫ�ص�ֵΪ1ʱ��ֻ��������һ��Ԫ�ؼ�1��ֵ
						System.out.println(num[n - 1] + 1);
					} else {//����������˵�ֵ
						System.out.println((num[0] - 1) + " " + (num[n - 1] + 1));
					}

				}

			} else if (k != -1 && p == 1 && t == 0) {//�����м�ֻȱ��һ������k
				System.out.println(k);
			} else if (t != 0 || p != 1) {//������
				System.out.println("mistake");
			}

		}
	}

}

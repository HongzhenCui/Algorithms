package ģ��һ;

import java.util.Scanner;

/**
 * ţţ��һ����ס���������Ѿ���n���㣬ÿ����Ĵ�СΪfishSize[i] (1 �� i �� n,��Ϊ������)��
 * ţţ��������²�׽���������ס�����ڴ����Ŵ����С��Ķ��ɡ������۲죬ţţ����һ����A�Ĵ�СΪ����һ����B��С��2����10��(����2����С��10����С)����A��Ե���B�����ǵ������ţţҪ����������Ҫ��֤��
 * 1���Ž�ȥ�����ǰ�ȫ�ģ����ᱻ������Ե� 2��������Ž�ȥҲ���ܳԵ�������
 * ��������Ѿ����ڵ����Ѿ��ദ�˺ܾã����������ǻ��ಶʳ������֪���·�����Ĵ�С��Χ[minSize,maxSize](������Ĵ�С����������ʾ),ţţ��֪���ж����ִ�С������Է��������ס�
 * 
 * ��������: �������ݰ���3��. 
 * ��һ��Ϊ�·�����ĳߴ緶ΧminSize,maxSize(1 �� minSize,maxSize �� 1000)�� �Կո�ָ��� 
 * �ڶ���Ϊ��������Ѿ����������n(1 �� n �� 50) 
 * ������Ϊ�Ѿ��е���Ĵ�СfishSize[i](1 �� fishSize[i] �� 1000)���Կո�ָ���
 * 
 * �������: ����ж����ִ�С������Է��������ס�������Ĵ�С����������ʾ
 * 
 * ��������: 1 12 1 1
 * 
 * �������: 3
 */
public class Q1_01_�ö���_����ͨ�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String string = sc.nextLine();
			String strn = sc.nextLine();
			String string2 = sc.nextLine();

			String[] str = string.split(" ");

			int minSize = Integer.parseInt(str[0]);// �·��������Сֵ
			int maxSize = Integer.parseInt(str[1]);// �·���������ֵ
			int n = Integer.parseInt(strn);// �Ѿ����������
			int[] fishSize = new int[n];// ������Ĵ�С
			String[] str2 = string2.split(" ");
			for (int i = 0; i < n; i++) {
				fishSize[i] = Integer.parseInt(str2[i]);
			}

			// System.out.println(minSize + "," + maxSize + "," + n + ",");
			System.out.println(getNum(minSize, maxSize, n, fishSize));

		}
	}

	public static int getNum(int min, int max, int n, int[] fishSize) {// fishSize��ʾ����Ĵ�С
		int count = 0;
		for (int i = min; i <= max; i++) {// i��ʾ����ķ�Χ
			int flag = 1;
			for (int j = 0; j < n; j++) {// j��ʾ��j����
				//�ؼ���һ�仰��������if�е��жϡ��ҳ����ʵĽ�����Χ��
				//�·�����㲻�ܱ��Ե���Ҳ���ܳԵ�ԭ�е���
				if (i >= 2 * fishSize[j] && i <= 10 * fishSize[j] || fishSize[j] >= 2 * i && fishSize[j] <= 10 * i) {
					flag = 0;
				}
			}
			if (flag == 1)
				count++;
		}

		return count;
	}

}

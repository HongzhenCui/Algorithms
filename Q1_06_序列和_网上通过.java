package ģ��һ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * ����һ��������N�ͳ���L���ҳ�һ�γ��ȴ��ڵ���L�������Ǹ����������ǵĺ�ǡ��ΪN��
 * �𰸿����ж������������Ҫ�ҳ�������С���Ǹ��� ���� N = 18 L = 2�� 
 * 5 + 6 + 7 = 18 3 + 4 + 5 + 6 = 18 ��������Ҫ��ģ���������������̵� 5 6 7
 * 
 * ��������: �������ݰ���һ�У� ����������N(1 �� N �� 1000000000),L(2 �� L �� 100)
 * 
 * �������: ��С���������������Ǹ��������Կո�ָ�����ĩ�޿ո����û�����������л����ҳ������г��ȴ���100�������No
 * 
 * ��������: 18 2
 * 
 * �������: 5 6 7
 */
public class Q1_06_���к�_����ͨ�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int len = sc.nextInt();
			List<Integer> list = getSequence(n, len);
			if (list.size() == 0) {
				System.out.println("No");
			} else {
				for (int i = 0; i < list.size(); i++) {//��ӡ��Ԫ��
					if (i == 0) {
						System.out.print(list.get(0));
					} else {
						System.out.print(" " + list.get(i));
					}
				}
			}
		}
	}

	public static List<Integer> getSequence(int n, int len) {
		List<Integer> list = new ArrayList<>();//������ŷ�������������
		for (int i = len; i <= 100; i++) {//�ȴ���̵�����ж�
			//���ȱ�֤nҪ���ڵ���i * (i - 1) / 2
			//����ж�n��i * (i - 1) / 2�Ĳ��ǲ������öԵ�ǰԪ�صĸ�������
			if ((n - i * (i - 1) / 2) >= 0 && (n - i * (i - 1) / 2) % i == 0) {
				int a = (n - i * (i - 1) / 2) / i;
				for (int j = 0; j < i; j++) {
					list.add(a + j);
				}
				return list;
			}
		}
		return list;
	}
}

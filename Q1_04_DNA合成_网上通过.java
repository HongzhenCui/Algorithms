package ģ��һ;

import java.util.Scanner;

/**
 * DNA��������4������������Ϊ��λ���Ӷ��ɵĳ�������4������������ֱ���A,T,C,G���ּ����
 * ����������ԭ��A��T����Եģ�C��G����Եġ���������������������ͬ�Ĳ���ÿ��λ�õļ������Եģ�
 * ��ô���ǾͿ�����Ժϳ�ΪDNA��˫�����ṹ�����ڸ������������������������һ�������滻������
 * �������ϵ�ĳ��λ�õļ������Ϊ����һ�ּ������������Ҫ���ٴ��������������Գɹ�
 * 
 * ��������: �������һ�У� ���������ַ���,�ֱ��ʾ������,�����ַ���������ͬ�ҳ��Ⱦ�С�ڵ���50��
 * 
 * �������: ���һ����������������Ҫ���ٴ��������������Գɹ�
 * 
 * ��������: ACGT TGCA
 * 
 * �������: 0
 */
public class Q1_04_DNA�ϳ�_����ͨ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String string = sc.nextLine();
			String[] strings = string.split(" ");
			String a = strings[0];
			String b = strings[1];

			if (a.length() != b.length()) {
				return;
			}
			int j = 0;
			for (int i = 0; i < a.length(); i++) {
				//ע����ԵĹ����ǣ�A--T��T--A,G--C,C--G��˫��Ĺ���
				if (a.charAt(i) == 'A' && b.charAt(i) == 'T' || a.charAt(i) == 'T' && b.charAt(i) == 'A'
						|| a.charAt(i) == 'G' && b.charAt(i) == 'C' || a.charAt(i) == 'C' && b.charAt(i) == 'G') {
					j++;
				}
			}

			System.out.println(a.length() - j);
		}
	}
}

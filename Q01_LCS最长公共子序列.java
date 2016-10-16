package �ַ���;

import java.util.Scanner;
import java.util.Stack;
/**
 * �������������ַ���������������ַ����Ĺ���������
 * */
public class Q01_LCS����������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		String y = sc.next();
		getLCS(x,y);
	}
	
	public static void getLCS(String x, String y){
		
		char[] s1 = x.toCharArray();
		char[] s2 = y.toCharArray();
		int[][] array = new int[x.length()+1][y.length()+1];//�˴������̳���Ҫ���ַ������ȶ��1����Ҫ��洢һ��0��һ��0
				
		for(int j = 0; j < array[0].length; j++){//��0�е�j��ȫ����ֵΪ0
			array[0][j] = 0;
		}
		for(int i = 0; i < array.length; i++){//��i�У���0��ȫ��Ϊ0
			array[i][0] = 0;
		}
		
		for(int m = 1; m < array.length; m++){//���ö�̬�滮�����鸳��ֵ
			for(int n = 1; n < array[m].length; n++){
				if(s1[m - 1] == s2[n - 1]){
					array[m][n] = array[m-1][n-1] + 1;//��̬�滮��ʽһ
				}else{
					array[m][n] = max(array[m -1][n], array[m][n -1]);//��̬�滮��ʽ��
				}
			}
		}
//		for(int m = 0; m < array.length; m++){//�����̸���ֵ,�������Դ����½ǿ�ʼ�����ҳ���󹫹�������
//			for(int n = 0; n < array[m].length; n++){
//				System.out.print(array[m][n]);
//			}
//			System.out.println();
//		}
		Stack stack = new Stack();
		int i = x.length() - 1;
		int j = y.length() - 1;
		
		while((i >= 0) && (j >= 0)){
			if(s1[i] == s2[j]){//�ַ����Ӻ�ʼ������������ȣ������ջ��
				stack.push(s1[i]);
				i--;
				j--;
			}else{
				if(array[i+1][j] > array[i][j+1]){//����ַ������ַ���ͬ����������������ͬ���ַ���ע�⣺���������Ҫ���ַ������ַ��ĸ�����1�����i��jҪ����1
					j--;
				}else{
					i--;
				}
			}
		}
		
		while(!stack.isEmpty()){//��ӡ���ջ����������������Ĺ���������
			System.out.print(stack.pop());
		}
	}
	
	public static int max(int a, int b){//�Ƚ�(a,b)��������ֵ
		return (a > b)? a : b;
	}
}

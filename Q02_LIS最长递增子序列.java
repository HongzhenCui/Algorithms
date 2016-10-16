package �ַ���;

import java.util.Arrays;
import java.util.Stack;
/**
 * ���⣺LIS����������С�����һ�����飬�ҳ�����ĵ����������С�
 * ���˼·��ԭ����arr��������˳�򱣳ֲ��䣬����������array�����ǵ����ġ������õ����������е�������һ���ǵ��������С�
 * 		      Ҫ�������arr������������У���ʵ����������arr��������������array������������С�
 * */
public class Q02_LIS����������� {

	public static void main(String[] args) {
		int[] arr = {5,6,7,1,2,3,8};
		int len = arr.length;
		int[] array = new int[len];
		//��arr���Ƹ�array
		for(int j = 0; j < arr.length; j++){
			array[j] = arr[j];
		}
		
		//�˴�����ʹ��Java���Դ������򷽷�Arrays.sort(arr);Ϊ����ϰ��д��һ����������
		quickSort(array,0,array.length-1);
		
		System.out.print("����ǰ�����飺");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		System.out.print("���������飺");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ",");
		}
		System.out.println();
				
		getLCS(arr, array);
	}
	//hinge---��Ŧ
	public static int findHinge(int[] array, int left, int right){
		int key;
		key = array[left];//��¼left,��ʱarray[left]Ϊ��
		
		while(left < right){
			while(left < right && array[right] > key){
				right --;
			}
			array[left] = array[right];//��ʱarray[right]Ϊ��
			
			while(left < right && array[left] < key){
				left ++;
			}
			array[right] = array[left];//��ʱarray[left]Ϊ��
		}
		
		array[left] = key;
		return left;
	}
	//����һ�����������㷨
	public static void quickSort(int[] array, int left, int right){
		int mid;
		if(left < right){
			mid = findHinge(array, left, right);
			quickSort(array, left, mid -1);
			quickSort(array, mid +1, right);
		}
	}
	
	public static void getLCS(int[] array, int[] data){//���������ȡ�����������
		int len1 = array.length;
		int len2 = data.length;
		
		int[][] newArr = new int[len1+1][len2+1];
		//���õ�0�к͵�0��Ϊ0
		for(int i = 0; i < newArr.length; i++){
			newArr[i][0] = 0;
		}
		for(int j = 0; j < newArr[0].length; j++){
			newArr[0][j] = 0;
		}
		
		//��ά������д����¼��ͬ���ַ�����
		for(int i = 1; i < newArr.length; i++){
			for(int j = 1; j < newArr[i].length; j++){
				if(array[i - 1] == data[j - 1]){
					//���湫ʽһ��LCS(Xm, Yn) = LCS(Xm-1, Yn-1) +Xm
					newArr[i][j] = newArr[i-1][j-1] + 1;
				}else{
					//���湫ʽ����LCS(Xm, Yn) = MAX{LCS(Xm-1, Yn), LCS(Xm, Yn-1)}
					newArr[i][j] = max(newArr[i-1][j],newArr[i][j-1]);
				}
			}
		}
		
//		//�������ݣ������̸���ֵ,�������Դ����½ǿ�ʼ�����ҳ���󹫹�������
//		for(int m = 0; m < newArr.length; m++){
//			for(int n = 0; n < newArr[m].length; n++){
//				System.out.print(newArr[m][n]);
//			}
//			System.out.println();
//		}
		
		Stack<Integer> stack = new Stack();
		int m = array.length - 1;
		int n = data.length - 1;
		while(n >= 0 && m >= 0){//����Ӻ���ǰ����
			if(array[m] == data[n]){//�ַ���ͬ����ջ
				stack.push(array[m]);
				m--;
				n--;
			}else{
				if(newArr[m+1][n] > newArr[m][n+1]){//�ַ���ͬʱ�����ݴ�ӡ���Ķ�ά���󣨲������ݣ�������һ����ͬ���ַ�
					n--;
				}else{
					m--;
				}
			}
		}
		
		while(!stack.isEmpty()){//��ӡ����ĵ���������
			System.out.print(stack.pop() + ",");
		}
	}
	
	public static int max(int a, int b){
		return (a > b) ? a : b;
	}
	

}

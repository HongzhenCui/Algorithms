package ����;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zengqiangFor {
	/**
	 * ��ǿforѭ����Ӧ��ʵ����
	 * ����ʹ�÷�Χ��Ҫ�ǣ�һά���顢��ά�����List
	 */
	public static void main(String[] args) {
		//1��һά���飨��ͨ���飩�е�ʹ��
		int array[] = {1,2,3,4,5,6,7};
		
		//��ǿforѭ��
		for(int arritem : array){
			System.out.println(arritem);
		}
		//��ͨ��forѭ��
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
		
		//2����ά�����е�ʹ��
		int array2[][] = {{1,2,3},{4,5,6},{7,8,9}};
		//��ǿ��forѭ��
		for(int arrayitem[] : array2){
			for(int item : arrayitem){
				System.out.println(item);
			}
		}
		//�ձ�Ķ�ά�����forѭ��
		for(int i = 0; i < array2.length; i++){
			for(int j = 0; j < array2[i].length; j++){
				System.out.println(array2[i][j]);
			}
		}
		
		//��List�е�ʹ��
		List<String> list = new ArrayList<String>();
		list.add("xxx");
		list.add("yyy");
		list.add("zzz");
		//��ǿfor��ʹ��
		for(String item : list){
			System.out.println(item);
		}
		//һ������µ�forѭ��
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		//����������
		for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
			System.out.println(iterator.next());
		}
	}
}

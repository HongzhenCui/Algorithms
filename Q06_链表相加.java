package ����_�ݹ�_ջ;

import java.util.Random;
/**
 * ������������Ǹ�����������ÿ���ڵ�ֻ�洢һ�����֣�ʵ�������������ӣ���������ͷ��㡣
 * ���磺2����4����3��5����6����4���õ�������ʱ7����0����8
 * */
public class Q06_������� {
	
	public static void main(String[] args){
		ListNode ls1 = getList(3);//
		ListNode ls2 = getList(5);
		
		System.out.print("����һ��");
		ListNode l1 = ls1.nextNode;
		while(l1 != null){//��ӡ����һ
			System.out.print(l1.value + ",");
			l1 = l1.nextNode;
		}
		System.out.println();
		
		System.out.print("�������");
		ListNode l2 = ls2.nextNode;
		while(l2 != null){//��ӡ�����
			System.out.print(l2.value + ",");
			l2 = l2.nextNode;
		}
		System.out.println();
		
		System.out.print("������Ӻ�Ľ����");
		ListNode ls3 = addList(ls1, ls2);
		while(ls3.nextNode != null){//��ӡ��Ӻ������
			System.out.print(ls3.nextNode.value + " ,");
			ls3 = ls3.nextNode;
		}
	}
	//����������ӡ����������������ͷ��㣬��ӵĹ��̰����ĸ����棺
	//1���Ϸ��Ե��жϣ�2����������ͬʱ���ڵĽ����ӣ�3������ϳ�������4�����Ҫ��ֹ��λλ��������һ�����
	public static ListNode addList(ListNode h1, ListNode h2){
		if(h1 == null && h2 == null){//1���Ϸ��Ե��жϣ�
			return null;
		}
		ListNode head = new ListNode();//��Ӻ������ͷ���
		ListNode pTail = head;
		ListNode p1 = h1.nextNode;
		ListNode p2 = h2.nextNode;
		ListNode curp;
		int carry = 0;//��λλ
		int value;//���ֵ
		while(p1 != null && p2 != null){//2����������ͬʱ���ڵĽ�����
			value = p1.value + p2.value + carry;//����������ĺ��ټ��Ͻ�λλ
			carry = value / 10;
			value = value % 10;//��Ӻ�����ģ��£�����ֵ
			
			curp = new ListNode(value);//��valueΪֵ��һ����㣬����ӵ�head������
			pTail.nextNode = curp;
			pTail = curp;
									
			p1 = p1.nextNode;
			p2 = p2.nextNode;
		}
		
		ListNode p = (p1 != null) ? p1 : p2;//�ж��ĸ�����Ƚϳ�
		//3������ϳ�������,���ϳ�������ʣ��Ĳ�����ӵ�������head��
		while(p != null){
			value = p.value + carry;
			carry = value / 10;
			value = value % 10;
			
			curp = new ListNode(value);
			pTail.nextNode = curp;
			pTail = curp;
			
			p = p.nextNode;
		}
		
		//4�����һλ���ܴ��ڽ�λλ����Ҫ����
		if(carry != 0){
			curp = new ListNode(carry);
			pTail.nextNode = curp;
		}
		
		return head;		
	}
	
	//�����������ĺ���������length����������ĳ��ȣ��������ĸ���
	public static ListNode getList(int length){//length������ĳ���
		if(length < 0){
			return null;
		}
		ListNode head = new ListNode();//�����ͷ���
		ListNode p1 = head;
		if(length == 0){
			return head;
		}
		Random r = new Random();
		for(int i = 0; i < length; i++){
			ListNode p = new ListNode(r.nextInt(10));//�������10���ڵ���ֵ��Ϊ����valueֵ
			p1.nextNode = p;//���á�β�巨��
			p1 = p1.nextNode;
			//System.out.print(p.value + " ");
		}
		//System.out.println();
		return head;
	}
}

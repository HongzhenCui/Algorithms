package ����_�ݹ�_ջ;
import java.util.Random;
/*
 * ����һ��������ת�������m��n��λ�á�Ҫ��ֱ�ӷ�ת���������¿ռ�
 * �Ե��ĸ��͵ڰ˸����Ϊ��Χ����תǰ������13,96,31,66,71,16,43,78,71,1,��ת�������13,96,31,78,43,16,71,66,71,1,
 * */
public class Q07_����Ĳ��ַ�ת {

	public static void main(String[] args) throws Exception {
		ListNode h1 = getList(10);
		
		System.out.print("��תǰ������");
		ListNode l1 = h1.nextNode;
		while(l1 != null){
			System.out.print(l1.value + ",");
			l1 = l1.nextNode;
		}
		System.out.println();
		
		System.out.print("��ת�������");	
		ListNode headList = reverse(h1, 4, 8);
		ListNode l2 = headList.nextNode;
		while(l2 != null){
			System.out.print(l2.value + ",");
			l2 = l2.nextNode;
		}
	}
	
	//��ת����
	public static ListNode reverse(ListNode head, int m, int n) throws Exception{
		if(m > n){
			throw new  Exception("����ķ�ת�ķ�Χ����!");
		}
		ListNode Head = head;
		ListNode cur = head.nextNode;
		int i;
		for(i = 0; i < m - 1; i++){//��ѭ���ҵ�m-1��
			//System.out.println(cur.value + ".");
			head = cur;
			cur =  cur.nextNode;
		}
		
		ListNode pre = cur;//preָ���m-1������λ��
		cur = cur.nextNode ;//��m�����
		ListNode pnext;
		for(; i < n - 1; i++){//�������ͼ������
			pnext = cur.nextNode;
			cur.nextNode = head.nextNode;
			head.nextNode = cur;
			pre.nextNode = pnext;
			cur = pnext;
		}
		return Head;
	}
	
	//�������һ���������в���length��������ĸ���
	public static ListNode getList(int length){
		Random r = new Random();
		if(length < 0){
			return null;
		}
		ListNode head = new ListNode();
		ListNode point = head;
		if(length == 0){
			return head;
		}
		
		for(int i = 0; i < length; i++){
			ListNode p = new ListNode(r.nextInt(100));
			point.nextNode = p;
			point = point.nextNode;
			//System.out.println(point.value + ",");
		}
		return head;
	}
}

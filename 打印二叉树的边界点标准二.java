package ������;

public class ��ӡ�������ı߽���׼�� {
	
	/**
	 * ��Ŀ������һ�ö�������ͷ���head���������±�׼��ʱ���ӡ�߽�ڵ�
	 * 1��ͷ���Ϊ�߽�ڵ�
	 * 2��Ҷ�ڵ�Ϊ�߽���
	 * 3������߽�������ȥ��·��Ϊ�߽�ڵ�
	 * 4�����ұ߽�������ȥ��·��Ϊ�߽�ڵ�
	 * */
	/**
	 * ˼·��
	 * 1��ͷ��㣬��ӡ
	 * 2��Ҷ�ڵ㣬��ӡ
	 * 3���м���Ҫ�ж�
	 *   3.1��headΪ�м䣬������Ϊ��������
	 *   3.2������м���Ҫ��������ǲ��Ǳ߽�ڵ㣬�ǵĻ��������жϸýڵ�����ֵ��ǲ��Ǵ��ڣ��ǵĻ�����ӡ�����ǵĻ���ӡ��
	 *                                    ���ǵĻ�������ӡ�����ų�Ҷ�ӽڵ���жϣ�
	 *      ����˳��ǰ�������
	 *   3.3�Ҳ����м���Ҫ��������ǲ��Ǳ߽�ڵ㣬�ǵĻ��������жϸýڵ�����ֵ��ǲ��Ǵ��ڣ��ǵĻ�����ӡ�����ǵĻ���ӡ��
	 *                                    ���ǵĻ�������ӡ�����ų�Ҷ�ӽڵ���жϣ�
	 *      ����˳�򣺺��������
	 *   ˵��������˳�ı�����ʽ��һ�µ�Ŀ���Ǳ�֤˳ʱ���ӡ��
	 * */
	
	public static void main(String[] args) {
		Node node1 = new Node(1);  
		Node node2 = new Node(2);  
		Node node3 = new Node(3);  
		Node node4 = new Node(4);  
		Node node5 = new Node(5);  
		Node node6 = new Node(6);  
		Node node7 = new Node(7);  
		Node node8 = new Node(8);  
		Node node9 = new Node(9);  
		Node node10 = new Node(10);  
		Node node11 = new Node(11);  
		Node node12 = new Node(12);  
		Node node13 = new Node(13);  
		Node node14 = new Node(14);  
		Node node15 = new Node(15);  
		Node node16 = new Node(16);  
		node1.left = node2;  
		node1.right = node3;  
		node2.right = node4;  
		node3.left = node5;  
		node3.right = node6;  
		node4.left = node7;  
		node4.right = node8;  
		node5.left = node9;  
		node5.right = node10;  
		node8.right = node11;  
		node9.left = node12;  
		node11.left = node13;  
		node11.right = node14;  
		node12.left = node15;  
		node12.right = node16;  
		printEdge(node1); 
	}
	
	public static void printEdge(Node head){
		if(head == null){
			return ;
		}
		
		System.out.print(head.value + " ");
		if(head.left != null && head.right != null){
			printLeftEdge(head.left, true);
			printRightEdge(head.right, true);
		}else{
			printEdge(head.left == null ? head.left : head.right);
		}
	}
	public static void printLeftEdge(Node h, boolean print){
		if(h == null){
			return ;
		}
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
		printLeftEdge(h.left, print);
		printLeftEdge(h.right, print && h.left == null ? true : false);
	}
		
	public static void printRightEdge(Node h, boolean print){
		if(h == null){
			return ;
		}
		printRightEdge(h.left, print && h.right == null ? true : false);
		printRightEdge(h.right, print);
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
	}
}

//class Node{
//	int value;
//	Node left;
//	Node right;
//	
//	public Node(int data){
//		this.value = data;
//	}
//}

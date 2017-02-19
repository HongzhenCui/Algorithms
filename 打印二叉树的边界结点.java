package ������;

public class ��ӡ�������ı߽��� {
	
	/**
	 * ��Ŀ��
	 * ����һ�Ŷ�������ͷ���head,�������±�ʵ�ֶ������߽ڵ����ʱ���ӡ
    	1��ͷ�ڵ�Ϊ�߽�ڵ�
    	2��Ҷ���Ϊ�߽�ڵ�
    	3������ڵ��������ڵĲ���������߻����ұߣ���ôҲ�Ǳ߽�ڵ㡣
	 * */
	/**
	 * ˼·����ӡ�߽��
	 * 1���ȶ�����Ķ������ĺϷ��Խ����ж�
	 * 2��ȡ�������ĸ߶ȣ��������--���õݹ��ȡ
	 * 3��ȡÿһ�����������ҽ�㣬������㱣�浽Node[level][2]�����С�����ӡ������
	 * 4��ȡ����������ҽ�㣬������Ҷ�ӽ�㣬���жϵ������ǣ�head.left == null && head.right == null && head != edgeMap[level][0] && head != edgeMap[level][1]������ӡ
	 * 5��ӡ���ҽ�㣬�˴�ע�⣺��֤��������ҵĽ�㲻һ���Ŵ�ӡ��������ܻ��ظ���ӡ
	 * */
	
	public static void main(String[] args){
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
		//1�Ϸ���
		if(head == null){
			return;
		}
		//2�ݹ�����������Ĳ����
		int height = getLevel(head, 0);
		//3��ȡÿһ������Һ������㣬����ӡ���󣬼�¼����
		Node[][] edgeMap = new Node[height][2];
		setEdgeMap(head, 0, edgeMap);
		//��ӡ������
		for(int i = 0; i < edgeMap.length; i++){
			System.out.print(edgeMap[i][0].value + " ");
		}
		
		//4��ӡ����������ҵ�Ҷ�ӽ��
		printLeftNodeInMap(head, 0, edgeMap);
		
		//5��ӡ���ұ߽��
		for(int i = edgeMap.length - 1; i!= -1; i--){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.print(edgeMap[i][1].value + " ");
			}
		}
		
	}
	public static void printLeftNodeInMap(Node head, int level, Node[][] edgeMap){
		if(head == null){
			return ;
		}
		//����������ҵ�Ҷ�ӽ��������������ý��û�к��ӽ�㣬left��right��Ϊnull�����Ҹý�㲻������edgeMap�У�
		if(head.left == null && head.right == null && head != edgeMap[level][0] && head != edgeMap[level][1]){
			System.out.print(head.value + " ");
		}
		printLeftNodeInMap(head.left, level + 1, edgeMap);
		printLeftNodeInMap(head.right, level + 1, edgeMap);
	}
	
	public static void setEdgeMap(Node h,int level, Node[][] edgeMap){
		if(h == null){
			return ;
		}
		//�¾仰���ȸ�ֵ�����ж��Ƿ�Ϊnull������ٸ�ֵ
		edgeMap[level][0] = edgeMap[level][0] == null ? h : edgeMap[level][0];
		edgeMap[level][1] = h;
		setEdgeMap(h.left, level + 1, edgeMap);
		setEdgeMap(h.right, level + 1, edgeMap);
		
	}
	
	public static int getLevel(Node head, int level){
		if(head == null){
			return level;
		}
		
		return Math.max(getLevel(head.left, level + 1), getLevel(head.right, level + 1));
	}
	
}

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int data){
		this.value = data;
	}
}

package ��;

//����ƽ�������Avl�Ľṹ
public class AvlNode<T extends Comparable<T>> {
	public AvlNode(T value){
		this(value, null, null);
	}
	
	public AvlNode(T value, AvlNode lt, AvlNode rt){
		data = value;
		left = lt;
		right = rt;
		height = 0;
	}
	
	T data;				//��ֵ
	AvlNode<T> left;	//���ӽ��
	AvlNode<T> right;	//�Һ��ӽ��
	int height;			//���ĸ߶�
}

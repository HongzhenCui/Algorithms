package ��;

/**
 * ƽ���������һϵ�в�����
 * 1���������ĸ߶�height(AvlNode<T> t)
 * 2��������תʵ�֣�LL��LR��RL��RR��
 * 3��AVL���в���ڵ�Ĳ��������ز����Ľ��
 * 4��AVL����ɾ��������
 * 5��AVL����ɾ��keyֵ�Ľ��
 * 6���ǵݹ�ʵ�ֲ���tree�е�keyֵ
 * 7��Ѱ�����ڵ�&�������ֵ
 * 8��Ѱ����С�ڵ�&������Сֵ
 * 9��ǰ�����Avl��---����--��--�ҡ����ݹ飩
 * 10���������Avl��---����--��--�ҡ����ݹ飩
 * 11���������Avl��---����--��--�������ݹ飩
 * */
public class AVL<T extends Comparable<T>> {
	//�������ĸ߶�
	public int height(AvlNode<T> t){
		return t == null ? -1 : t.height;
	}
	
	//LL����ѡת
	public AvlNode<T> leftLeftRotate(AvlNode<T> k2){
		AvlNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height);	
		
		return k1;
	}
	
	//RR:����ת
	public AvlNode<T> rightRightRotate(AvlNode<T> k1){
		AvlNode<T> k2;
		k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		
		k1.height = Math.max(height(k1.left), height(k2.left)) + 1;
		k2.height = Math.max(k1.height, height(k2.right)) + 1;
		
		return k1;
	}
	
	//LR:˫��ת-----��RR��LL
	public AvlNode<T> leftRightRotate(AvlNode<T> k3){
		k3.left = rightRightRotate(k3.left);
				
		return leftLeftRotate(k3);
	}
	
	//RL:˫��ת-----��LL��RR
	public AvlNode<T> rightLeftRotate(AvlNode<T> k1){
		k1.left = leftLeftRotate(k1.left);
		
		return rightRightRotate(k1);
	}
	
	//AVL���в���ڵ�Ĳ��������ز����Ľ��
	public AvlNode<T> insert(T key, AvlNode<T> tree){
		//����һ���µĽ��
		if(tree == null){
			return new AvlNode<T>(key,null,null);
		}
		
		int cmp = key.compareTo(tree.data);
		
		//��tree�������ϲ���
		if(cmp < 0){
			tree.left = insert(key, tree.left);
			if(height(tree.left) - height(tree.right) == 2){
				if(key.compareTo(tree.left.data) < 0){
					//LL�ͣ�����ת
					tree = leftLeftRotate(tree);
				}else{
					//LR�ͣ�˫��ת
					tree = leftRightRotate(tree);
				}
			}
		}else if(cmp > 0){
			tree.right = insert(key, tree.right);
			if(height(tree.right) - height(tree.left) == 2){
				if(key.compareTo(tree.right.data) > 0){
					//RR�ͣ�����ת
					tree = rightRightRotate(tree);
				}else{
					//RL�ͣ�˫��ת
					tree = rightLeftRotate(tree);
				}
			}
		}else{
			//��ȵ����
			return null;
		}
		
		// ����� ���ĸ߶�
		tree.height = Math.max(height(tree.left), height(tree.right)) + 1; 
		
		return tree;
	}
	
	//AVL����ɾ������������Ҫɾ���Ľ����del,tee�����ĸ����
	public AvlNode<T> remove(AvlNode<T> tree, AvlNode<T> del){
		if(tree == null || del == null){//�Ϸ��Ե��ж�
			return null;
		}
		
		int cmp = del.data.compareTo(tree.data);//�ж�Ҫɾ������ֵ�͸��ڵ�ֵ�Ĵ�С
		if(cmp < 0){//del�ڸ�������������
			tree.left = remove(tree.left , del);
			//ɾ�����del��Ҫ�ж�tree�ĸ߶��Ƿ�ƽ�⣬��ƽ��Ҫ����
			if(height(tree.right) - height(tree.left) == 2){//tree��leftɾ�����󣬸߶��п���С��right�ĸ߶ȣ�������tree.right-tree.left==2���ж�
				AvlNode<T> temR = tree.right;
				if(height(temR.left) > height(temR.right)){//���tree��˵��RL
					tree = rightLeftRotate(tree);
				}else{
					tree = rightRightRotate(tree);
				}
				
			}
		}else if(cmp > 0){//Ҫɾ���Ľ������������������
			tree.right = remove(tree.right, del);
			//ɾ�����del��Ҫ�ж�tree�ĸ߶��Ƿ�ƽ�⣬��ƽ��Ҫ����
			if(height(tree.left) - height(tree.right) == 2){//tree��rightɾ�����󣬸߶��п�����left����right�����������
				AvlNode<T> temL = tree.left;//Ҫ��������������
				if(height(temL.right) > height(temL.left)){//LR
					tree = leftRightRotate(tree);
				}else{
					tree = leftLeftRotate(tree);
				}
			}
		}else{//tree�Ƕ�ӦҪɾ���Ľ��
			//1.tree������������Ϊ�ǿ�
			if(tree.left != null && tree.right != null){
				if(height(tree.left) > height(tree.right)){
					AvlNode<T> max = maxNode(tree.left);//�ҳ������������ֵ
					tree.data = max.data;
					tree.left = remove(tree.left, max);
				}else{
					AvlNode<T> min = minNode(tree.right);//�ҳ�����������Сֵ�滻tree
					tree.data = min.data;
					tree.right = remove(tree.right, min);
				}
			}else{
				AvlNode<T> temp = tree;
				tree = (tree.left != null) ? tree.left : tree.right;
				temp = null;
			}
		}
		return tree;
	}
	
	//ɾ��tree��ֵΪkey�Ľ��
	public void remove(AvlNode<T> tree, T key){
		AvlNode<T> temp;
		
		if((temp = search(tree, key)) != null){
			tree = remove(tree, temp);
		}
	}
	
	/*
	 * �ǵݹ�ʵ�ֲ���tree�е�keyֵ
	 * */
	public AvlNode<T> search(AvlNode<T> tree, T key){
		if(tree == null){
			return null;
		}
		
		while(tree != null){
			int cmp = key.compareTo(tree.data);
			
			if(cmp < 0){//��tree����������
				tree = tree.left;
			}else if(cmp > 0){//��tree����������
				tree = tree.right;
			}else{
				return tree;
			}
		}
		return null;
	}
	
	
	//Ѱ�����ڵ�
	public AvlNode<T> maxNode(AvlNode<T> tree){
		if(tree == null){
			return null;
		}
		while(tree.right != null){
			tree = tree.right;
		}
		return tree;
	}
	//���ڵ��valueֵ
	public T maxValue(AvlNode<T> tree){
		AvlNode<T> p = maxNode(tree);
		if(p != null){
			return p.data;
		}
		return null;
	}
	
	//Ѱ����С���
	public AvlNode<T> minNode(AvlNode tree){
		if(tree == null){
			return null;
		}
		while(tree.left != null){
			tree = tree.left;
		}
		return tree;
	}
	//��С����valueֵ
	public T minValue(AvlNode<T> tree){
		AvlNode<T> p = minNode(tree);
		if(p != null){
			return p.data;
		}
		return null;
	}
	
	//ǰ�����Avl��---����--��--�ҡ�
	public void preOrder(AvlNode<T> tree){
		if(tree != null){
			System.out.print(tree.data + ",");
			preOrder(tree.left);
			preOrder(tree.right);
		}		
	}
	
	//�������Avl��---����--��--�ҡ�
	public void inOrder(AvlNode<T> tree){
		if(tree != null){
			inOrder(tree.left);
			System.out.print(tree.data + ",");
			inOrder(tree.right);
		}
	}
	
	//�������Avl��---����--��--����
	public void postOrder(AvlNode<T> tree){
		if(tree != null){
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.data + ",");
		}
	}	
}



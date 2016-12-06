package ��������;
import java.util.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Set;

public class TopSort {
	public static void main(String[] args) {
		//�������
		Node A = new Node("A");  
	    Node B = new Node("B");  
	    Node C = new Node("C");  
	    Node D = new Node("D");  
	    Node E = new Node("E");  
	    Node F = new Node("F");  
	    
	    //������������ͼ�����������ӵ���������ͼ��
	    topGraph graph = new topGraph(); 
	    graph.addNode(A, B);  
	    graph.addNode(B, C);  
	    graph.addNode(B, D);  
	    graph.addNode(D, C);  
	    graph.addNode(E, C);  
	    graph.addNode(C, F);  
	    
	    //������������ͼgraph������topsort��������ȡ����������������
	    SubTopSort t = new SubTopSort(graph); 
	    t.topsort();
	    for(Node temp : t.getResult()){  
	        System.out.print(temp.value.toString() + ";"); 
	    }
	}
}

//������������Ľ����
class Node{
	public Object value;//���ֵ
	public int inDegree;//���
	
	public Node(Object val){
		this.value = val;
	}
}

//��������ͼ
class topGraph{
	//ͼ�н��ļ���
	public Set<Node> vertexSet = new HashSet<Node>();
	//�ߵļ��ϣ�������¼���ڵı�
	public Map<Node, Set<Node>> adj = new HashMap<Node,Set<Node>>();
	
	//����������ͼ����ӽ��
	public boolean addNode(Node start, Node end){
		if(!vertexSet.contains(start)){//�㼯�в���start��㣬�����
			vertexSet.add(start);
		}
		if(!vertexSet.contains(end)){//�㼯�в���end��㣬�����
			vertexSet.add(end);
		}
		//adj�ڽӱ��а���start��end���ʱ��������κν�㣬����ֵΪfalse
		if(adj.containsKey(start) && adj.get(start).contains(end)){
			return false;
		}
		//���ڽӱ��а���start��㣬���ǲ�����end����ǣ�Ҫ��end�����ӵ��ڽӱ���
		if(adj.containsKey(start)){
			adj.get(start).add(end);
		}else{//�ڽӱ��в���startʱ��Ҫ�γ�һ���ߣ���������ӵ�adj��
			Set<Node> temp = new HashSet<Node>();
			temp.add(end);
			adj.put(start, temp);
		}
		end.inDegree++;
		return true;		
	}
}

class SubTopSort{//����ķ�������һ����������Ľ����result
	public List<Node> result;//�洢��������Ľ��
	public Queue<Node> InDegreeIsZero;//���������������Ϊ0�Ľ��Ҫ��ӽ�ȥ
	public topGraph graph;
	
	public SubTopSort(topGraph g){
		this.graph = g;
		this.result = new ArrayList<Node>();
		this.InDegreeIsZero = new LinkedList<Node>();
		
		for(Node iterator : this.graph.vertexSet){
			if(iterator.inDegree == 0){
				this.InDegreeIsZero.add(iterator);
			}
		}
	}
	
	public void topsort(){
		while(!InDegreeIsZero.isEmpty()){
			Node ver = InDegreeIsZero.poll();//����Ԫ��
			result.add(ver);
			//�жϽ��ver���ڽӱ��Ƿ�Ϊ�գ����Ϊ��������
			if(this.graph.adj.keySet().isEmpty()){
				return;
			}
			
			//�����Ϊ�գ��������֮���ڵı�
			for(Node v : this.graph.adj.get(ver)){
				//ͨ�����ٱ�����ɾ���õ�
				v.inDegree--;
				if(v.inDegree == 0){
					InDegreeIsZero.add(v);
				}
			}
			this.graph.vertexSet.remove(ver);//�㼯��ɾ��ver
			this.graph.adj.remove(ver);//�߼���ɾ��ver
		}
		if(!this.graph.vertexSet.isEmpty()){
			throw new IllegalArgumentException("���ڻ�·");
		}
	}
	
	public Iterable<Node> getResult(){
		return result;
	}
}








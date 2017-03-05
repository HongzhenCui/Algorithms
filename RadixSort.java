package ����;

import java.util.Collection;
import java.util.Queue;

import javax.management.Query;

import org.omg.CORBA.PUBLIC_MEMBER;

public class RadixSort {
//	���������α����
//	RadixSort()
//	    for d = 1 to ����ֵ�������������ڵ�λ��
//	        ���ݵ�dλ���ֽ����е����ֱַ���䵽��0����9�У�
//	        ������֤��Ž�һ�������У�
	public static void radixsort(int[] data){
		int d, j, k, factor;
		int radix = 10;
		int digits = 10;
		Queue[] queues = new Queue[radix];
		for(d = 0; d < radix; d++)
			queues[d] = new Queue();
		for(d = 1, factor = 1; d <= digits; factor *=radix, j++){
		    for(j=0; j < data.length; j++){
		    	queues[(data[j]/factor)%radix].enqueue(new Integer(data[j]));
		    }
		    for(j = k = 0; j < radix; j++){
		    	while(!queues[j].isEmpty()){
		    		data[k++] = ((Integer)queues[j].dequeue()).intValue();
		    	}
		    }
		}

	}
	
	

}

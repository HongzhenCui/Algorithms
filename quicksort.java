package ����;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
//quicksort(Object[] array)
//    ѡ������tmp
//    ��Ԫ�ؽ������໮�ֳ�������suba1��suba2
//    ���������ڽ��п�������
public class quicksort {
	public static void main(String[] args){
		int[] a = {8,5,4,7,6,1,6,3,8,12,10};
		if(a.length <= 0){
			return;
		}
		System.out.println("����֮ǰ��\n"+Arrays.toString(a));
		quicksort(a, 0, a.length-1);
		System.out.println("����֮��\n"+Arrays.toString(a));
	}
	public static int getMiddle(int[] array, int low, int high){
		int tmp = array[low];//����ĵ�һ����Ϊ����
		while(low < high){
			//�����Ҳ�Ԫ�ش������ᣬ��high�±��1;����Ļ���������ҪС���������Ԫ�����
			while(low < high && array[high] >= tmp){
				high--;
			}
			array[low] = array[high];//������С�ļ�¼�ƶ������
			//��������Ԫ��С�����ᣬ��low�±��1������Ļ���������Ҫ���������Ԫ�ص��Ҳ�
			while( low < high && array[low] <=tmp){
				low++;
			}
			array[high] = array[low];//��������Ԫ�ط����Ҳ�
		}
		array[low] = tmp;//�����¼�����
		return low;//���������λ��
	}
	public static void quicksort(int[] array, int low, int high){
		if(low < high){
			int middle = getMiddle(array, low, high);//��list����һ��Ϊ��
			quicksort(array, low, middle-1);
			quicksort(array, middle+1, high);
		}
	}
}

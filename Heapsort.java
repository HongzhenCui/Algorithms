package ����;

import java.util.Arrays;

////�������α����
////heapsort(data[])
////    dataת���һ���ѣ�
////    for i = data.length-1 downto 2
////        ������iλ���ϵ�Ԫ�ؽ���;
////        �ָ���data[0],...,data[i-1]�Ķ�����;
//public class Heapsort {
//	public void heapsort(Object[] data){
//		//������ת����һ����
//		for(int i = data.length/2-1; i >= 0; --i)
//			moveDown(data, i, data.length-1);
//		//ʵ��λ�õĵ���
//		for(int i = data.length-1; i >= 1; --i){
//			swap(data, 0, i);
//			moveDown(data, 0, i-1);
//		}
//	}
//	//��һ�����鴴����һ����(��Ԫ�������������ƶ����㷨ʵ�֣�
//	void moveDown(Object[] data, int first, int last){
//		int largest = 2*first +1;
//		while(largest <= last){
//			//first�ڵ����������ӽڵ㣨2*first+1��2*first+2����
//			//���Comparable�Ƚϵ����������ӽڵ��Ԫ�ش�С
//			if(largest < last && 
//					((Comparable)data[largest]).compareTo(data[largest+1]) < 0)
//				largest++;
//			//�Ƚϸ��ڵ�����ڵ㴦ֵ�Ĵ�С����������������򽻻�ֵ�Ĵ�С�������ƶ�Ԫ��
//			if(((Comparable)data[first]).compareTo(data[largest]) < 0){
//				swap(data, first, last);
//				first = largest;
//				largest = 2*first +1;
//			}
//			else 
//				//������ѵ�ѭ��ʱ���˳�ѭ��
//				largest = last + 1;
//		}
//	}
//	//ʵ������������Ԫ�صĽ���
//	void swap(Object[] a, int e1, int e2){
//		Object tmp = a[e1];
//		a[e1] = a[e2];
//		a[e2] = tmp;
//	}
//
//}

public class Heapsort {
    public static void heapSort(int[] data){
        System.out.println("��ʼ����");
        int arrayLength=data.length;
        //ѭ������
        for(int i=0;i<arrayLength-1;i++){
            //����
            buildMaxHeap(data,arrayLength-1-i);
            //�����Ѷ������һ��Ԫ��
            swap(data,0,arrayLength-1-i);
            System.out.println(Arrays.toString(data));
        }
    }
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
    //��data�����0��lastIndex���󶥶�
    private static void buildMaxHeap(int[] data, int lastIndex) {
        //��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k���������жϵĽڵ�
            int k=i;
            //�����ǰk�ڵ���ӽڵ����
            while(k*2+1<=lastIndex){
                //k�ڵ�����ӽڵ������
                int biggerIndex=2*k+1;
                //���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����
                if(biggerIndex<lastIndex){
                    //�������ӽڵ��ֵ�ϴ�
                	//data[biggerIndex].compareTo(data[biggerIndex+1])<0
                    if(data[biggerIndex] < data[biggerIndex+1]){
                        //biggerIndex���Ǽ�¼�ϴ��ӽڵ������
                        biggerIndex++;
                    }
                }
                //���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
                //data[k].compareTo(data[biggerIndex])<0
                if(data[k] < data[biggerIndex]){
                    //��������
                    swap(data,k,biggerIndex);
                    //��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] data={21,30,49,30,16,9};
        System.out.println("����֮ǰ��\n"+Arrays.toString(data));
        heapSort(data);
        System.out.println("����֮��\n"+Arrays.toString(data));
    }
}
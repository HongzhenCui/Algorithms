package ����;
//���������㷨��α����
//insertionsort(data[]){
//	for i=1 to data.length-1
//	    temp = data[i];
//	    �����д���temp��Ԫ��data[i]�ƶ�һ��λ��
//	    ��temp�ŵ���ȷ��λ����
//}
public class insertionsort {
	public static void main(Object[] data) {
		//�������򷽷���ͨ��ʵ��
		for(int i=1,j;i<data.length;i++){
			Comparable temp=(Comparable)data[i];
			//�����д���Temp��Ԫ��data[j]�ƶ�һ��λ��
			for (j = i; j >0 && temp.compareTo(data[j-1]) < 0; j--)
				data[j] = data[j-1];
			//��temp�ŵ���ȷ��λ����
			data[j] = temp;
		}
		//����������Ĳ��������ʵ��
//	public static void main(int[] data) {
//		for(int i=1,j; i<data.length; i++){
//			int temp = data[i];
//			for(j=i;j > 0 && temp < data[j-1]; j--)
//				data[j] = data[j-1];
//			data[j] = temp;
//		}
	}
}


package ����;

//Shell�����α����
//��data�ֳ�h������
//    for i =1 to h
//        ����������data(i);
//    ��������data
public class Shellsort {
	public void Shellsort(Object[] data){
		/*
		 * �����漰���ı���������
		 * i��ʾ��Shell�����е�������������i������
		 * j��k��ʾ������Ԫ�أ�
		 * h��ʾ������ֵ��
		 * hCnt��ʾ������ֵ�����ڿ���ÿ������Ĵ�����
		 * increment[]��ʾ��ÿ������ʱ������ֵ�����顣
		 * */
		int i, j, k, h, hCnt, increments[] = new int[20];
		//����һ�����ʵ�����ֵh
		for(h = 1, i = 0; h < data.length; i++){
			increments[i] = h;
			h = 3*h + 1;
		}
		//һ������i������
		for(i--; i >= 0; i--){
			h = increments[i];
			//ÿ��������ִ�еĴ���
			for(hCnt = h; hCnt < 2*h; hCnt++){
				//��ÿ���н���ֱ�Ӳ�������
				for(j = hCnt; j < data.length;){
					Comparable tmp = (Comparable)data[j];
					k = j;
					while (k-h >=0 && tmp.compareTo(data[k-h]) < 0) {
						data[k] = data[k-h];
						k -= h;
					}
					data[k] = tmp;
					j += h;
				}
			}
		}
	}
}

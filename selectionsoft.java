package ����;
//ѡ�������α����
//selectionsoft(data[])
//    for i = 0 to data.length-2
//    ��data[i],...,data[data.length-1]��ѡ��ȡ��С��Ԫ�أ�
//    ������data[i]������
public class selectionsoft {
	public void selectionsoft (int[] data) {
		int i,j,least;
		if(data == null || data.length <= 0){
			return;
		}
		for(i = 0; i < data.length -1; i++){
			for(j = i+1, least = i; j < data.length; j++){
				//least=i;��ʾ����ǰλ�õ�Ԫ�ض���Ϊ��Сֵ���±�
				//�����С�ڵ�ǰ��Сֵ�Ĺؼ���
				if(data[least] > data[j])
					//���˹ؼ��ֵ��±긳ֵ��least
					least = j;
			}
			if(i != least){//���least������i,˵���ҵ���Сֵ
				int tmp = data[least];
			    data[least] = data[i];
			    data[i] = tmp;
			}
		}
	}
}

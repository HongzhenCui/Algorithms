package ����;

//ð�������α����
//bubblesort(data[])
//    for i to data.length-2
//        for j = data.lengt-1 downto j+1
//            ���˳�����ͽ���j��j-1λ���ϵ�Ԫ�أ�

public class bubblesort {
	//bubblesort1()����ÿ��Ѱ����СԪ�ط�����Ӧλ�ã�ǰ�ߣ�
	public void bubblesort1(int[] data){
		int tmp = 0;
		for(int i = 0; i < data.length; i++){//���ѭ����0��data.length-1
			for(int j = data.length-1; j > i; --j){//�ڲ�ѭ���Ӵ���iλ�ú��Ԫ����ѡ��
				if(data[j] < data[j-1]){
					tmp = data[j];
					data[j] = data[j-1];
					data[j-1] = tmp;
				}
			}
		}
	}
	//bubblesort1()����ÿ��Ѱ�����ֵ������Ӧλ�ã���ߣ�
	public void bubblesort2(int[] a){
		int temp = 0;
		for(int i = a.length-1; i > 0; --i){//���ѭ���Ǵ�a.length-1��0��λ����
			for(int j = 0; j < i; j++){//�ڲ�ѭ���Ǵ�0��i��λ���ϵ�Ԫ�ؽ���ѡ��
				if(a[j+1] < a[j]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
}

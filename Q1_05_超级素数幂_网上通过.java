package ģ��һ;

import java.util.Scanner;
/**
 * ���һ�������ܱ�ʾΪp^q(^��ʾ������)��pΪһ������,qΪ����1���������ͳ�������������������ݡ�
 * ���ڸ���һ��������n,���n��һ��������������Ҫ�ҳ���Ӧ��p,q��
 * 
 * ���룺27
 * �����3 3
 * */

public class Q1_05_����������_����ͨ�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			long n = sc.nextLong();
			function(n);
		}
	}
	public static void function(long n){
		long p = (long)(Math.sqrt(n)+1);
		long q = 2;
		for(;p>=2;p--){
			long tmp = myPow(p, q);
			long flag = tmp-n;
			if(flag == 0){
				if(!isPrime((int)p)) continue;
				System.out.println(p + " " + q);
				return;
			}else if(flag<0){
				q++;
				p=(long)(Math.pow(n, 1.0/q)+1);//��Ӧָ������ʱ��������n^(1.0/q),��q�θ�����n,
			}
		}
		System.out.println("No");
	}
	
	public static boolean isPrime(int n){//�ж�һ�����Ƿ�Ϊ����
		if(n<1){
			return false;
		}
		for(int i = 2; i*i <= n; i++){
			if(n%i ==0){
				return false;
			}			
		}		
		return true;
	}
	public static long myPow(long p, long q){//�Զ�������ݼ�������
		return q == 0? 1:myPow(p, q-1)*p;
	}	
}

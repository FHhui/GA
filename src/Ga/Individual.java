package Ga;

import java.util.Random;

public class Individual {
//�����࣬��װ������Ϣ������Ⱥ�Ļ�����ɵ�λ��
	int fitness=0;
	int[] genes=new int[5];//����Ļ�������
	int genLength=5;
	public Individual() {
		//����Ĺ��췽�����Ը�����й��졣
		Random ran=new Random();
		//����������ɻ�������
		for(int i=0;i<genes.length;i++) {
			//�����ƶ�2����ȡ��֮��ֻ��1,0���ֿ��ܣ�Ҳ���ǽ����Զ�ת��Ϊ�˶�����
			genes[i]=ran.nextInt()%2;
		}
		//��ʼ��ÿһ����ĺ��ʳ̶ȡ�
		this.fitness=0;
	}
	
	public void clalFitness() {
		//����ļ�����Ӧ�ȵĺ���,���������Ӧ�ȼ������
		fitness=0;
		for(int i=0;i<5;i++) {
			if(genes[i]==1) {
				fitness++;
			}
		}
	}
	
}

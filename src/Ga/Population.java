package Ga;

public class Population {
//��Ⱥ�࣬�ɸ������,����ʤ��̭�Ķ���
	int popSize=10;
	Individual[] indivals=new Individual[10];
	int fittest=0;
	public void initializePopulation(int Size) {
		//��ʼ������
		for(int i=0;i<indivals.length;i++) {
			indivals[i]=new Individual();
		}
	}
	public Individual getFittest() {
		//������Ⱥ����Ӧ�̶���ߵ�
		int maxFit=0;
		for(int i=0;i<indivals.length;i++) {
			//if(indivals[maxFit].fitness<=indivals[i].fitness) {
			if(maxFit<=indivals[i].fitness) {
				maxFit=i;
			}
		}
		fittest=indivals[maxFit].fitness;
		return indivals[maxFit];
	}
	public Individual getSeconfFittest() {
		//������Ⱥ����Ӧ�ȵڶ��ߵ�
		int maxFit1=0;
		int maxFit2=0;
		for(int i=0;i<indivals.length;i++) {
			if(indivals[i].fitness>indivals[maxFit1].fitness)
			{
				maxFit2=maxFit1;
				maxFit1=i;
			}else if(indivals[i].fitness>indivals[maxFit2].fitness) {
				maxFit2=i;
			}
			
		}
		return indivals[maxFit2];
	}
	public int getLeastFittestIndex() {
		//������С��Ӧ��ѡ������ֻ��Ҫ֪�����ĵ�ַ������Ĩɱ����
		int minFit=0;
		for(int i=0;i<indivals.length;i++) {
			//if(indivals[minFit].fitness>=indivals[i].fitness)
			if(minFit>=indivals[i].fitness)
				minFit=i;
		}
		return minFit;
	}
	public void calculateFitness() {
		for(int i=0;i<indivals.length;i++) {
			indivals[i].clalFitness();
		}
		getFittest();
	}
	
}

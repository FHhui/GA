package Ga;

public class Population {
//种群类，由个体组成,是优胜劣汰的对象。
	int popSize=10;
	Individual[] indivals=new Individual[10];
	int fittest=0;
	public void initializePopulation(int Size) {
		//初始化个体
		for(int i=0;i<indivals.length;i++) {
			indivals[i]=new Individual();
		}
	}
	public Individual getFittest() {
		//查找种群中适应程度最高的
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
		//查找种群中适应度第二高的
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
		//对于最小适应度选手我们只需要知道他的地址并将其抹杀即可
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

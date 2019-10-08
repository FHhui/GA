package Ga;

import java.awt.SecondaryLoop;
import java.util.Random;

public class SimpleDemoGA {
	//测试类,也就是生物生存的自然环境类。
	private Population population=new Population();
	private Individual fittest;
	private Individual secfittest;
	//这里的两个个体在前期作的是父母，后期则代表着子女。
	private int generationCount=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran=new Random();
		SimpleDemoGA demo=new SimpleDemoGA();
		demo.population.initializePopulation(10);//初始化种群的操作。
		
		demo.population.calculateFitness();//对种群的适应程度进行初始化计算
		
		System.out.println(("Generation: " + demo.generationCount + " Fittest: "+demo.population.fittest));
		
		while(demo.population.fittest<5) {//种群适应度的判别函数。
			demo.generationCount++;
			
			demo.Selection();
			demo.crossover();
			if (ran.nextInt()%7 < 5) {
	                demo.mutation();
	            }//变异的产生是需要一定的概率的。
			demo.addFittestOffspring();
			//想种群中添加并抹杀。
			demo.population.calculateFitness();
			//发生改变以后再一次计算种群的适应度
			 System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
		}

        System.out.println("\nSolution found in generation " + demo.generationCount);
        System.out.println("Fitness: "+demo.population.getFittest().fitness);
        System.out.print("Genes: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(demo.population.getFittest().genes[i]);
        }
        System.out.println("");
	}
	public void Selection() {
		fittest=population.getFittest();
		secfittest=population.getSeconfFittest();
		//选择适应度最高的两组，只有他们有交配权。
	}
	public void crossover() {
		Random ran=new Random();
		//设置变异点，且保证变异点的位置不会超出基因的长度
		int crossOverPoint=ran.nextInt(population.indivals[0].genLength);
		//让两个优秀的个体进行交配操作。
		for(int i=0;i<crossOverPoint;i++) {
			//在变异点前的基因进行交叉互换操作。
			int temp=fittest.genes[i];
			fittest.genes[i]=secfittest.genes[i];
			secfittest.genes[i]=temp;
		}
	}
	public void mutation() {
		//个体自己染色体发生的变异行为。
		Random ran=new Random();
		int mutationPoint=ran.nextInt(population.indivals[0].genLength);
		if(fittest.genes[mutationPoint]==0) {
			fittest.genes[mutationPoint]=1;
		}else {
			fittest.genes[mutationPoint]=0;
		}
		mutationPoint=ran.nextInt(population.indivals[0].genLength);
		if(secfittest.genes[mutationPoint]==0) {
			secfittest.genes[mutationPoint]=1;
		}else {
			secfittest.genes[mutationPoint]=0;
		}
	}
	public Individual getFittestOffSpring() {
		if(fittest.fitness>secfittest.fitness) {
			return fittest;
		}else {
			return secfittest;
		}
	}
	public void addFittestOffspring() {
		//删除掉最小适应度的个体，并在种群中添加一个当前最大适应度的个体
		fittest.clalFitness();
		secfittest.clalFitness();
		int least=population.getLeastFittestIndex();
		population.indivals[least]=getFittestOffSpring();
	}
}

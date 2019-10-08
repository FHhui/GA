package Ga;

import java.awt.SecondaryLoop;
import java.util.Random;

public class SimpleDemoGA {
	//������,Ҳ���������������Ȼ�����ࡣ
	private Population population=new Population();
	private Individual fittest;
	private Individual secfittest;
	//���������������ǰ�������Ǹ�ĸ���������������Ů��
	private int generationCount=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran=new Random();
		SimpleDemoGA demo=new SimpleDemoGA();
		demo.population.initializePopulation(10);//��ʼ����Ⱥ�Ĳ�����
		
		demo.population.calculateFitness();//����Ⱥ����Ӧ�̶Ƚ��г�ʼ������
		
		System.out.println(("Generation: " + demo.generationCount + " Fittest: "+demo.population.fittest));
		
		while(demo.population.fittest<5) {//��Ⱥ��Ӧ�ȵ��б�����
			demo.generationCount++;
			
			demo.Selection();
			demo.crossover();
			if (ran.nextInt()%7 < 5) {
	                demo.mutation();
	            }//����Ĳ�������Ҫһ���ĸ��ʵġ�
			demo.addFittestOffspring();
			//����Ⱥ����Ӳ�Ĩɱ��
			demo.population.calculateFitness();
			//�����ı��Ժ���һ�μ�����Ⱥ����Ӧ��
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
		//ѡ����Ӧ����ߵ����飬ֻ�������н���Ȩ��
	}
	public void crossover() {
		Random ran=new Random();
		//���ñ���㣬�ұ�֤������λ�ò��ᳬ������ĳ���
		int crossOverPoint=ran.nextInt(population.indivals[0].genLength);
		//����������ĸ�����н��������
		for(int i=0;i<crossOverPoint;i++) {
			//�ڱ����ǰ�Ļ�����н��滥��������
			int temp=fittest.genes[i];
			fittest.genes[i]=secfittest.genes[i];
			secfittest.genes[i]=temp;
		}
	}
	public void mutation() {
		//�����Լ�Ⱦɫ�巢���ı�����Ϊ��
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
		//ɾ������С��Ӧ�ȵĸ��壬������Ⱥ�����һ����ǰ�����Ӧ�ȵĸ���
		fittest.clalFitness();
		secfittest.clalFitness();
		int least=population.getLeastFittestIndex();
		population.indivals[least]=getFittestOffSpring();
	}
}

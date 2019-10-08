package Ga;

import java.util.Random;

public class Individual {
//个体类，封装个体信息，是种群的基本组成单位。
	int fitness=0;
	int[] genes=new int[5];//个体的基因数组
	int genLength=5;
	public Individual() {
		//个体的构造方法，对个体进行构造。
		Random ran=new Random();
		//个体随机生成基因数组
		for(int i=0;i<genes.length;i++) {
			//二进制对2进行取余之后只有1,0两种可能，也就是将其自动转换为了二进制
			genes[i]=ran.nextInt()%2;
		}
		//初始化每一个体的合适程度。
		this.fitness=0;
	}
	
	public void clalFitness() {
		//个体的计算适应度的函数,将个体的适应度计算出来
		fitness=0;
		for(int i=0;i<5;i++) {
			if(genes[i]==1) {
				fitness++;
			}
		}
	}
	
}

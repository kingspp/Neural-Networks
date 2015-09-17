package com.ml.gates;

public class TruthTable {
	NeuralLogic neuralLogic = new NeuralLogic();

	void init_andLogic(int [][] input){
		for(int i=0;i<2;i++)
			for(int j=0; j<2; j++)
				input[i][j] = i*j;	
		if(Main.TTABLE)
			Print.printTruthTable(input);
	}
	
	void init_orLogic(int [][] input){
		for(int i=0;i<2;i++)
			for(int j=0; j<2; j++)
				input[i][j] = ((i+j) > 0) ? 1:0 ;	
		if(Main.TTABLE)
			Print.printTruthTable(input);
	}
	
	void init_nandLogic(int[][] input){
		for(int i=0;i<2;i++)
			for(int j=0; j<2; j++)
				input[i][j] =neuralLogic.notGATE(i*j);	
		if(Main.TTABLE)
			Print.printTruthTable(input);
	}
	
	void init_norLogic(int[][] input){
		for(int i=0;i<2;i++)
			for(int j=0; j<2; j++)
				input[i][j] = neuralLogic.notGATE( ((i+j) > 0) ? 1:0 );	
		if(Main.TTABLE)
			Print.printTruthTable(input);
	}
}

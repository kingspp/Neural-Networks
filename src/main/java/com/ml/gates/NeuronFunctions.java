package com.ml.gates;

import java.util.Random;

public class NeuronFunctions {

	boolean dy = false;
	static final int NULL = 99;
	
	public int activation(Neuron neuronA, Neuron neuronB){
		double temp=0;
		double sum = 0.0;
		sum = (neuronA.getValue() * neuronA.getWeight()) + (neuronB.getValue() * neuronB.getWeight());		
		sum = (dy) ? sigmoidDy(sum) : sigmoid(sum);
		temp = 	(sum >= 0.5) ? 1:0;		
		if(Main.TRAINING){
			int[][] logicTable = Neuron.getLogicTable();
			if(logicTable[neuronA.getValue()][neuronB.getValue()] != temp){
				if(Main.STEPS++ > 5){
					dy=true;
					if(Main.STEPS > Main.MaxSTEPS){
						System.err.println("Error in finding a suitable weight");
						System.exit(1);
					}
				}
				if(Main.TESTING)
					System.out.println(neuronA.getValue()+" ("+Main.gate+") "+neuronB.getValue() + " != "+ temp + " Error Rate:"+ getErrorRate(logicTable[neuronA.getValue()][neuronB.getValue()] , temp));
				neuronA.setWeight(getRandom(Main.MINRange, Main.MAXRange));
				System.out.println("NeuronA value: "+ neuronA.getValue() + " weight: "+ neuronA.getWeight());
				neuronB.setWeight(getRandom(Main.MINRange, Main.MAXRange));
				System.out.println("NeuronB value: "+ neuronB.getValue() + " weight: "+ neuronB.getWeight());
				return NULL;
			}
			else 
				return (temp >= 1 ) ? 1:0;		
		}
		return (temp >= 1 ) ? 1:0;
	}
	
	public double sigmoid(double input){	
		 Main.SIGMOID = 1 / (1 + Math.pow(Math.E, (-1 * input)));
		if(Main.TESTING)
			System.out.println("Sigmoid value: " + Main.SIGMOID);		
		return Main.SIGMOID;
	}
	
	public double sigmoidDy(double input){
		return input * (1-input);
	}
	
	public static double getRandom(double min, double max) {
		Random r = new Random();
		double randomValue =  min + (r.nextDouble() * (max- min));
		randomValue = Math.round(randomValue * 100.0) / 100.0;
		return new Double(randomValue);
	}
	
	public static double getErrorRate(double inpIdeal, double inpPrac){
		double err = 0.5 *(Math.pow((inpIdeal - inpPrac), 2)) ;
		return err;
	}
}
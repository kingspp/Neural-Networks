package com.ml.gates;

import java.util.HashMap;

public class Neuron {

	private int value;
	private double weight;
	private boolean logic;
	private static int[][] logicTable = new int[2][2];
	private static final int NULL = 99;

	private static HashMap<String, double[]> weightMap;
	/*
	 * static
	 * {
	 * double[] init_null = { (double) NULL, (double) NULL };
	 * weightMap.put("and", init_null);
	 * weightMap.put("or", init_null);
	 * weightMap.put("not", init_null);
	 * weightMap.put("nand", init_null);
	 * }
	 */

	public Neuron()
	{
	}

	public Neuron( int value )
	{
		this.value = value;
		this.weight = NeuronFunctions.getRandom(Main.MINRange, Main.MAXRange);
	}

	public Neuron( int[][] input )
	{
		Neuron.logicTable = input;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue( int value )
	{
		this.value = value;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight( double weight )
	{
		this.weight = weight;
	}

	public boolean getLogic()
	{
		return logic;
	}

	public void setLogic( boolean logic )
	{
		this.logic = logic;
	}

	public static int[][] getLogicTable()
	{
		return logicTable;
	}

	public void setLogicTable( int[][] logicTable )
	{
		Neuron.logicTable = logicTable;
	}

	public int activation( Neuron neuronA, Neuron neuronB )
	{
		NeuronFunctions neuronFunctions = new NeuronFunctions();
		double[] WEIGHT = new double[2];
		int result = NULL;
		while( result == NULL )
			result = neuronFunctions.activation(neuronA, neuronB);
		WEIGHT[0] = neuronA.getWeight();
		WEIGHT[1] = neuronB.getWeight();
		System.out.println("Final weights are: ");
		System.out.println("Neuron A: " + neuronA.getWeight());
		System.out.println("Neuron B: " + neuronB.getWeight());
		return result;
	}
}
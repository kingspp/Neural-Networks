package com.ml.gates;

public class Print {

	public static void printTruthTable( int[][] input )
	{
		System.out.println();
		System.out.println("Truth Table: " + Main.gate);
		System.out.println("------------------------------");
		System.out.println("A\t B\t Y");
		for( int i = 0; i < input.length; i++ )
			for( int j = 0; j < input.length; j++ )
				System.out.println(i + "\t " + j + "\t " + input[i][j]);
		System.out.println();
	}

	public static void printNeuronStatus( String name, Neuron neuron )
	{
		System.out.println(name + " value:" + neuron.getValue() + " weight: " + neuron.getWeight());
	}

}

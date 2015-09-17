package com.ml.gates;

public class NeuralLogic {

	boolean high = true;
	boolean low = false;
	double THRESHOLD = 1.5;
	static int andLogic[][] = new int[2][2];
	static int orLogic[][] = new int[2][2];
	static int nandLogic[][] = new int[2][2];
	static int notLogic[][] = new int[2][2];
	static int norLogic[][] = new int[2][2];
	static Neuron neuronA;
	static Neuron neuronB;
	static Neuron neuronC;
	static TruthTable truthTable = new TruthTable();

	public int andGATE( int a, int b, boolean train )
	{
		System.out.println("\nAND Gate selected");
		neuronA = new Neuron(a);
		Print.printNeuronStatus("neuronA", neuronA);
		neuronB = new Neuron(b);
		Print.printNeuronStatus("neuronB", neuronB);
		if( train )
		{
			truthTable.init_andLogic(andLogic);
			neuronC = new Neuron(andLogic);
		}
		else
			neuronC = new Neuron();

		return neuronC.activation(neuronA, neuronB);
	}

	public int notGATE( int input )
	{
		return (input >= 1) ? 0 : 1;
	}

	public int[] notGATE( int[] input )
	{
		int[] value = new int[input.length];
		for( int i = 0; i < input.length; i++ )
			value[i] = (input[i] >= 1) ? 0 : 1;
		return value;
	}

	public int nandGATE( int a, int b, boolean train )
	{
		System.out.println("\nNAND Gate selected");
		neuronA = new Neuron(a);
		Print.printNeuronStatus("neuronA", neuronA);
		neuronB = new Neuron(b);
		Print.printNeuronStatus("neuronB", neuronB);
		if( train )
		{
			truthTable.init_nandLogic(nandLogic);
			neuronC = new Neuron(nandLogic);
		}
		else
			neuronC = new Neuron();

		return neuronC.activation(neuronA, neuronB);
	}

	public int orGATE( int a, int b, boolean train )
	{
		System.out.println("\nOR Gate selected");
		neuronA = new Neuron(a);
		Print.printNeuronStatus("neuronA", neuronA);
		neuronB = new Neuron(b);
		Print.printNeuronStatus("neuronB", neuronB);
		if( train )
		{

			neuronC = new Neuron(orLogic);
		}
		else
			neuronC = new Neuron();
		neuronC.activation(neuronA, neuronB);
		return neuronC.activation(neuronA, neuronB);
	}

	public int norGATE( int a, int b, boolean train )
	{
		System.out.println("\nNOR Gate selected");
		neuronA = new Neuron(a);
		Print.printNeuronStatus("neuronA", neuronA);
		neuronB = new Neuron(b);
		Print.printNeuronStatus("neuronB", neuronB);
		if( train )
		{
			truthTable.init_norLogic(norLogic);
			neuronC = new Neuron(norLogic);
		}
		else
			neuronC = new Neuron();
		neuronC.activation(neuronA, neuronB);
		return neuronC.activation(neuronA, neuronB);
	}

	public int xorGATE( int a, int b, boolean train )
	{
		System.out.println("\nXOR Gate selected");
		neuronA = new Neuron(notGATE(a));
		neuronB = new Neuron(notGATE(b));
		truthTable.init_norLogic(norLogic);
		neuronC = new Neuron(norLogic);
		int result0 = neuronC.activation(neuronA, neuronB);

		neuronA = new Neuron(a);
		neuronB = new Neuron(b);
		neuronC = new Neuron(norLogic);
		int result1 = neuronC.activation(neuronA, neuronB);

		neuronA = new Neuron(result0);
		neuronB = new Neuron(result1);
		neuronC = new Neuron(norLogic);
		int fres = neuronC.activation(neuronA, neuronB);
		return fres;
	}

}
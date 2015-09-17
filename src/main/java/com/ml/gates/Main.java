package com.ml.gates;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	static NeuralLogic logic = new NeuralLogic();
	public static int STEPS = 1;
	public static boolean TRAINING = true;
	public static final double MINRange = -1.0;
	public static final double MAXRange = 1.0;
	public static boolean RESULT;
	public static double SIGMOID;
	public static boolean TESTING = false;
	public static boolean TTABLE = false;
	public static int MaxSTEPS = 15;
	public static final String[] gateSelection = { "and", "or", "nand", "nor", "xor" };
	public static int numberOfGates = gateSelection.length;

	/////////////////////////// Define Inputs
	public static int a = 1;
	public static int b = 1;
	public static boolean RandomInput = true;
	public static String gate = "xor"; // and | or | not | nand

	//////////////////////////////////////

	public static void main( String v[] )
	{
		// Training();

		if( RandomInput )
		{
			Random r = new Random();
			a = (r.nextDouble() > 0.5) ? 0 : 1;
			b = (r.nextDouble() > 0.5) ? 0 : 1;
			gate = gateSelection[r.nextInt(numberOfGates)];
		}
		System.out.println("Neural Networks");
		System.out.println("A: " + a + " B: " + b);
		if( TRAINING )
			System.out.println("Training enabled");
		try
		{
			Method m = logic.getClass().getMethod(gate + "GATE", int.class, int.class, boolean.class);
			System.out.println(m.invoke(logic, a, b, TRAINING));
		}
		catch( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sigmoid: " + Main.SIGMOID);
		System.out.println("Training Steps: " + STEPS);

	}

	static void Training()
	{
		int id = 0;
		/*
		 * while( id < numberOfGates )
		 * {
		 * try
		 * {
		 * Method m = logic.getClass().getMethod(gate + "GATE", int.class,
		 * int.class, boolean.class);
		 * System.out.println(m.invoke(logic, a, b, TRAINING));
		 * }
		 * catch( NoSuchMethodException | SecurityException |
		 * IllegalAccessException | IllegalArgumentException
		 * | InvocationTargetException e )
		 * {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * }
		 * }
		 */

		Map<String, ArrayList<Double>> map = new HashMap<String, ArrayList<Double>>();

		ArrayList<Double> list = new ArrayList<Double>();
		list.add(0.25);
		list.add(0.01);
		map.put("and", list);
		JSONHandler handler = new JSONHandler();
		handler.convertMaptoJSON(map);
		// System.out.println(map.get("and")[0]);

	}
}
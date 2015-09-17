package com.ml.gates;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONHandler<T> {

	Iterator<T> iterator;

	public void convertMaptoJSON( Map<T, T> map )
	{

		JSONObject obj = new JSONObject();
		JSONArray jlist = new JSONArray();
		ArrayList<T> list = new ArrayList<T>();

		for( T n : map.keySet() )
		{
			list = (ArrayList<T>) map.get(n);

			iterator = list.iterator();
			while( iterator.hasNext() )
				jlist.add(iterator.next());
			obj.put(n, jlist);

		}

		try
		{

			FileWriter file = new FileWriter("weights.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

	}

	public void convertJSONtoMap( String fileName )
	{
		T[] list = (T[]) Main.gateSelection;
		JSONParser parser = new JSONParser();

		try
		{

			Object obj = parser.parse(new FileReader(fileName));

			JSONObject jsonObject = (JSONObject) obj;
			for( T n : list )
			{
				JSONArray msg = (JSONArray) jsonObject.get(n);
				System.out.println(n);
				Iterator<T> iterator = msg.iterator();
				while( iterator.hasNext() )
				{
					System.out.println(iterator.next());
				}
			}

		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		catch( ParseException e )
		{
			e.printStackTrace();
		}

	}

}

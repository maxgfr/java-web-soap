package service;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheWorldImpl implements TheWorld{


    //list with the median of the women speech rate at each French’s radio station between 2010 and 2018
    public String theWorld(String year) {
    	List<List<String>> records = new ArrayList<List<String>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("ressources/data.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Map<String, String>> finalDictionnary = new HashMap<String, Map<String, String> >();
        /*for(int j=16; j<records.size(); j++) { // starts in 2010
        	Map<String, String> dictionnary = new HashMap<String, String>();
        	for(int i=4; i<records.get(j).size(); i++) { // first column is year
        		dictionnary.put(records.get(0).get(i), records.get(j).get(2));
	        }
        	finalDictionnary.put(records.get(j).get(0), dictionnary);
        }*/
        
        for(int j=1; j<records.size(); j++) { 
        	Map<String, String> dictionnary = new HashMap<String, String>();
        	for(int i=4; i<records.get(j).size(); i++) { // first column is year
        		dictionnary.put(records.get(0).get(i), records.get(j).get(2));
	        }
        	finalDictionnary.put(records.get(j).get(0), dictionnary);
        }
        
        System.out.println(finalDictionnary);
        System.out.println(finalDictionnary.get(year).toString());
        return finalDictionnary.get(year).toString();
    }
}

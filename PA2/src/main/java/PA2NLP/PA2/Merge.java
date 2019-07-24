package PA2NLP.PA2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.io.*;

public class Merge {
	public static List<String> tolower(List<String> l){
		
		ListIterator<String> iterator = l.listIterator();   // makes it all lower case
	    while (iterator.hasNext())
	    {
	        iterator.set(iterator.next().toLowerCase());
	    }
		
		return l;
		
	}
	
	public static List<String> removeDuplicates(List<String>[] lol){ 	
		
		List<String> l = new ArrayList<String>(); 
		for(int i=0;i<lol.length;i++) {
			l.addAll(lol[i]);
		}
		ListIterator<String> iterator = l.listIterator();   // makes it all lower case
	    while (iterator.hasNext())
	    {
	        iterator.set(iterator.next().toLowerCase());
	    }
	    
	    Set<String> hs = new HashSet<String>();     //removes duplicates
	    hs.addAll(l);
	    l.clear();
	    l.addAll(hs);
	    
		return l;
		
	}
	
	public static List<String> remove_lowfreq(List<String>[] lol,List<String> l ,int f){
		List<String> x = new ArrayList<String>(); 
		for(int i =0;i<l.size();i++) {
			String key=l.get(i);
			int no_occ=0;
			for(int j=0;j<lol.length;j++) {
				no_occ+= Collections.frequency(lol[j], key);
			}
			if(no_occ>f) {
				x.add(key);
			}
				
		}
		
		return x;
		
	}
	public static List<String> remove_freq_range(List<String>[] lol,List<String> l ,int fl, int fu) throws Exception {
		//List<String> dict = new ArrayList<String>(); 	
	    String whole =readFile.Readfile("./data/words_alpha.txt");

	    List<String> dict = Arrays.asList(whole.split("\\s*\n\\s*"));
	    //System.out.println(dict.size());
		
		List<String> x = new ArrayList<String>(); 
		for(int i =0;i<l.size();i++) {
			String key=l.get(i);
			int no_occ=0;
			for(int j=0;j<lol.length;j++) {
				no_occ+= Collections.frequency(lol[j], key);
			}
			if(no_occ>=fl && no_occ<=fu && ! dict.contains(key)) {
				x.add(key);
			}
				
		}
		
		return x;
		
	}
}

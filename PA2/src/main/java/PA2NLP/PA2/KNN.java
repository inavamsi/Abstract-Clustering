package PA2NLP.PA2;

import java.util.Arrays;
import java.util.HashMap;

public class KNN {
	
	public static int[] normalKNN(float[][] matrix, float[][]matrixt,int k) {
		int[] closest= new int[matrixt.length];
		for(int i=0;i<matrixt.length;i++) {
			closest[i]=mode(klist(matrixt[i],matrix,k));
			
		}
		
		
		return closest;
	}
	
	public static String[] fuzzyKNN(float[][] matrix, float[][]matrixt,int k) {
		String[] closest= new String[matrixt.length];
		for(int i=0;i<matrixt.length;i++) {
			int[] temp=klist(matrixt[i],matrix,k);
			int one=0;
			int seven=0;
			int four=0;
			for(int j=0;j<temp.length;j++) {
				if(temp[j]==1) {
					one+=1;
				}
				else if(temp[j]==7) {
					seven+=1;
				}
				else {
					four+=1;
				}
			}
			closest[i]=" C1: "+ 100*one/temp.length +" % ,  C4: "+ 100*four/temp.length +" % ,  C7: "+100*seven/temp.length +" %";
			
		}
		
		
		
		
		return closest;
	}
	
	
	static int[] klist(float[] vector, float[][] mean,int k) {
		float[] distances = new float[mean.length];
		for(int i=0;i<mean.length;i++) {
			distances[i]=cosine_distance(vector,mean[i]);
		}
		int[] listofk= indexesOfTopElements(distances,k);
		for(int i=0;i<listofk.length;i++) {
			if(listofk[i]<8) {
				listofk[i]=1;
			}
			else if(listofk[i]<16) {
				listofk[i]=4;
			}
			else {
				listofk[i]=7;
			}
		}
		return listofk;
	}
	
	static int[] indexesOfTopElements(float[] orig, int nummax) {
        float[] copy = Arrays.copyOf(orig,orig.length);
        Arrays.sort(copy);
        float[] honey = Arrays.copyOfRange(copy,0, nummax);
        int[] result = new int[nummax];
        int resultPos = 0;
        for(int i = 0; i < orig.length; i++) {
            float onTrial = orig[i];
            int index = Arrays.binarySearch(honey,onTrial);
            if(index < 0) continue;
            result[resultPos++] = i;
        }
        return result;
    }
	
	public static float euclidean_distance(float[] v1, float[]v2) {
		float distance =0;
		for(int i =0;i<v1.length;i++) {
			
			float diff=v1[i]*v1[i]-v2[i]*v2[i];
			distance+=Math.abs(diff);
		}
		
		return distance;
		
	}
	public static float cosine_distance(float[] v1, float[]v2) {
		double distance =0;
		double v1_sq=0;
		double v2_sq=0;
		double dot=0;
		for(int i =0;i<v1.length;i++) {
			v1_sq+=v1[i]*v1[i];
			v2_sq+=v2[i]*v2[i];
			dot+=v1[i]*v2[i];
			
		}
		v1_sq=Math.sqrt(v1_sq);
		v2_sq= Math.sqrt(v2_sq);
		distance=dot/(v1_sq*v2_sq);
		return (float) (1 - distance);
		
	}
	
	public static int mode(int[] n)
	{
	    Arrays.sort(n);
	    
	    int count2 = 0;
	    int count1 = 1;
	    int pupular1 =0;
	    int popular2 =0;


	    for (int i = 0; i < n.length; i++)
	    {
	            pupular1 = n[i];
	            count1 = 0;    //see edit

	        for (int j = i + 1; j < n.length; j++)
	        {
	            if (pupular1 == n[j]) count1++;
	        }

	        if (count1 > count2)
	        {
	                popular2 = pupular1;
	                count2 = count1;
	        }

	        else if(count1 == count2)
	        {
	            popular2 = Math.min(popular2, pupular1);
	        }
	    }

	    return popular2;
	}
}

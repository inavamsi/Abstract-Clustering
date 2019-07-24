package PA2NLP.PA2;

public class Confusion {
	
	public static int[][] confusion_matrix(int[] pred, int[] actual){
		int[][] cm = new int[3][3];
		for(int i=0;i<pred.length;i++) {
			if(pred[i]==actual[i]) {
				if(pred[i]==1) {
					cm[0][0]+=1;
				}
				else if(pred[i]==4){
					cm[1][1]+=1;
				}
				else {
					cm[2][2]+=1;
				}
			}
			else {
				if(actual[i]==4) {
					if(pred[i]==1) {
						cm[1][0]+=1;
					}
					else {
						cm[1][2]+=1;
					}
				}
				else if(actual[i]==7) {
					if(pred[i]==1) {
						cm[2][0]+=1;
					}
					else {
						cm[2][1]+=1;
					}
				}
				else {
					if(pred[i]==7) {
						cm[0][2]+=1;
					}
					else {
						cm[0][1]+=1;
					}
				}
			}
		}
		return cm;
		
	}

}

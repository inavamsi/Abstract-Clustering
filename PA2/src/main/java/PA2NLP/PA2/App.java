package PA2NLP.PA2;




import java.util.*;
import java.io.PrintWriter;

public class App 
{
		  public static void main(String[] args) throws Exception {
			  	
			  
			    String prefix ="./data/ALS_test/";
			    String[] fileNames = {"paper01","paper02","paper03","paper04","paper05","paper06"};
			    //String[] fileNames = {"C1/article01","C1/article02","C1/article03","C1/article04","C1/article05","C1/article06","C1/article07","C1/article08","C4/article01","C4/article02","C4/article03","C4/article04","C4/article05","C4/article06","C4/article07","C4/article08","C7/article01","C7/article02","C7/article03","C7/article04","C7/article05","C7/article06","C7/article07","C7/article08"};
			    //String[] testFiles = {"T/unknown01.txt","T/unknown02.txt","T/unknown03.txt","T/unknown04.txt","T/unknown05.txt","T/unknown06.txt","T/unknown07.txt","T/unknown08.txt","T/unknown09.txt","T/unknown10.txt"};
			    //int[] actual= {1,1,1,1,4,4,7,7,4,1};
			    
			    
			    Integer clusters=5;
			    Integer threshold_frequency=3;//fileNames.length;
			    int choice =1;  ///choose 1 for cosine distance, 2 for euclidean distance
			    //Integer ngram_frequency =2;
			    
			    List<String> x = new ArrayList<String>(); 	
			    int size=fileNames.length;
			    
			    
			    //for(int i=0;i<size;i++) {
			    //	x.add(readFile.Readfile(prefix+fileNames[i]+".txt"));
			    //}
			    
			    x.add("Amyotrophic Lateral Sclerosis (ALS) is a fatal neurodegenerative disease characterized by the progressive loss of motor neurons. While several inherited pathogenic mutations have been identified as causative, the vast majority of cases are sporadic with no family history of disease. Thus, for the majority of ALS cases, a specific causal abnormality is not known and the disease may be a product of multiple inter-related pathways contributing to varying degrees in different ALS patients. Using unsupervised machine learning algorithms, we stratified the transcriptomes of 148 ALS decedent cortex tissue samples into three distinct and robust molecular subtypes. The largest cluster, identified in 61% of patient samples, displayed hallmarks of oxidative and proteotoxic stress. Another 20% of the ALS patient samples exhibited high levels of retrotransposon expression and other signatures of TDP-43 dysfunction. Finally, a third group showed predominant signatures of glial activation (19%). Together these results demonstrate that at least three distinct molecular signatures contribute to ALS disease. While multiple dysregulated components and pathways comprising these clusters have previously been implicated in ALS pathogenesis, unbiased analysis of this large survey demonstrated that sporadic ALS patient tissues can be segregated into distinct molecular subsets.");
			    x.add("Background: Amyotrophic lateral sclerosis (ALS) is a progressive fatal disease with a varying range of clinical characteristics. Objective: To describe the clinical characteristics in a large cohort of ALS participants enrolled in the National ALS Registry. Methods: Data from ALS participants who completed the Registry’s online clinical survey module during 2010–2015 were analyzed to determine characteristics, such as site of onset, associated symptoms, time of symptom onset to diagnosis, time of diagnosis to hospice referral, and pharmacological and non-pharmacological interventions. Results: Of the 1758 participants who completed the survey, 60.9% were male, 62.1% were 50–69 years old, and 95.5% white. Approximately, 72.0% reported initial limb weakness onset of disease, followed by bulbar (22.1%), and trunk/global onset (6.1%). Other symptoms ever experienced included cramps (56.7%), fasciculations (56.3%), and dysarthria (33.0%). The median time between an increase of muscle cramps until an ALS diagnosis was 12 months; limb onset participants had cramps longer preceding diagnosis versus those with bulbar onset. The most frequent interventions used included riluzole (48.3% currently using), wheelchairs/scooters (32.8%), and noninvasive breathing equipment (30.0%). Participants with trunk/global onset were referred to hospice almost four times earlier than others. Conclusions: These data show how ALS clinical characteristics differ widely in a large cohort of participants preceding diagnosis and reflect variations in disease onset, progression, and prognosis. Better characterization of symptom onset may assist clinicians in diagnosing ALS sooner, which could lead to earlier therapeutic interventions.");
			    x.add("Amyotrophic lateral sclerosis (ALS), commonly known as Lou Gehrig’s disease, is a progressive and fatal neuromuscular disease; the majority of ALS patients die within 2–5 years of receiving a diagnosis (1). Familial ALS, a hereditary form of the disease, accounts for 5%–10% of cases, whereas the remaining cases have no clearly defined etiology (1). ALS affects persons of all races and ethnicities; however, whites, males, non-Hispanics, persons aged ≥60 years, and those with a family history of ALS are more likely to develop the disease (2). No cure for ALS has yet been identified, and the lack of proven and effective therapeutic interventions is an ongoing challenge. Treatments currently available, Edaravone and Riluzole, do not cure ALS, but slow disease progression in certain patients (3,4). This report presents National ALS Registry findings regarding ALS prevalence in the United States for the period January 1–December 31, 2015. In 2015, the estimated prevalence of ALS cases was 5.2 per 100,000 population with a total of 16,583 cases identified. Overall, these findings are similar to the 2014 ALS prevalence and case count (5.0 per 100,000; 15,927 cases) (2). Prevalence rates by patient characteristics (most common in whites, males, and persons aged ≥60 years) and U.S. Census regions are consistent with ALS demographics and have not changed from 2014 to 2015 calendar years. The algorithm used to identify cases from national administrative databases was updated from the International Classification of Diseases, Ninth Revision (ICD-9) to the ICD-10 codes for claims starting on October 1, 2015, with no apparent effect on case ascertainment. Data collected by the National ALS Registry are being used to better describe the epidemiology of ALS in the United States and to facilitate research on the genetics, potential biomarkers, environmental pollutants, and etiology for ALS.");
			    x.add("Amyotrophic lateral sclerosis (ALS) is a neurodegenerative disease characterized by the premature death of motor neurons. In approximately 10% of the cases the disease is inherited as autosomal dominant trait (FALS). It has been found that mutations in the Cu/Zn superoxide dismutase gene (SOD1) are responsible for approximately 15% of FALS kindreds. We screened affected individuals from 70 unrelated FALS kindreds and identified 10 mutations, 6 of which are novel. Surprisingly, we have found a mutation in exon 3, which includes most of the active site loop and Zn2+ binding sites, a region where no previous SOD1 mutations have been found. Our data increase the number of different SOD1 mutations causing FALS to 55, a significant fraction of the 154 amino acids of this relatively small protein.");
			    x.add("Amyotrophic Lateral Sclerosis (ALS), the most common form among motoneuron diseases, is characterized by a progressive neurodegenerative process involving motor neurons in the motor cortex, brain stem and spinal cord. Sporadic (SALS) accounts for the majority of patients but in about 10% of ALS cases the disease is inherited (FALS), usually as an autosomal dominant trait. In the present study we show the results of a referred based multicenter study on the distribution of SOD1 gene mutations in the largest cohort of Italian ALS patients described so far. Two hundred and sixty-four patients (39 FALS and 225 SALS) of Italian origin were studied. In 7 out of 39 FALS patients we found the following SOD1 gene mutations: i) a new G12R missense mutation in exon 1, found in a patient with a slowly progressive disease course; ii) the G41S mutation, in four unrelated patients with rapidly progressive course complicated with cognitive decline in two of them; iii) the L114F mutation, in a patient with a slowly progressive phenotype; iv) the D90A mutation, in a heterozygous patient with atypical phenotype. In addition, in one SALS patient a previously reported synonymous variant S59S was identified. In 17 (3 FALS and 14 SALS) out of 264 patients (6.4 %) the polymorphism A-->C at position 34 of intron 3 (IVS3: + 34 A-->C) was found, and in one FALS patient a novel variant IVS3 + 62 T-->C was identified. The frequency of SOD1 gene mutations (17.9 %) in FALS cases was comparable with that found in other surveys with a similar sample size of ALS cases. No SOD1 gene mutations have been identified in SALS cases. Within FALS cases, The most frequent mutation was the G41S identified in four FALS.");
			    x.add("Amyotrophic lateral sclerosis (ALS) is as an adult-onset neurodegenerative disorder involving both upper and lower motor neurons. About 5% of all cases exhibit signs of frontotemporal degeneration (FTD). We established the mutation frequency of C9ORF72, SOD1, TARDBP, and FUS genes in 307 patients with sporadic ALS, 46 patients with familial ALS (FALS), and 73 patients affected with FTD, all originating from the northeastern part of Italy. C9ORF72 pathogenic expansion was found on 22% of familial ALS, 5% of sporadic ALS, and 14% of FTD patients, resulting the most frequently genetic determinant in our cohort. Sequence analysis of ALS cohort identified 2 novel variants on SOD1 (p.Glu41Gly) and FUS (p.Gly496Glyfs*31). Interestingly, the single base deletion on FUS was observed in an homozygous state, suggesting a recessive pattern of inheritance. No point mutations were identified on FTD cohort. Although useful to direct genetic testing, this study results expand the current knowledge of ALS genetics.");
			    x.add("Amyotrophic lateral sclerosis (ALS) is a paralytic disorder caused by degeneration of motor neurons in the brain and spinal cord. Identification of mutations in the gene for Cu,Zn superoxide dismutase (SOD1) in a subset of ALS families made it possible to develop a transgenic mouse model of ALS and to investigate its pathogenesis. These investigations suggest that mutant SOD1 acts through a toxic gain of function which may involve generation of free radicals. Conformational change in the mutant SOD1 protein, especially the distortion of the 'rim' of the electrostatic guidance channel may be central to this toxic gain of function and to the pathogenesis of ALS.");
			    x.add("Amyotrophic lateral sclerosis (ALS) is a fatal motor neuron disease, and the most common in European populations. Results of genetic analysis and mutation screening of SOD1 in a cohort of 60 Iranian ALS patients are here reported. Initially, linkage analysis in 4 families identified a disease-linked locus that included the known ALS gene, SOD1. Screening of SOD1 identified homozygous p.Asp90Ala causing mutations in all the linked families. Haplotype analysis suggests that the p.Asp90Ala alleles in the Iranian patients might share a common founder with the renowned Scandinavian recessive p.Asp90Ala allele. Subsequent screening in all the patients resulted in identification of 3 other mutations in SOD1, including p.Leu84Phe in the homozygous state. Phenotypic features of the mutation-bearing patients are presented. SOD1 mutations were found in 11.7% of the cohort, 38.5% of the familial ALS probands, and 4.25% of the sporadic ALS cases. SOD1 mutations contribute significantly to ALS among Iranians.");
			    x.add("Twelve cases of adult-onset progressive muscular atrophy variant of amyotrophic lateral sclerosis (PMA/ALS) were studied in a small rural population of 1500 in the Republic of Belarus (former Soviet Union). The patients were members of three apparently related kindreds, each showing autosomal dominant pattern of disease inheritance. The average age at clinical onset ranged from 26 to 57 years (mean, 40 years). Each patient suffered from skeletal muscle weakness and wasting, starting in the limbs and spreading to the trunk and neck, with very limited bulbar and no upper motor neuron involvement. Death from respiratory failure occurred from 13 to 48 months (mean, 28 months) after first symptoms. Dramatically decreased number of spinal motor neurons was the most characteristic neuropathologic feature in two autopsied cases. Most of the remaining degenerating neurons contained intracytoplasmic hyaline inclusion bodies. A D101N mutation in exon 4 of the SOD1 gene was identified in a PMA/ALS patient and in one of her three unaffected children. Our data support the view that some subtypes of familial ALS associated with SOD1 mutations may present as PMA. Diagnostic criteria of ALS should be accordingly modified to include the PMA variant of familial ALS.");
			    x.add("We performed a genetic analysis of the Cu/Zn superoxide dismutase gene (SOD1) in Spanish patients with sporadic or familial amyotrophic lateral sclerosis (ALS). We found mutations in 2 of 11 families (18%) with ALS. In addition, 1 of the 87 sporadic ALS patients studied harbored a mutation in the same gene. We identified G37R in exon 2 of the SOD1 gene in 1 family. Another patient, with sporadic ALS, showed a novel N65S in exon 3. In addition, we found a novel I112M in exon 4 in another family. Our data highlight the genetic heterogeneity of patients with ALS harboring mutations in the SOD1 gene and confirm that families with autosomal dominant inheritance of the trait, regardless of their ethnic background, are more likely to carry mutations in such a gene.");
			    x.add("We report a novel missense point mutation in exon 4 of the Cu/Zn superoxide dismutase (SOD) gene of affected members of a Japanese kindred segregating familial amyotrophic lateral sclerosis (FALS) through at least three successive generations. The mutation, which is predicted to cause the replacement of isoleucine at codon 104 by phenylalanine (I104F), is associated with a significant reduction in Cu/Zn SOD enzyme activity but results in a highly variable clinical phenotype. Age at onset varied from 6 to 55; the initial symptoms occurred in either the lower or upper extremities in different family members. The duration of the disease varied from 3 to 38 years. Two subjects, aged 59 and 34, remained asymptomatic until their death from other causes, although their offspring carrying the same mutation have already developed clinical evidence of the disease. These results suggest that FALS from this novel I104F mutation shows considerable clinical variation.");
			    x.add("Expansion mutations in the C9orf72 gene may cause amyotrophic lateral sclerosis (ALS), frontotemporal dementia (FTD), or mixtures of the two clinical phenotypes. Different imaging findings have been described for C9orf72-associated diseases in comparison with sporadic patients with the same phenotypes, but it is uncertain whether different phenotypes have a common genotype-associated imaging signature. To address this question, 27 unrelated C9orf72 expansion mutation carriers (C9 +) with varied phenotypes, 28 age-matched healthy controls and 22 patients with sporadic ALS (sALS) underwent 3T MRI scanning and clinical phenotyping. Measures of brain volumes and cortical thickness were extracted from T1 images. Compared to healthy controls and sALS patients, symptomatic C9 + subjects had greater ventricular volume loss and thalamic atrophy for age, with diffuse, patchy cortical thinning. Asymptomatic carriers did not differ from controls. C9 + ALS and ALS-FTD patients had less thinning of the motor cortex than sALS patients, but more thinning in extramotor regions, particularly in frontal and temporal lobes. C9 + ALS patients differed from sporadic ALS patients in the thickness of the superior frontal gyrus and lateral orbitofrontal cortex. Thickness of the precentral gyrus was weakly correlated with the revised ALS functional rating scale. Thickness of many cortical regions, including several frontal and temporal regions, was moderately correlated with letter fluency scores. Letter fluency scores were weakly correlated with ventricular and thalamic volume. To better understand how imaging findings are related to disease progression, nineteen C9 + subjects and 23 healthy controls were scanned approximately 6 months later. Ventricular volume increased in C9 + patients with FTD and ALS-FTD phenotypes and remained stable in asymptomatic C9 + subjects. We conclude that diffuse atrophy is a common underlying feature of disease associated with C9orf72 mutations across its clinical phenotypes. Ventricular enlargement can be measured over a 6-month time frame, and appears to be faster in patients with cognitive impairment.");
			    x.add("Objective: Determine the feasibility of developing a biorepository linked to the National ALS Registry. Background: To enhance the National ALS Registry, the Agency for Toxic Substances and Disease Registry (ATSDR) coordinated a pilot study to find the best way to collect and store biological samples for future ALS related research. Design/Methods: This study included two specimen collection components: 1) in-home collection of blood, urine, hair, and nail, on two occasions approximately six months apart; and 2) postmortem collection of brain, spinal cord, CSF, bone, muscle, and skin; participants could do both. The combination of these components allows a thorough evaluation of the challenges associated with assembling a national, population-based biorepository. Eligible participants must have enrolled in the National ALS Registry and consented to be contacted about research projects. Results: Three hundred and thirty-nine people consented from all 50 states to donate biological specimens and 330 provided specimens at least once. Approximately 18[percnt] of participants did not complete the second draw due mostly to death and illness. Participants’ ages ranged from 31-87 years and 60[percnt] were male. Fifty-four percent of participants lived 50 or more miles from an ALS specialty/referral center. Thirty people consented to postmortem tissue donation from 18 states. Fifteen donations have been completed. The first 11 cases all showed neuropathologically-confirmed ALS with TDP-43 inclusions with a mean age of 66 years (range: 43-76), 55[percnt] female, and mean brain weight of 1260g. The average length of time from study consent to death was eight months. Discussion/Conclusions: Creating a geographically diverse biorepository has unique challenges. However, based on expert input, ATSDR determined that it is feasible to incorporate a biorepository into the National ALS Registry. These specimens will be a valuable resource for researchers who will be able to request specimens for ALS studies. Study Supported by: ATSDR contract #200-2011-40830");
			    x.add("Amyotrophic Lateral Sclerosis (ALS, Lou Gehrig's disease), is a rapidly fatal motor neuron disease (MND) that causes progressive degeneration in both the upper and lower motor neurons. The ALS Registry Act, passed in 2008, created the National ALS Registry in order to better describe the prevalence and incidence of ALS in the United States. We identified ALS cases from the years 2001 � 2005 in national health databases (Centers for Medicare and Medicaid Services (CMS), Veterans Health Administration (VHA) and Veterans Benefits Administration (VBA)) using an algorithm developed through a group of pilot projects We found 16,226 individuals who definitely had ALS, and an additional 22,096 individuals who possibly had ALS. We compared these two groups of with the National Death Index (NDI) [2001-2008] to determine their vital status, as well as to determine if those identified as possibly having ALS could be classified as definite ALS cases and verify the vital status of the definite cases. 12,393 definite ALS cases, were deceased by the end of 2008. Of the possible ALS cases, 14,588 were deceased. The death certificate of 9,227 (63%) possible cases mentioned MND and provided enough additional information allow classification as definite ALS cases. Using the national databases and the NDI we identified a total of 25,453 ALS cases during 2001 � 2005. The use of NDI to supplement the national health databases resulted in an increase of more than 50% in the number of definite cases of ALS identified in 2001 � 2005.");
			    x.add("The ratio of the length of the index finger (2D) to the ring finger (4D) (2D:4D) has been reported to be lower (ie, 2D<4D) in people with amyotrophic lateral sclerosis (ALS) than non-ALS controls. This has led to suggestions that exposure to increased prenatal testosterone, which also lowers this ratio, could be a risk factor for ALS. In an attempt to test this hypothesis, we examined 2D:4Ds from large numbers of patients with ALS and controls.");
			    x.add("Amyotrophic lateral sclerosis (ALS) is a late-onset fatal neurodegenerative disease affecting motor neurons with an incidence of about 1/100,000. Most ALS cases are sporadic, but 5–10% of the cases are familial ALS. Both sporadic and familial ALS (FALS) are associated with degeneration of cortical and spinal motor neurons. The etiology of ALS remains unknown. However, mutations of superoxide dismutase 1 have been known as the most common cause of FALS. In this study, we provide a comprehensive review of ALS. We cover all aspects of the disease including epidemiology, comorbidities, environmental risk factor, molecular mechanism, genetic factors, symptoms, diagnostic, treatment, and even the available supplement and management of ALS. This will provide the reader with an advantage of receiving a broad range of information about the disease.");
			  	
			    size=x.size();
			  	List<String>[] ListofLists = new List[size];
			  	ListofLists=Preprocess.Start(x,size);
			  	System.out.println("0");
			  	List<String> merged = new ArrayList<String>();
			  	List<String> mergedf = new ArrayList<String>();
			  	List<String> mergedr = new ArrayList<String>();
			  	merged=Merge.removeDuplicates(ListofLists);
			  	//mergedr=Merge.remove_freq_range(ListofLists, merged, 1,1);
			  	//System.out.println(mergedr);
			  	mergedf=Merge.remove_lowfreq(ListofLists, merged, threshold_frequency);
			  	float[][] matrix = new float[size][mergedf.size()];
			  	matrix=Matrix.makedocm(mergedf,ListofLists);
			  	System.out.println("1");
			  	//System.out.println(mergedf);
			  	
			  	//==============================================================================
			  	/*
			    Integer k=5;
			  	List<String> xt = new ArrayList<String>(); 	
			    int sizet=testFiles.length;
			    
			    for(int i=0;i<sizet;i++) {
			    	xt.add(readFile.Readfile(prefix+testFiles[i]));
			    }
			  	List<String>[] ListofListst = new List[sizet];
			  	ListofListst=Preprocess.Start(xt,sizet);
			  	int[] freq = Matrix.dfreq(mergedf,ListofLists,matrix);
			  	float[][] matrixt = new float[sizet][mergedf.size()];
			  	matrixt=Matrix.makedocm_test(mergedf,ListofListst,freq);
			  	
			  	System.out.println("");
			  	System.out.println(" k value chosen : "+k);
			  	System.out.println("");
			  	
			  	int[] clusterize = KNN.normalKNN(matrix,matrixt,k);
			  	for(int g=0;g<clusterize.length;g++) {
			  		System.out.println(testFiles[g]+" belongs to Cluster : " +clusterize[g]);
			  	}
			  	System.out.println("");
			  	System.out.println("Fuzzy Clustering : ");
			  	String[] fclusterize = KNN.fuzzyKNN(matrix,matrixt,k);
			  	for(int g=0;g<fclusterize.length;g++) {
			  		System.out.println(testFiles[g]+" :  "+fclusterize[g]);
			  	}
			  	System.out.println("");
			  	System.out.println("Confusion Matrix : ");
			  	System.out.println("    Predicted     C1  C4  C7 : ");
			  	int [][] cm=Confusion.confusion_matrix(clusterize,actual);
			  	for(int i=0;i<3;i++) {
			  		if(i==0) {
		  				System.out.print("Actual Cluster 1 : ");
		  			}
		  			if(i==1) {
		  				System.out.print("Actual Cluster 4 : ");
		  			}
		  			if(i==2) {
		  				System.out.print("Actual Cluster 7 : ");
		  			}
			  		for(int j=0;j<3;j++) {
			  			
			  			System.out.print(cm[i][j]);
			  			System.out.print("   ");
			  		}
			  		System.out.println("");
			  	}
			  	
			  	float p=0;
			  	float r=0;
			  	float[] tp =new float[3];
			  	float[] tc =new float[3];
			  	
			  	for(int i=0;i<3;i++) {
			  		for(int j=0;j<3;j++) {
			  			tp[i]+=(float)cm[j][i];
			  			tc[i]+=(float)cm[i][j];
			  		}
			  		
			  	}
			  	for(int i=0;i<3;i++) {
			  		p+=cm[i][i]/tp[i];
			  		r+=cm[i][i]/tc[i];
			  	}
			  	p=p/3;
			  	r=r/3;
			  	
			  	float f = 2*p*r/(p+r);
			  	System.out.println("Precision : "+p);
			  	System.out.println("Recall : "+r);
			  	System.out.println("F measure : "+f);
			  	
			  	
			  	/*
			  	for(int a=0;a<sizet;a++){
			  		for(int b=0;b<mergedf.size();b++) {
			  			System.out.print(matrixt[a][b]+" ");
			  		}
			  		System.out.println("");
			  	}
			  	
			  	*/
			  	
			  	
			  	
			  	//Preprocess.twogram(3,ListofLists,Merge.remove_lowfreq(ListofLists, merged, ngram_frequency));
			  	//Preprocess.threegram(2,ListofLists,Merge.remove_lowfreq(ListofLists, merged, ngram_frequency));
			  	List<String> mergedtoprint = new ArrayList<String>();
			  	mergedtoprint=Merge.remove_lowfreq(ListofLists, merged, 3);
			  	PrintWriter writer = new PrintWriter("topics.txt", "UTF-8");
			  	for(int i=0;i<mergedtoprint.size();i++) {
			  		writer.println(mergedtoprint.get(i));
			  	}
			  	writer.close();
			  	//float[][] matrix = new float[size][mergedf.size()];
			  	//matrix=Matrix.makedocm(mergedf,ListofLists);
			  	
			  	csv.write(matrix, mergedf);
			  	System.out.println();
			  	
			  	String d="";
			  	if(choice==1)
			  		d="cosine";
			  	else
			  		d="euclidean";
			  	System.out.println("Distance Metric selected: "+d);
			  	System.out.println("Total clusters selected: "+clusters);
			  	System.out.println();
			  	
			  	int[][] clustered_sets = new int[clusters][size];
			  	clustered_sets = kmeanspp.cluster(matrix,clusters,choice);
			  	System.out.println("Kmeans++ ");
			  	for(int j=0;j<clusters;j++) {
			  		System.out.print("cluster"+j+" : ");
				  	for(int i=0;i<size;i++){
				  		int key=clustered_sets[j][i];
				  		if(key!=-1)
				  	    System.out.print(key+"  ");
				  	} 
				  	System.out.println();
			  	}
			  	System.out.println();
			  	System.out.println();
			  	System.out.println();
			  	clustered_sets = kmeans.cluster(matrix,clusters);
			  	System.out.println("Kmeans ");
			  	for(int j=0;j<clusters;j++) {
			  		System.out.print("cluster"+j+" : ");
				  	for(int i=0;i<size;i++){
				  		int key=clustered_sets[j][i];
				  		if(key!=-1)
				  	    System.out.print(key+"  ");
				  	} 
				  	System.out.println();
			  	}
			  	System.out.println();
		        
		        
		        
		  }
}
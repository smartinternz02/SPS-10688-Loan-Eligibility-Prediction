package org2.ml;

import java.io.IOException;

import java.util.*;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.StringToNominal;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;
import tech.tablesaw.columns.Column;
import tech.tablesaw.table.Relation;
import tech.tablesaw.table.TableSliceGroup;
import tech.tablesaw.columns.AbstractColumn;
import tech.tablesaw.*;
import tech.tablesaw.columns.strings.*;
import tech.tablesaw.aggregate.*;

public class DataAnalysis {
	private static final Instances NumericToNominal = null;
	private static TableSliceGroup i;

	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception
	{

	try {
		Table loan_data=Table.read().csv("D:\\eclipsepractice\\org2.ml\\src\\main\\java\\org2\\ml\\train_u6lujuX_CVtuZ9i.csv");	
		System.out.println(loan_data.shape());
		System.out.println(loan_data.structure());
		System.out.println(loan_data.missingValueCounts());
//create a column of loanamount_log
		 loan_data.addColumns(DoubleColumn.create("LoanAmount_log",loan_data.nCol("LoanAmount").log1p().asDoubleArray()));
		//for filling the missing values of gender using mode
		 int x=loan_data.column("Gender").size();
		 String maxnumber="";
		 int maxappearance=-1;
		 for(int i=0;i<x;i++)
		 {
			 int count=0;
			 for(int j=0;j<x;j++)
			 {
				 if(loan_data.column("Gender").get(i)==loan_data.column("Gender").get(j))
				 {
					 count++;
				 }
			 }
			 if(count>maxappearance)
			 {
				 maxnumber=(String)loan_data.column("Gender").get(i);
				 maxappearance=count;
			 }
		 }
		 Column col = loan_data.column("Gender");
		 System.out.println("the mode of Gender is "+maxnumber);
		 col.set(col.isMissing(), maxnumber);
	 System.out.println(loan_data.missingValueCounts());
		 
		 
		 
			//for filling the missing values of Married using mode
		 int n=loan_data.column("Married").size();
		 String Marriedmaxnumber="";
		 int Marriedmaxappearance=-1;
		 for(int i=0;i<n;i++)
		 {
			 int count=0;
			 for(int j=0;j<n;j++)
			 {
				 if(loan_data.column("Married").get(i)==loan_data.column("Married").get(j))
				 {
					 count++;
				 }
			 }
			 if(count>Marriedmaxappearance)
			 {
				 Marriedmaxnumber=(String)loan_data.column("Married").get(i);
				 Marriedmaxappearance=count;
			 }
		 }
		 Column col1 = loan_data.column("Married");
		 System.out.println("the mode of Married is "+Marriedmaxnumber);
		 col1.set(col1.isMissing(), Marriedmaxnumber);
		 System.out.println(loan_data.missingValueCounts());
		 
		 
			//for filling the missing values of Dependents using mode
		 int n1=loan_data.column("Dependents").size();
		 String Dependentsmaxnumber="";
		 int Dependentsmaxappearance=-1;
		 for(int i=0;i<n1;i++)
		 {
			 int count=0;
			 for(int j=0;j<n1;j++)
			 {
				 if(loan_data.column("Dependents").get(i)==loan_data.column("Dependents").get(j))
				 {
					 count++;
				 }
			 }
			 if(count>Dependentsmaxappearance)
			 {
				 Dependentsmaxnumber=(String)loan_data.column("Dependents").get(i);
				 Dependentsmaxappearance=count;
			 }
		 }
		 Column col2 = loan_data.column("Dependents");
		 System.out.println("the mode of Dependents is"+Dependentsmaxnumber);
		 col2.set(col2.isMissing(), Dependentsmaxnumber);
		 System.out.println(loan_data.missingValueCounts());
		 
		 
		 
			//for filling the missing values of Dependents using mode
		 int n2=loan_data.column("Self_Employed").size();
		 String Self_Employedmaxnumber="";
		 int Self_Employedmaxappearance=-1;
		 for(int i=0;i<n2;i++)
		 {
			 int count=0;
			 for(int j=0;j<n2;j++)
			 {
				 if(loan_data.column("Self_Employed").get(i)==loan_data.column("Self_Employed").get(j))
				 {
					 count++;
				 }
			 }
			 if(count>Self_Employedmaxappearance)
			 {
				 Self_Employedmaxnumber=(String)loan_data.column("Self_Employed").get(i);
				 Self_Employedmaxappearance=count;
			 }
		 }
		 
		 Column col3 = loan_data.column("Self_Employed");
		 System.out.println("the mode of Self_Employed is "+Self_Employedmaxnumber);
		 col3.set(col3.isMissing(), Self_Employedmaxnumber);
		 System.out.println(loan_data.missingValueCounts());
		 
		 //for filling the missing values of LoanAmount using mean
		 Column col4 = loan_data.column("LoanAmount");
		 col4.set(col4.isMissing(),(int) loan_data.nCol("LoanAmount").mean());
		 System.out.println(loan_data.structure());
		 System.out.println(loan_data.missingValueCounts());
		 //for filling the missing value of loanamount_log
		 Column col5 = loan_data.column("LoanAmount_log");
		 col5.set(col5.isMissing(),(double) loan_data.nCol("LoanAmount_log").mean());
		 
		 
		//for filling the missing values of Dependents using mode
		 int n3=loan_data.column("Loan_Amount_Term").size();
		 Integer maxnumber1=-1;
		 int maxappearance1=-1;
		 for(int i=0;i<n3;i++)
		 {
			 int count1=0;
			 for(int j=0;j<n3;j++)
			 {
				 if(loan_data.column("Loan_Amount_Term").get(i)==null)
				 {
					 break;
				 }
				 else if(loan_data.column("Loan_Amount_Term").get(j)==loan_data.column("Loan_Amount_Term").get(i))
				 {
					 count1=count1+1;
					 
				 }
				 
			 }
			 if(count1>maxappearance1)
			 {
				 maxappearance1=count1;
				 
				 maxnumber1=(Integer) loan_data.column("Loan_Amount_Term").get(i);
				 
			 }
			
		 }
		 
		 
		 Column col6 = loan_data.column("Loan_Amount_Term");
		 System.out.println("the mode of Loan_Amount_Term is "+maxnumber1);
		 col6.set(col6.isMissing(), maxnumber1);
		 System.out.println(loan_data.missingValueCounts());
		 

		 
		 int n4=loan_data.column("Credit_History").size();
		 Integer maxnumber2=-1;
		 int maxappearance2=-1;
		 for(int i=0;i<n4;i++)
		 {
			 int count1=0;
			 for(int j=0;j<n4;j++)
			 {
				 if(loan_data.column("Credit_History").get(i)==null)
				 {
					 break;
				 }
				 else if(loan_data.column("Credit_History").get(j)==loan_data.column("Credit_History").get(i))
				 {
					 count1=count1+1;
				
				 }
				 
			 }
			 if(count1>maxappearance2)
			 {
				 maxappearance2=count1;
				 
				 maxnumber2=(Integer) loan_data.column("Credit_History").get(i);
				 
			 }
			
		 }
		 
		 
		 Column col7 = loan_data.column("Credit_History");
		 System.out.println("the mode of Credit_History is "+maxnumber2);
		 col7.set(col7.isMissing(), maxnumber2);
		 System.out.println(loan_data.missingValueCounts());
//		total income of applicant and co applicant
 loan_data.addColumns(DoubleColumn.create("TotalIncome",loan_data.nCol("ApplicantIncome").add(loan_data.nCol("CoapplicantIncome")).asDoubleArray()));//log10().asDoubleArray()

 //normalization of total income
 loan_data.addColumns(DoubleColumn.create("TotalIncome_log",loan_data.nCol("TotalIncome").log1p().asDoubleArray()));
	System.out.println(loan_data.structure());
	
//	Layout layout=Layout.builder().title("TotalIncome_log").build();
//	HistogramTrace trace1=HistogramTrace.builder(loan_data.nCol("TotalIncome_log")).build();
//	Plot.show(new Figure(layout,trace1));
loan_data.removeColumns("Dependents");
loan_data.removeColumns("ApplicantIncome");
loan_data.removeColumns("CoapplicantIncome");
loan_data.removeColumns("LoanAmount");
loan_data.removeColumns("Loan_Amount_Term");
loan_data.removeColumns("LoanAmount_log");
loan_data.removeColumns("TotalIncome");
loan_data.removeColumns("TotalIncome_log");


  

	System.out.println(loan_data.missingValueCounts());
	System.out.println(loan_data.print());
	loan_data.write().csv("D:\\eclipsepractice\\org2.ml\\src\\main\\java\\org2\\ml\\final.csv");
    
	}
	catch(IOException e) {
		e.printStackTrace();
	}

	}
}

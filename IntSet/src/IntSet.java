import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class IntSet {
	private int size;
	Scanner input = new Scanner(System.in);
	private int []set;
	private IntSet(){}
	private IntSet(int id){
		int []arr;
		System.out.println("Enter number of value to insert in set "+id+": ");
		int n=input.nextInt();
		arr=new int[n];
		System.out.println("Enter "+n+" values:\n");
		for(int i=0;i<n;i++){
			arr[i]=input.nextInt();
		}
		arrToSet(arr, arr.length);
	}
	//array to set
	private void arrToSet(int []arr,int n){
		//array to set
		int j=0;
		Arrays.sort(arr);
		set=new int[n];
		for(int i=0;i<n-1;i++){
			if(arr[i]!=arr[i+1]){
				set[j++]=arr[i];
			}
		}
		set[j++]=arr[n-1];
		size=j;
	}	
	//display set
	private void showSet(){
		System.out.println("\nSet values:");
		for(int i=0;i<size;i++){
			System.out.print(set[i]+" ");
		}
		System.out.println("\n");
	}
	//check is member or not
	private boolean isMember(int val){
		boolean flag=false;
		for(int i=0;i<size;i++){
			if(val==set[i]){
				flag=true;
			}
		}
		return flag;
	}
	
	//union
	private void union(IntSet s1, IntSet s2){
		int []arr=new int[s1.size+s2.size];
		int len=s1.size+s2.size;
		for(int i=0;i<s1.size;i++){
			arr[i]=s1.set[i];
		}
		for(int i=0;i<s2.size;i++){
			arr[i+s1.size]=s2.set[i];
		}
		arrToSet(arr, s1.size+s2.size);

		System.out.println("\nUnion of sets: ");
	}
	//is sub array or not
	private static boolean isSubArray(int A[], int B[],int n, int m){
		int i = 0, j = 0; 
		while (i < n && j < m){
			if (A[i] == B[j]){
			i++; 
			j++;
			if (j == m) 
				return true; 
			}
			else{ 
				i = i - j + 1; 
				j = 0; 
			} 
		} 
		return false; 
	}
	
	//get compliment
	private void getComplement(){
		int []arr=new int[10];
		int j=0,flag=0,k;
		for(int i=0;i<10;i++){
			flag=0;
			for(k=0;k<set.length;k++){
				if(i==set[k]){
					flag=1;
				}
			}
			if(flag==0){
				arr[j++]=i;
			}
		}
		System.out.println("\nCompliment of set-3 (U=1-10):");
		for(int i=0;i<j;i++){
			System.out.println(arr[i]+" ");
		}
		
	}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		IntSet s1 = new IntSet(1);
		s1.showSet();
		IntSet s2 = new IntSet(2);
		s2.showSet();
		
		//union
		IntSet s3 = new IntSet();
		s3.union(s1, s2);
		s3.showSet();
		//to check is member or not
		System.out.println("\nEnter value to check is member or not: ");
		System.out.println("Is Member: "+s3.isMember(input.nextInt()));
		//to check is sub array or not
		System.out.println("\nSet-1 is sub set of Set-3: "+IntSet.isSubArray(s3.set,s1.set,s3.size,s1.size));
		//complement of set-3
		s3.getComplement();

	}
	

}

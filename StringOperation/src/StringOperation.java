import java.util.Scanner;


public class StringOperation {
	Scanner in = new Scanner(System.in);
	String str;
	//input string
	private StringOperation(){
		System.out.println("Enter String: ");
		str = in.nextLine();
	}
	//Display String
	private void getString(){
		System.out.println(str);
	}
	//Comparing string
	private static int strCompare(StringOperation s1, StringOperation s2){
		int flag=1;
		if(s1.str.length()!=s2.str.length()){
			flag=0;
		}else{
			int len=s1.str.length();
			for(int i=0;i<len;i++){
				if(s1.str.charAt(i)!=s2.str.charAt(i)){
					flag=0;
					break;
				}
			}
		}
		return flag;
	}
	
	//reverse string
	private void reverse(){
		System.out.println("Reversed String: ");
		String s = "";
		int len=str.length();
		for(int i=len-1;i>=0;i--){
			s+=str.charAt(i);
		}
		str=s;
		getString();
	}
	//change case
	private void changeCase(String str){
		System.out.println("After changing case: ");
		String s = "";
		int len=str.length();
		for(int i=len-1;i>=0;i--){
			if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
				s+=(char)(str.charAt(i)+32);
			}else{
				s+=(char)(str.charAt(i)-32);
			}
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		StringOperation s1= new StringOperation();
		s1.getString();
		StringOperation s2= new StringOperation();
		s2.getString();
		//compare string
		if(StringOperation.strCompare(s1, s2)==1){
			System.out.println("Both string are equal !");
		}else{
			System.out.println("Both string are not equal !");
		}
		//reverse of s1
		s1.reverse();
		//change case
		s1.changeCase(s1.str);
		
		
	}

}

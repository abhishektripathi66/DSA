public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Main.openRussianDoll(10);
	}

	public static void openRussianDoll(int n){
		if(n==1) System.out.println("doll number is "+n);
		else{
			openRussianDoll(n-1);
			System.out.println("doll number is "+n);
		}
	}
}

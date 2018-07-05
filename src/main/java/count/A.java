package count;

public class A {
	public static void main(String[] args){

		out :for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 5){
					continue out;
				}
				System.out.println(j);
			}
		}


	}
}

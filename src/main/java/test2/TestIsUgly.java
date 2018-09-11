package test2;

public class TestIsUgly {
	public static void main(String[] args){
		long l = System.currentTimeMillis();
		System.out.println(GetUglyNumber_Solution1(1000000));
		System.out.println(System.currentTimeMillis()-l);
	}
	public static boolean IsUgly(int number) {
		int i = number;
		while (number % 2 == 0)

			number /= 2;

		while (number % 3 == 0)

			number /= 3;

		while (number % 5 == 0)

			number /= 5;
 		boolean b = number == 1;
 		if (b){
			System.out.println(i);
		}
		return b;

	}

	public static int GetUglyNumber_Solution1(int index) {

		if (index <= 0)
			return 0;
		int number = 0;
		int uglyFound = 0;
		while (uglyFound < index) {
			++number;
			if (number == Integer.MAX_VALUE){
				System.out.println(uglyFound);
				return number;
			}
			if (IsUgly(number)) {
				++uglyFound;
			}
		}
		System.out.println(uglyFound);
		return number;
	}

	public static int GetUglyNumber_Solution2(int index){
		int i = 1;
		int _2Max = 2;
		int _3Max = 3;
		int _5Max = 5;
		int[] num = new int[index];
		int p = 1;
		num[0] = 1;
		while (p < index){



		}
		return 0;
	}



	public static int min(int number1, int number2, int number3)

	{

		int min = (number1 < number2) ? number1 : number2;

		min = (min < number3) ? min : number3;


		return min;

	}
}

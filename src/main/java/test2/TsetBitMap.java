package test2;

public class TsetBitMap {
	public static final int _1MB = 129;
	//每个byte记录8bit信息,也就是8个数是否存在于数组中
	public static byte[] flags = new byte[_1MB];


	public static void main(String[] args) {
		//待判重数据
		int[] array = {255, 1024, 0, 1024, 255, 1, 2, 3, 4, 5, 6, 7,7 ,8,9,10,11,12,13,14,16,15};

		int index = 0;
		for (int num : array) {
			if (!getFlags(num)) {
				//未出现的元素
				index = index + 1;
				//设置标志位
				setFlags(num);
				System.out.println("set " + num);
				System.out.println();
			} else {
				System.out.println(num + " already exist");
			}
		}
		for (int i = 0; i < array.length; i++) {

			int a = flags[array[i] >> 3];
			System.out.println("i = " + i + ",array[i]=" + array[i] + ",num >> 3 = " + (array[i] >> 3) + ",flags[num >> 3]=" + a + ",toBinary=" + Integer.toBinaryString(a));
		}
	}

	public static void setFlags(int num) {
		System.out.println("========set==========");
		//使用每个数的低三位作为byte内的映射
		//例如: 255 = 0x11111111
		//低三位(也就是num & (0x07))为0x111 = 7, 则byte的第7位为1, 表示255已存在
		System.out.println("num= " + num + " ,toBinary = " + Integer.toBinaryString(num));
		System.out.println("num >> 3 = " + (num >> 3) + " ,toBinary = " + Integer.toBinaryString((num >> 3)));
		System.out.println("num & (0x07) = " + (num & (0x07)) + " ,toBinary = " + Integer.toBinaryString((num & (0x07))));
		System.out.println("0x01 << (num & (0x07)) = " + (0x01 << (num & (0x07))) + " ,toBinary = " + Integer.toBinaryString((0x01 << (num & (0x07)))));
		flags[num >> 3] |= 0x01 << (num & (0x07));
		System.out.println("flags[num >> 3] = " + flags[num >> 3]);
		System.out.println("========set==========");

	}

	public static boolean getFlags(int num) {
		System.out.println("========get==========");
		System.out.println("num= " + num + " ,toBinary = " + Integer.toBinaryString(num));
		System.out.println("num >> 3 = " + (num >> 3) + " ,toBinary = " + Integer.toBinaryString((num >> 3)));
		System.out.println("(num & (0x07)) = " + (num & (0x07)) + " ,toBinary = " + Integer.toBinaryString((num & (0x07))));
		System.out.println("(flags[num >> 3] >> (num & (0x07)) & 0x01) = " + ((flags[num >> 3] >> (num & (0x07)) & 0x01)) + " ,toBinary = " + Integer.toBinaryString(((flags[num >> 3] >> (num & (0x07)) & 0x01))));
		System.out.println("(flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01 = " + ((flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01));
		System.out.println("========get==========");
		return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
	}
}

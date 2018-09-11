package test2;

public class TestBitMap {
	public static final int _1MB = 1024 * 1024;
	//每个byte记录8bit信息,也就是8个数是否存在于数组中
	public static byte[] flags = new byte[512 * _1MB];


	public static void main(String[] args) {
		//待判重数据
		int[] array = {254, 255, 253, 252, 251, 250, 249, 248, 247, 246, 245, 244, 243, 1024, 0, 65536, 255, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int index = 0;
		for (int num : array) {
			if (!getFlags(num)) {
				//未出现的元素
				array[index] = num;
				index = index + 1;
				//设置标志位
				setFlags(num);
			} else {
				System.out.println(num + " already exist");
			}
		}
		for (int i : array) {
			System.out.print(i+",");
		}
	}

	public static void setFlags(int num) {
		//使用每个数的低三位作为byte内的映射
		//例如: 255 = 0x11111111
		//低三位(也就是num & (0x07))为0x111 = 7, 则byte的第7位为1, 表示255已存在
		flags[num >> 3] |= 0x01 << (num & (0x07));
		System.out.println();
		System.out.println("set start");
		System.out.println(flags[num >> 3] + ":" + num + ":" +( num >> 3));
		System.out.println("set " + num);
		System.out.println("set end");
		System.out.println();
	}

	public static boolean getFlags(int num) {
		return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
	}
}

/**
 * @projectName: wz-component
 * @package: PACKAGE_NAME
 * @className: StringIntern
 * @description:
 * @author: zhi
 * @date: 2023/2/28
 * @version: 1.0
 */
public class StringIntern {

	public static void main(String[] args) {
		// 创建一个对象, 字符串常量池中
		String a = "hello";
		System.out.println(a.intern() == a); // true     intern返回字符串常量池引用

		// 创建两个对象, 字符串常量池   堆
		String b = new String("world_11"); // 此时 world_11 已经放入常量池中
		b.intern(); // 什么也不做, 返回字符串常量池引用
		String d = "world_11";     // 如果字符串常量池存在, 则直接引用 (返回b在常量池的引用)
		System.out.println(b.intern() == d); // true, 因为 b = new String("world") 在字符串常量池中也有一份
		System.out.println(b == d); // false, b 为堆中引用, d 为常量池中引用, 所以不相等
		System.out.println("----------------");

		// (显式)创建StringBuilder对象, 不会放入字符串常量池
		StringBuilder sb = new StringBuilder();
		sb.append("wang-aaa"); // 此时 wang-aaa 放入常量池中
		sb.append("bbb"); // 此时 bbb 放入常量池中
		String e = sb.toString(); // 调用 sb.toString() 在堆中创建, 不会放入字符串常量池; 此时常量池中没有wang-aaabbb
		e.intern(); // 如果只append一个: 这一步什么都不会做, 因为常量池中已经存在;   如果append多个, 这一步会放入常量池中
		String f = "wang-aaabbb"; // 在常量池中
		System.out.println(e == f); // append一个: false,   append多个: 调用intern  true

		System.out.println("---------------");
		// 1.8 会(隐式)创建StringBuilder对象, 不会放入字符串常量池. 调用toString方法
		String g = new String("1") + new String("1");
		g.intern(); // 放入字符串常量池中
		String g1 = "11"; // 直接取字符串常量池中引用
		System.out.println(g == g1); // true


		char[] chars = {'l', 'i', '_', 's', 'i'};
		String s = new String(chars, 0, chars.length); // 堆中有, 常量池没有
		s.intern(); // 放入常量池中
		String s2 = "li_si";
		System.out.println(s == s2); // true
	}
}

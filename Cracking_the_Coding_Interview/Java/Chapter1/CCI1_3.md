>  1.3 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否编程另一个字符串。

依据参考资料，需要考虑的两点是，
1. 字符是否区分大小写字母；
2. 是否考虑空格。

首先，若两字符串的长度不同，结果为`false`；接下来，对于s1中的每个字符，判断其在s2中否存在，这里借鉴了`生成不重复的随机数`的思路，但时间复杂度仍为O(n^2)。

```java
public static boolean CCI1_3(String s1, String s2) {
	if(s1.length() != s2.length())
		return false;

	char[] c2 = s2.toCharArray();
	int size = c2.length;
	boolean isContain = false;

	for(int i = 0; i < s1.length(); i++) {
		for(int j = 0; j < size; j++) {
			if(s1.charAt(i) == c2[j]) {
				c2[j] = c2[size - 1];//@生成不重复的随机数
				size--;
				isContain = true;
			}
		}

		if(!isContain)
			return false;
	}

	return true;
}
```

还可以将两字符串排序，使用`equals`方法判断排序后的字符串。[@利用快速排序解决问题](http://jemoii.github.io/blog/about-quicksort-and-else/)

也可以记录两字符串中各字符的出现次数，再对应比较。
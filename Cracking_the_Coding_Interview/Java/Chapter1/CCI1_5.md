> 1.5 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变成a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。

```java
public String CCI1_5(String s) {
	if(s.length() < 1)
		return null;

	char c = s.charAt(0);
	int quantity = 1;
	String ss = "";

	for(int i = 1; i < s.length(); i++) {
    	// 累加字符重复的次数
		if(s.charAt(i) == c) {
			quantity++;
		}
        // 添加给定重复字符串的压缩结果
		else {
			ss += c;
			ss += String.valueOf(quantity);
			c = s.charAt(i);
			quantity = 1;
		}
	}

	ss += c;
	ss += String.valueOf(quantity);
	// 判断字符串长度有没有缩短
	if(ss.length() >= s.length())
		return s;

	return ss;
}
```

[@逆过程](http://jemoii.github.io/blog/qunar-2015-spring-test2/)
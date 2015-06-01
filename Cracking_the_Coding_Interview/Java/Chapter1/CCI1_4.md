> 1.4 编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串尾部有足够的空间存放新增字符。并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

```java
public char[] CCI1_4(char[] before) {
	int capacity = before.length;// 容量
	int size = before.length;// 真实长度

	for(int i = 0; i < size; ) {
		if(before[i] == ' ') {
        	// 保证尾部有足够的空间
			while(capacity - size < 2) {
				char[] temp = new char[2 * capacity];
				System.arraycopy(before, 0, temp, 0, size);
				before = temp;
				capacity = before.length;
			}
			// 将空格后的字符依次后移，添加“%20”
			for(int j = size - 1; j > i; j--)
				before[j + 2] = before[j];

			before[i] = '%';
			before[i + 1] = '2';
			before[i + 2] = '0';

			size = size + 2;
			i = i + 3;
		}
		else {
			i++;
		}
	}
	// 将字符数组缩短到真实长度
	char[] after = new char[size];
	System.arraycopy(before, 0, after, 0, size);

	return after;
}
```

`将空格后的字符依次后移`会降低方法的效率。

还可以首先遍历一次字符数组，统计空格的个数，然后

```java
newLength = length + numOfBlank * 2;
```

从后自前添加字符。
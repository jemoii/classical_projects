>	5.5编写一个函数，确定需要改变几个位，才能将整数A转成整数B。

```java
public int CCI5_5(int A, int B) {
	//A与B中不同的位数即C中1的位数
	int C = A ^ B;

    int count = 0;
	while(C != 0) {
		if((C & 1) == 1)
			count++;
		C = C >> 1;
	}

    return count;
}
```

使用

```java
while(C != 0) {
	count++;
	C = C & (C - 1);//消除C中最右侧的1
}
```

也可以统计C中1的位数。
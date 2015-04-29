> 5.2 给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表示。如果该数字无法精确地用32为以内的二进制表示，则打印“ERROR”。

```java
public static String CCI5_2(double d) {
	if(d <= 0 || 1 <= d)
		return "ERROR";

	StringBuffer buffer = new StringBuffer();
	buffer.append(".");

	boolean judge = false;	//该实数能否被精确表示
	for(int i = 0; i < 32; i++) {
		d = d * 2;

		if(d > 1) {
			buffer.append("1");
			d = d - 1;
		}
		else if(d < 1)
			buffer.append("0");
		else {
			buffer.append("1");
			judge = true;
			break;
		}
	}

	if(judge)
		return buffer.toString();

	return "ERROR";
}
```
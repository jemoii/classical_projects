>	3.6编写程序，按升序对栈进行排序（即最大元素位于栈顶）。最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构（如数组）。该栈支持如下操作：push、pop、peek和isEmpty。

#####思路分析

设主栈cs中自底而上元素为：`9, 2, 10, 7, 5`；辅栈vs初始为空，存放最终的排序好的元素。

-	cs的栈顶元素出栈，5，`vs当前为空，5即最小的元素`，直接压入vs；

-	cs的栈顶元素出栈，7，`7 >= 5`，排序未被破坏，直接压入vs；

-	cs的栈顶元素出栈，10，`10 >= 7`，排序未被破坏，直接压入vs；

-	cs的栈顶元素出栈，2，`2 < 10`，直接压栈，排序会被破坏，将10从vs出栈，重新压入cs（保证2仍位于cs栈顶，即先将2出栈暂存，在10压入后，重新压入cs），

	-	`2 < 7`，直接压栈，排序会被破坏，将7从vs出栈，重新压入cs（保证2仍位于cs栈顶），

	-	`2 < 5`，直接压栈，排序会被破坏，将5从vs出栈，重新压入cs（保证2仍位于cs栈顶），

	-	`vs当前为空`，现在可以将2压入vs，cs中自底而上元素为：`9, 10, 7, 5`；

-	5, 7, 10依次出栈，vs中的排序未被破坏，依次直接压入vs；

-	cs的栈顶元素出栈，9，`9 < 10`，直接压栈，排序会被破坏，将10从vs出栈，重新压入cs（保证9仍位于cs栈顶），

	-	`9 >= 7`，直接压入vs；

-	cs的栈顶元素出栈，10，`10 >= 9`，直接压入vs；

-	cs栈为空，vs栈得到排序好的结果。

#####程序实现

```java
public java.util.Stack<Integer> CCI3_6(java.util.Stack<Integer> cs) {
	java.util.Stack<Integer> vs = new java.util.Stack<Integer>();

	while(!cs.isEmpty()) {
		if(vs.isEmpty())//
			vs.push(cs.pop());
		else if(cs.peek() >= vs.peek())//
			vs.push(cs.pop());
		else {//
			int s = cs.pop();
			cs.push(vs.pop());
			cs.push(s);
		}
	}

	return vs;
}
```
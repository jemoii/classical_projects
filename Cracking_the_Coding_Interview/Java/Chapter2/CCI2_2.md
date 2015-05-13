>	2.2实现一个算法，找出单向链表中倒数第k个节点。

使用“快行指针”，指针pf从头节点向后遍历k个节点，如果已经超出链表范围，则说明该链表不存在倒数第k个节点，指针ps指向头节点。这样，同时向后遍历至pf指向尾节点，ps.next即指向倒数第k个节点。

链表模型为`A(head)->B->C->D(tail)->null`

```java
public Node<Integer> CCI2_2(Node<Integer> head, int k) {
	Node<Integer> pf = head;
	int i = 0;
	while(i < k) {
		if(pf.next == null)
			return null;

		pf = pf.next;
		i++;
	}

	Node<Integer> ps = head;
	while(pf.next != null) {
		pf = pf.next;
		ps = ps.next;
	}

	return ps.next;
}
```

测试该算法需要依照链表模型构造链表

```java
//由数组构造链表
int[] array = new int[] {8,9,1,3,6};

Node<Integer> head = new Node<Integer>(array[0]);
Node<Integer> current = head;
for(int i = 1; i < array.length; i++) {
	current.next = new Node<Integer>(array[i]);
	current = current.next;
}
current.next = null;
```
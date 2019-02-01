package linked_Structure_1;

public class Ex6_1_Linked_LIst {

	public static void main(String[] args) {
		
		LinkedList LL  = new LinkedList();
		LinkedList2 LL2  = new LinkedList2();
		
		/*
		System.out.println(
				"(1) 공백 리스트에 노드 3개 삽입하기");
		LL.insertLastNode("월");
		LL.insertLastNode("수");
		LL.insertLastNode("일");
		LL.printList();
		
		System.out.println();
		System.out.println(
		"(2) 수 노드 뒤에 금 노드 삽입하기");
		ListNode pre = LL.searchNode("수");
		
		if (pre == null) {
			System.out.println("검색실패 >> no data");
		} else {
			LL.insertMiddleNode(pre, "금");
			LL.printList();
		} 
		
		System.out.println();
		System.out.println(
		"(3) 리스트의 노드를 역순으로 바꾸기");
		LL.reverseList();
		LL.printList();
		
		System.out.println();
		System.out.println(
		"(4) 리스트의 마지막 노드 삭제하기");
		LL.deleteLastNode();
		LL.printList();
		*/
		
		
		
		LL2.insertLastNode("월");
		LL2.insertLastNode("수");
		LL2.insertLastNode("일");
		
		LL2.SearchNode("일");
		
	}
}

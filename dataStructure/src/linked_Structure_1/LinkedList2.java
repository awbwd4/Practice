package linked_Structure_1;

public class LinkedList2 {

	private ListNode head;
	//연결리스트의 첫번째 노드
	
	public LinkedList2() {
		head = null;
		//이 클래스의 객체를 생성하면 공백리스트가 생성됨.
	}
	
	public void insertMiddleNode(ListNode pre, String data) {
		//파라미터 pre : 노드가 삽입될 위치의 직전 노드, data : 삽입될 노드가 갖고있는 데이터 필드 값
		
		ListNode newNode = new ListNode(data);//삽입될 노드 객체 생성
		newNode.link = pre.link;
		pre.link = newNode;
	}
	
	public void insertLastNode(String data) {
		
		ListNode newNode = new ListNode(data);
		if (head == null) {
			this.head = newNode;
			//공백리스트인경우
		}else {
			ListNode temp = head;	
			
			while (temp.link != null) {
					temp = temp.link;
			}
			temp.link = newNode;
		}
	}
	
	public void deleteLastNode() {
		
		ListNode pre;
		ListNode temp;
		
		pre = head;
		temp = head.link;
		
		while(temp.link != null) {
			
			pre = temp;
			temp = temp.link;
			
		}
		pre.link = null;
	}
	
	public ListNode SearchNode(String data) {
		ListNode temp = this.head;
		
		while(temp.link != null){
			
			if (temp.getData() == data) {
				return temp;
			}else {
				
				temp = temp.link;
				
			}			
			
		}
		System.out.println(temp.getData());
		return temp;
	}
	
	public void reverseList() {
		
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		
		while (next != null) {
			
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		
		}
		
		head = current;
	}
	
	
	
}

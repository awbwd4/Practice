package linked_Structure_1;

public class LinkedList {
	
	private ListNode head;
	//리스트의 첫번째 노드
	
	public LinkedList() {
		head = null;
	}
	
	//중간에 노드 삽입
	public void insertMiddleNode(ListNode pre, String data) {
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}

	//말단에 노드 삽입
	public void insertLastNode(String data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			//삽입되는 연결리스트가 공백리스트일 경우
			this.head = newNode;
		} else {
			ListNode temp = head;
			//삽입되는 리스트의 헤드(참조변수)
			while (temp.link != null) {
				temp = temp.link;
				//마지막 노드를 찾는다
			}
			temp.link = newNode;
		}
	}
	
	/*//말단 노드 삭제
	public void deleteLastNode() {
		ListNode pre;
		//삭제될 노드의 앞에 있는 노드를 가리키는 변수
		
		ListNode temp;
		
		//공백리스트인 경우 메서드 그대로 종료
		if (head == null) return;
		
		if (head.link == null) {
			//노드가 하나만 있는 리스트인 경우
			head = null;
			
		}else {
			pre = head;
			temp = head.link;
			
			while(temp.link != null){
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
			                                              
		} 
	}*/

	
	public void deleteLastNode() {
		ListNode pre;
		//삭제할 노드의 직전 노드
		ListNode temp;
		//노드 이동을 위해 임시로 선언한 노드
		
		if(head == null) return;
		//공백노드이면 메소드 종료
		
		if (head.link == null) {
			//리스트에 노드가 하나 뿐인경우
			head = null;
		}else {
			
			pre = head;
			temp = head.link;
			
			while(temp.link != null) {
				
				pre = temp;
				temp = temp.link;
				
			}
			
			//temp.link가 null일 때,
			//즉 마지막 노드일때.
			pre.link = null;
			
			
			
			
			
			
		}
		
		
		
		
	
	}
	
	
	
	
	
	
	public ListNode searchNode(String data) {
		ListNode temp = this.head;
		
		while (temp != null) {
			if (data == temp.getData()) {
				return temp;
			}else {
				temp = temp.link;
			}
		}
		return temp;
	}

	public void reverseList() {
		//리스트 내의 노드들 순서 뒤집기
		
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
	
	public void printList() {
		ListNode temp = this.head;
		
		System.out.printf("L = (");
		
		while(temp != null) {
			System.out.printf(temp.getData());
			temp = temp.link;
			if (temp != null) {
				System.out.printf(", ");
			}
		}
		System.out.println(")");
	}

}

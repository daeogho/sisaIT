package j09Collection;

// K:key, V:value, E:element
// new GenericTest<String>()
// new GenericTest<MemberDTO();

public class GenericTest<E> {

	private E data;
	public GenericTest() {
		
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}

}

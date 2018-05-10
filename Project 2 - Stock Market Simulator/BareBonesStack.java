
public interface BareBonesStack <E> {
	E push(E obj);			//To insert at the TOS
	E pop();				//To remove items from TOS
	E peek();				//To take a look at the TOS
	boolean empty();		//check if the stack is empty

}
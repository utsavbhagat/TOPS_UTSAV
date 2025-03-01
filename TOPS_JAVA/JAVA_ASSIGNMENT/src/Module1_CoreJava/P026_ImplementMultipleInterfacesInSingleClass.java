package Module1_CoreJava;

interface Printable{
	void print();
}
interface Shareable{
	void share();
}
interface Editable{
	void edit();
}

class File implements Printable,Shareable,Editable{
	private String content;
	
	public File(String content) {
		this.content = content;
	}
	
	public void print() {
		System.out.println(content+"file is Printing. ");
	}
	
	public void share() {
		System.out.println(content+"file is Sharing. ");
	}
	
	public void edit() {
		System.out.println(content+"file is Editing. ");
	}
}
public class P026_ImplementMultipleInterfacesInSingleClass {
	public static void main(String[] args) {
		File f = new File("Hello Mr. ");
		
		f.print();
		f.share();
		f.edit();
	}
}

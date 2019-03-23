
public class JUnitTestTimer {

	public static void main(String[] args) {
		Timer one = new Timer(23,59,59,true);
		System.out.println("original time set is " + one.getHour() + ":" + one.getMinutes()+  ":" + one.getSeconds());
		one.incrementSeconds();
		System.out.println(one.getHour() + ":" + one.getMinutes()+  ":" + one.getSeconds());

	}

}

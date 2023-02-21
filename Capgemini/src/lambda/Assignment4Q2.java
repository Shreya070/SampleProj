package lambda;

import java.util.ArrayList;

@FunctionalInterface
interface MyLambda2 {
	public ArrayList<Assignment4Q2> list(ArrayList<Assignment4Q2> m);
}

public class Assignment4Q2 {

	private int totalPrice;
	private String status;

	public Assignment4Q2(int totalPrice, String status) {
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public static ArrayList<Assignment4Q2> listOfOrders(ArrayList<Assignment4Q2> orders, MyLambda2 m) {
		return m.list(orders);
	}

	public static void main(String[] args) {
		ArrayList<Assignment4Q2> A = new ArrayList<Assignment4Q2>();
		Assignment4Q2 obj1 = new Assignment4Q2(100000, "Accepted");
		Assignment4Q2 obj2 = new Assignment4Q2(1000, "Accepted");
		Assignment4Q2 obj3 = new Assignment4Q2(10001, "Completed");
		Assignment4Q2 obj4 = new Assignment4Q2(10001, "Unaccepted");
		A.add(obj1);
		A.add(obj2);
		A.add(obj3);
		A.add(obj4);
		MyLambda2 l = (V) -> {
			for (int i = 0; i < V.size(); i++) {
				if (V.get(i).totalPrice > 10000 && (V.get(i).status.equalsIgnoreCase("Accepted")
						|| V.get(i).status.equalsIgnoreCase("Completed"))) {
				} else
					V.remove(V.get(i));
			}
			return V;
		};
		ArrayList<Assignment4Q2> B = Assignment4Q2.listOfOrders(A, l);
		for (Assignment4Q2 e : B)
			System.out.println(e.totalPrice +" " + e.status);
	}
}
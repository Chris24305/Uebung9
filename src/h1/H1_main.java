package h1;

public class H1_main {
	public static void main(String[]args) {
		PrioListe Liste = new PrioListe();
		Patient a = new Patient("Chris", 1);
		Liste.addPatient(a);
		Patient b = new Patient("Chris2", 11);
		Liste.addPatient(b);
		Patient c = new Patient("Chris3", 10);
		Liste.addPatient(c);
		Patient d = new Patient("Chris4", 7);
		Liste.addPatient(d);
		Liste.getNextPatient();
		System.out.println(Liste.getPosition(a));
	}
}

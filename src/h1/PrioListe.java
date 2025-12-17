package h1;

import java.util.ArrayList;

public class PrioListe {
	
	public ArrayList<Patient> myList = new ArrayList<>();
	
	public void addPatient(Patient p) {
		
		if (myList.isEmpty()) {
			myList.add(p);
		
		} else {
			
			Patient patientToCompare = myList.get(0);
			for(int i = 0; i <= myList.size()-1; i++) {
				patientToCompare = myList.get(i);
				
				if (p.getPrio() < patientToCompare.getPrio()) {
					myList.add(i, p);
					break;
				}
				
				if (i== myList.size()-1) {
					myList.add(p);
					break;
				}
			}
		}
	}
	
	public Patient getNextPatient() {
		Patient nextPatient = myList.getFirst();
		myList.remove(0);
		return nextPatient;
	}
	
	public int getPosition(Patient p) {
		return myList.indexOf(p);
	}
}

package h2;

import java.util.ArrayList;

public class Bus {
	private ArrayList<Passenger> passengers;

	public Bus() {
		passengers = new ArrayList<>();
	}

	public void enterBus(Passenger p) {
		passengers.add(p);
	}

	private void exitBus() {
		if (passengers.size() != 0) {
			Passenger mustExit;
			for (int i = 0; i < passengers.size(); i++) {
				mustExit = passengers.get(i);
				if (mustExit.getPlanned() == mustExit.getVisited()) {
					passengers.remove(i);
					i--;
				}
			}
		}
	}

	public void nextStop(Passenger[] boarding) {
		for (int i = 0; i < passengers.size(); i++) {
			passengers.get(i).increaseVisited();
		}

		exitBus();

		for (int i = 0; i < boarding.length; i++) {
			passengers.add(boarding[i]);
		}
	}

	public void nextStop() {
		for (int i = 0; i < passengers.size(); i++) {
			passengers.get(i).increaseVisited();
		}

		exitBus();
	}

	public ArrayList<Passenger> findPassengersWithoutTickets() {
		ArrayList<Passenger> noTicket = new ArrayList<>();
		for (int i = 0; i < passengers.size(); i++) {
			if (!passengers.get(i).getTicket()) {
				noTicket.add(passengers.get(i));
				passengers.remove(i);
				i--;
			}
		}
		return noTicket;
	}

	public void transferPassengers(Bus otherBus, String[] passengerNames) {
		for (int i = 0; i < passengers.size(); i++) {
			for (int j = 0; j <  passengerNames.length; j++) {
				if (passengerNames[i].equals(passengers.get(j).getName())) {
					otherBus.enterBus(passengers.get(i));
					passengers.remove(i);
					break;
				}
			}
		}
	}
}

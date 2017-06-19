
public class Bany {
	
	private int tipus; //0 si no hi ha ningu, 1 si són dones, 2 si són homes, 3 ple
	private int num; //persones que hi ha
	private int MAXP; //màxim de persones
	
	public Bany(int maxp) {
		tipus = 0;
		num = 0;
		MAXP = maxp;
	}

	public synchronized int getTipus() {
		return tipus;
	}
	
	public synchronized void entrar(int genere) {
		try {
			while ((tipus!=0 && genere!=tipus) || tipus==3) wait();
			if(tipus == 0) tipus = genere;
			if(++num == MAXP) tipus = 3;
			switch(tipus){
			case 1:
				System.out.println("som " + num + " dones");
				break;
			case 2:
				System.out.println("som " + num + " homes");
			}
			
			notifyAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void sortir() {
		num--;
		System.out.println("surt " + tipus);
		if(num == 0) tipus = 0;
		notifyAll();
	}
	
	

}
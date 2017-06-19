



public class Persona extends Thread {
	private Bany bany;
	private int genere;
	
	public Persona(Bany b) {
		bany = b;
	}

	public Persona(Bany b, String name, int g) {
		super(name);
		genere = g;
		bany = b;
	}

	public Persona(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		for(;;) {
			bany.entrar(genere);
			UtilitzarBany();
			bany.sortir();
			Treballar();
		}		
	}

	private void Treballar() {
		try {
			System.out.println(getName() + " torno a treballar");
			Thread.sleep((long) Math.random()*8000+2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void UtilitzarBany() {
		System.out.println(getName() + " vaig al bany...");
		try {
			Thread.sleep((long) Math.random()*2000+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	
}
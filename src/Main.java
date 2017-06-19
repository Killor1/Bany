/*
 * LAVABO, tienen que entrar unas personas al lavabo. Maximo 5 del mismo sexo. Si hay 1 chica, pueden entrar chicas pero los chicos no y viceversa. SEMAFORO-> rosa(chica), azul(chico), nada(vacio), rojo(lleno)
 * */

public class Main {

	public static void main(String... args) {
		Bany bany = new Bany(3);
		Persona dones[] = new Persona[50];
		Persona homes[] = new Persona[50];
		
		for(int i=0;i<50;i++) {
			dones[i] = new Persona(bany,"dona-" + i, (short) 1);
			homes[i] = new Persona(bany,"home-" + i, (short) 2);
		}
		
		for(int i=0;i<50;i++) {
			dones[i].start();
			homes[i].start();
		}
		
		
	}

}

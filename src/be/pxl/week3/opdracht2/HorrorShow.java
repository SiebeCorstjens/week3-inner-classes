package be.pxl.week3.opdracht2;

public class HorrorShow {

	public static void main(String[] args) {
		class Vampire implements Monster {
			@Override
			public String menace() {
				return "I'll drink your blood!!";
			}
		}
		
		class Werewolf implements DangerousMonster {
			@Override
			public String menace() {
				return "I'll destroy you.";
			}
			
			@Override
			public void destroy(Monster monster) {
				System.out.println(menace() + " Big fight " + getClass().getSimpleName() + " killed one " + monster.getClass().getSimpleName());
			}
		}
		
		Werewolf werewolf = new Werewolf();
		werewolf.destroy(new Vampire());
		
	}
	
	

}

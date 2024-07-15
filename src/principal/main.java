package principal;

import bot.RandomBot;
import game.Game;

public class main {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Game game = new Game();
		game.matchWithRandomBot(new RandomBot());
	}

}

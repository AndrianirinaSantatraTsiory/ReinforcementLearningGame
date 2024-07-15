package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bot.RandomBot;

public class Game {
	char[][] game_table = new char[3][3];
	public void showGameTable() {
		System.out.println("  0 1 2");
		for(int i=0;i<3;i++) {
			System.out.println(i+" "+game_table[i][0]+" "+game_table[i][1]+" "+game_table[i][2]);
		}
	}
	public ArrayList<ArrayList<Integer>> getAvailableBox(){
		ArrayList<ArrayList<Integer>> available=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(game_table[i][j]=='\u0000') {
					ArrayList<Integer> box=new ArrayList<>();
					box.add(i);
					box.add(j);
					available.add(box);
				}
			}
		}
		return available;
	}
	private boolean isGameOver(){
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(game_table[i][j]=='\u0000') {
					return false;
				}
			}
		}
		return true;
	}
	public void matchWithRandomBot(RandomBot randomB) {
		int row=0,col=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Match start");
		while(!isGameOver()&&getWinner()==' ') {
			System.out.println("Random Bot🤖:");
			List<Integer> move=randomB.play(getAvailableBox());
			game_table[move.get(0)][move.get(1)]='X';
			showGameTable();
			if(isGameOver() || getWinner() != ' ')break;
			System.out.println("Humain🧑:");
			row=sc.nextInt();
			col=sc.nextInt();
			game_table[row][col]='O';
			showGameTable();
		}
		if(getWinner()=='X')System.out.println("The winner is: Random Bot🤖");
		else if(getWinner()=='O')System.out.println("The winner is: Humain🧑");
		else System.out.println("Match null");
	}
	private char getWinner() {
		for(int i=0;i<3;i++) {
			if(game_table[i][0] !='\u0000' && game_table[i][0]==game_table[i][1] && game_table[i][1]==game_table[i][2])
				return game_table[i][0];
		}
		for(int j=0;j<3;j++) {
			if(game_table[0][j] !='\u0000' && game_table[0][j]==game_table[1][j] && game_table[1][j]==game_table[2][j])
				return game_table[0][j];
		}
		if(game_table[0][0] !='\u0000' && game_table[0][0]==game_table[1][1] && game_table[1][1]==game_table[2][2])
			return game_table[0][0];
		if(game_table[2][2] !='\u0000' && game_table[2][2]==game_table[1][1] && game_table[1][1]==game_table[0][0])
			return game_table[2][2];
		return ' ';
	} 
}

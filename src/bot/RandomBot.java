package bot;

import java.util.ArrayList;
import java.util.List;

public class RandomBot {
	public List<Integer> play(ArrayList<ArrayList<Integer>> availableBox){
		return availableBox.get((int)(Math.random()*availableBox.size()));
	}
}

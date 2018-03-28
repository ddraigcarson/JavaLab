package evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import players.Player;
import players.PlayerBot;

public class BuilderBot {

	public List<Player> createPlayerBotBatch(int noOfBots){
		List<Player> bots = new ArrayList<Player>();
		for (int i=0 ; i<noOfBots ; i++) {
			bots.add(new PlayerBot());	
		}
		return bots;
	}

	public List<Player> createPlayerBotBatch(int noOfBots, Player bestBot){
		List<Player> bots = new ArrayList<Player>();
		for (int i=0 ; i<noOfBots ; i++) {
			PlayerBot bot = new PlayerBot();
			bot.getMemory().putAll(((PlayerBot) bestBot).getMemory());
			bots.add(new PlayerBot());	
		}
		return bots;
	}
	
	public List<Player> createBestBotBatch(List<Player> bots, Player bestBot){
		Map<String, BoardSquare> bestMemory = bestBot.getMemory();
		for (Player bot : bots) {
			bot.resetBot();
			bot.getMemory().putAll(bestMemory);
		}
		return bots;
	}
	
	public Player findBestBot(List<Player> bots) {
		Player bestBot = bots.get(0);
		for (Player bot : bots) {
			if (bot.getPlayerScore() > bestBot.getPlayerScore()) {
				bestBot = bot;
			}
		}
		return bestBot;
	}
	
}

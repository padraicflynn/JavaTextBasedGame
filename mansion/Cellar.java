package mansion;

import java.util.List;

import engine.Player;
import things.Thing;

public class Cellar implements Room {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Thing> getThings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exit> getExits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canUseItem(Player player, Thing item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void useItem(Player player, Thing item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exit(Player player, Exit exit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addExit(Exit exit) {
		// TODO Auto-generated method stub

	}

}

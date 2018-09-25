package ass2.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ass2.backend.Boulder;
import ass2.backend.EmptyTile;
import ass2.backend.Entity;
import ass2.backend.Maze;
import ass2.backend.Player;
import ass2.backend.Switch;

/**
 * US2: Boulder pushing
 * 
 * User-Story Description:
 * As a player, I should be able to push boulders by moving into them,
 * so that I can eventually position them on top of switches.
 * 
 * Acceptance Criteria:
 * - Moving the player character into a square occupied by a boulder 
 * should case the boulder to move into the opposite square
 * - Boulders should not move into walls. In the case a wall blocks 
 * the boulders movement, neither it nor the player character should move
 * - Other boulders should behave in a similar fashion to walls to prevent 
 * multiple boulders being moved at once
 * - Moving a boulder onto a switch should trigger the switch.
 * - Moving a boulder off a switch should un_trigger it
 *
 */
class BoulderPushingTest {
	String map1 = 
			"X X X X X\n" +
      "X P . . .\n" + 
      "X . B . .\n" +
      "X . . S .\n" +
      "X . . . .\n";
	String map2 = 
			"X X X X X\n" +
      "X P . . .\n" + 
      "X . B . .\n" +
      "X . B S .\n" +
      "X . . . .\n";
	Maze maze;
	Player player;
	
	@Test
	void testBoulderTriggerSwitchOnOff() {
		maze = Maze.parseMaze(5, 5, map2);
		player = maze.getPlayer();
		player.moveDown();
		player.moveDown();
		Entity theSwitch = maze.getEntity(3, 3);
		assertTrue(theSwitch instanceof Switch);
		assertTrue(theSwitch.isTriggered() == false);
		player.moveRight();
		assertTrue(theSwitch.isTriggered() == true);
		player.moveRight();
		assertTrue(theSwitch.isTriggered() == false);
	}
	
	@Test
	void testPlayerPushBoulderToOtherBoulder() {
		maze = Maze.parseMaze(5, 5, map2);
		player = maze.getPlayer();
		player.moveRight();
		assertTrue(maze.getEntity(1, 2) instanceof Player);
		assertTrue(maze.getEntity(2, 2) instanceof Boulder);
		assertTrue(maze.getEntity(3, 2) instanceof Boulder);
		player.moveDown();
		assertTrue(maze.getEntity(1, 2) instanceof Player);
		assertTrue(maze.getEntity(2, 2) instanceof Boulder);
		assertTrue(maze.getEntity(3, 2) instanceof Boulder);
	}

	@Test
	void testPlayerPushBoulderDownAndToBoudary() {
		maze = Maze.parseMaze(5, 5, map1);
		player = maze.getPlayer();
		assertTrue(maze.getEntity(1, 2) instanceof EmptyTile);
		player.moveRight();
		assertTrue(maze.getEntity(1, 2) instanceof Player);
		assertTrue(maze.getEntity(2, 2) instanceof Boulder);
		player.moveDown();
		assertTrue(maze.getEntity(1, 2) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 2) instanceof Player);
		assertTrue(maze.getEntity(3, 2) instanceof Boulder);
		player.moveDown();
		assertTrue(maze.getEntity(2, 2) instanceof EmptyTile);
		assertTrue(maze.getEntity(3, 2) instanceof Player);
		assertTrue(maze.getEntity(4, 2) instanceof Boulder);
		player.moveDown();
		player.moveDown();
		player.moveDown();
		assertTrue(maze.getEntity(2, 2) instanceof EmptyTile);
		assertTrue(maze.getEntity(3, 2) instanceof Player);
		assertTrue(maze.getEntity(4, 2) instanceof Boulder);
	}
	
	@Test
	void testPlayerPushBoulderRightAndToBoudary() {
		maze = Maze.parseMaze(5, 5, map1);
		player = maze.getPlayer();
		assertTrue(maze.getEntity(2, 1) instanceof EmptyTile);
		player.moveDown();
		assertTrue(maze.getEntity(2, 1) instanceof Player);
		assertTrue(maze.getEntity(2, 2) instanceof Boulder);
		player.moveRight();
		assertTrue(maze.getEntity(2, 1) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 2) instanceof Player);
		assertTrue(maze.getEntity(2, 3) instanceof Boulder);
		player.moveRight();
		assertTrue(maze.getEntity(2, 2) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 3) instanceof Player);
		assertTrue(maze.getEntity(2, 4) instanceof Boulder);
		player.moveRight();
		player.moveRight();
		player.moveRight();
		assertTrue(maze.getEntity(2, 2) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 3) instanceof Player);
		assertTrue(maze.getEntity(2, 4) instanceof Boulder);
	}
	
	@Test
	void testPlayerPushBoulderUpAndToWall() {
		maze = Maze.parseMaze(5, 5, map1);
		player = maze.getPlayer();
		assertTrue(maze.getEntity(3, 2) instanceof EmptyTile);
		player.moveDown();
		player.moveDown();
		player.moveRight();
		assertTrue(maze.getEntity(3, 2) instanceof Player);
		assertTrue(maze.getEntity(2, 2) instanceof Boulder);
		player.moveUp();
		assertTrue(maze.getEntity(3, 2) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 2) instanceof Player);
		assertTrue(maze.getEntity(1, 2) instanceof Boulder);
		player.moveUp();
		player.moveUp();
		assertTrue(maze.getEntity(3, 2) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 2) instanceof Player);
		assertTrue(maze.getEntity(1, 2) instanceof Boulder);
	}

	@Test
	void testPlayerPushBoulderLeftAndToWall() {
		maze = Maze.parseMaze(5, 5, map1);
		player = maze.getPlayer();
		assertTrue(maze.getEntity(2, 3) instanceof EmptyTile);
		player.moveRight();
		player.moveRight();
		player.moveDown();
		assertTrue(maze.getEntity(2, 3) instanceof Player);
		assertTrue(maze.getEntity(2, 2) instanceof Boulder);
		player.moveLeft();
		assertTrue(maze.getEntity(2, 3) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 2) instanceof Player);
		assertTrue(maze.getEntity(2, 1) instanceof Boulder);
		player.moveLeft();
		player.moveLeft();
		assertTrue(maze.getEntity(2, 3) instanceof EmptyTile);
		assertTrue(maze.getEntity(2, 2) instanceof Player);
		assertTrue(maze.getEntity(2, 1) instanceof Boulder);
	}
}

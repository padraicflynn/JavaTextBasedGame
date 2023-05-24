# TextBasedAdventure
I am attempting to make a text based adventure game in Java where you escape a haunted mansion. 
You will control a character in a mansion. There are different commands you can use, go, look, take, use, see (exits), see what is in your inventory, help (list of commands, and quit. I hope to have a mansion full of rooms, things to look at, take and use and explore solve puzzles. The goal is to escape the mansion. Hopefully you don't encounter
any ghosts or anything scary. 

5/8/2023
We have a player, and some basic rooms set up. You can currently go into a few rooms, but some of the descriptions load twice and not all the exits connect yet. 
I hope to get the mansion set up so the player can move to each room of the mansion correctly. 
After that we can start adding details, like the items and things to look at in each room.
From there we can add the events, such as unlocking a door with a key you picked up and placed in your inventory. 

5/18/2023
We are able to move through the fully connected mansion! All the rooms connect in a way that (mostly) make sense for a mansion! You are able to "go" north, south, east, west, up and down
to explore the mansion! The new "see" command shows all the exits in a room, so you'll never be lost. While it would be fun to start adding flavor text to the rooms, next I think
I'll start working on getting the item objects working. Being able to "take" items and add them to the player's inventory. Then making sure the inventory screen works. After that
I think "use" items to interact with things in the room should let me start making some puzzles in the haunted mansion! 

5/23/2023
We are able to "take" items from rooms now. A "key" was easy, but something with two words like "haunted book" is tricky. These are test items,
not that you would willingly take a haunted book! We are able to check our inventory and see what we have, both the key and haunted book now.
I tried to get the haunted book to kill the player on use (for testing!) and it worked! But the way I had everything set up the rooms 
held each item, but I want to be able to use any item in any room and in an effort to adjust that I broke the use method now.
It worked for a minute though, so I'm sure we can fix it so the list of items can be populated in the things package/class as a
place to store all the game items and use them from there.
I also had the idea of triggering events with an old "RPG maker" trick, adding invisible items to the players inventory
that the game could see if the player had triggered certain events earlier or not by the presence of these invisible items.
Time to rework the whole inventory system!
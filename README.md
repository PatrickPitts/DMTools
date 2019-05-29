# DMTools
A series of tools useful to manage characters, encounters, and resources for Dunegeons and Dragons, 5th Edition

As I continue to improve my application development skillset, the logical structure of new if similar functions may begin to differ
from older structures. Because of this, there may be some inconsistencies in design choice between similar structures of the program.
As the old addage goes, though, "it works on my machine," and part of my continued development of this project is to homoginize some
of the functions into a unified logical structure.

As of this release, DM tools can:

Build new characters! The user can input various essential information for a character (character class, level, ability scores, hit points,
skills, some character traits and features), that will be saved and accessed in other areas of the program. 
- IN FUTURE UPDATES: expanded lists of character features, including traits and features assigned by character race, and other 
player choices, and spell lists.

Manage Parties! When building a character, the user can assign a character to a particular party (i.e., collection of players in a single
Dungeons and Dragons campaign). The user can inspect all characters within certain parties, or all characters saved to the program.
- IN FUTURE UPDATES: migrate characters to different parties and collections on the fly

Get Essential Character Information! Once a party is selected, essential combat and information statistics is presented on all members
of the party in a single, easy to read panel. In this way, the user can get an effective at-a-glance read on key player statistics
that will help facilitate decision making and planning on the part of the Dungeon Master
- IN FUTURE UPDATES: Player hitpoint management, and customizing what essential character information is displayed

View Important Resources for the game! Stat blocks for monsters, NPCs, and creatures used in your game can be referenced quickly
with dynamic searching tools, as well as rules and regulations from the game books themselves.
- IN FUTURE UPDATES: Complete the spell book reference, as well as character class features and general rules reference. Additionally,
implementation to add new creatures, spells, abilities, and rules within the structure of the program itself. Currently, the user must 
edit the included .csv files directly to incorporate new information

Manage Combat Initiative! The user can quickly implement turn order for players and the monsters in the game quickly and without added
calculation. Simply type in the rolls for each character (and the monsters in the combat), and the tracker will sort this list into
initiative order. 
- IN FUTURE UPDATES: Implement encounter collections, i.e. preplanned groups of monsters directly into the initiative sorter.
Additionally, UI updates to facilitate ease of use, and additional options.

-----Upcoming Features-----
Full Character Management: A revamped character management system that will allow Dungeon Masters and Players alike get a 
comprehensive view of their character sheet. 

Encounter and Campaign Managers: Build collections of monsters, and track key features of the group as well as individuals.
This will be incorporated with the Combat Initiative manager. Additionally, manage maps, notes, other characters, and rule sets
for complete campaigns.

Combat Mapping: Visualizing the standard square-grid map system used in many pen-and-paper role-playing-games to visualize
and manage in-game combat. This will allow users to manage character trackers/tokens, map creation, notes management, and 
interactive elements in the maps themselves.


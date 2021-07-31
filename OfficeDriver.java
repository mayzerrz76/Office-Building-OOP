/**********************************************************
* Program Name   : OfficeDriver
* Author         : Ryan May
* Due Date       : 09/29/2020
* Course/Section : CSC112-301
* Program Description: This program allows you to create and manage an office building.
*	 The program will display a menu with various actions to manage your office building
*	 The menu allows the user to add or delete rooms from the office, display the office,
*	 sort the office roster by room number or capacity, view available rooms of a certain
*	 size, reserve or release rooms, create a new building, or quit. The program includes
*    a welcome message at the beginning of program and an exit message when you quit.
*	 If you choose an invalid menu selection the program displays an error message.
*	 This program formats building names to title case, and room numbers are formatted
*	 to 4 characters long.
*
* Methods:
* -------
* main			   		-  Allows the user to create an office object using an office name,
*						   and number of office rooms.  The method allows the user to choose
*						   an action from a menu. The actions include adding rooms, deleting
*						   rooms, displaying the office, sorting the office rooms, reserving
*						   rooms, releasing rooms, viewing available rooms of a certain size,
*						   creating a new office, or quitting. If an invalid
*						   menu choice is input this method displays an error message. When you
*						   choose to quit, an exit message is displayed.
* menu					-  Displays a menu with different actions. Gets a menu
*						   choice from the user and returns as an integer.
* createTeam			-  This method allows you to enter a an office building name,
*						   and the max number of rooms in building to instantiate an
*						   office building object, and returns that office object.
*						   Returns a default team object if user chooses to quit.
* createTeam (overload)	-  This overloaded method allows you to enter a an office building name,
*						   and the max number of rooms in building to instantiate an
*						   office building object, and returns that office object.
*						   Returns the same office object that was passed in to this
*						   method if the user chooses to quit back to menu.
* addRooms				-  Allows user to add multiple rooms to an office object
* deleteRooms			-  Displays a room list with index numbers and allows
*						   user to delete multiple rooms by index number.
* reserveRoom			-  Allows the user to reserve a room that is available.
* releaseRoom			-  Allows the user to release a room that had been reserved.
* displayBuilding 		-  Displays the contents of office building and its rooms
* viewAvailable			-  Allows user to view available rooms of a certain capacity
* sortOffice	 		-  Allows user to sort an offices rooms by capacity or room number
* errorMessage			-  Displays an error message to the user for invalid menu selection
* exitMessage      		-  Displays exit message and program author signature
**********************************************************/


public class OfficeDriver
{
	/**********************************************************
	* Method Name    : main
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method allows a user to create an office building object. This
	*	 This method calls upon a menu method that allows a user to perform various actions
	*	 on their office building object. This method allows user to perfom menu actions
	*	 until they choose to quit. The menu options allow you to add rooms, delete rooms,
	*	 reserve a room, release a room, display building, sort office rooms, view available
	*	 rooms of a certain size, create a new building, or quit. Each of these actions will
	*	 be performed by their respected methods that exist within this class. Each of those
	*	 methods have submethods that help in their functionality. When you choose to quit this
	*	 method displays an exit message to user.
	*
	* BEGIN main
	*	 Call method to create building
	*	 Call the menu method to display menu and get user menu selection
	*	 WHILE(The selection is not quit)
	*	  	 IF(User selection is add rooms)
	*			Call the add rooms method
	*	  	 ELSE
	*			IF(User selection is delete rooms)
	*			   Call the delete rooms method
	*			ELSE
	*			   IF(User selection is display office building)
	*				  Call the display office method
	*			   ELSE
	*				  IF(User selection is reserve room)
	*					 Call the reserve room method
	*				  ELSE
	*				     IF(User selection is release room)
	*					    Call the release room method
	*					 ELSE
	*					    IF(User selection view available rooms of certain size)
	*						   Call method to view available rooms of size
	*						ELSE
	*						   IF(User selection is sort office)
	*							  Call method to sort office
	*						   ELSE
	*							  IF(User selection is create new building)
	*							     Call method to create building
	*							  ELSE
	*								 Call method to dispay error message
	*							  END IF
	*						   END IF
	*  						END IF
	*					 END IF
	*				  END IF
	*		       END IF
	*			END IF
	*		 END IF
	*		 Call the menu method to display menu and get user menu selection
	*	  END WHILE
	*	  Call method to display an exit message
	* END main
    **********************************************************/
	public static void main(String [] args)
	{
		//local constants
		final int QUIT = 0;					//Used as a quit sentinel value for our menu
		final int ADD_ROOMS = 1;			//Represents the add room menu choice
		final int DELETE_ROOMS = 2;			//Represents the delete room menu choice
		final int DISPLAY_OFFICE = 3;		//Represents the display office building menu choice
		final int RESERVE_ROOM = 4;			//Represents the reserve room menu choice
		final int RELEASE_ROOM = 5;			//Represents the release room menu choice
		final int AVAILABLE_BY_SIZE = 6;	//Represents rooms available of certain size menu choice
		final int SORT_OFFICE = 7;			//Represents the sort office menu choice
		final int NEW_BUILDING = 8;			//Represents the create new building menu choice

		//local data
		OfficeInfo office;					//Declaration for an office building object
		int selection; 						//Represents the users menu selection as an int

		/************************************************/

		//Call method to create building
		office = createBuilding();

		//Call the menu method to display menu and get user menu selection
		selection = menu();

		//WHILE(The selection is not quit)
		while(selection != QUIT)
		{
			//IF(User selection is add rooms)
			if(selection == ADD_ROOMS)

				//Call the add rooms method
				addRooms(office);

			//ELSE
			else

				//IF(User selection is delete rooms)
				if(selection == DELETE_ROOMS)

					//Call the delete rooms method
					deleteRooms(office);

				//ELSE
				else

					//IF(User selection is display office building)
					if(selection == DISPLAY_OFFICE)

						//Call the display team method
						displayBuilding(office);

					//ELSE
					else

						//IF(User selection is reserve room)
						if(selection == RESERVE_ROOM)

							//Call the reserve room method
							reserveRoom(office);

						//ELSE
						else

							//IF(User selection is release room)
							if(selection == RELEASE_ROOM)

								//Call the release room method
								releaseRoom(office);

							//ELSE
							else

								//IF(User selection view available rooms of certain size)
								if(selection == AVAILABLE_BY_SIZE)

									//Call the method to view available rooms of size
									viewAvailable(office);

								//ELSE
								else

									//IF(User selection is sort office)
									if(selection == SORT_OFFICE)

										//Call the method to sort office
										sortOffice(office);

									//ELSE
									else

										//IF(User selection is create new building)
										if(selection == NEW_BUILDING)

											//Call method to create building
											office = createBuilding(office);

										//ELSE
										else

											//Call method to display error message
											errorMessage();

										//END IF

									//END IF

								//END IF

							//END IF

						//END IF

					//END IF

				//END IF

			//END IF

			//Call the menu method to display menu and get users menu selection
			selection = menu();

		}
		//END WHILE

		//Call method to display an exit message
		exitMessage();

	}//End main

	/**********************************************************
	* Method Name    : menu
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and display
	*					a menu with numbers next to each menu choice.
	*					The method will allow the user to enter their menu
	*					choice. The menu choice is returned as an integer.
	*
	* BEGIN menu
	*	 Clear screen
	*	 Display a menu header
	*	 Display menu options with number choices
	*	 Get menu choice from user
	*	 Return menu choice as an integer
	* END menu
	**********************************************************/

	public static int menu()
	{
		//local constants

		//local variables
		int menuChoice;							//Represents the menu choice number of the user

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display a menu header
		System.out.print("\n\n\n\n" + Util.setLeft(54, "OFFICE  MENU"));

		//Display menu options with number choices
		System.out.print("\n\n" +
						Util.setLeft(46,"(0) Quit Office Manager") + "\n" +
						Util.setLeft(46,"(1) Add Rooms to Your Office") + "\n" +
						Util.setLeft(46,"(2) Delete Rooms from Office") + "\n" +
						Util.setLeft(46,"(3) Display Office Building") + "\n" +
						Util.setLeft(46,"(4) Reserve an Office Room") + "\n" +
						Util.setLeft(46,"(5) Release an Office Room") + "\n" +
						Util.setLeft(46,"(6) Available Rooms of Certain Size") + "\n" +
						Util.setLeft(46,"(7) Sort the Office Building") + "\n" +
						Util.setLeft(46,"(8) Create New Office Building") + "\n\n" +
						Util.setLeft(46,"Enter a menu choice number: "));

		//Get menu choice from user
		menuChoice = Keyboard.readInt();

		//Return menu choice as an integer
		return menuChoice;

	}//End menu


	/**********************************************************
	* Method Name    : createBuilding
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will display a welcome message to
	*	 the user and then prompts user to enter in the name of an office
	*	 building or quit to the menu.  If the user enters a building name
	*	 they will then be prompted for the max number of rooms in the
	*	 building. This method will then use those inputs to instantiate
	*	 an OfficeInfo object and that object will be returned by this method.
	*	 If the user chose to quit, this method will instantiate a default OfficeInfo
	*	 object and return that.
	*
	* BEGIN createBuilding
	*	 Clear the screen
	*	 Display welcome message and ask user for a building name or quit to menu
	*	 IF(Building name input is not quit)
	*		Format office name to title case
	*		Ask user for the max number of office rooms
	*	    Instantiate an office building object
	*	 ELSE(User entered quit value)
	*	 	Instantiate a default office building object
	*	 ENDIF
	*	 Return the office building object
	* END createBuilding
	**********************************************************/

	public static OfficeInfo createBuilding()
	{
		//local constants
		final String QUIT = "0";			//Used as a value to quit to menu
		final int DEFAULT_SIZE = 25;		//Used as the default max number of building rooms

		//local variables
		String buildingIn;					//Represents a building name input by the user
		int maxRoomsIn;						//Represents input max rooms an office object can hold
		OfficeInfo officeBldg;				//Represents an office object we will insantiate and return

		/****************************************************/

		//Clear the screen
		Util.cls();

		//Display welcome message and ask user for a building name or quit to menu
		System.out.print("\n\n\n\n" + Util.setLeft(36, "Welcome, and thank you for using Office Manager!") +
						"\n" + Util.setLeft(50, "Created by: Ryan May") + "\n\n\n" +
						Util.setLeft(38, "Enter the name of your office or 0 for menu: "));
		buildingIn = Keyboard.readString();

		//IF(Building name input is not quit)
		if(buildingIn.compareTo(QUIT) != 0)
		{
			//Format office name to title case
			buildingIn = Util.toTitleCase(buildingIn);

			//Ask user for the max number of office rooms
			System.out.print(Util.setLeft(38, "Enter the maximum room numbers in building : "));
			maxRoomsIn = Keyboard.readInt();

			//Instantiate an office building object
			officeBldg = new OfficeInfo(maxRoomsIn, buildingIn);
		}

		//ELSE
		else

				//Instantiate a default office building object
				officeBldg = new OfficeInfo(DEFAULT_SIZE, "Default Office");

		//END IF

		//Return the office building object
		return officeBldg;

	}//End createBuilding

	/***********************************************************
	* Method Name    : createBuilding (Overload)
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This is an overloaded method. It will display a
	*	 welcome message to the user and then prompts user to enter in the name
	*	 name of an office building or quit to the menu.  If the user enters a
	*	 building name they will then be prompted for the max number of rooms in
	*	 the building. This method will then use those inputs to instantiate
	*	 an OfficeInfo object and that object will be returned by this method.
	*	 If the user chose to quit, this method will return the same object that
	*	 was passed in.
	*
	* BEGIN createBuilding
	*	 Clear the screen
	*	 Display welcome message and ask user for a building name or quit to menu
	*	 IF(Building name input is not quit)
	*		Format office name to title case
	*		Ask user for the max number of office rooms
	*	    Instantiate an office building object
	*	 ELSE(User entered quit value)
	*	 	Set office to return to the office passed in
	*	 END IF
	*	 Return the office building object
	* END createBuilding
	**********************************************************/

	public static OfficeInfo createBuilding(OfficeInfo office)
	{
		//local constants
		final String QUIT = "0";			//Used as a value to quit to menu

		//local variables
		String buildingIn;					//Represents a building name input by the user
		int maxRoomsIn;						//Represents input max rooms an office object can hold
		OfficeInfo officeBldg;				//Represents an office object we will insantiate and return

		/****************************************************/

		//Clear the screen
		Util.cls();

		//Display welcome message and ask user for a building name or quit to menu
		System.out.print("\n\n\n\n" + Util.setLeft(36, "Welcome, and thank you for using Office Manager!") +
						"\n" + Util.setLeft(50, "Created by: Ryan May") + "\n\n\n" +
						Util.setLeft(38, "Enter the name of your office or 0 for menu: "));
		buildingIn = Keyboard.readString();

		//IF(Building name input is not quit)
		if(buildingIn.compareTo(QUIT) != 0)
		{
			//Format office name to title case
			buildingIn = Util.toTitleCase(buildingIn);

			//Ask user for the max number of office rooms
			System.out.print(Util.setLeft(38, "Enter the maximum room numbers in building : "));
			maxRoomsIn = Keyboard.readInt();

			//Instantiate an office building object
			officeBldg = new OfficeInfo(maxRoomsIn, buildingIn);
		}

		//ELSE(User entered quit value)
		else

				//Set office to return to the office passed in
				officeBldg = office;

		//END IF

		//Return the office building object
		return officeBldg;

	}//End createBuilding

	/**********************************************************
	* Method Name    : addRooms
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and prompt
	*	 the user to input a room number to add or quit back to menu.
	*	 If the user enters a room number, they will then be prompted for
	*	 a capacity of that room.  The method instantiates a temporary room
	*	 object, and passes that room object into another method that will
	*	 add the room as long as the building is not full.  This method will
	*	 then let the user know if the room was added or not.  Method allows
	*	 user to add multiple rooms.
	*
	* BEGIN addRooms
	*	 Clear screen
	*	 Get a room number or return to the main menu
	*	 WHILE(Room number is not return)
	*		 Get the capacity of the room
	*		 Instantiate a room object
	*		 Clear the screen
	*	  	 IF(Room is added)
	*		    Display message that the room was added
	*		 ELSE
	*			Display message that the room was not added
	*		 END IF
	*		 Get another room number or return to main menu
	*	 END WHILE
	* END addRooms
    **********************************************************/

	public static void addRooms(OfficeInfo office)
	{
		//local constants
		final String RETURN = "0";			//String value used to quit/return to menu
		final int ROOM_NUM_LENGTH = 4;		//Used to represent the max length for room num

		//local variables
		String room;						//The player name the user puts in
		int capacity;						//The players jersey number the user puts in
		RoomInfo tempRoom;					//Declaring a player object we can use to construct a player object

		/****************************************************/

		//Clear Screen
		Util.cls();

		//Get a room number or return to the main menu
		System.out.print("\n\n\n\n" + Util.setLeft(38, "Enter a room number or 0 to return to menu: "));
		room = Keyboard.readString();

		//WHILE(Room number is not return)
		while(room.compareTo(RETURN) != 0)
		{
			//Format the length of room number
			room = Util.formatNameLength(ROOM_NUM_LENGTH, room);

			//Get the capacity of the room
			System.out.print(Util.setLeft(38, "Enter the capacity of the room            : "));
			capacity = Keyboard.readInt();

			//Instantiate a room object
			tempRoom = new RoomInfo(room, capacity);

			//Clear the screen
			Util.cls();

			//IF(Room is added)
			if(office.addRoom(tempRoom))

				//Display message that room was added
				System.out.print("\n\n" + Util.setLeft(52,"Room was added!") + "\n\n");

			//ELSE
			else

				//Display message that room was not added
				System.out.print("\n\n" + Util.setLeft(50, "Room was NOT added!") + "\n\n");

			//END IF

			//Get another room number or return to main menu
			System.out.print(Util.setLeft(38, "Enter a room number or 0 to return to menu: "));
			room = Keyboard.readString();

		}
		//END WHILE

	}//End addRooms

	/**********************************************************
	* Method Name    : deleteRooms
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and call
	*	 a method that displays a office's rooms with index numbers next
	*	 to each room. That same method will get an index choice from the
	*	 user and use that choice to call a method that deletes the room
	*    the user chose. This method allows user to delete multiple rooms or
	*	 to	quit/return to menu. This method will also let the user know
	*	 if a room was deleted or not.
	*
	* BEGIN deleteRooms
	*	 Clear screen
	*	 Print blank lines for output purpose
	*	 Display room list with index number and get index number to delete
	*	 WHILE(User index input is not return)
	*		 Clear screen
	*	  	 IF(Room is deleted)
	*			Display message that the room was deleted
	*		 ELSE
	*			Display message that no room was deleted
	*		 END IF
	*		 Print blank lines for output purpose
	*		 Display room list with index number and get index number to delete
	*	 END WHILE
	* END deleteRooms
    **********************************************************/

	public static void deleteRooms(OfficeInfo office)
	{
		//local constants
		final int RETURN = 0;				//Represents a value used to quit/return to menu

		//local variables
		int indexIn;						//Represents the index choice the user inputs

		/****************************************************/

		//Clear screen
		Util.cls();

		//Print blank lines for output purpose
		System.out.print("\n\n\n\n\n\n");

		//Display room list with index number and get index number to delete
		indexIn = office.displayRoomIndex();

		//WHILE(User index input is not return)
		while(indexIn != RETURN)
		{
			//Clear screen
			Util.cls();

			//IF(Room is deleted)
			if(office.deleteRoom(indexIn))

				//Display message that the room was deleted
				System.out.print("\n\n\n" + Util.setLeft(51, "Room was deleted!"));

			//ELSE
			else

				//Display message that no room was deleted
				System.out.print("\n\n\n" + Util.setLeft(50, "No room was deleted!"));

			//END IF

			//Print blank lines for output purposes
			System.out.print("\n\n\n");

			//Display room list with index number and get index number to delete
			indexIn = office.displayRoomIndex();

		}
		//END WHILE

	}//End deleteRooms

	/**********************************************************
	* Method Name    : reserveRoom
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will allow the user to reserve a room.
	*	 This method will call another method to display a list of available
	*	 rooms. The user will then be prompted to enter a room number to reserve.
	*	 If that method returns true, it means the user was successful at reserving
	*	 room, and a message will let user know room was reserved. If the method
	*	 invoked returns false, this method will display a message that the room
	*	 was not reserved.
	*
	* BEGIN reserveRoom
	*	 Clear screen
	*	 IF(Room entered was reserved)
	*	 	Display output that room was reserved
	*	 ELSE(Room was not reserved)
	*		Display output that room was not reserved
	*	 END IF
	*	 Pause the screen by prompting the user for input
	* END reserveRoom
	**********************************************************/

	public static void reserveRoom(OfficeInfo office)
	{
		//local constants

		//local variables
		String pause;			//Arbitrary string value used to pause the screen

		/**********************************************************/

		//Clear the screen
		Util.cls();

		//IF(Room entered was reserved)
		if(office.displayForReserve())

			//Display output that room was reserved
			System.out.print("\n\n" + Util.setLeft(51, "Room was reserved!"));

		//ELSE
		else

			//Display output that room was not reserved
			System.out.print("\n\n" + Util.setLeft(49, "Room was not reserved!"));

		//END IF

		//Pause the screen by prompting user for input
		System.out.print("\n\n" + Util.setLeft(44, "Enter 0 to return to main menu: "));
		pause = Keyboard.readString();

	}//End reserveRoom

	/**********************************************************
	* Method Name    : releaseRoom
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will allow the user to release a room.
	*	 This method will call another method to display a list of reserved rooms,
	*	 and allow the user to enter which room they would like to release. If that
	*	 method returns true, it means the user was successful at releasing room,
	*	 and a message will let user know room was released. If the method invoked
	*	 returns false, this method will display a message that the room was not released.
	*
	* BEGIN releaseRoom
	*	 Clear screen
	*	 IF(Room entered was released)
	*	 	Display output that room was released
	*	 ELSE(Room was not released)
	*		Display output that room was not released
	*	 END IF
	*	 Pause the screen by prompting the user for input
	* END releaseRoom
	**********************************************************/

	public static void releaseRoom(OfficeInfo office)
	{
		//local constants

		//local variables
		String pause;			//Arbitrary string value used to pause the screen

		/**********************************************************/

		//Clear the screen
		Util.cls();

		//IF(Room entered was released)
		if(office.displayForRelease())

			//Display output that room was released
			System.out.print("\n\n" + Util.setLeft(51, "Room was released!"));

		//ELSE
		else

			//Display output that room was not released
			System.out.print("\n\n" + Util.setLeft(49, "Room was not released!"));

		//END IF

		//Pause the screen by prompting user for input
		System.out.print("\n\n" + Util.setLeft(44, "Enter 0 to return to main menu: "));
		pause = Keyboard.readString();

	}//End releaseRoom

	/**********************************************************
	* Method Name    : displayBuilding
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and display
	*	 the contents/info of an office building object.  This will include
	*	 building info, as well as a list of rooms, with room info included.
	*
	* BEGIN displayBuilding
	*	 Clear screen
	*	 Display the office object
	*	 Pause the screen by prompting the user for input
	* END displayBuilding
	**********************************************************/

	public static void displayBuilding(OfficeInfo office)
	{
		//local constants

		//local variables
		String pause;				//Arbitrary value input by user to pause screen
		/*******************************************************/

		//Clear the screen
		Util.cls();

		//Display the office object
		System.out.print("\n\n" + office.toString());

		//Pause the screen by prompting user for input
		System.out.print("\n\n"+ Util.setLeft(40, "Enter any number to return to main menu: "));
		pause = Keyboard.readString();

	}//End displayBuilding

	/**********************************************************
	* Method Name    : viewAvailable
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and prompt
	*	 the user to input a minimum capacity of available rooms they
	*	 would like to view.  The method then clears the screen again and
	*	 uses the capacity input by user to call upon another method to
	*	 display a list of available rooms of at least that capacity.
	*	 The method will then pause the screen so the user can view list.
	*
	* BEGIN viewAvailable
	*	 Clear screen
	*	 Prompt user to input a minimum capacity
	*	 Clear the screen again
	*    Call method to display list of available rooms of certain size
	*	 Pause the screen by asking the user for input
	* END viewAvailable
	**********************************************************/

	public static void viewAvailable(OfficeInfo office)
	{
		//local constants

		//local variables
		int capInput;			//Represents the capacity input by the user
		String pause;			//Arbitrary input value used to pause the screen
		/**********************************************************/

		//Clear the screen
		Util.cls();

		//Prompt user to input a minimum capacity
		System.out.print("\n\n" + Util.setLeft(33, "Enter a minimum capacity of available rooms to view: "));
		capInput = Keyboard.readInt();

		//Clear the screen again
		Util.cls();

		//Call method to display list of avaialable rooms of certain size
		office.displayAvailableSize(capInput);

		//Pause the screen by asking the user for input
		System.out.print("\n\n" + Util.setLeft(42, "Enter 0 to return to the main menu: "));
		pause = Keyboard.readString();

	}//End viewAvailable

	/**********************************************************
	* Method Name    : sortOffice
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and display
	*	 sorting options for the user. The method allows the user
	*	 to choose to sort an office's rooms by room number or by capacity.
	*	 It will let the user know that the rooms were sorted, if
	*	 their choice was valid. If their sorting choice was invalid
	*	 it will let user know the office rooms were not sorted.
	*
	* BEGIN sortOffice
	*	 Clear screen
	*	 Display sorting options and ask user for sorting choice
	*	 IF(Users sorting choice is sort by room number)
	*     	Call method to sort building by room number
	*		Display message that building was sorted
	*	 ELSE
	*		IF(Users sorting choice is sort by capacity)
	*		   Call method to sort building by capacity
	*		   Display message that building was sorted
	*	 	ELSE
	*			Display message that building was not sorted
	*		END IF
	*	 END IF
	*	 Pause the screen by asking for input
	* END sortOffice
	**********************************************************/

	public static void sortOffice(OfficeInfo office)
	{
		//local constants
		final int BY_ROOM_NUM = 1;				//Used to indicate the sort by room number choice
		final int BY_CAPACITY = 2;				//Used to indicate the sort by capacity choice

		//local variables
		int sortChoice;							//Represents the sorting choice input by the user
		String pauseSort;						//Arbitrary value used to pause the screen

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display sorting options and ask user for sorting choice
		System.out.print("\n\n\n\n" +
						Util.setLeft(45, "(1) Sort rooms by room number") + "\n" +
						Util.setLeft(45, "(2) Sort rooms by capacity") + "\n\n" +
						Util.setLeft(48, "Input menu sort choice: "));
		sortChoice = Keyboard.readInt();

		//IF(Users sorting choice is sort by room number)
		if(sortChoice == BY_ROOM_NUM)
		{
			//Call method to sort players by room number
			office.sortByRoom();

			//Display message that office was sorted
			System.out.print("\n\n" +
							Util.setLeft(51, "Office was sorted!"));
		}

		//ELSE
		else

			//IF(Users sorting choice is sort by capacity)
			if(sortChoice == BY_CAPACITY)
			{
				//Call method to sort rooms by capacity
				office.sortByCapacity();

				//Display message that office was sorted
				System.out.print("\n\n" +
								Util.setLeft(51, "Office was sorted!"));
			}

			//ELSE
			else

				//Display message that office was not sorted
				System.out.print("\n\n" +
								 Util.setLeft(49, "Office was NOT sorted!"));

			//END IF

		//END IF

		//Pause the screen by asking for input
		System.out.print("\n\n" +
							Util.setLeft(47, "Enter 0 to return to menu: "));
		pauseSort = Keyboard.readString();

	}//End sortOffice

	/**********************************************************
	* Method Name    : errorMessage
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and display
	*	 an error message to the user. This method pauses the screen on
	*	 the message by asking for input.
	*
	* BEGIN errorMessage
	*	 Clear screen
	*	 Display error message
	*	 Pause screen by asking for input
	* END errorMessage
	**********************************************************/

	public static void errorMessage()
	{
		//local constants

		//local variables
		String errorPause;				//Aribitrary value used to pause the screen

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display error message
		System.out.print("\n\n\n\n" +
						Util.setLeft(46, "Your selection was invalid!!"));

		//Pause screen by asking for input
		System.out.print("\n\n" +
						Util.setLeft(42, "Enter 0 to return to the main menu: "));
		errorPause = Keyboard.readString();

	}//End errorMessage

	/**********************************************************
	* Method Name    : exitMessage
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and display
	*	 an exit and thank you method with author signature.
	*
	* BEGIN exitMessage
	*	 Clear screen
	*	 Display exit message
	*	 Display author signature
	* END exitMessage
	**********************************************************/

	public static void exitMessage()
	{
		//local constants

		//local variables

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display exit message
		System.out.print("\n\n\n\n" +
						Util.setLeft(41, "Thank you for using building manager!!"));

		//Display author signature
		System.out.print("\n\n" +
						Util.setLeft(49, "Created by:   Ryan May") + "\n" +
						Util.setLeft(49, "Class     : CSC112-301") + "\n" +
						Util.setLeft(49, "Due Date  : 09/29/2020") + "\n\n\n\n\n\n");

	}//End exitMessage

}//End OfficeDriver


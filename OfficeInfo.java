/**********************************************************
* Program Name   : OfficeInfo
* Author         : Ryan May
* Due Date       : 09/29/2020
* Course/Section : CSC112-301
* Program Description: This program allows you to construct
*	 objects that contain data for an office and the rooms in that
*	 office. The program also formats the data of a team to string
*	 data for output purposes. The program keeps track of an
*	 array of room objects, and includes methods to add or delete
*	 rooms. This program keeps provides methods to sort the array of
*	 room objects as well. The program allows you to reserve and release
*	 rooms by displaying available and reserved rooms, resepctively, and
*	 allowing the user to choose which room. Program also provides a method
*	 that displays available rooms of a certain size.
*
* Methods:
* -------
* Constructor   		-  Instantiates an obect of this class and initializes
*						   the instance data. Instantiates an array of room objects
*						   objects.
* dispAvailableSize 	-  Displays a list of rooms available of a certain size.
* addRoom				-  Adds a room object to room array if the array is not full.
*						   Returns true if a room is added, and increments counter
* deleteRoom			-  Deletes a room obect using an index number to indicate
*				 		   which room. Returns true if room is deleted.
* displayRoomIndex		-  Displays array of room objects with index numbers next to
*						   each room, and allows the user to input an index number that
*						   indicates which room to delete, and returns that number.
* displayForReserve		-  Allows you to set the name of the sport for a team object
* displayForRelease 	-  Returns the jersey number of a player
* sortByCapacity		-  Sorts the array of rooms by room capacity
* sortByRoom			-  Sorts the array of rooms by room number
* toString      		-  Formats OfficeInfo for string output
**********************************************************/

public class OfficeInfo
{
	//class constants

	//class variables
	private String buildingName;		//String representing the name of office building
	private int numRooms;				//Represents number of rooms an office building can fit
	private RoomInfo[] officeRooms;		//Array of room objects representing rooms in office building
	private int roomCount;				//Indicates the sum of rooms that have been created

	/********************************************************/

	/**********************************************************
	* Method Name    : OfficeInfo
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This is a constructor method that is used
	*	 instantiate an OfficeInfo object that represents an office building
	*	 This method takes the total amount of rooms, and the name of the
	*	 office building and uses that data to initialize the instance data of
	*	 a building, including instantiating an array of room objects
	*	 using the total rooms parameter as the size of the array.
	*	 The rest of the class data is initialized here as well to avoid
	*	 null pointers.
	*
	* BEGIN OfficeInfo
	*	 Initialize the instance data
	* END OfficeInfo
    **********************************************************/

    public OfficeInfo(int totalRooms, String officeName)
    {
		//local constants

		//local variables

		/********************************************************/

		//Initialize the instance data
		buildingName = officeName;
		numRooms = totalRooms;
		officeRooms = new RoomInfo[totalRooms];
		roomCount = 0;

	}//End OfficeInfo constructor

	/**********************************************************
	* Method Name    : displayAvailableSize
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will display a list of office rooms
	*	 that offer at least a specified capacity. The list will only include
	*	 available rooms that have not yet been reserved.  The method will
	*	 recieve an integer to determine the minumum capacity of available rooms
	*	 to display. If there are no rooms to that meet the criteria, a message
	*	 will display indicating no rooms available of that size.
	*
	* BEGIN displayAvailableSize
	*	 FOR(Each room in the array)
	*		 IF(The room is available and is at least the capacity passed in)
	*		    Display room
	*		    Set NO rooms indicator to false
	*		 END IF
	*	 END FOR
	*	 IF(There are no rooms available of size passed in)
	*		 Display message that no rooms available of that size
	*	 END IF
	* END displayAvailableSize
    **********************************************************/

	public void displayAvailableSize(int size)
	{
		//local constants

		//local variables
		boolean noRooms = true;			//Boolean that indicates no available rooms of a size when true

		/*********************************************************/


		//Display header
		System.out.print("\n\n" + Util.setLeft(42, "Room      Capacity      Availability")
						+"\n");

		//FOR(each room in the array)
		for(int count = 0; count < roomCount; count++)
		{
			//IF(The room is available and is at least the capacity passed in)
			if(officeRooms[count].getStatus() && officeRooms[count].getCapacity() >= size)
			{
				//Display room
				System.out.println(Util.setLeft(42, officeRooms[count].toString()));

				//Set NO rooms indicator to false
				noRooms = false;
			}
			//END IF

		}
		//END FOR

		//IF(There are no rooms available of size passed in)
		if(noRooms)

				//Display message that no rooms available of that size
				System.out.print("\n\n" +Util.setLeft(42, "No rooms are available of that size!"));

		//ENDIF

	}//End displayAvailableSize

	/**********************************************************
	* Method Name    : addRoom
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will add a room to our array of
	*	 rooms if the array isn't full. The method will check to see if the
	*	 array is full, and if it's not it will place the room object passed
	*	 in and place it in the next room array element.  If a room was added
	*	 this method will return a boolean value of true, if no room was added
	*	 this method will return a boolean value of false.
	*
	* BEGIN addRoom
	*	 IF(The room array is not full)
	*	  	Add room obect to the next available array element
	*		Increment the room count
	*		Set room added indicator to added value
	*	 ELSE
	*		Set room added indicator to not added value
	*	 END IF
	*	 Return true if a room was added, return false if a room was not added
	* END addRoom
    **********************************************************/

	public boolean addRoom(RoomInfo room)
	{
		//local constants

		//local variables
		boolean roomAdded;						//Room added indicator 0 if player was added 1 if player was not

		/****************************************************/

		//IF(The room array is not full)
		if(roomCount < numRooms)
		{
			//Add room object to the next available array element
			officeRooms[roomCount] = room;

			//Increment the room count
			roomCount += 1;

			//Set room added indicator to true
			roomAdded = true;
		}

		//ELSE
		else

			//Set room added indicator false
			roomAdded = false;

		//END IF

		//Return true if a room was added, return false if a room was not added
		return (roomAdded);

	}//End addRoom

	/**********************************************************
	* Method Name    : deleteRoom
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will receive an integer that
	*	 represents the index number of the room the user wants to delete.
	*	 The method will make sure that the index is valid, and will delete
	*	 the room at that index by shifting all the rooms up one spot in the array
	*	 that came after the deleted array, and decrementing the room count. If
	*	 the deletion was successful this method returns true, if no room
	*	 was deleted this method returns false.
	*
	* BEGIN deleteRoom
	*	 IF(The index of the room is valid)
	*	  	FOR(Each room that comes after the deleted room in the room array)
	*			Shift each room up one spot in the room array
	*		END FOR
	*		Decrement the room count
	*	 END IF
	*	 Return true if a room was deleted, return false if a room was not deleted
	* END deleteRoom
    **********************************************************/

	public boolean deleteRoom(int indexNum)
	{
		//local constants

		//local variables

		/****************************************************/

		//IF(The index of the player is valid)
		if(indexNum > 0 && indexNum <= roomCount)
		{
				//FOR(Each player that comes after the deleted player in the player array)
				for(int count = indexNum; count < roomCount; count ++)
				{
					//Shift each player up one spot in the player array
					officeRooms[count-1] = officeRooms[count];
				}
				//END FOR

				//Decrement the room count
				roomCount -= 1;
		}
		//END IF

		//Return true if a player was deleted, return false if a player was not deleted
		return (indexNum > 0 && indexNum <= roomCount);

	}//End deleteRoom

	/**********************************************************
	* Method Name    : displayRoomIndex
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will display a list of rooms in an
	*	 office building, with index numbers next to each room. This
	*	 method will then prompt the user to choose an index number of
	*	 a room they would like to delete. The index number they choose
	*	 is returned by this method as an integer.
	*
	* BEGIN displayRoomIndex
	*	 Display header
	*	 FOR(Each room in the array)
	*	     Display room info of each room on separate line with index numbers
	*	 END FOR
	*	 Ask user for index number of the room they want to delete
	*	 Return the users index choice as an integer
	* END displayRoomIndex
    **********************************************************/

	public int displayRoomIndex()
	{
		//local constants

		//local variables
		int indexIn;				//Represents the index number that the user chooses

		/****************************************************/

		//Display header
		System.out.print(Util.setLeft(38, "INDEX   Room      Capacity      Availability")
						+"\n");

		//FOR(Each player in the array)
		for(int roomIndex = 1; roomIndex <= roomCount; roomIndex ++)
		{
			//Display player info of each player on separate line with index numbers
			System.out.print(Util.setRight(41, "" + roomIndex) +
							Util.setLeft(5, "" +  officeRooms[roomIndex-1]) +
							"\n");
		}
		//END FOR

		//Ask user for index number of the room they want to delete
		System.out.print("\n" + Util.setLeft(32, "Enter index of room you want to delete or 0 to return: "));
		indexIn = Keyboard.readInt();

		//Return the users index choice as an integer
		return indexIn;

	}//End displayRoomIndex

	/**********************************************************
	* Method Name    : displayForReserve
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will display a list of rooms that are
	*	 available to reserve. The user will be prompted to enter a room they would
	*	 like to reserve or quit to main menu. If the user enters a room, the method
	*	 will check to make sure it's a valid room number. If the user enters a valid
	*	 number this method will call a separate method to set that room to reserved,
	*	 and the method will return a true value.  If they enter an invalid room or
	*	 choose to quit, this method will return false.
	*
	* BEGIN displayForReserve
	*	 Display header
	*	 FOR(Each room in the array)
	*	 	IF(The room is available)
	*		   Display room with a new line
	*		END IF
	*	 END FOR
	*	 Ask user for room number of the room they want to reserve
	*	 Format room number input to 4 characters
	*	 FOR(Each room in the array)
	*	 	IF(The room is valid and available)
	*		   Set room to reserved
	*		   Set reserved indicator to true
	*		END IF
	*	 END FOR
	*	 Return true if room was reserved and false if not
	* END displayForReserve
    **********************************************************/

	public boolean displayForReserve()
	{
		//local constants
		final int ROOM_MAX_LENGTH = 4;		//Represents max length of the room number

		//local variables
		String room4Reserve;				//Room number input by user to reserve room
		boolean isReserved = false;			//Boolean that returns true if room was reserved
		/****************************************************/

		//Display header
		System.out.print("\n\n" + Util.setLeft(42, "Room      Capacity      Availability")
						+"\n");

		//FOR(Each room in the array)
		for(int count = 0; count < roomCount; count ++)
		{
			//IF(The room is available)
			if(officeRooms[count].getStatus())

				//Display room with a new line
				System.out.print(Util.setLeft(42, "" +  officeRooms[count]) +
							"\n");

			//END IF
		}
		//END FOR

		//Ask user for the room number of the room they want to reserve
		System.out.print("\n" + Util.setLeft(31, "Enter a room number to reserve that room or 0 to return: "));
		room4Reserve = Keyboard.readString();

		//Format room number input to 4 characters
		room4Reserve = Util.formatNameLength(ROOM_MAX_LENGTH, room4Reserve);

		//FOR(Each room in the array)
		for(int count = 0; count < roomCount; count ++)
		{
			//IF(Room is valid and is available)
			if(room4Reserve.equalsIgnoreCase(officeRooms[count].getRoomNum()) && officeRooms[count].getStatus())
			{
				//Set room to reserved
				officeRooms[count].setReserved();

				//Set reserved indicator to true
				isReserved = true;

			}//END IF

		}//END FOR


		//Return true if room was reserved and false if not
		return isReserved;

	}//End displayForReserve

	/**********************************************************
	* Method Name    : displayForRelease
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will display a list of rooms that are
	*	 reserved. If there are no rooms reserved a message will let the user know.
	*	 The user will be prompted to enter a room they would like to relase or quit
	*	 to main menu. If the user enters a room, the method will check to make sure
	*	 it's a valid room number. If the user enters a valid number this method will
	*	 call a separate method to set that room to released, and the method will return
	*	 a true value.  If they enter an invalid room or choose to quit, this method will
	*	 return false.
	*
	* BEGIN displayForRelease
	*	 Display header
	*	 FOR(Each room in the array)
	*	 	IF(The room is reserved)
	*		   Display room with a new line
	*		END IF
	*	 END FOR
	*	 Ask user for room number of the room they want to release
	*	 Format room input to 4 characters
	*	 FOR(Each room in the array)
	*	 	IF(The room is valid and available)
	*		   Set room to available
	*		   Set released indicator to true
	*		END IF
	*	 END FOR
	*	 Return true if room was released and false if not
	* END displayForRelease
    **********************************************************/

	public boolean displayForRelease()
	{
		//local constants
		final int ROOM_MAX_LENGTH = 4; 		//Represents max length of the room number
		//local variables
		String room4Release;				//Room number input by user to release room
		boolean isReleased = false;			//Boolean that returns true if room was released
		/****************************************************/

		//Display header
		System.out.print("\n\n" + Util.setLeft(42, "Room      Capacity      Availability")
						+ "\n");

		//FOR(Each room in the array)
		for(int count = 0; count < roomCount; count ++)
		{
			//IF(The room is reserved)
			if(!officeRooms[count].getStatus())

				//Display room with a new line
				System.out.print(Util.setLeft(42, "" +  officeRooms[count]) +
							"\n");

			//END IF
		}
		//END FOR

		//Ask user for the room number of the room they want to release
		System.out.print("\n" + Util.setLeft(31, "Enter a room number to release that room or 0 to return: "));
		room4Release = Keyboard.readString();

		//Format room number input to 4 characters
		room4Release = Util.formatNameLength(ROOM_MAX_LENGTH, room4Release);

		//FOR(Each room in the array)
		for(int count = 0; count < roomCount; count ++)
		{
			//IF(Room is valid and is reserved)
			if(room4Release.equalsIgnoreCase(officeRooms[count].getRoomNum()) && !officeRooms[count].getStatus())
			{
				//Set room to available
				officeRooms[count].setAvailable();

				//Set released indicator to true
				isReleased = true;

			}//END IF

		}//END FOR


		//Return true if room was released and false if not
		return isReleased;

	}//End displayForRelease

	/**********************************************************
	* Method Name    : sortByCapacity
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will use nested 'for' loops
	*	 to compare the room capacities of room objects that are next to
	*	 eachother in an array and places the objects in numerical order
	*	 according to room capacity by creating a tempory elements to shift
	*	 array elements.  This is considered bubble sorting.
	*
	* BEGIN sortByCapacity
	* 	 FOR(As long as the array is not sorted)
	*		 FOR(Each element next to each other in the array)
	*			 IF(Room elements capacity are not in numerically ascending order)
	*				Store the room with the larger capacity as a temporary room object
	*				Shift the room with the smaller capacity up in the array
	*				Shift the room with the bigger capacity down in the array
	*			 END IF
	*		 END FOR
	*	 END FOR
	* END sortByCapacity
    **********************************************************/

	public void sortByCapacity()
	{
		//local constants

		//local variables
		RoomInfo tempRoom;					//Represents a room object for temporary storage purposes

		/****************************************************/

		//FOR(As long as array is not sorted)
		for(int i = 0; i < roomCount; i++)
		{
			//FOR(Each element next to each other in the array)
			for(int j = i + 1; j < roomCount; j++)
			{
				//IF(Room elements capacity are not in numerically ascending order)
				if(officeRooms[i].getCapacity() > officeRooms[j].getCapacity())
				{
					//Store the room with the larger capacity as a temporary room object
					tempRoom = officeRooms[i];

					//Shift the room with the smaller capacity up in the array
					officeRooms[i] = officeRooms[j];

					//Shift the room with the bigger capacity down in the array
					officeRooms[j] = tempRoom;
				}
				//END IF
			}
			//END FOR
		}
		//END FOR

	}//End soryByCapacity

	/**********************************************************
	* Method Name    : sortByRoom
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will use nested 'for' loops
	*	 to compare the room numbers of room objects that are next to
	*	 eachother in an array and places the objects in numerical order
	*	 according to room number by creating a tempory elements to shift
	*	 array elements.  This is considered bubble sorting.
	*
	* BEGIN sortByCapacity
	* 	  FOR(As long as the array is not sorted)
	*		  FOR(Each element next to each other in the array)
	*			  IF(Room elements room nums are not in numerically ascending order)
	*				  Store the room with the larger room num as a temporary room object
	*				  Shift the room with the smaller room num up in the array
	*				  Shift the room with the bigger room num down in the array
	*			  END IF
	*		  END FOR
	*	  END FOR
	* END sortByCapacity
    **********************************************************/

	public void sortByRoom()
	{
		//local constants

		//local variables
		RoomInfo tempRoom;					//Represents a room object for temporary storage purposes

		/****************************************************/

		//FOR(As long as array is not sorted)
		for(int i = 0; i < roomCount; i++)
		{
			//FOR(Each element next to each other in the array)
			for(int j = i + 1; j < roomCount; j++)
			{
				//IF(Room elements room nums are not in numerically ascending order)
				if(officeRooms[i].getRoomNum().compareToIgnoreCase(officeRooms[j].getRoomNum()) > 0)
				{
					//Store the room with the larger room num as a temporary room object
					tempRoom = officeRooms[i];

					//Shift the room with the smaller room num up in the array
					officeRooms[i] = officeRooms[j];

					//Shift the room with the bigger room num down in the array
					officeRooms[j] = tempRoom;
				}
				//END IF
			}
			//END FOR
		}
		//END FOR

	}//End sortByRoom

	/*********************************************************************
	* Method Name    : toString
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will format the data of an
	*	 office building object to a string for output purposes.
	*
	* BEGIN toString
	* 	 Format the office building header and rooms header
	*	 FOR(Each room that has been created)
	*	 	 Add room to output on its own line
	*	 END FOR
	*	 Return building output formatted as string
	* END toString
    **********************************************************************/

	public String toString()
	{
		//local constants

		//local variables
		String output;				//Represents the String output of our building object
		/************************************************************/

		//Format the office building header and rooms header
		output = Util.setLeft(50, "Building Name: " + buildingName) + "\n" +
				 Util.setLeft(50, "Total Rooms  : " + numRooms) + "\n" +
				 Util.setLeft(50, "Rooms Created: " + roomCount) + "\n\n" +
				 Util.setLeft(42, "Room      Capacity      Availability") + "\n";

		//FOR(Each room that has been created)
		for(int count = 0; count < roomCount; count ++)

			//Add room to output on its own line
			output += Util.setLeft(42, "" + officeRooms[count]) + "\n";

		//END FOR

		//Return building output formatted as string
		return output;
	}


}//End OfficeInfo
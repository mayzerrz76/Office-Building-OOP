/**********************************************************
* Program Name   : RoomInfo
* Author         : Ryan May
* Due Date       : 09/29/2020
* Course/Section : CSC112-301
* Program Description: This program allows you to construct
*	 objects that contain data about an office room. The
*	 program also formats the data of a room to string
*	 data for output purposes. The room is initialized to
*	 available when a room object is created.
*
* Methods:
* -------
* Constructor   -  Instantiates an obect of this class and initializes
*				   the instance data. Constructs a room object set to available
*				   by default.
* getStatus 	-  Returns true if a room is available, false if room is reserved
* setReserved   -  Sets the status of the room to reserved
* setAvailable  -  Sets the status of the room to avaialable
* getCapacity	-  Returns the capacity of a room
* getRoomNum	-  Returns the room number as a string
* toString      -  Formats the objects data to a string output
**********************************************************/
public class RoomInfo
{
	//class constants

	//class variables
	private String roomNum;				//Represents a room number of an office room
	private int roomCap;				//Represents the capacity of an office room
	private boolean roomAvailable;		//Boolean representing a room's availability

	/**********************************************************
	* Method Name    : RoomInfo
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This is a constructor method that is
	* 	 used to instantiate a RoomInfo object that represents a building
	* 	 room. This method takes the room number and room capacity as parameters
	* 	 and uses those values to initialize/instantiate a room object.  The
	* 	 room is initialized to available by default.
	*
	* BEGIN RoomInfo
	*	 Initialize the instance data
	* END RoomInfo
    **********************************************************/

	public RoomInfo(String roomIn, int capacity)
	{
		//local constants

		//local variables

		/******************************************************/

		//Initialize the instance data
		roomNum = roomIn;
		roomCap = capacity;
		roomAvailable = true;


	}//End RoomInfo constructor

	/**********************************************************
	* Method Name    : getStatus
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will return the availabilty of
	*    a room as a boolean. It will return true if the room is available
	*	 and false when the room is reserved.
	*
	* BEGIN getStatus
	*	 Return true if room is available, false if reserved
	* END getStatus
    **********************************************************/

	public boolean getStatus()
	{
		//local constants

		//local variables

		/****************************************************/

		//Return true if room is available, false if reserved
		return roomAvailable;


	}//End getStatus

	/**********************************************************
	* Method Name    : setReserved
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will set the status of a
	*	 room to reserved. This will set a false value to the
	*	 room availability boolean.
	*
	* BEGIN setReserved
	*	 Set room to reserved
	* END setReserved
    **********************************************************/

	public void setReserved()
	{
		//local constants

		//local variables

		/****************************************************/

		//Set room to reserved
		roomAvailable = false;


	}//End setReserved

	/**********************************************************
	* Method Name    : setAvailable
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will set the status of a
	*	 room to reserved. This will set a true value to the
	*	 room availability boolean.
	*
	* BEGIN setReserved
	*	 Set room to reserved
	* END setReserved
    **********************************************************/

	public void setAvailable()
	{
		//local constants

		//local variables

		/****************************************************/

		//Set room to available
		roomAvailable = true;

	}//End setAvailable

	/**********************************************************
	* Method Name    : getCapacity
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will return the capacity of
	*	 a room as an integer.
	*
	* BEGIN getCapacity
	*	 Return the capacity of the room as an int
	* END getCapacity
    **********************************************************/

	public int getCapacity()
	{
		//local constants

		//local variables

		/****************************************************/

		//Return the capacity of the room as an int
		return roomCap;

	}//End getCapacity

	/**********************************************************
	* Method Name    : getRoomNum
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC112-301
	* Program Description: This method will return the a room's
	*	 room number as a string.
	*
	* BEGIN getRoomNum
	*	 Return the room number as a string
	* END getRoomNum
    **********************************************************/

	public String getRoomNum()
	{
		//local constants

		//local variables

		/****************************************************/

		//Return the room number as a string
		return roomNum;

	}//End getRoomNum

	/**********************************************************
	* Method Name    : toString
	* Author         : Ryan May
	* Due Date       : 09/29/2020
	* Course/Section : CSC111-302
	* Program Description: This method will format the data of a
	*	 room object to a string for output purposes.
	*
	* BEGIN toString
	*    IF(the room is available)
	*	    Set status string to available
	*	 ELSE
	*		Set status string to reserved
	*	 END IF
	* 	 Format string output of room object
	*	 Return output
	* END toString
    **********************************************************/

	public String toString()
	{
		//local constants

		//local variables
		String output; 					//String output of our object
		String status;					//String used to indicated the status of a room
		/****************************************************/

		//IF(the room is available)
		if(roomAvailable)

			//Set status string to available
			status = "Available";

		//ELSE
		else

			//Set status string to reserved
			status = "Reserved";

		//ENDIF

		//Format string output of room object
		output = "" + roomNum + Util.setRight(14, "" + roomCap) +
				Util.setRight(18, status);

		//Return Output
		return output;

	}//End toString

}//End RoomInfo

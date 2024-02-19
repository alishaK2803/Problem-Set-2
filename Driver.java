import java.util.ArrayList;

/**
 * This class tests the "Reserving Rooms" Hotel class for Problem Set 2
 * 
 * @author Prof. White
 * @version Fall 2019
 */
public class Driver
{
    public static void main(String args[])
    {
        System.out.println("Constructing a room\n");
        Room room = new Room(110, View.OCEAN_FRONT, 8, true);
        System.out.println("Room.getRoomNumber\nExpected:\t110\nReceived:\t" + room.getRoomNumber());
        System.out.println("\nRoom.getView\nExpected:\tOCEAN_FRONT\nReceived:\t" + room.getView());
        System.out.println("\nRoom.getMaxCapacity\nExpected:\t8\nReceived:\t" + room.getMaxCapacity());
        System.out.println("\nRoom.hasKitchenette\nExpected:\ttrue\nReceived:\t" + room.hasKitchenette());
        System.out.println("\nRoom.toString Expected:\tRoom Number: 110\tView:  Ocean Front\tMaximum Capacity:  8\tKitchenette");
        System.out.print("Room.toString Received:\t");
        System.out.println(room.toString());

        System.out.println("\n**********\nModifying room with room.setRoomNumber, room.setView, room.setMaxCapacity, room.setKitchenette");
        room.setRoomNumber(999);
        room.setView(View.OCEAN_SIDE);
        room.setMaxCapacity(4);
        room.setKitchenette(false);
        System.out.println("\nRoom.getRoomNumber Expected:  999");
        System.out.println(("Room.getRoomNumber Received:  " + room.getRoomNumber()));
        System.out.println("\nRoom.getView Expected:  OCEAN_SIDE");
        System.out.println("Room.getView Received:  " + room.getView());
        System.out.println("\nRoom.getMaxCapacity Expected:  4");
        System.out.println("Room.getMaxCapacity Received:  " + room.getMaxCapacity());
        System.out.println("\nRoom.hasKitchenette Expected:  false");
        System.out.println("Room.hasKitchenette Received:  " + room.hasKitchenette());

        System.out.println("\n**********\nModifying view");
        room.setView(View.STREET_SIDE);
        System.out.println("\nRoom.getView Expected:  Street Side");
        System.out.print("Room.getView Received:  ");
        switch(room.getView())
        {
            case OCEAN_FRONT: System.out.println("Ocean Front"); break;
            case OCEAN_SIDE: System.out.println("Ocean Side"); break;
            case STREET_SIDE:  System.out.println("Street Side"); 
        }

        System.out.println("\n**********\nCreating hotel, input availableRooms and reservedRooms");
        ArrayList<Room> avail = new ArrayList<Room>();
        ArrayList<Room> reserve = new ArrayList<Room>();
        avail.add(new Room(102, View.OCEAN_SIDE, 7, true));
        avail.add(new Room(104, View.STREET_SIDE, 5, true));
        avail.add(new Room(105, View.STREET_SIDE, 4, true));
        avail.add(new Room(201, View.STREET_SIDE, 4, false));
        avail.add(new Room(203, View.OCEAN_SIDE, 6, false));
        avail.add(new Room(205, View.OCEAN_FRONT, 8, false));
        reserve.add(new Room(101, View.OCEAN_FRONT, 8, true));
        reserve.add(new Room(103, View.OCEAN_SIDE, 6, true));
        reserve.add(new Room(202, View.STREET_SIDE, 5, false));
        reserve.add(new Room(204, View.OCEAN_SIDE, 7, false));
        Hotel hotel = new Hotel(avail, reserve);
        avail = null;
        reserve = null;
        System.out.println("\nHotel.toString Expected:");
        System.out.println("Available Rooms:\nRoom Number: 102\tView:  Ocean Side\tMaximum Capacity:  7\tKitchenette");
        System.out.println("Room Number: 104\tView:  Street Side\tMaximum Capacity:  5\tKitchenette");
        System.out.println("Room Number: 105\tView:  Street Side\tMaximum Capacity:  4\tKitchenette");
        System.out.println("Room Number: 201\tView:  Street Side\tMaximum Capacity:  4");
        System.out.println("Room Number: 203\tView:  Ocean Side\tMaximum Capacity:  6");
        System.out.println("Room Number: 205\tView:  Ocean Front\tMaximum Capacity:  8");
        System.out.println("\nReserved Rooms:\nRoom Number: 101\tView:  Ocean Front\tMaximum Capacity:  8\tKitchenette");
        System.out.println("Room Number: 103\tView:  Ocean Side\tMaximum Capacity:  6\tKitchenette");
        System.out.println("Room Number: 202\tView:  Street Side\tMaximum Capacity:  5");
        System.out.println("Room Number: 204\tView:  Ocean Side\tMaximum Capacity:  7");

        System.out.println("\n\nHotel.toString Received:");
        System.out.println(hotel.toString());

        System.out.println("\n**********\nHotel.reserveRoom, Hotel.makeRoomAvailable, Hotel.getAllAvailableRooms, Room.getRoomNumber");
        System.out.println("Attempting to reserve rooms 104, 103, and 205");
        System.out.println("\nExpected hotel.reserveRoom: true\nReceived hotel.reserveRoom: " + hotel.reserveRoom(104));
        System.out.println("\nExpected hotel.reserveRoom: false\nReceived hotel.reserveRoom: " + hotel.reserveRoom(103));
        System.out.println("\nExpected hotel.reserveRoom: true\nReceived hotel.reserveRoom: " + hotel.reserveRoom(205));
        System.out.println("\nAttempting to make rooms 101, 102, and 204 available");
        System.out.println("Expected hotel.makeRoomAvailable: true\nReceived hotel.makeRoomAvailable: " + hotel.makeRoomAvailable(101));
        System.out.println("\nExpected hotel.makeRoomAvailable: false\nReceived hotel.makeRoomAvailable: " + hotel.makeRoomAvailable(102));
        System.out.println("\nExpected hotel.makeRoomAvailable: true\nReceived hotel.makeRoomAvailable: " + hotel.makeRoomAvailable(204));
        System.out.println("\nhotel.getAllAvailableRooms Expected: 101 102 105 201 203 204");
        System.out.print("hotel.getAllAvailableRooms Received: ");
        avail = hotel.getAllAvailableRooms();
        for(Room rm : avail)
        {
            System.out.print(rm.getRoomNumber() + " ");
        }
        System.out.println();
        System.out.println("\nHotel.getAllReservedRooms Expected:  103 104 202 205");
        System.out.print("Hotel.getAllReservedRooms Received:  ");
        reserve = hotel.getAllReservedRooms();
        for(Room rm : reserve)
        {
            System.out.print(rm.getRoomNumber() + " ");
        }
        System.out.println();

        System.out.println("\n**********\nCreating hotel, default constructor");
        hotel = new Hotel();

        System.out.println("\nHotel.addNewRoom");
        System.out.println("Expected:  Rooms on floors 1 and 2;");
        System.out.println("Expected:  Rooms 1 - 3 are ocean front, with capacity 6 and kitchenette");
        System.out.println("Expected:  Room 4 is ocean side, with capacity 4 and kitchenette");
        System.out.println("Expected:  Rooms 5 - 7 are street side, with capacity 8 - NO kitchenette");
        System.out.println("Expected:  Room 8 is ocean side, with capacity 5 and kitchenette");
        System.out.println("Expected:  No rooms are reserved.");  

        for (int floor = 1; floor < 3; floor++)
        {
            hotel.addNewRoom(new Room(floor * 100 + 4, View.OCEAN_SIDE, 4, true));

            for(int roomNum = 1; roomNum < 4; roomNum++)
            {
                hotel.addNewRoom(new Room(floor * 100 + roomNum, View.OCEAN_FRONT, 6, true));
            }

            hotel.addNewRoom(new Room(floor * 100 + 8, View.OCEAN_SIDE, 5, true));

            for(int roomNum = 5; roomNum < 8; roomNum++)
            {
                hotel.addNewRoom(new Room(floor * 100 + roomNum, View.STREET_SIDE, 8, false));
            }
        }           

        System.out.println("\nHotel.toString Received:");
        System.out.println(hotel.toString());

        System.out.println("\n**********\nHotel.reserveRoom");
        hotel.reserveRoom(101);
        hotel.reserveRoom(208);

        System.out.println("\nHotel.getAvailableRoomByRoomNumber Expected:  true\nHotel.getAvailableRoomByRoomNumber Received:  " + (hotel.getAvailableRoomByRoomNumber(101) == null));
        System.out.println("\nHotel.getReservedRoomByRoomNumber Expected:\tRoom Number: 101\tView:  Ocean Front\tMaximum Capacity:  6\tKitchenette\nHotel.getReservedRoomByRoomNumber Received:\t" + hotel.getReservedRoomByRoomNumber(101).toString());
        System.out.println("\nHotel.getAvailableRoomByRoomNumber Expected:\tRoom Number: 102\tView:  Ocean Front\tMaximum Capacity:  6\tKitchenette\nHotel.getAvailableRoomByRoomNumber Received:\t" + hotel.getAvailableRoomByRoomNumber(102).toString());
        System.out.println("\nHotel.getReservedRoomByRoomNumber Expected:  true\nHotel.getReservedRoomByRoomNumber Received:  " + (hotel.getReservedRoomByRoomNumber(102) == null));

        System.out.println("\n***********\nHotel.makeRoomAvailable");
        hotel.makeRoomAvailable(101);

        System.out.println("\nHotel.getAvailableRoomByRoomNumber Expected:\tRoom Number: 101\tView:  Ocean Front\tMaximum Capacity:  6\tKitchenette\nhotel.getAvailableRoomByRoomNumber Received:\t" + hotel.getAvailableRoomByRoomNumber(101).toString());
        System.out.println("\nHotel.getReservedRoomByRoomNumber Expected:  true\nHotel.getReservedRoomByRoomNumber Received:  " + (hotel.getReservedRoomByRoomNumber(101) == null));
        System.out.println("\nHotel.getAvailableRoomByRoomNumber Expected:  true\nHotel.getAvailableRoomByRoomNumber Received:  " + (hotel.getAvailableRoomByRoomNumber(208) == null));
        System.out.println("\nHotel.getReservedRoomByRoomNumber Expected:\tRoom Number: 208\tView:  Ocean Side\tMaximum Capacity:  5\tKitchenette\nHotel.getReservedRoomByRoomNumber Received:\t" + hotel.getReservedRoomByRoomNumber(208).toString());

        System.out.println("\n**********\nHotel.getAvailableRooms >= first floor, ocean front view, capacity >= 4, with kitchenette");
        System.out.println("Setting room 102 to no kitchenette, room 103 to max capacity 4");
        hotel.getAvailableRoomByRoomNumber(102).setKitchenette(false);
        hotel.getAvailableRoomByRoomNumber(103).setMaxCapacity(4);

        System.out.println("\nHotel.getAvailableRooms Expected:");
        System.out.println("Room Number: 101	View:  Ocean Front	Maximum Capacity:  6	Kitchenette");
        System.out.println("Room Number: 103	View:  Ocean Front	Maximum Capacity:  4	Kitchenette");
        System.out.println("Room Number: 201	View:  Ocean Front	Maximum Capacity:  6	Kitchenette");
        System.out.println("Room Number: 202	View:  Ocean Front	Maximum Capacity:  6	Kitchenette");
        System.out.println("Room Number: 203	View:  Ocean Front	Maximum Capacity:  6	Kitchenette");

        System.out.println("\nHotel.getAvailableRooms Received:");
        avail = hotel.getAvailableRooms(1, View.OCEAN_FRONT, 4, true);
        for(Room rm : avail)
        {
            System.out.println(rm.toString());
        }

        System.out.println("\n**********\nHotel.getAvailableRooms >= second floor, street side view, capacity >= 8, no kitchenette");
        System.out.println("Setting room 205 max capacity to 4, room 206 to kitchenette");
        hotel.getAvailableRoomByRoomNumber(205).setMaxCapacity(4);
        hotel.getAvailableRoomByRoomNumber(206).setKitchenette(true);
        
        System.out.println("\nHotel.getAvailableRooms Expected:");
        System.out.println("Room Number: 207	View:  Street Side	Maximum Capacity:  8");
        System.out.println("\nHotel.getAvailableRooms Received:");
        avail = hotel.getAvailableRooms(2, View.STREET_SIDE, 6, false);
        for(Room rm : avail)
        {
            System.out.println(rm.toString());
        }

    }        
}



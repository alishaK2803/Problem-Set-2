import java.util.ArrayList;

/**
 * 
 * @author Prof. White
 * @version Fall 2019
 */
public class Hotel {
    private ArrayList<Room> availableRooms;
    private ArrayList<Room> reservedRooms;

    public Hotel() {
        this.availableRooms = new ArrayList<>();
        this.reservedRooms = new ArrayList<>();
    }

    public Hotel(ArrayList<Room> availableRooms, ArrayList<Room> reservedRooms) {
        this.availableRooms = availableRooms;
        this.reservedRooms = reservedRooms;
    }

    /**
     * Adds a new room to the available rooms list.
     * 
     * @param room The room to be added.
     */
    public void addNewRoom(Room room) {
        availableRooms.add(room);
    }

    public boolean reserveRoom(int roomNumber) {
        for (Room room : availableRooms) {
            if (room.getRoomNumber() == roomNumber) {
                availableRooms.remove(room);
                reservedRooms.add(room);
                return true;
            }
        }
        return false;
    }

    public boolean makeRoomAvailable(int roomNumber) {
        for (Room room : reservedRooms) {
            if (room.getRoomNumber() == roomNumber) {
                reservedRooms.remove(room);
                availableRooms.add(room);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns all available rooms.
     * 
     * @return The list of available rooms.
     */
    public ArrayList<Room> getAllAvailableRooms() {
        return availableRooms;
    }

    /**
     * Returns all reserved rooms.
     * 
     * @return The list of reserved rooms.
     */
    public ArrayList<Room> getAllReservedRooms() {
        return reservedRooms;
    }

    public Room getAvailableRoomByRoomNumber(int roomNumber) {
        for (Room room : availableRooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public Room getReservedRoomByRoomNumber(int roomNumber) {
        for (Room room : reservedRooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public ArrayList<Room> getAvailableRooms(int floor, View view, int capacity, boolean kitchenette) {
        ArrayList<Room> matchingRooms = new ArrayList<>();
        for (Room room : availableRooms) {
            if (room.getRoomNumber() / 100 == floor && room.getView() == view && room.getMaxCapacity() >= capacity && room.hasKitchenette() == kitchenette) {
                matchingRooms.add(room);
            }
        }
        return matchingRooms;
    }

}


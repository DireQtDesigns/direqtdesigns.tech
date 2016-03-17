ArrayList<Drone> sortedByHealth = new ArrayList<>();

/**
 * chosenEnemy() chooses an enemy based on the lowest health as well as  checking if the distance isn't too large / object != null.
 * @return String theChosenOne: The name of the enemy that gets returned
 */
public String chosenEnemy() {
        EnemyDrone theChosenOne = null;
        String[] keys = drones.keySet().toArray(new String[drones.size()]);
        HashMap<Double, EnemyDrone> distanceMap = new HashMap<>();
        for(int i = 0; i < drones.size(); i++) {
        if(drones.get(keys[i]) instanceof MyDrone || drones.get(keys[i]) instanceof TeamDrone) return null;
        sortedByHealth.add(drones.get(keys[i]));
        sortList(sortedByHealth);

        }
        for(Drone d : sortedByHealth) {
        MyDrone myDrone = null;
        for (int i = 0; i < drones.size(); i++) {
        if (drones.get(keys[i]) instanceof MyDrone) myDrone = (MyDrone) drones.get(keys[i]);
        }
        if (calculateDistance(d, myDrone.getXCoordinate(), myDrone.getYCoordinate()) > 200 || myDrone == null || d == null)
        return null;
        if (d instanceof EnemyDrone && d != null) {
        distanceMap.put(calculateDistance(myDrone.getXCoordinate(), myDrone.getYCoordinate()), (EnemyDrone) d);

        double smallest = Integer.MAX_VALUE;
        for(double dble : distanceMap.keySet()){
        if(dble < smallest){
        smallest = dble;
        theChosenOne = distanceMap.get(smallest);
        }
        }
        }
        }

        if(theChosenOne != null)
        return theChosenOne.getName();
        else return null;
        }

/**
 * Sorts given list based on health levels of Drones in it; Lowest health comes first
 * @param listToSort: the list to sort based on health
 * @return listToSort: The finally sorted list.
 */
public ArrayList<Drone> sortList(ArrayList<Drone> listToSort) {
        int lowerIndex;
        Drone swapDrone;

        for(int i = 0; i < listToSort.size(); i++){
        lowerIndex = i;

        for(int k = i; k < listToSort.size(); k++){
        if(listToSort.get(k).compareTo(listToSort.get(lowerIndex)) < 0){
        lowerIndex = k;
        }
        }

        swapDrone = listToSort.get(i);
        listToSort.set(i, listToSort.get(lowerIndex));
        listToSort.set(lowerIndex, swapDrone);
        }
        System.out.println(listToSort.toString());
        return listToSort;
        }



/**
 * chosenEnemy() chooses an enemy based on the lowest health as well as  checking if the distance isn't too large / object != null.
 * @return String theChosenOne: The name of the enemy that gets returned
 */
public String chosenEnemy() {
        EnemyDrone theChosenOne = null;
        String[] keys = drones.keySet().toArray(new String[drones.size()]);
        HashMap<Double, EnemyDrone> distanceMap = new HashMap<>();
        for(int i = 0; i < drones.size(); i++) {
        if(drones.get(keys[i]) instanceof MyDrone || drones.get(keys[i]) instanceof TeamDrone) return null;
        sortedByHealth.add(drones.get(keys[i]));
        sortList(sortedByHealth);

        }
        for(Drone d : sortedByHealth) {
        MyDrone myDrone = null;
        for (int i = 0; i < drones.size(); i++) {
        if (drones.get(keys[i]) instanceof MyDrone) myDrone = (MyDrone) drones.get(keys[i]);
        }
        if (calculateDistance(d, myDrone.getXCoordinate(), myDrone.getYCoordinate()) > 200 || myDrone == null || d == null)
        return null;
        if (d instanceof EnemyDrone && d != null) {
        distanceMap.put(calculateDistance(myDrone.getXCoordinate(), myDrone.getYCoordinate()), (EnemyDrone) d);

        double smallest = Integer.MAX_VALUE;
        for(double dble : distanceMap.keySet()){
        if(dble < smallest){
        smallest = dble;
        theChosenOne = distanceMap.get(smallest);
        }
        }
        }
        }

        if(theChosenOne != null)
        return theChosenOne.getName();
        else return null;
        }

/**
 * Sorts given list based on health levels of Drones in it; Lowest health comes first
 * @param listToSort: the list to sort based on health
 * @return listToSort: The finally sorted list.
 */
public ArrayList<Drone> sortList(ArrayList<Drone> listToSort) {
        int lowerIndex;
        Drone swapDrone;

        for(int i = 0; i < listToSort.size(); i++){
        lowerIndex = i;

        for(int k = i; k < listToSort.size(); k++){
        if(listToSort.get(k).compareTo(listToSort.get(lowerIndex)) < 0){
        lowerIndex = k;
        }
        }

        swapDrone = listToSort.get(i);
        listToSort.set(i, listToSort.get(lowerIndex));
        listToSort.set(lowerIndex, swapDrone);
        }
        System.out.println(listToSort.toString());
        return listToSort;
        }

/**
 * calculates distance of a targetName based on given Drone:d coordinates and your coordinates as stroed in the hashmap
 * @param drone
 * @param hostileX
 * @param hostileY
 * @return
 */
private double calculateDistance(Drone drone, double hostileX, double hostileY) {
        if (debug == 2) System.out.println("calculated distance: " + Math.sqrt((Math.pow(hostileX - drone.getXCoordinate(), 2)) + (Math.pow(hostileY - drone.getYCoordinate(), 2))));

        return Math.sqrt((Math.pow(drone.getXCoordinate() - hostileX, 2)) + (Math.pow(drone.getYCoordinate() - hostileY, 2)));
        }



////////////////////////////// DRONE.JAVA ////////////////////////////

//APPARANTLY OPTIONAL, BUT: 'inherits Comparable<Drone>'

public int compareTo(Drone d) {
        if(getEnergy() < d.getEnergy()) {
        return -1;
        } else if(getEnergy() > d.getEnergy()) {
        return 1;
        } else return 0;
        }
if (fireAtWill) fireGun(e.getDistance(), getEnergy(), isTeammate(e.getName()));


    /**
     * User story 12.
     * Uses a given distance between target to decide how powerful the gunshot should be.
     * Distance as well as current health decide whether to shoot with a power of 3, 2, or 1 to not waste energy as well as to not kill himself in the process...
     * Returns when distance >= 100 and energy >= 2 to not commit suicide
     *
     * @param distance
     * @param energy
     */
    public void fireGun(double distance, double energy, boolean isTeamMate) {
        int firePower = 0;
        if(isTeamMate) return;
        if (energy <= 2) return;
        if (distance >= 100) return;
        else if (energy >= 80) {
            if (distance < 100 && distance >= 50) {
                firePower = 1;
            } else if (distance < 50 && distance >= 30) {
                firePower = 2;
            } else if (distance < 30) {
                firePower = 3;
            }
        } else if (energy <= 50 && energy > 30) {
            if (distance < 100 && distance >= 30) {
                firePower = 1;
            } else if (distance < 30) {
                firePower = 2;
            }
        } else if (energy <= 30) firePower = 1;
        fire(firePower);
    }
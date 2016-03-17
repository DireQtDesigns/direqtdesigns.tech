            setTurnRight(getHeadingTurnAmt(90));
            ahead(80);
            execute();
            setTurnRight(getHeadingTurnAmt(180));
            ahead(80);
            execute();
            setTurnRight(getHeadingTurnAmt(270));
            ahead(80);
            execute();
            setTurnRight(getHeadingTurnAmt(360));
            ahead(80);
            execute();

    /**
     * 
     * @param heading The heading the tank needs to turn towards.
     * @return turnAmt: The amount the robot needs to turn in order to turn towards to the specific given heading.
     */
    public double getHeadingTurnAmt(int heading) {
        double turnAmt = 0;
        if(heading == 0 || heading >= 360) turnAmt = 0;
        if(heading <= 180 && heading - getHeading() < 180) {
            turnAmt = heading - getHeading();
        } else if(heading <= 180) {
            turnAmt = (360 - heading + getHeading() * -1);
        } else if(heading - getHeading() < -180) {
            turnAmt = 360 - getHeading() + heading;
        } else turnAmt = heading - getHeading();
        return turnAmt;
    }
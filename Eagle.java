public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    /**
     * take off, must be on the floor
     */
    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s taking off.%n", this.getName());
        }
    }

    /**
     * glide, must be in the air
     */
    @Override
    public void glide() {
        if (this.flying) {
            System.out.printf("%s is gliding.%n", this.getName());
        } else {
            System.out.printf("%s is not enough high.%n", this.getName());
        }
    }

    /**
     * ascend return meters
     * @param meters altitude increase
     * @return altitude
     */
    public int ascend(int meters) {
        if(this.flying) {
            this.altitude = Math.min(this.altitude + meters, 2500);
            System.out.printf("%s is ascending, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }
    /**
     * descend return meters
     * @param meters altitude decrease
     * @return altitude
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s is descending, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    /**
     * landed, must be on the air
     */
    @Override
    public void land() {
        if (this.flying && this.altitude == 1) {
            System.out.printf("%s landed.%n", this.getName());
        } else {
            System.out.printf("%s is still in the air!%n", this.getName());
        }
    }
}

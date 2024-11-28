package pkg_interface;

public interface BicycleInterface {

    public static final String BRAND = "Goodee";
    public static final int MAX_SPEED = 30;

    public abstract void speedUp(int increment);
    public abstract void speedDown(int decrement);
	
}

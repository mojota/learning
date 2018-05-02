package Adapter;

/**
 * @author jamie
 * @date 18-5-2
 */
public class AdapterTargetC extends Adaptee implements Target {
    @Override
    public void request() {
        super.specialRequest();
    }
}

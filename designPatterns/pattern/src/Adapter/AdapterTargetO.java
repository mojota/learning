package Adapter;

/**
 * 对象适配器
 *
 * @author jamie
 * @date 18-5-2
 */
public class AdapterTargetO implements Target {

    private Adaptee mAdaptee = new Adaptee();

    public AdapterTargetO(){
    }

    public AdapterTargetO(Adaptee adaptee){
        this.mAdaptee = adaptee;
    }

    @Override
    public void request() {
        mAdaptee.specialRequest();
    }
}

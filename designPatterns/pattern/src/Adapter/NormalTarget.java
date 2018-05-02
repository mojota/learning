package Adapter;

/**
 * @author jamie
 * @date 18-5-2
 */
public class NormalTarget implements Target {
    @Override
    public void request() {
        System.out.println("输出220V");
    }
}

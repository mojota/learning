package Adapter;

/**
 * 正常不需要适配的类
 * @author jamie
 * @date 18-5-2
 */
public class NormalTarget implements Target {
    @Override
    public void request() {
        System.out.println("输出220V");
    }
}

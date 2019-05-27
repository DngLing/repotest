package genericity;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 14:30 2019/5/22
 * @Modified By:
 */
public class TInterfaceImpl implements TInterface<String> {
    @Override
    public String getT() {
        return "nihao";
    }
}

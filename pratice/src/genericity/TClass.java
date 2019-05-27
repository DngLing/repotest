package genericity;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 14:03 2019/5/22
 * @Modified By:
 */
public class TClass<Key,Value> {
    private Key key;
    private Value val;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getVal() {
        return val;
    }

    public void setVal(Value val) {
        this.val = val;
    }
}

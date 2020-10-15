package ct.com.lxkj.util;

public class UserUtils {

    public static Integer getUserId() {
        return ThreadLocalUtil.get();
    }
}

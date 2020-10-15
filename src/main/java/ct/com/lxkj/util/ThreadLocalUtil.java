package ct.com.lxkj.util;

public class ThreadLocalUtil<T> {

    private static final ThreadLocal threadLocal = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public static <T> void set(T value) {
        threadLocal.set(value);
    }

    public static <T> T get() {
        return (T) threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

}

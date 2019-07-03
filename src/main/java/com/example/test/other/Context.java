package com.example.test.other;

public final class Context {
    private static final ThreadLocal<Integer> HOLDER = new ThreadLocal<>();
    private Context() {
    }

    public static Integer select(){
        return HOLDER.get();
    }

    public static void set(Integer str){

            HOLDER.set(str);

    }

    public static void clear() {
        HOLDER.remove();
    }

    public static void excute(Integer src, CaculateFunction caculateFunction) {
        Integer oldLookupKey = select();
        try {
            set(src);
            caculateFunction.calcute(HOLDER.get());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            set(oldLookupKey);
        }
    }
}

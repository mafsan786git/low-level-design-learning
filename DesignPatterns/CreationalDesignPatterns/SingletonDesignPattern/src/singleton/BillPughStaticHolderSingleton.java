package singleton;

public class BillPughStaticHolderSingleton {
    private BillPughStaticHolderSingleton(){}

    private static class SingletonHolder{
        private static final BillPughStaticHolderSingleton INSTANCE = new BillPughStaticHolderSingleton();
    }

    public static BillPughStaticHolderSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

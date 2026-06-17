public abstract class AbstractSensorHandler implements SensorDataHandler{

    private int handledCount = 0;
    private int skippedCount = 0;

    public final void handle(Sensorreading reading){
        if (reading== null){
            skippedCount++;
            onNull();
            return;
        }
        handledCount++;
        process(reading);
    }

    protected abstract void process(Sensorreading reading);
    protected void onNull(){
        System.err.println(getClass().getSimpleName()+": null-Reading ignoriert");
    }

    @Override
    public void close(){
        System.out.println("__"+ getClass().getSimpleName()+": "+handledCount+ " verarbeitet, "+ skippedCount+ " übersürungen ___");
    }

    public int getHandledCount(){return handledCount;}
    public int getSkippedCount(){return skippedCount;}

}
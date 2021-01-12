package app.profiling;

public interface LongMBean {
    long getAllPoints();
    long getAllPointsInArea();

    boolean crat5();
    void loging();

    void incPoints(int value);
    void incPointsInArea(int value);
}

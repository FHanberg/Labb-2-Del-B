package carmodel;

/**
 * Framework for an object that can be transported
 */
public interface Transportable {
    void loadSelf();
    void unloadSelf();
    void setX(double newX);
    void setY(double newY);
    double getX();
    double getY();
    Size getSize();
    void followTransport(double speed, double direction);
}

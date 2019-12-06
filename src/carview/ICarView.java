package carview;

public interface ICarView {
    int getCarWidth();
    int getCarHeight();
    int getWorldWidth();
    int getWorldHeight();
    void updatePosAndImg(String[] ObjectName);
    void callForRepaint();
}

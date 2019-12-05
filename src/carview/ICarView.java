package carview;

public interface ICarView {
    int getCarWidth();
    int getCarHeight();
    void updatePosAndImg(int x, int y, String ObjectName);
    void callForRepaint();
}

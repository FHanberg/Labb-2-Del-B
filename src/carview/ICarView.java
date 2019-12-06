package carview;

import carcontroller.IListener;

public interface ICarView {
    int getCarWidth();
    int getCarHeight();
    int getWorldWidth();
    int getWorldHeight();
    void updatePosAndImg(String[] ObjectName);
    void callForRepaint();
    void addObserver(IListener observer);
    int getGasAmount();
}

package sk.stuba.fei.uim.oop.utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberListener implements ActionListener {

private int recievedNumber;
    public NumberListener(int recievedNumber) {
        this.recievedNumber=recievedNumber;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

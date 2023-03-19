package metier;

import dao.HDMI;
import dao.VGA;

public class AdaptateurHdmiVersVga implements VGA {
    private HDMI hdmi;

    public AdaptateurHdmiVersVga(HDMI hdmi) {
        this.hdmi = hdmi;
    }

    @Override
    public void print(String message) {
        hdmi.print(message.getBytes());
    }
}

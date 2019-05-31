public class CharacterAbe extends Character{
    private boolean receivedDonuts;
    private boolean requestedBurger;
    private boolean requestedDonuts;

    public CharacterAbe(String fileName, int x, int y, int width, int height) {
        super(fileName, x, y, width, height);

        this.receivedDonuts = false;
        this.requestedBurger = false;
        this.requestedDonuts = false;
    }

    public boolean receivedDonuts() {
        return receivedDonuts;
    }

    public void setReceivedDonuts(boolean receivedDonuts) {
        if (super.isVisible())
            this.receivedDonuts = receivedDonuts;
    }

    public boolean requestedBurger() {
        return requestedBurger;
    }

    public void setRequestedBurger(boolean requestedBurger) {
        this.requestedBurger = requestedBurger;
    }

    public boolean requestedDonuts() {
        return requestedDonuts;
    }

    public void setRequestedDonuts(boolean requestedDonuts) {
        this.requestedDonuts = requestedDonuts;
    }
}
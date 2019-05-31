public class CharacterKrusty extends Character {
    private boolean requestStatus;

    public CharacterKrusty(String fileName, int x, int y, int width, int height) {
        super(fileName, x, y, width, height);
        requestStatus = false;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public boolean hasRequested() {
        return requestStatus;
    }
}
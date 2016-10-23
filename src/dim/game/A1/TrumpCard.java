package dim.game.A1;

public class TrumpCard extends Card {
    private int id;
    private String title;
    private String type;
    private String subtitle;

    public TrumpCard(int id){
        super(id);
        this.subtitle = subtitle;
    }

    public String toString() {
        return "\nid ="+id;
    }
}

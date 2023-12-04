import java.util.ArrayList;
import java.util.Comparator;

public class Team<T extends Player> {
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.setName(name);
    }
    public void addPlayer(T player) {
        if (getMembers().contains(player)) {
            System.out.println(player.getName() + " is already on this team");
        } else {
            System.out.println(player.getName() + " picked for team " + getName());
        }
    }
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            won++;
            message = " thắng ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " hòa ";
        } else {
            lost++;
            message = " thua ";
        }
        played++;
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (getWon() * 2) + getTied();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getTied() {
        return tied;
    }

    public void setTied(int tied) {
        this.tied = tied;
    }

    public ArrayList<T> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<T> members) {
        this.members = members;
    }
}

import java.util.ArrayList;
import java.util.Comparator;

public class League <T extends Team>{
    private String name;
    private ArrayList<T> leagues = new ArrayList<>();
    public League(String name) {
        this.setName(name);
        this.setLeagues(new ArrayList<>());
    }

    public boolean addTeam(T team) {
        if (getLeagues().contains(team)) {
            return false;
        } else {
            getLeagues().add(team);
            return true;
        }
    }

    public void showLeagueTable() {
        getLeagues().sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(o2.ranking(), o1.ranking());
            }
        });
        for (T t : getLeagues()) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<T> getLeagues() {
        return leagues;
    }

    public void setLeagues(ArrayList<T> leagues) {
        this.leagues = leagues;
    }
}

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> arrayList = new ArrayList<>();
        arrayList.add(new Player("amy ", 100 ));
        arrayList.add(new Player("david ", 100));
        arrayList.add(new Player("heraldo ", 50));
        arrayList.add(new Player("aakansha ", 75));
        arrayList.add(new Player("aleksa ", 150));
        Checker checker = new Checker();
        arrayList.sort(checker);
        arrayList.forEach(player -> System.out.println(player.getName() + " " + player.getScore()));
    }
}
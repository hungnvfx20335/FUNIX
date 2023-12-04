import java.time.temporal.Temporal;

public class Main {
    public static void main(String[] args) {
        BaseballPlayer baseballPlayer = new BaseballPlayer("Hùng");
        FootballPlayer footballPlayer = new FootballPlayer("Cường");
        SoccerPlayer soccerPlayer = new SoccerPlayer("Toản");


        Team<FootballPlayer> numberOneSoftware = new Team<>("Number One Software");
        numberOneSoftware.addPlayer(footballPlayer);

        Team<BaseballPlayer> blackStone = new Team<>("Black Stone");
        blackStone.addPlayer(baseballPlayer);

        Team<FootballPlayer> thanhHoa = new Team<>("Thanh Hoa");
        thanhHoa.addPlayer(new FootballPlayer("Nghia"));

        Team<FootballPlayer> hoaHongDen = new Team<>("Hoa Hồng Đen");

        thanhHoa.matchResult(numberOneSoftware, 1, 0);
        thanhHoa.matchResult(hoaHongDen, 3, 1);

        hoaHongDen.matchResult(numberOneSoftware, 2, 1);

        League<Team<FootballPlayer>> league = new League<>("Viet Nam");
        league.addTeam(numberOneSoftware);
        league.addTeam(hoaHongDen);
        league.addTeam(thanhHoa);
        league.showLeagueTable();
    }
}
package probelklausur.dartsCounter;

public class Player {
    private String name;
    private int countDartsThrown;
    private Visit[] visits;

    public Player(String name) {
        this.name = name;
        this.visits = new Visit[10];
    }

    public int getRemainingPoints() {
        int remaining = 501;
        for (Visit visit : visits) {
            if (visit != null) remaining -= visit.getValue();
        }
        return remaining;
    }

    public boolean addVisit(Visit visit) {
        countDartsThrown += visit.getFields().length;
        if (getRemainingPoints() - visit.getValue() < 0) return true;
        else if (getRemainingPoints() - visit.getValue() == 0 && !visit.getLastField().isDoubleField()) return true;
        if (getRemainingPoints() - visit.getValue() == 1) return true;

        return addVisitToList(visit);
    }

    private boolean addVisitToList(Visit visit) {
        for (int i = 0; i < visits.length; i++) {
           if (visits[i] == null) {
               visits[i] = visit;
               return true;
           }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCountDartsThrown() {
        return countDartsThrown;
    }
}

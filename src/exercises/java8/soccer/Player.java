package exercises.java8.soccer;

public record Player(int number, String name, String position, String birthday, String club, int games, int goals) {

    @Override
    public String toString() {
        return number + " | " + name + ", " + position + ", " + birthday + ", " + club + ", " + games + " games, " + goals + " goals";
    }
}

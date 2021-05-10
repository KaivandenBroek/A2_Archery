package nl.hva.ict.ads;

import java.util.*;

/**
 * Holds the name, archer-id and the points scored for 30 arrows.
 *
 * Archers MUST be created by using one of the generator methods. That is way
 * the constructor is private and should stay private. You are also not allowed
 * to add any constructor with an access modifier other then private unless it
 * is for testing purposes in which case the reason why you need that
 * constructor must be contained in a very clear manner in your report.
 */
public class Archer {
    public final static int MAX_ARROWS = 3;
    public final static int MAX_ROUNDS = 10;
    private final static Random randomizer = new Random();
    private int id; // Once assigned a value this attribute is not allowed to change.

    private String firstName;
    private String lastName;

    private static int tens;
    private static int nines;
    private int totalScore;

    private static int amountArchers = 0;

    /**
     * Constructs a new instance of Archer and assigns a unique ID to the instance.
     * The ID is not allowed to ever change during the lifetime of the instance! For
     * this you need to use the correct Java keyword. Each new instance is a
     * assigned a number that is 1 higher than the last one assigned. The first
     * instance created should have ID 135788;
     *
     * @param firstName the archers first name.
     * @param lastName  the archers surname.
     */
    protected Archer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = generateId();
    }

    private int generateId() {
        int id = 135778 + amountArchers;
        return id;
    }

    /**
     * <b>This is a convenience constructor that only should be used by
     * unit-tests!</b>. The ID is not allowed to ever change during the lifetime of
     * the instance! For this you need to use the correct Java keyword.
     *
     * @param id        the id for the archer.
     * @param firstName the archers first name.
     * @param lastName  the archers surname.
     */
    protected Archer(int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * Registers the point for each of the three arrows that have been shot during a
     * round. The <code>points</code> parameter holds the three scores, one for each
     * arrow.
     *
     * @param round  the round for which to register the points, 1 based.
     * @param points the points shot during the round.
     */
    public void registerScoreForRound(int round, int[] points) {
        for (int point : points) {
            totalScore = +point;
        }
    }

    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Returns the number of 10's scored by this archer.
     * 
     * @return the number of 10's for this archer.
     */
    public int getTens() {
        return tens;
    }

    /**
     * Returns the number of 9's scored by this archer.
     * 
     * @return the number of 9's for this archer.
     */
    public int getNines() {
        return nines;
    }

    public int getId() {
        return id;
    }

    /**
     * Generates a score for an arrow.
     * 
     * @return the points awarded for a single arrow.
     */
    public static int shootArrow() {
        return randomizer.nextInt(11);
    }

    public static void toString(List<Archer> archers) {
        for (int i = 0; i < archers.size(); i++)
            System.out.println(archers.get(i).id + " " + archers.get(i).getTotalScore() + " " + archers.get(i).firstName
                    + " " + archers.get(i).lastName);
    }

    /*
     * The code below is for your own convenience. You don't have include it in your
     * report.
     */

    /**
     * This methods creates a List of archers. This method takes care of assigning
     * each arhcher a first name, surname and lets them should 30 arrows.
     *
     * @param nrOfArchers the number of archers in the list.
     * @return
     */
    public static List<Archer> generateArchers(int nrOfArchers) {
        List<Archer> archers = new ArrayList<>(nrOfArchers);
        for (int i = 0; i < nrOfArchers; i++) {
            Archer archer = new Archer(Names.nextFirstName(), Names.nextSurname());
            amountArchers++;
            letArcherShoot(archer);
            archers.add(archer);
        }
        return archers;

    }

    private static void letArcherShoot(Archer archer) {
        for (int round = 1; round <= MAX_ROUNDS; round++) {
            archer.registerScoreForRound(round, shootOneRound());
        }
    }

    private static int[] shootOneRound() {
        int[] points = new int[MAX_ARROWS];
        for (int arrow = 0; arrow < MAX_ARROWS; arrow++) {
            points[arrow] = shootArrow();

            if (points[arrow] == 10) {
                tens++;
            }
            if (points[arrow] == 9) {
                nines++;
            }
        }
        return points;
    }

}

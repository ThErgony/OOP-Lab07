/**
 * 
 */
package it.unibo.oop.lab.nesting1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import it.unibo.oop.lab.socialnetwork.SocialNetworkUserImpl;
import it.unibo.oop.lab.socialnetwork.User;

/**
 * 
 * Represents a social network user along with the sports he/she likes to do or
 * to follow.
 * 
 * 1) Complete the definition of the nested static class Sport, featuring just a
 * field representing the sport name.
 * 
 * 2) Add the unimplemented methods.
 * 
 * @param <U>
 *            specific {@link User} type
 */
public class SportSocialNetworkUserImpl<U extends User> extends SocialNetworkUserImpl<U> {

    /**
     * Static {@link Sport} constant.
     */
    public static final Sport SOCCER;
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport F1;
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport MOTOGP;
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport VOLLEY;
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport BASKET;
    /**
     * Static {@link Sport} constant.
     */
    public static final Sport BIKE;

    /*
     * TODO: initialize properly these sports
     */
    static {
        SOCCER = new Sport("Soccer");
        F1 = new Sport("Formula 1");
        MOTOGP = new Sport("Moto GP");
        VOLLEY = new Sport("Volley");
        BASKET = new Sport("Basket");
        BIKE = new Sport("Bike");
    }

    /**
     * Field meant to keep track of the set of sports followed/done by a user.
     */
    private final Set<Sport> sports;

    /**
     * Builds a new {@link SportSocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SportSocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
    }

    /**
     * Builds a new {@link SportSocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SportSocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.sports = new HashSet<>();
    }

    /*
     * [METHODS]
     * 
     * Implements all the methods below
     */

    /**
     * Add a new sport followed by this user: if the user already likes or does
     * the sport, nothing happens.
     * 
     * @param sport
     *            a sport followed/done by the user
     */
    // TODO
    public void addSport(final Sport sport) {
    	boolean present = false;
    	for (final Sport s : sports) {
			if (s == sport) {
				present = true;
			}
		}
    	if (!present) {
    		this.sports.add(sport);
		}
    }

    /**
     * Returns true if a user likes/does a given sport.
     * 
     * @param s
     *            sport to use as an input
     * @return true if a user likes sport s
     */
    // TODO
    public boolean hasSport(final Sport s) {
        return this.sports.contains(s);
    }

    /*
     * TODO
     * 
     * Complete the definition of this static inner class defining a Sport along
     * with its bare name.
     */
    public static final class Sport {
        /*
         * TODO
         * 
         * Redefine equals so that two sports are equal only if they feature the
         * very same name. Remember that you must also redefine hashCode()!
         */
    	private final String name;
    	private int hash;
    	
        /**
         * constructor for sport name and hashing
         * @param sportName
         * 			required a valide name for the sport, if null send error message
         */
    	public Sport(final String sportName) {
        	this.name = Objects.requireNonNull(sportName, "Require a valide name for the sport");
        	this.hash = hashCode();
		}
    	
    	/**
    	 * create a new hashing code for the sport, using the name
    	 * if sport is present don't change the hash
    	 */
    	@Override
		public int hashCode() {
			if (this.hash == 0) {
				this.hash = this.name.hashCode();
			}
			return this.hash;
		}

		/**
		 * override method, equals for the class with object passed, if the same
		 * return if present the sport
		 */
		@Override
        public boolean equals(final Object o) {
            if (this.getClass().equals(o.getClass())) {
				return this.name.equals(o.getClass().getName());
			}
			return false;
        }
    }
}

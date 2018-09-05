package tut07.generictype;

/**
 * Interface for a set
 *
 * @param <E> uses a generic type so any object can be declared of this type
 */
public interface Set<E> extends Iterable<E> {

  /**
   * Method to add an element to the set
   * @param e The element to add
   */
  public void add(E e);

  /**
   * Method to remove an element from the set
   * @param e The element to remove
   */
  public void remove(E e);

  /**
   * Method to return a union of this set and another set
   * @param secondSet the set to be unioned with
   * @return a new set that is the union of these two sets
   */
  public Set<E> union(Set<E> secondSet);

  /**
   * Method to return an intersection of this set and another set
   * The intersection can take in a wildcard type because if
   * another set is passed in that is a different type
   * then the intersection of these sets will naturally be an empty set
   * @param secondSet the set to be intersected with
   * @return a new set that is the intersection of these two sets
   */
  public Set<E> intersection(Set<E> secondSet);

  /**
   * Method to determine if this set is a subset of another set (WRW)
   * @param secondSet the set this set is compared to
   * @return true if this set is a subset (or equal to) the second set
   */
  public boolean subset(Set<E> secondSet);

  /**
   * Method to determine if a given element is in the set
   * @param e The element to determine if in the set
   * @return true if the element is in the set
   */
  public boolean contains(Object e);

  /**
   * Method to return the number of items in the set
   * @return the number of itmes in the set
   */
  public int size();

}

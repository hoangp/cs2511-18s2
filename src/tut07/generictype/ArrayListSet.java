package tut07.generictype;

import java.util.*;

/**
 * An implementation of a set using an ArrayList
 * @author bradfordh
 *
 * @param <E> uses a generic type so any object can be declared of this type
 */
public class ArrayListSet<E> implements Set<E> {
  ArrayList<E> setElements = new ArrayList<>();

  /**
   * Default constructor builds an empty set
   */
  public ArrayListSet() {
    // To be completed
  }

  /**
   * Copy constructor, makes a copy of the inputed set.
   * @param arrayListSet
   */
  public ArrayListSet(ArrayListSet<E> arrayListSet) {
    // To be completed
  }

  @Override
  public void add(E e) {
    // To be completed
  }

  @Override
  public void remove(E e) {
    // To be completed
  }

  @Override
  public Set<E> union(Set<E> secondSet) {
    // To be completed
    return null;
  }

  @Override
  public Set<E> intersection(Set<E> secondSet) {
    // To be completed
    return null;
  }

  @Override
  public boolean contains(Object e) {
    // To be completed
    return true;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public String toString() {
    // To be completed
    return null;
  }

  @Override
  public boolean equals(Object o) {
    return false;
  }

  @Override
  public boolean subset(Set<E> secondSet) {
    for (E e : this) // can do this since Set<E> implements Iterable<E>!!
      if (!secondSet.contains(e)) return false;
    return true;
  }

  @Override
  public int size() {
    return 0;
  }

}

/*
 * if (getClass() != obj.getClass()) return false;
 * -> can't compare sets implemented differently (WRW)
 * => if (!(o instanceof Set)) return false; 
 * -> can't test for Set<E> due to type unsure
 * 
 * 
 * ArrayListSet<?> other = (ArrayListSet<?>) obj;
 * -> The cast needs the ? wildcard to avoid a compiler warning that types should be parameterized. 
 * -> but still can't compare sets implemented differently
 * => Set<?> secondSet = (Set<?>) obj;
 * 
 * Add if (secondSet.size() != size()) return false;
 * Add return containsAll(secondSet);
 *   or for loop to check each elements, since Set implement Iterable
 
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    
    //if (getClass() != obj.getClass()) return false;
    if (!(obj instanceof Set)) return false; 
    
    // ArrayListSet<?> other = (ArrayListSet<?>) obj;
    Set<?> secondSet = (Set<?>) obj;
    
    if (secondSet.size() != size()) return false;
    
    // can do this since Set<E> implement Iterable<E>!!
    for (E e : this) {
      if (!secondSet.contains(e)) return false;
    }
    
    return true;
  }
  
 * Standard clone.
 * Just to see if clone works for ArrayListSet<E>. (WRW)
 * Works but generates a compiler warning Unchecked Cast.
 
  @Override
  public ArrayListSet<E> clone()
  {
    try
    {
      ArrayListSet<E> clone = (ArrayListSet<E>) super.clone();
      return clone;
    }
    catch (CloneNotSupportedException e)
    {
      return null;
    }
  }
 */

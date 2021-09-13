/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author George
 * @param <T>
 */
public interface Comparator<T> {

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    int compare(T o1, T o2);
}

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * I have adhered to the honor code on this assignment.
 * This is my test class for MyArrayList
 * @author jackbenson
 */
public class MyArrayListTest extends MyArrayList {

    /*~~~~~~~~~~~~~~~~~~~~~
     * WALK THROUGH TESTS
     * testMyArrayList()
     * testSize()
     * test exceptions ...
     ~~~~~~~~~~~~~~~~~~~~~*/

    /**
     * testMyArrayList()
     * This tests that my empty constructor is working correctly
     */

    @Ignore
    public void testMyArrayList(){
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        ArrayList<Integer>   real = new ArrayList<Integer>();
        assertEquals("Size after construction", real.size(), test.size());
    }

    /**
     * testSize1()
     * this test to see if my size method is working correctly
     */

    @Ignore
    public void testSize1(){
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        ArrayList<Integer>   real = new ArrayList<Integer>();
        assertEquals( "Size after construction", real.size(), test.size());
        test.add(0,5);
        real.add(0,5);
        assertEquals( "Size after add", real.size(), test.size());
    }

    /**
     * testForAddLeftException()
     * this tests the exception that should be thrown by the add method when adding to a negative index
     * @throws Exception If the index is out of bounds.
     */

    @Test(expected=IndexOutOfBoundsException.class)
    public void testForAddLeftException() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(-1, 5);
    }

    /**
     * testForAddRightException()
     * this test the exception that should be thrown by the add method when adding to an index is greater than size
     * @throws Exception If the index is out of bounds.
     */

    @Test(expected=IndexOutOfBoundsException.class)
    public void testForAddRightException() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(test.size()+1, 5);
    }

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~OTHER TESTS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * testAddE()
     * testAddIntEFront()
     * testAddIntEBack()
     * testGet()
     * testIndexOutOfBounds() for Get() * 2
     * testRemove()
     * testSet()
     * testAdd()
     * testIndexOutOfBounds() for Add() * 2
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /**
     * testAddE() adds strings to the end of two MyArrayList and a real ArrayList
     * this test then checks to see if the strings at each index are the same
     * @throws FileNotFoundException If the file is not found.
     */

    @Ignore
    public void testAddE() throws FileNotFoundException{
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        while (c.hasNextLine()) {
            String s = c.nextLine();
            test.add(s);
            real.add(s);
        }
        //System.out.println(test);
        //System.out.println(real);
        if (test.size() == real.size()) {
            for ( int i = 0; i < real.size(); i++ ) assertSame(test.get(i), real.get(i));
        }
    }

    /**
     * This test adds strings to the front of MyArrayList and a real ArrayList
     * checks to see if strings are the same
     * @throws FileNotFoundException If the file is not found.
     */

    @Ignore
    public void testAddIntEFront() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        while (c.hasNextLine()) {
            String s = c.nextLine();
            test.add(0, s);
            real.add(0, s);
        }
        //System.out.println(test);
        //System.out.println(real);
        if (test.size() == real.size()) {
            for ( int i = 0; i < real.size(); i++ ) assertSame(test.get(i), real.get(i));
        }
    }

    /**
     * This test add strings to the middle of MyArrayList and a real ArrayList
     * checks to see if the strings are the same
     * @throws FileNotFoundException If the file is not found.
     */

    @Ignore
    public void testAddIntEBack() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        while (c.hasNextLine()) {
            String s = c.nextLine();
            test.add((test.size() / 2), s);
            real.add((real.size() / 2), s);
        }
        //System.out.println(test);
        //System.out.println(real);
        if (test.size() == real.size()) {
            for ( int i = 0; i < real.size(); i++ ) assertSame(test.get(i), real.get(i));
        }
    }

    /**
     * This test tests the get method by comparing the strings get returns for the same index
     * @throws Exception If there is an error adding to the list.
     */

    @Ignore
    public void testGet() throws Exception {
        MyArrayList< Integer > test = new MyArrayList();
        ArrayList< Integer > real = new ArrayList< Integer >();
        test.add(1);
        real.add(1);
        test.add(2);
        real.add(2);
        test.add(0, 0);
        real.add(0, 0);
        assertEquals("Size after construction: ", test.get(1), real.get(1));
    }

    /**
     * Tests to see if IndexOutOfBoundsException works for the get() method
     * using index greater than size
     */

    @Test(expected=IndexOutOfBoundsException.class )
    public void testIndexOutofBoundsGet() {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(1); //index 0
        test.add(2); //index 1
        test.get(2); //size +1
    }

    /**
     * Tests the same as above but from the negative index
     */

    @Test(expected=IndexOutOfBoundsException.class )
    public void testIndexOutofBoundsGet2() {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(1); //index 0
        test.add(2); //index 1
        test.get(-1); //size -1
    }

    /**
     * This tests the Remove() method
     * 1) Read in strings from "test1.txt"
     * 2) Remove every other string from MyArrayList (test) and an ArrayList (real)
     * 3) Add those words to another MyArrayList (second) and an ArrayList (realTwo)
     * 4) Compare the strings with assertSame
     * @throws FileNotFoundException If the file is not found
     */

    @Ignore
    public void testRemove() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        MyArrayList< String > second = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        ArrayList< String > realTwo = new ArrayList< String >();

        while ( c.hasNext() ) {
            String s = c.next();
            test.add(s);
            real.add(s);
        }
        for ( int i = 0; i < test.size(); i++ ) {
            if ( i % 2 == 0 ) {
                second.add(test.remove(i));
                realTwo.add(real.remove(i));
            }
        }
        for ( int i = 0; i < second.size(); i++ ) assertSame("String Same?", realTwo.get(i), second.get(i));
        System.out.println(test);
        System.out.println(second);
        System.out.println(real);
        System.out.println(realTwo);
    }

    /**
     * This tests the Set() method
     * Moves string of last index to first index
     * compare strings
     * @throws FileNotFoundException If the file is not found.
     */

    @Ignore
    public void testSet() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        ArrayList< String > realTwo = real;
        MyArrayList< String > testTwo = test;

        while ( c.hasNext() ) {
            String s = c.next();
            test.add(s);
            real.add(s);
        }
        for ( int i = 0; i < test.size(); i++ ) {
            String q = test.get(test.size() - i - 1);
            String r = real.get(real.size() - i - 1);
            testTwo.set(i, q);
            realTwo.set(i, r);
        }

        for ( int i = 0; i < testTwo.size(); i++ ) assertSame("String Same?", real.get(i), testTwo.get(i));
    }

    /**
     * The test of the Add() method
     * Add two items
     * See if 2 == test.size()
     * @throws Exception If there is an error adding to the MyArrayList.
     */

    @Ignore
    public void testAdd() throws Exception {
        MyArrayList< Integer > test = new MyArrayList();
        ArrayList< Integer > real = new ArrayList< Integer >();
        test.add(1);
        real.add(1);
        test.add(2);
        real.add(2);
        test.add(0, 0);
        real.add(0, 0);
        assertEquals("Size after construction: ", test.size(), real.size());
    }

    /**
     * Test IndexOutOfBounds for the add() method
     * (from right hand side)
     */

    @Test(expected=IndexOutOfBoundsException.class )
    public void testIndexOutofBoundsAdd() {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(1); //index 0
        test.add(2); //index 1
        test.add(3, 3); //size +1

    }

    /**
     *Test IndexOutOfBounds for the add() method
     * (from left hand side)
     */

    @Test(expected=IndexOutOfBoundsException.class )
    public void testIndexOutofBoundsAdd1() {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(1); //index 0
        test.add(2); //index 1
        test.add(-1, 3); //size +1
    }

    /**
     * test the isEmpty method
     */

    @Ignore
    public void isEmptyTest() {
        MyArrayList< String > test = new MyArrayList< String >();
        assertTrue(test.isEmpty());
    }

    /**
     * Test to see if clear() function works.
     * @throws FileNotFoundException If the file is not found.
     */

    @Ignore
    public void clearTest() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        while ( c.hasNext() ) {
            String s = c.next();
            test.add(s);
            real.add(s);
        }
        test.clear();
        real.clear();
        assertEquals(true, test.isEmpty());
        assertEquals(true, real.isEmpty());

    }

   /*~~~~~~~~~~~~~~~~~~~~
    * Efficiency Testing
    * testAddEfficiency()
    * testRemoveEfficiency()
    * testMemory()
    ~~~~~~~~~~~~~~~~~~~~*/

    /**
     * Testing efficiency of Add() method
     * @throws InterruptedException If the process is interrupted
     * Adding to the beginning took 16 minutes
     * Adding to the end took less than a second
     */

    @Ignore
    public void testAddEfficiency() throws InterruptedException {
        int counter = 0;
        MyArrayList< Integer > test = new MyArrayList();
        for ( int i = 0; i < 1000000; i++ ) {
            int q = test.size();
            test.add(0, q);                     //Adding to the beginning
            //test.add(test.size(),q);            //Adding to the end of the list
            counter++;
            if ( counter == 10000 ) {
                System.out.println(test.size());
                counter = 0;
            }
        }
    }

    /**
     * Testing efficiency of the Remove() method
     * Add items to the end of the list
     * Remove items from back of the list
     * @throws InterruptedException If teh process is interrupted.
     */

    @Ignore
    public void testRemoveEfficiency()  throws InterruptedException {
        MyArrayList< Integer > test = new MyArrayList();
        for ( int i = 0; i < 1000000; i++ ) {
            int q = test.size();
            test.add(i, q);
        }
        int counter = 0;
        for ( int j = 999999; j >= 0; j-- ) {
            test.remove(j);
            counter++;
            if( counter == 10000 ){
                System.out.println(test.size());
                counter = 0;
            }
        }
        //System.out.println(test.size());
    }

    /**
     * Testing time and number until memory runs out
     * Print value Initial: 155,990,000
     * Print value with Extended: 105,660,000
     * Why is extended memory worse...
     */

    @Ignore
    public void testMemory() {
        MyArrayList< Integer > test = new MyArrayList();
        for ( int i = 0;; i++ ) {
                int numToIndex = i;
                while (9 < numToIndex ) numToIndex/=10;
                if ( Math.abs(numToIndex) == 1 ) {
                        test.add((test.size()),i);
                        if( (i%10000) == 0) {
                            System.out.println(i);
                        }
                }
        }
    }
}


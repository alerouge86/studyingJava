package com.alerouge.demo.codewars;

import java.util.List;

/**
 * For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class, which is a utility
 * class helpful for querying paging information related to an array.
 * <p>
 * The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. The types
 * of values contained within the collection/array are not relevant.
 * <p>
 * The following are some examples of how this class is used:
 * <p>
 * PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
 * helper.pageCount(); //should == 2
 * helper.itemCount(); //should == 6
 * helper.pageItemCount(0); //should == 4
 * helper.pageItemCount(1); // last page - should == 2
 * helper.pageItemCount(2); // should == -1 since the page is invalid
 * <p>
 * // pageIndex takes an item index and returns the page that it belongs on
 * helper.pageIndex(5); //should == 1 (zero based index)
 * helper.pageIndex(2); //should == 0
 * helper.pageIndex(20); //should == -1
 * helper.pageIndex(-10); //should == -1
 */
public class PaginationHelper<T> {
    private final List<T> collection;
    private final int itemsPerPage;
    private final int itemsLastPage;
    private int pageCount;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<T> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.itemsLastPage = this.collection.size() % this.itemsPerPage;
        this.pageCount = this.collection.size() / this.itemsPerPage;
        if (this.itemsLastPage != 0) this.pageCount++;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return this.pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex == this.pageCount - 1) {
            // last page
            return this.itemsLastPage;
        } else if (pageIndex < this.pageCount) {
            return this.itemsPerPage;
        } else {
            return -1;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (this.collection.isEmpty() ||
                itemIndex < 0 ||
                itemIndex > this.itemCount()) {
            return -1;
        }
        return itemIndex / this.itemsPerPage;
    }
}


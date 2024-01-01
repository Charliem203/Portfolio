# Lab 5, list partners here!
# Charlie Madison
# Nate Solomon
# NAME HERE
# NAME HERE


# LAB5 has a substantial written Q&A component as well. You answer these questions by updating the
# multi-line strings below to indicate your answer. It's a bit hokey, but it works.
# Question 1: Which image file you submitted covers which analysis case?
Answer1 = """
Sorted_list_plot.png is placed for sorted order.
near_sorted_plot.png is placed for random order.
backwards_plot.png is placed for reverse-sorted order
"""

# Question 2: For each algorithm, explain how you see it behaving in your images.
# If the algorithm's behavior differed case-by-case say this and explain how it behaved in each case.

Answer2_insertion = """
Insertion sort shows a time complex, 0(n^2), this smakes it less suitable for a large datasets because this is suitable for small datasets as the number of comparisons and shifts are smaller.
"""

Answer2_selection = """
Selection sort shows a time complex, 0(n^2), this is not suitable for a large dataset because of its inefficiency.It selects the minimumm element from the unsorted portion and places it at the beginning.
"""

Answer2_merge = """
Merge sort shows a time complex of 0(n log n). It handlles large datasets and outplaces other sorting algorithms for larger inputs. Merge sort instructs and follows the divide and conquer which is dividing the array into smaller subarrays until sorting is insignificant and then merging them back in a sorted place.
"""

Answer3_insertion = """
The theoretical runtime for insertion sort is O(n^2), where n is the number of elements. This is due to its nested loop structure, where each element may need to be compared and shifted multiple times.
"""

Answer3_selection = """
The theoretical runtime for selection sort is O(n^2). Similar to insertion sort, it has nested loops that lead to a quadratic time complexity as it repeatedly selects the minimum element and places it in the sorted portion.
"""

Answer3_merge = """
The theoretical runtime for merge sort is O(n log n). It achieves this efficiency through the divide-and-conquer approach, consistently dividing the dataset until sorted pairs are obtained and then merging them back efficiently.
"""


# Question 4: For each algorithm, How did the observed behavior match the theoretical behavior? Again, if your answer
# differs case by case, say that here and explain your findings for each case.

Answer4_insertion = """
The observed behavior of insertion sort matches the theoretical runtime because, in practice, it performs well for small datasets or nearly sorted data where its quadratic time complexity is less of a concern. However, for larger datasets, its inefficiency becomes apparent.
"""

Answer4_selection = """
The observed behavior of selection sort matches the theoretical runtime because, in practice, it exhibits quadratic time complexity. It is suitable for educational purposes or small datasets but is impractical for larger datasets where more efficient algorithms are available.
"""

Answer4_merge = """
The observed behavior of merge sort matches the theoretical runtime because its divide-and-conquer strategy results in a consistent O(n log n) performance. This makes it efficient for various dataset sizes, especially for large datasets where its advantages over quadratic time complexity algorithms are prominent.
"""


# Question 5: Merge sort is theoretically the fastest algorithm, are there
# cases where another algorithm might be faster?

Answer5 = """
While merge sort is theoretically the fastest general-purpose sorting algorithm with O(n log n) time complexity, there are cases where other algorithms might be faster. For small datasets, simpler algorithms like insertion sort or selection sort might perform better due to their lower overhead. Additionally, in scenarios where memory usage is a critical factor, algorithms with lower space complexity, even if they have a higher time complexity, might be preferred.
"""


# Question 6: If you didn't know the order of data you might want to sort,
# what algorithm might you use to sort it, and why?

Answer6 = """
If the order of data is unknown, a good choice might be merge sort. Merge sort guarantees a consistent O(n log n) time complexity, making it efficient for a wide range of scenarios, including unknown or random orders. Its divide-and-conquer approach ensures reliable performance and is not as sensitive to the initial order of the data as some other algorithms.
"""


# Selection, Insertion, and Merge sorts -- taken from ZyBooks.
# Not too different, its still the same algorithm, they just did it using less memory than I did
# (Which leads to a slightly harder to understand piece of code)

def selection_sort(numbers):
    """Sort the list numbers in-place with comparison counting."""
    comparison_count = 0  # Initialize comparison count
    for i in range(len(numbers) - 1):
        # Find the index of the smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(numbers)):
            if numbers[j] < numbers[index_smallest]:
                index_smallest = j
            comparison_count += 1  # Increment comparison count
        # Swap numbers[i] and numbers[index_smallest]
        temp = numbers[i]
        numbers[i] = numbers[index_smallest]
        numbers[index_smallest] = temp
    return comparison_count  # Return the total comparison count



def insertion_sort(numbers):
    """Sort the list numbers in-place with comparison counting."""
    comparison_count = 0  # Initialize comparison count
    for i in range(1, len(numbers)):
        j = i
        comparison_count+=1
        # Insert numbers[i] into the sorted part, stopping once numbers[i] is in the correct position
        # For counting purposes, consider every time the list condition is checked as one comparison
        while j > 0 and numbers[j] < numbers[j - 1]:
            # Swap numbers[j] and numbers[j - 1]
            temp = numbers[j]
            numbers[j] = numbers[j - 1]
            numbers[j - 1] = temp
            j = j - 1
            comparison_count += 1
    # Increment comparison count
    return comparison_count  # Return the total comparison count


def merge(numbers, i, j, k):
    """Given two sorted sub-lists create one sorted list. This is done in-place, meaning we are given one list
    and expected to modify the list to be sorted. Furthermore, this operates on "sub-lists" (a specific range of the list)
    The list named numbers may contain other types of data than just numbers
    the variables i, j, and k are all indices into the numbers list
    So the part of the list to be sorted is from position i to k (inclusive) with i to j being one sorted list, and j+1 to k being another.
    """
    comparison_count = 0  # Initialize the comparison count
    merged_size = k - i + 1  # Size of merged partition
    merged_numbers = [0] * merged_size  # Temporary list for merged numbers

    merge_pos = 0  # Position to insert merged number
    left_pos = i  # Initialize left partition position
    right_pos = j + 1  # Initialize right partition position

    # Add the smallest element from the left or right partition to merged numbers
    while left_pos <= j and right_pos <= k:
        if numbers[left_pos] < numbers[right_pos]:
            merged_numbers[merge_pos] = numbers[left_pos]
            left_pos = left_pos + 1
        else:
            merged_numbers[merge_pos] = numbers[right_pos]
            right_pos = right_pos + 1
        merge_pos = merge_pos + 1
        comparison_count += 1  # Increment comparison count

    # If the left partition is not empty, add the remaining elements to merged numbers
    while left_pos <= j:
        merged_numbers[merge_pos] = numbers[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    # If the right partition is not empty, add the remaining elements to merged numbers
    while right_pos <= k:
        merged_numbers[merge_pos] = numbers[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    # Copy merged numbers back to the 'numbers' list
    merge_pos = 0
    while merge_pos < merged_size:
        numbers[i + merge_pos] = merged_numbers[merge_pos]
        merge_pos = merge_pos + 1

    return comparison_count  # Return the comparison count





def merge_sort_recursive(numbers, i, k):
    """Sort the sub-list in numbers from position i to k (inclusive)"""
    comparison_count = 0  # Initialize the comparison count

    if i < k:
        j = (i + k) // 2  # Find the midpoint in the partition

        # Recursively sort left and right partitions and count comparisons
        comparison_count += merge_sort_recursive(numbers, i, j)
        comparison_count += merge_sort_recursive(numbers, j + 1, k)

        # Merge left and right partition in sorted order and count comparisons
        comparison_count += merge(numbers, i, j, k)

    return comparison_count  # Return the total comparison count

def merge_sort(numbers):
    """Sort a list of numbers

    This function is added on-top of the textbook's code to simply start the recursive process with the
    appropriate parameters. This also gives us a consistent sorting interface over the three sorts.
    """
    comparison_count = merge_sort_recursive(numbers, 0, len(numbers) - 1)
    return comparison_count  # Return the total comparison count



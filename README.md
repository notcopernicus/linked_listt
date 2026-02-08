# overview

In this repo, we will design and implement CourseEnroll which is a coure enrollment system for students written in Java.

We will have a dyanmic array called enrolled students and a singly linked list called waitlisted students.

When a seat becomes available (when an enrolled student drops the course) ->
the first student in the waitlist is autoomatically promoted into the enrolled list.

#### coding task

    1. Implement array based data structure for enrolled students
    2. Implement linked list data structure for waitlisted students
    3. Provide methods for enrolling, dropping, searching, listing and expoerting/importing student data.
    4. Implement a command-line menu that allows the user to interact with the system


#### extra coding taask:

    1. implement duplicate enroll attempt message
    2. sorted export of enrolled students by name or ID
    3. capacity change at runtime?


#### useful definitions:

    1. Dynamic Array - an array in which once capacity == size and space is allocated in memory by doubling the original size of the array.

    2. Array - linear data structure in which elements are stored in continous memory locations.

    3. Amortized Analysis is a way of looking at the "average cost of an operation over a long sequence of events rather than just looking at the worst case scenario for a single event.

##### personal notes

I believe that while not explicitly stated in the assignment we have to objects. Student and Course. The two are instantiated with respective variables in their classes. We input these as parameters into our array based and linkked list data strucutre. However, I need to fact check this.

We haven't went over dynamic arrays in class, but I do remember it from last year during computer programming II. It'll be really educating to see how you can create a dynamic array without a helpful collections framework that is already defined for example ArrayList in Java or ctypes in python.

##### references

https://www.geeksforgeeks.org/java/creating-a-dynamic-array-in-java/
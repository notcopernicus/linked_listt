# overview

In this repo, we will design and implement CourseEnroll which is a coure enrollment system for students written in Java.

We will have a dyanmic array called enrolled students and a singly linked list called waitlisted students.

When a seat becomes available (when an enrolled student drops the course) ->
the first student in the waitlist is autoomatically promoted into the enrolled list.

##### coding task:
    1. Implement array based data structure for enrolled students
    2. Implement linked list data structure for waitlisted students
    3. Provide methods for enrolling, dropping, searching, listing and expoerting/importing student data.
    4. Implement a command-line menu that allows the user to interact with the system


#### extra coding taask:
    1. implement duplicate enroll attempt message
    2. sorted export of enrolled students by name or ID
    3. capacity change at runtime?


##### personal notes

I believe that while not explicitly stated in the assignment we have to objects. Student and Course. The two are instantiated with respective variables in their classes. We input these as parameters into our array based and linkked list data strucutre. However, I need to fact check this.
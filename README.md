# MovieTitles

This program adds .csv file (if added, as in assignment 2, number of files) to a Stack.
Data from files, from Stack, is transfered to 2D ArrayList, which further converted to
LinkedList and sorted. 

Once in LiknedList, the titles (includng years) are extracted and placed to a separate
LinkedList, which then converted to a TreeMap with keys as titles, and values as years.

At this point the funtionalities are made to shift the data around. It can be printed
from the LinkedList as total sorted, as another LinkedList as title/year sorted.

Funtions such as display full treemap (keys, values), and display "Recommended", subset,
of treemap are included.

I used LinkedLists and ArrayLists for data shifting and converting because unlike Arrays,
they are easy manipulate when there is unknown amount of data in files.

Then I used Regular Expressions to extract years (digits) from titles and vice versa.
Once I transfered data to TreeMap, there are many native methods to play with the data. 
The "Recommended movies", printSubTree function, I made to deal with subsets of data based of 
information provided is one of native methods. 

Inside the treemap, the recommendations are based on entered movie titles (in this case,
9 movies between titles indicated). Normally I would make it to be based on the prior search
history, but it is outside of the scope of this assignment. When I have more time, 
I'll adjust the code.

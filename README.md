# HashTable of strings
 HashTable using java
//Ashish Kumar cs610 ak2633 prp
---------------------------------------
Information regarding the code
---------------------------------------
>>"HANDOUT 2 ADHERED; NO BUGS TO REPORT"

>>java Lexicon_2633 file_name ,This command can be used to run the program.
  java Lexicon_2633 ,This will give an error to enter the file name.
  
>>The variable name for the integer array in the code is HashTable.
  The variable name for the character array in the code is CharTable.
  

1>
  14 M //reject
  14 0.0 //reject
  10 Ashish //reject
  14 1 //this will be the first valid insert command
  10 Kumar
  
  a>The program will reject the creation command if you enter float or string in place of integer.
    The error message will be "Please Enter the table size as valid Integer".
    Table will only be created for (14 1) which is a valid table entry.
  
  b>Till the valid command of table creation is executed, data won't be inserted in the table.
    The message shown at the console will be "Table Not Created".
  
2>
  14 9
  10 Ashish
  10 Kumar
  14 2 //This command 
  13
  
  a>Here create commands are entered at two instances which is not proper.
    Thus you will get the message "Duplicate table creation command entered" while trying to create the table again.
	
3>
  14 M //reject
  14 0.0 //reject
  14 1 //table will be created here
  10 ganesh\
  10 \va\man\
  11 \va\man\
  11 ganesh\
  10 Professor
  10 rio
  13
        //null command will be rejected
        //null command will be rejected
  17 10 Professor//17 command will be rejected
  17 10 Berlin
  17 10 Maiami
  17 10 rio
  17 10 tokyo
  17 10 lisben
  17 10 ram
  
  a>Hence the above invalid create commands will be rejected.
    null commands will be rejected ,17 commands will also be rejected,"File contains invalid command" will be printed.
	
4>Plese see the below test result for the entries.
  
  14 3
     //null command
  17 //invalid command
  10 Ashish
  10 Kumar
  10 Mishra
  12 Ashish
  12 Kumar
  12 Mishra
  13
  11 Ashish
  11 Kumar
  11 Mishra
  13
  12 Ashish
  12 Kumar
  12 Mishra
  11 Ashish
  11 Kumar
  11 Mishra
  
  Below is the result 
  ----------------
  File contains invalid command //this is for the null command
  File contains invalid command //this is for the 17 command
  Ashish Found at slot :2 Character array :0
  Kumar Found at slot :0 Character array :7
  Mishra Found at slot :1 Character array :13
  
  Ready to print--------------------------------------
  T:                                A : Ashish/Kumar/Mishra/
  0 : 7
  1 : 13
  2 : 0
  
  Total Slots Occupied : 3
  Total Slots Unccupied : 0
  Total Slots in charTable : 21
  Ashish deleted from slot :2
  Kumar deleted from slot :0
  Mishra deleted from slot :1
  
  Ready to print--------------------------------------
  T:                                A : ******/*****/******/
  0 : 
  1 : 
  2 : 
  
  Total Slots Occupied : 0
  Total Slots Unccupied : 3
  Total Slots in charTable : 21
  Ashish Not Found
  Kumar Not Found
  Mishra Not Found
  Ashish not found,So cant be deleted
  Kumar not found,So cant be deleted
  Mishra not found,So cant be deleted

	
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
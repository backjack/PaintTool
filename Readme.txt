######################
   Paint Tool
######################

Problem Statement

*** The Problem ****************************

__Description__

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quire limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit


Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behaviour of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.

__Sample I/O__

Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q
**********************************************************************



1) Design
------------
The design of tool logically consists of following components.

1) Command : Command module consists of  ICommand interface and its respective implementations. It takes validator, to validate command and then excutes it. Any new command to System can be extended from AbstractCommand class. Commands are further classified as BasicCommand like Quite , Canvas Commands (CreateCanvas, LineCommand),

2) Validator : Validator module components consist of iValidator interface and ValidationParameter. Its is decoupled from Command, since many commands of different family can have same validation criteria.
VaildationParamter is class which contains List of Types of Params expected in Command. For example, B 4 6 o, its ValidationParamter will have following list [String.class, Integer.class, Integer.class, String.class]

3) Input : It is input to tool. Input can be recived from file or Console


4) Drawable : Drawable is an interface, which takes input as Canvas and parameters to draw figures on canvas. Mostly Drawable should be composition in a Command so that i can be reused. For example LineCommand and RectangleCommand uses same DrawLine object to draw line and rectangle respectively.

5) Paintable : Paintable is an interface which takes same parameters as Drawable, since its behaviour is different from draw. Hence, new interface is created. Bucketfill class implements Paintable and it should be used as composition. 

6) Canvas : Canvas class to create canvas to draw and paint on basis of command. 
   
  
Note: Please refer class diagram for more information
  

2) How to run App
 - Build project using maven and then run below command. The main class  com.cs.painttool.PaintApp.
    Run following command
	- goto project run "mvn clean package"
	- goto paintoo/target and run command  "java -jar paintool-1.0-SNAPSHOT.jar"
 - You can also run it from TestCase com.cs.painttool.PaintAppTest  by uncommenting @Test.
  
  
3) Assumptions:
----------------

1) Commands are case sensitive.

2) Error is reported to user, If user tries to run draw and paint command without creating canvas.

3) Once canvas is created, user cannot create another canvas.

4) There is no constraint on max number of input parameters to command. For ex: FillBucket command requires 3 params, but if user enters more than 3 parameters then the first 3 params will be taken for execution. 

5) For BucketFill Command B 1 2 o, it will not color pixel (1,2) if there exits Line/Rectangle Border i.e 'x' and No Error will be shown

6) For invalid Command, user will receive respective error on the screen.
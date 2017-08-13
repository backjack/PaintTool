Read me

######################
   Paint Tool
######################

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
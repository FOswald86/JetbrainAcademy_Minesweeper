# JetbrainAcademy_Minesweeper  


This project will teach you how to work with multidimensional arrays in Java.  
You will be dealing with algorithms for generating the playfield and processing player moves.  
You will also find out what collections and stacks are.
You will work with Flood- or Ceed-Fill
  
First of all define the difficulty by telling the program how many mines you want on the field.  
  
The field:
'.' unexplored field  
'/' explored empty field  
'*' you marked that field as potentional mine  
'X' mine  
'[0-8]' hint how many mines are around that field  
  
Then enter coordinates and command ( free or mine ) for your move.  
  
free: 
will explore the field, 
if there is a mine you lost,  
if there is a hint it gets revealed,  
if there is a empty field all empty and number neighbors getting revealed too (Flood or Cell-Fill)  

mine:
marks that field as potential mine  
same field twice unmarks the field again  
  

<img src="https://github.com/FOswald86/JetbrainAcademy_Minesweeper/blob/master/minesweeper.gif" width="800" height="500" />  

https://hyperskill.org/projects/77   

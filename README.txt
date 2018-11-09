Build jar file:
mvn clean package

path:
Game/target
Game-1.0.0.jar

*copy file to:
Game\src\main\resources\config.ini 
Game\target\config.ini 

|_Game-1.0.0.jar
|_config.ini


---config.ini(content)----
boardSquareSize=3
player1=x
player2=o
--------------------------

run app target path:
java -jar Game-1.0.0.jar


run tests:

TicTacToeTest
PlayGameTest

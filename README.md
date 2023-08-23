# Tic-Tac-Toe | Project 1

## Intro
As I continue to progress in my career in software automation, I'm devoting time to strengthen my fundamental skills in Java. The best way to learn, in my opinion, is by doing! So, I've embarked on a mission to create fun, engaging projects to not only enhance my understanding but to also demonstrate my capabilities.

My first project in this journey is a classic game of Tic Tac Toe. I've added a unique twist by introducing a start page, providing a friendly and interactive user experience even before the game begins. 


<div style="display: flex; justify-content: space-between;">
  <div style="flex: 1; margin-right: 10px; border: 1px solid black; border-radius: 10px; padding: 5px;">
    <img src="https://github.com/JasonRafferty/Tic-Tac-Toe/blob/master/TicTacToe/src/Demo2.JPG" alt="Diagram" style="width: 400px; height: auto;">
    <p align="left">Figure 1: Tic-Tac-Toe Start Game Interface</p>
  </div>

## In-game Functionality 

In the Tic Tac Toe game, the turn order at the beginning of each round is determined randomly. The mechanism to decide the winner is currently based on evaluating various row combinations to identify three-in-a-row. Although functional, this approach is not the most efficient and is slated for optimization in future updates.


  <div style="flex: 1; margin-left: 10px; border: 1px solid black; border-radius: 10px; padding: 5px;">
    <img src="https://github.com/JasonRafferty/Tic-Tac-Toe/blob/master/TicTacToe/src/Demo1.JPG" alt="Diagram" style="width: 400px; height: auto;">
    <p align="left">Figure 2: Tic-Tac-Toe In-Game Experience</p>
  </div>
</div>

In this Tic Tac Toe game, the tie mechanism is implemented by ensuring two conditions are met:

1. No winner is declared, i.e., no player has achieved one of the winning patterns.
2. All board spaces are filled, i.e., there are no empty spaces left.
   
This design decision is crucial to avoid a common issue where the "It's a Tie" message is displayed even when a player wins on the final move. Here, we ensure the tie announcement is displayed only when the game board is filled and there's no winner.


 <div style="flex: 1; margin-left: 10px; border: 1px solid black; border-radius: 10px; padding: 5px;">
    <img src="https://github.com/JasonRafferty/Tic-Tac-Toe/blob/master/TicTacToe/src/Demo3.JPG" alt="Diagram" style="width: 400px; height: auto;">
    <p align="left">Figure 3: Tic-Tac-Toe Tied Game</p>
  </div>
</div>

## End Game Interface

In the end game screen, users can either replay the game or quit, which would close the game window. Each of these texts has a hover effect that alters its color to provide ainteractive experience. Additionally, there's a unique functionality on the logo. Upon clicking it, it switches on and navigates the user directly to my GitHub profile, 


 <div style="flex: 1; margin-left: 10px; border: 1px solid black; border-radius: 10px; padding: 5px;">
    <img src="https://github.com/JasonRafferty/Tic-Tac-Toe/blob/master/TicTacToe/src/Demo4.JPG" alt="Diagram" style="width: 400px; height: auto;">
    <p align="left">Figure 4: Tic-Tac-Toe End Game Interface</p>
  </div>
</div>

## Conclusion

To conlude, this first project has been a rewarding journey and has served as a fruitful learning experience, introducing me to various functionalities. As I continue to broaden my expertise, I will revisit this project to incorporate advanced features such as a time limit for each player and an AI opponent.  I intend to carry forward this momentum, creating a diverse array of projects to further sharpen my programming skills.

 <div style="flex: 1; margin-left: 10px; border: 1px solid black; border-radius: 10px; padding: 5px;">
    <img src="https://github.com/JasonRafferty/Tic-Tac-Toe/blob/master/TicTacToe/src/LogoHover.jpg" alt="Diagram" style="width: 100px; height: auto;">
  </div>
</div>

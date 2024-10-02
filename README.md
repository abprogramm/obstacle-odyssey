# Obstacle Odyssey

## Overview

**Obstacle Odyssey** is a simple yet engaging 2D game built in **Java**. The objective of the game is to navigate through various levels by avoiding obstacles and reaching the designated box to progress to the next stage. Along the way, players can collect coins to boost their score, adding an additional layer of challenge and reward. Each level becomes progressively more difficult, ensuring a dynamic and increasingly intense gaming experience.

## Features

- **Level Progression**: Navigate through different levels, each with increasing difficulty, by reaching the correct box to advance.
- **Obstacle Avoidance**: Dodge a variety of obstacles that become more challenging as you move up in levels, testing your reflexes and timing.
- **Coin Collection**: Collect coins scattered throughout the levels to maximize your score. The more coins you collect, the higher your final score at the end of the game.
- **Progressive Difficulty**: With each new level, the complexity of the obstacles and the level design increases, making the game harder as you progress.
- **Score System**: Your score is determined by how many coins you collect throughout the game, adding a competitive aspect for players aiming for high scores.

## Technology Stack

- **Java**: The game is entirely coded in Java, leveraging object-oriented programming principles to handle game mechanics, player movement, obstacle generation, and scoring.
- **Java Swing (or JavaFX)**: Used for the graphical user interface and rendering 2D elements on the screen.
- **Key Listeners**: Capture player input (e.g., arrow keys or WASD) for controlling character movement.

## Gameplay

- **Objective**: Avoid obstacles, reach the correct box, and collect as many coins as possible while advancing through increasingly difficult levels.
- **Controls**: Move the character using arrow keys or WASD to navigate around obstacles and pick up coins.
- **Winning Condition**: Successfully reach the correct box at the end of each level without hitting any obstacles to proceed. The game concludes after completing all levels, and your final score is displayed based on the coins collected.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/abprogramm/obstacle-odyssey.git
   ```

2. Navigate to the project directory:
   ```bash
   cd obstacle-odyssey
   ```

3. Compile the game:
   ```
   javac Main.java
   ```

4. Run the game:
   ```
   java Main
   ```

## Usage

Once the game is compiled and running, you can start playing **Obstacle Odyssey**:

1. **Start the Game**: Upon launching the game, you'll be presented with the first level. Use your keyboard to control the player character.
   
2. **Controls**:
   - **Arrow Keys**: Move your character up, down, left, or right to navigate through the level.
   
3. **Objective**: 
   - Avoid hitting any obstacles.
   - Reach the correct (green) box at the end of each level to advance to the next stage.
   - Collect coins scattered throughout each level to increase your score.

4. **Levels**:
   - As you progress through levels, the difficulty increases with more challenging obstacles and more complex paths.
   
5. **End of the Game**:
   - Once you complete the final level, your score is displayed based on the number of coins you collected.

# Dutch Flag Sorting Project

This project implements a visual representation of the Dutch Flag sorting algorithm using JavaFX. The application creates a window with randomly colored threads (red, white, and blue) and allows the user to sort them into the pattern of the Dutch flag.

## Prerequisites

To build and run this project, you need to have the following installed on your system:

- Java Development Kit (JDK) 11 or later
- Gradle 6.0 or later

## Project Structure

The project consists of four main Java files:

1. `Flag.java`: Represents the flag and contains the sorting logic.
2. `FlagDemo.java`: The main application class that sets up the JavaFX GUI.
3. `Thread.java`: Represents a single thread in the flag.
4. `ThreadColor.java`: An enum that defines the colors used in the flag.

## Building the Project with Gradle

To build the project using Gradle, follow these steps:

1. Create a new directory for your project and navigate to it in the terminal.

2. Create a `build.gradle` file in the project root directory with the following content:

   ```groovy
   plugins {
       id 'application'
       id 'org.openjfx.javafxplugin' version '0.0.10'
   }

   repositories {
       mavenCentral()
   }

   javafx {
       version = "16"
       modules = ['javafx.controls']
   }

   application {
       mainClass = 'dutchflag.FlagDemo'
   }

   sourceSets {
       main {
           java {
               srcDirs = ['src/main/java']
           }
       }
   }
   ```

3. Create the following directory structure for your Java files:
   ```
   src/main/java/dutchflag/
   ```

4. Place all four Java files (`Flag.java`, `FlagDemo.java`, `Thread.java`, and `ThreadColor.java`) in the `src/main/java/dutchflag/` directory.

5. Open a terminal in the project root directory and run the following command to build the project:
   ```
   gradle build
   ```

## Running the Application

After building the project, you can run the application using the following Gradle command:

```
gradle run
```

This will start the JavaFX application. You should see a window with randomly colored threads representing the Dutch flag. Use the "Sort" button to arrange the threads into the correct flag pattern, and the "Reset" button to randomize the threads again.

## Troubleshooting

If you encounter any issues related to JavaFX, make sure you're using a compatible version of Java and JavaFX. You may need to adjust the JavaFX version in the `build.gradle` file to match your Java version.

For any other issues, please check your Gradle and Java installations, and ensure all files are in the correct locations within the project structure.

# NoteTaker Android Project

### NoteTaker (or ArchitectureNoteExample)  is a mobile app for Android. 

## Table of Content

- [General Info](#general-info)
- [Technologies](#technologies)
- [Features](#features)


## General Info
NoteTaker is a mobile app for Android. It was developed as a study project. <br>
The aim for me was to understand the opportunities and capabilities that the Room library provides and to exercise the MVVM architecture style.<br>
It allows the user to write down notes and store them in the local database. It also displays them in a recycler view sorting them based on the notes' priority index.


## Technologies
The tech stack includes:
* MVVM architecture
* Room library for local storage

## Features
 
 ### - Creating a Note:
 The application allows users to create a note. The user can give a titel, body and a priority index to his notes.<br>
 Upon clicking the "save button" the note is stored in the local database
 
 ### - Updating a Note:
 The items in the Recycler View have onLongClickListener implemented. When trigered, an activity for result starts.<br>
 The user can choose to update any information in the selected note.

 ### - Deleting a Note
 The user can delete a note of his/her choice. The Recycler View has an ItemTouchHelper attached to it.<br>
  On left swipe the selected item is deleted. 



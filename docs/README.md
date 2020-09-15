# User Guide

## Duke

Duke helps you to keep track of a list of tasks that you have or have not done so that you don't forget them.

## Features 

### Create different types of tasks

There are 3 types of tasks that you can add to Duke:

- Todo - tasks without deadline
- Event - tasks that happen on a specific date/time
- Deadline - tasks with deadline

### Mark tasks as done

After you have done a task, you can mark it as done so that you can keep track of what is and is not done.

### Delete tasks

You can also delete tasks that you have done or tasks that are no longer relevant easily.

### Find tasks

You can easily search for tasks that contain the keyword you specified.

## Usage

### `todo <taskname>` - Add a todo task

This command adds a todo task to the task list

Example of usage: 

`todo laundry`

Expected outcome:

`Got it. I've added this task:`

`[T][✗] laundry`

`Now you have 1 tasks in the list.`


### `event <taskname> /at <date/time>` - Add an event with specific date/time

This command adds an event with date/time to the task list

Example of usage: 

`event comic festival /at Jun 16`

Expected outcome:

`Got it. I've added this task:`

`[E][✗] comic festival  (at:  Jun 16)`

`Now you have 2 tasks in the list.`
 
 
### `deadline <taskname> /by <date/time>` - Add a task with a deadline

This command adds a task with a deadline to the task list.

Example of usage: 

`deadline CS1231 assignment /by Sept 11`

Expected outcome:

`Got it. I've added this task:`

`[D][✗] CS1231 assignment  (by:  Sept 11)`

`Now you have 3 tasks in the list.`
  
  
### `list` - List out all tasks

This command list out all the available tasks.

Example of usage: 

`list`

Expected outcome:

`1. [T][✗] laundry`

`2. [E][✗] comic festival  (at:  Jun 16)`

`3. [D][✗] CS1231 assignment  (by:  Sept 11)`
  
  
### `done <index>` - Mark a task as done

This command marks the task with the index specified as done.

Example of usage: 

`done 2`

Expected outcome:

`Nice! I've marked this task as done:`

`[E][✓] comic festival  (at:  Jun 16)`


### `delete <index>` - Delete a task

This command deletes the task at the specified index from the list of tasks.

Example of usage: 

`delete 1`

Expected outcome:

`Noted. I've removed this task:`

`[T][✗] laundry`

`Now you have 2 tasks in the list.`
 
 
### `find <keyword>` - Find tasks with keyword

This command finds all the tasks that contain the keyword input.

Example of usage: 

`find comic`

Expected outcome:

`Here are the matching tasks in your list:`

`1. [E][✓] comic festival  (at:  Jun 16)`


### `bye` - Exit the program

This command exits the program.

Example of usage: 

`bye`

Expected outcome:

`Bye. Hope to see you again soon!`
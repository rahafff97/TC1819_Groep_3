# TechLab - _API Server_
## General information
The TechLab API server runs on Django 2.1.7 with the django REST framework 3.9.2 and is developed in Python. 
## Installation
In order to run the django server there are a couple of requirements.  
You nee Python 3.7 and have to install all of the requirements for django by running the following command in the project 
root folder `pip install -r requirements.txt`.  
After the installation of the python requirements for Django there still are a couple of commands that have to be ran 
before you're able to run the server.  

To start with, for the creation of the local database and the addition of the required tables and columns you will have 
to run the following command `python manage.py migrate`. Migrations can be seen as version changes of a database, e.g. 
each time a new functionality with models gets added there will be a new 'migration' for the databases.  
After setting up the database you are able to create a 'superuser', this can be seen as the admin of the web interface,
this can be done by using the following command `python manage.py createsuperuser`, after using the command you will be 
prompted to fill in a username, email and password.   
**Note:** Before you run any of the commands, make sure you are inside of the project folder, e.g. the `TechLab/` folder, 
at which the `requirement.txt`, `manage.py` and this file are located.
## Migrations
After making changes to the database models you want the changes to take effect on the database, but before the database 
knows about the changes it has to compare the old models with the current models. It is a sort of version control for 
the database. These 'versions' get created by using the following command `python manage.py makemigrations`. After 
running this command you ALWAYS have to run the migrate command in order to let the changes take effect to the database.  

## Running the server
After installing all the requirements you are able to run the server in two different configurations.  
1. As Developer `python manage.py runserver --settings=TechLab.settings.development`
2. In Production `python manage.py runserver `

## More information 
For some more information on the usage of Django and a development tutorial [Click Here](https://docs.djangoproject.com/en/2.1/intro/)
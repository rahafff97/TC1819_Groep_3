# TechLab - _API Server_
## General information
The TechLab API server runs on Django 2.1.7 with the django REST framework 3.9.2 and is developed in Python. 
## Installation
In order to run the django server there are a couple of requirements.  
You nee Python 3.7 and have to install all of the requirements for django by running the following command in the project 
root folder `pip install -r requirements.txt`.  
**Note:** at a later date you might as well have to make migrations to the desired database, thus can be achived by running
`python manage.py migrate`
## Running the server
After installing all the requirements you are able to run the server in two different configurations.  
1. As Developer `python manage.py runserver --settings=TechLab.settings.development`
2. In Production `python manage.py runserver `
# encoding: utf-8
import csv    
from collections import defaultdict

class ManipulateCSVFile:


    # Add filepaths!
    def __init__(self):

        self.lecture = '/home/aleksanderhh/Downloads/database/Lectures.csv' 
        self.tdtCourses = '/home/aleksanderhh/Downloads/database/TDT_Courses.csv'
        self.courseCoordinator = '/home/aleksanderhh/downloads/Database/CourseCoordinator.csv'
        self.lecturer = '/home/aleksanderhh/Downloads/database/Lecturer.csv'
        self.semester = '/home/aleksanderhh/Downloads/database/Semester.csv'


    # Commandline for choosing file to manipulate
    def chooseFile(self):

        string = ("What file do you wan't to manipulate? \n0: Lecture \n1: TDT Courses\n2: Course coordinator \n3: Lecturer \n4: Semester \nChoice: ")
    
        choice = input(string)

        if(choice == 0):
            return self.lecture
        elif(choice == 1):
            return self.tdtCourses
        elif(choice == 2):
            return self.courseCoordinator
        elif(choice == 3):
            return self.lecturer
        elif(choice == 4):
            return self.semester
        else:
            print "You didn't choose any of the options"


    # Returns TDT courses csv filepath
    def getCourseCodeFilePath(self):

        return self.tdtCourses


    # Prints out content in csv file
    def readCSV(self, file):

        csvFile = open(file,'r') 

        for row in csvFile:
            print ', '.join(row)

        csvFile.close()


    # Fetch and saves a specific column in csv file to a list
    def fetchFromCSV(self, file, columnName):

        columns = defaultdict(list)
        with open(file) as f:
            reader = csv.DictReader(f)
            for row in reader: 
                for (k,v) in row.items():
                    columns[k].append(v)
                        
        return columns[columnName]


    # Writes to csv file
    def writeToCSV(self, file, string):

    	csvFile = open(file,'a') 
        csvFile.write(string)
        csvFile.close()


    # Count lines in csv file
    def countLinesInCSV(self, file):

        numCourses = sum(1 for line in open(file))
        return numCourses     


    # Deletes information stored in the csv-file
    def cleanCSVFile(self, file):

    	csvFile = open(file,'w') 
        csvFile.close()

# encoding: utf-8
import csv    

class ManipulateCSVFile:

    def __init__(self):
        self.filePath = '/home/aleksanderhh/Downloads/Database/Lectures.csv' # ADD pilepath!

    def readCSV(self):
        csvFile = open(self.filePath,'r') 
        
        csvFile.close()


    def writeToCSV(self, string):

    	csvFile = open(self.filePath,'a') 
        csvFile.write(string)
        csvFile.close()

   def countLinesInCSV(self):

        numCourses = sum(1 for line in open(self.filePath))
        return numCourses     

    # Deletes information stored in the csv-file
    def cleanCSVFile(self):

    	csvFile = open(self.filePath,'w') 
        csvFile.close()

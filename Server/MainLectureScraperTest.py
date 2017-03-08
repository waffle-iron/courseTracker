# encoding: utf-8
from datetime import date
from scraper.scrapeLectureInformation import LectureInformationScraper
from tests.testManipulateCSV import TestManipulateCSVFile

def main():

    chooseOption()




def chooseOption():
    choice = None
    string = ("What do you wan|t to test? \n0: Nothing -> Exit \n1: csv manipulation \n2: LectureScraper \n3: BLA \n4: BLA \nChoice: ")
    
    while(choice != 0):
        choice = int(raw_input(string))
        
        if(choice == 0):
            #0 - Exiting
            print "\nExiting"   

        elif(choice == 1):
            #1 - csv Manipulation
            testCSVManipulation = TestManipulateCSVFile()
            testCSVManipulation.run()
            print "\nFinised testing csv manipulation"
         
        elif(choice == 2):
            #2 - Reading file
            print "\nFinished testing "
         
        elif(choice == 3):
            #3 - Count lines in file
            print ("\nNumber of lines in the file is: ")
            
        elif(choice == 4):
            #4 - Delete everything inside the file
            print "\nTest file is now empty"
         
        else:
            print "\nYou didn't choose any of the options"

    





main()



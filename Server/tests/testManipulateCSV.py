# encoding: utf-8

from scraper.manipulateCSV import ManipulateCSVFile

class TestManipulateCSVFile:
  
    # Testing everything
    #-----------------------------
    def __init__(self):
        self.test = ManipulateCSVFile()
        self.choice = None

    def chooseOption(self, file):
        string = ("What do you wan|t to do with the csv file? \n0: Nothing -> Exit \n1: Write \n2: Read \n3: Count lines in file \n4: Delete everything inside the file \nChoice: ")
    
        while(self.choice != 0):
            self.choice = int(raw_input(string))
        
            if(self.choice == 0):
                #0 - Exiting
                print "\nExiting"   

            elif(self.choice == 1):
                #1 - Writing to file
                self.test.writeToCSV(file, "Test1, \nTest2, \nTest3, ")
                print "\nTested writing to csv file"
         
            elif(self.choice == 2):
                #2 - Reading file
                self.test.readCSV(file)
                print "\nTested reading csv file"
         
            elif(self.choice == 3):
                #3 - Count lines in file
                num = self.test.countLinesInCSV(file)
                print ("\nNumber of lines in the file is: " + num)
            
            elif(self.choice == 4):
                #4 - Delete everything inside the file
                self.test.cleanCSVFile(file)
                print "\nTest file is now empty"
         
            else:
                print "\nYou didn't choose any of the options"

            #return choice

    def run(self):
        file = self.test.chooseFile()
        self.chooseOption(file)


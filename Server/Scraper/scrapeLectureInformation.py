# encoding: utf-8

#import lxml.html
import urllib2
import os
import sys

from scraper.manipulateCSV import ManipulateCSVFile

# This is an example on how we can scrape information about lectures from NTNU's site.

class LectureInformationScraper:

    def __init__(self):
        self.courseInformationLink = None
        self.html = None
        self.courseCode = None
        self.startTime = None
        self.weekDay = None
        self.weekNum = None
        self.room = None
        self.lectureIndex = None
        self.lectureNum = 0
    
    # CourseCode in uppercases: Ex. "TDT4140"
    def getCourseInformationLink(self, courseCode, year, version):
        self.courseCode = courseCode
        url = "https://www.ntnu.edu/web/studies/courses?p_p_id=coursedetailsportlet_WAR_courselistportlet&p_p_lifecycle=2&p_p_resource_id=timetable&_coursedetailsportlet_WAR_courselistportlet_year=%d&_coursedetailsportlet_WAR_courselistportlet_courseCode=%s&year=%d&version=%d" %(year, courseCode, year, version)
        self.courseInformationLink = url

    # Ex. link: https://www.ntnu.edu/web/studies/courses?p_p_id=coursedetailsportlet_WAR_courselistportlet&p_p_lifecycle=2&p_p_resource_id=timetable&_coursedetailsportlet_WAR_courselistportlet_year=2017&_coursedetailsportlet_WAR_courselistportlet_courseCode=TDT4140&year=2017&version=1

    # Fetches and saves html-content to a string
    def getCourseInformation(self):
        response = urllib2.urlopen(self.courseInformationLink)
        courseInformationContent = response.read()
        self.html = courseInformationContent

    # Saves the html-content to a temporarily file - Perhaps unnecessary
    # def addLectureInformationToTxt():
        #filePath = "/home/aleksanderhh/Downloads/temp.txt"
        #file = open(filePath,'w') 
        #file.write(html) 
        #file.close() 	

    
    # Count numbers of lectures 
    def countNumLectures(self):
        return self.html.count('"FOR"')

    # Saves information from site as a string
    def fetchInfoFromHtml(self, lectureNum):
        lectureS = '"FOR"'
        courseCodeS = '"courseCode":"'
        startTimeS = '"from":"'
    	weekDayS = '"dayNum":'
    	weekNumS = '"weeks":['
    	roomS = '"romNavn":"'
    	end = '","'
        endDayNum = ','
        endWeekNum = '],"rooms":'

        # Finds all the indexes to make us fetch specific information from html
                
        self.lectureIndex = (self.html.find(lectureS, 300*lectureNum) + len(lectureS))

    	courseCodeStartIndex = (self.html.find(courseCodeS, self.lectureIndex) + len(courseCodeS))
    	courseCodeEndIndex = self.html.find(end, courseCodeStartIndex)
    	startTimeStartIndex = (self.html.find(startTimeS, self.lectureIndex) + len(startTimeS))
        startTimeEndIndex = self.html.find(end, startTimeStartIndex)
    	weekDayStartIndex = (self.html.find(weekDayS, self.lectureIndex) + len(weekDayS))
        weekDayEndIndex = self.html.find(endDayNum, weekDayStartIndex)
        weekNumStartIndex = (self.html.find(weekNumS, self.lectureIndex) + len(weekNumS))
        weekNumEndIndex = self.html.find(endWeekNum, weekNumStartIndex)
    	roomStartIndex = (self.html.find(roomS, self.lectureIndex) + len(roomS))
        roomEndIndex = self.html.find(end, roomStartIndex)
        #self.lectureIndex = (self.html.find(lectureS, roomEndIndex) + len(lectureS))
        self.lectureNum+=1

        # Stores specific information to the global variables for the class
        self.courseCode = self.html[courseCodeStartIndex:courseCodeEndIndex]
        self.startTime = self.html[startTimeStartIndex:startTimeEndIndex]
        self.weekDay = self.html[weekDayStartIndex:weekDayEndIndex]
        self.weekNum = self.html[weekNumStartIndex:weekNumEndIndex]
        self.room = self.html[roomStartIndex:roomEndIndex]
    
        # For testing purposes
        print self.courseCode
        print self.startTime
        print self.weekDay
        print self.weekNum
        print self.room

    # Append information about lectures to CSV file
    def addLecturesToCSV(self):
        string = (self.courseCode + ',' + self.startTime + ',' + self.weekDay + ',' + self.weekNum + ',' + self.room + ',\n')

        csvFile = ManipulateCSVFile()
        csvFile.writeToCSV(string)


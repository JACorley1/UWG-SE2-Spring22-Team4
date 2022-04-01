#!/usr/bin/env python3
from enum import Enum

#*
# * Creates a enum for the days of the week
# * 
# * @version Python Spring 2022
# * @author Jordan Wagner
# 
class Days(Enum):
    MONDAY = 0
    TUESDAY = 1
    WEDNESDAY = 2
    THURSDAY = 3
    FRIDAY = 4
    SATURDAY = 5
    SUNDAY = 6

    #*
    # * Creates a enum for the days of the week froma  string
    # * @param day the day to get the enum for
    # * @returns the appropriate enum
    # 
    def fromString(day):
        if day in 'MONDAY':
            return Days.MONDAY
        elif day in ('TUESDAY'):
            return Days.TUESDAY
        elif day in ('WEDNESDAY'):
            return Days.WEDNESDAY
        elif day in ('THURSDAY'):
            return Days.THURSDAY
        elif day in ('FRIDAY'):
            return Days.FRIDAY
        elif day in ('SATURDAY'):
            return Days.SATURDAY
        elif day in ('SUNDAY'):
            return Days.SUNDAY
        else:
            raise NotImplementedError

        #*
    # * Creates a string for the days of the week from an enum
    # * @param day the day to get the string for
    # * @returns the appropriate string
    # 
    def toString(day):
        if day == Days.MONDAY:
            return 'MONDAY'
        elif day ==  Days.TUESDAY:
            return 'TUESDAY'
        elif day == Days.WEDNESDAY:
            return 'WEDNESDAY'
        elif day == Days.THURSDAY:
            return 'THURSDAY'
        elif day == Days.FRIDAY:
            return 'FRIDAY'
        elif day == Days.SATURDAY:
            return 'SATURDAY'
        elif day == Days.SUNDAY:
            return 'SUNDAY'
        else:
            raise NotImplementedError

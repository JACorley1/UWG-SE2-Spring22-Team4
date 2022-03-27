
#!/usr/bin/env python3
from enum import Enum

# *
# * class that stores the muscleGroupEnum
# *
# * @author Jordan Wagner
# * @version Spring 2022
# 
class MuscleGroup(Enum):
    ARMS = 0
    LEGS = 1 
    BACK = 2 
    ABS = 3
    CHEST = 4 
    SHOULDERS = 5
    CALVES = 6

    # *
    # * takes a string and turns it into the appropriate enum
    # * @param muscle the muscle to turn into an enum
    # * @return the appropriate enum 
    # 
    def fromString(muscle):
        if muscle in 'ARMS':
            return MuscleGroup.ARMS
        elif muscle in ('LEGS'):
            return MuscleGroup.LEGS
        elif muscle in ('BACK'):
            return MuscleGroup.BACK
        elif muscle in ('ABS'):
            return MuscleGroup.ABS
        elif muscle in ('CHEST'):
            return MuscleGroup.CHEST
        elif muscle in ('SHOULDERS'):
            return MuscleGroup.SHOULDERS
        elif muscle in ('CALVES'):
            return MuscleGroup.CALVES
        else:
            raise NotImplementedError
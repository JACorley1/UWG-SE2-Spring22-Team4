#!/usr/bin/env python3

# *
# * defines the exercise alt class for deserializing JSONS
# * 
# * 
# * @author group4
class ExerciseAlt :
    
    # *
    #     * creates an exerciseAlt object
    #     * 
    #     * @precondition !name.isEmpty() && description.isEmpty() && name != null &&
    #     *               description != null
    #     * @postcondition this.name == name && this.description == description
    #     * @param name        the name of the excersise
    #     * @param description the description of the exercise
    #     * @param category    the muscle category
    #     * @param equipment   int representation of equipment
    #     * @param intensity   int representation of intensity
    def defineDetails(name,  description,  category,  equipment, intensity) :
        exerciseDetails = {}
        if (name == None) :
            raise  ("name cant be null created")
        if (description == None) :
            raise  ("description cant be null created")
        if not name :
            raise  ("exercise name cant be empty")
        if not description :
            raise  ("exercise description cant be empty")

        exerciseDetails["name"] = name
        exerciseDetails["description"] = description
        exerciseDetails["category"] = category
        exerciseDetails["equipment"] = equipment
        exerciseDetails["intensity"] = intensity
        return exerciseDetails


# *
# * defines the exercise alt class for deserializing JSONS
# * 
# * 
# * @author group4
class ExerciseAlt :
    name = None
    description = None
    category = 0
    equipment = None
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
    def __init__(self, name,  description,  category,  equipment) :
        if (name == None) :
            raise  java.lang.IllegalArgumentException("name cant be null created")
        if (description == None) :
            raise  java.lang.IllegalArgumentException("description cant be null created")
        if (name.isEmpty()) :
            raise  java.lang.IllegalArgumentException("exercise name cant be empty")
        if (description.isEmpty()) :
            raise  java.lang.IllegalArgumentException("exercise description cant be empty")
        self.name = name
        self.description = description
        self.category = category
        self.equipment = equipment
    # *
    #     * gets the name of the exercise
    #     * 
    #     * @return the name
    def  getName(self) :
        return self.name
    # *
    #     * gets the text description of the exercise
    #     * 
    #     * @return the description of the exercise
    def  getDescription(self) :
        return self.description.replaceAll("\\<[^>]*>","")
    # *
    #     * returns the int representation of the muscle category defined by the data
    #     * 
    #     * @return the int representation of the muscle category
    def  getCategory(self) :
        return self.category
    # *
    #     * returns the int representation of the muscle category defined by the data
    #     * 
    #     * @return the int representation for equipment
    def  getEquipment(self) :
        if (len(self.equipment) > 0) :
            return self.equipment[0]
        else :
            return 0
